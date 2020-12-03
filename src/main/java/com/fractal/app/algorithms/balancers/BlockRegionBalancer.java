package com.fractal.app.algorithms.balancers;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.fractal.app.algorithms.math.ComplexNumber;
import com.fractal.app.algorithms.math.Region;
import com.fractal.app.networking.Data;
import com.fractal.app.networking.DataListener;
import com.fractal.app.networking.NetworkInterface;

/**
 * This class provides an interface to a load balancing algorithm.
 *
 * @author Scott Gigawatt
 *
 * @version 7 July 2017
 */
public class BlockRegionBalancer implements Distributable {
  /** Represents default number of regions wide to create. */
  private static final int DEFAULT_NUM_REGIONS_WIDE = 10;

  /** Represents default number of regions high to create. */
  private static final int DEFAULT_NUM_REGIONS_HIGH = 10;

  /** Represents the width (in pixels) of a region. */
  private static final int WIDTH = 10;

  /** Represents the height (in pixels) of a region.. */
  private static final int HEIGHT = WIDTH;

  /** The number of regions wide to create. */
  private int numRegionsWide;

  /** The number of regions high to create. */
  private int numRegionsHigh;

  /** The list of regions to be calculated. */
  private List<Region> regions;

  /** The client contains the load to be balanced. */
  private DataListener client;

  /** The list of servers to whom calculations will be sent. */
  private List<NetworkInterface> servers;

  /** A mapping of servers to assigned regions to calculate. */
  private Map<NetworkInterface, List<Region>> serverAssignMap;

  /** A mapping of servers to number of calculations to perform. */
  private Map<NetworkInterface, Integer> serverToNumCalcsMap;

  /**
   * Constructs a new {@link BlockRegionBalancer} with the specified number of rows.
   *
   * @param numRegions The number of rows to create.
   */
  public BlockRegionBalancer(DataListener client) {
    this(client, DEFAULT_NUM_REGIONS_WIDE, DEFAULT_NUM_REGIONS_HIGH);
  }

  /**
   * Constructs a new {@link BarRegionBalancer} with the specified client, list of servers, and
   * default number of rows.
   */
  public BlockRegionBalancer(DataListener client, int numRegionsWide, int numRegionsHigh) {
    this.client = client;
    this.numRegionsWide = numRegionsWide;
    this.numRegionsHigh = numRegionsHigh;
    servers = new ArrayList<NetworkInterface>();
    serverAssignMap = new HashMap<NetworkInterface, List<Region>>();
    serverToNumCalcsMap = new HashMap<NetworkInterface, Integer>();
    regions = Collections.synchronizedList(new LinkedList<Region>());
  }

  /**
   * Sets the number of set calculators for the server attached to the specified
   * {@link NetworkInterface} to the specified number.
   *
   * @param iFace The {@link NetworkInterface} tied to the server.
   * @param numCalcs The number of set calculators to set.
   */
  public void setNumCalcs(NetworkInterface iFace, int numCalcs) {
    this.serverToNumCalcsMap.put(iFace, new Integer(numCalcs));
  }

  /**
   * This method is responsible for breaking apart the specified region into distributable
   * sub-regions.
   *
   * @param region The region to break apart.
   *
   * @throws IOException If any input or output exception should occur.
   */
  public void distribute(Region region) throws IOException {
    Region tmpRegion = null;
    ComplexNumber min = null;
    ComplexNumber max = null;
    ComplexNumber julia = region.getJulia();
    double tmpXMin = 0.0;
    double tmpYMin = 0.0;
    double tmpXMax = 0.0;
    double tmpYMax = 0.0;
    double minX = region.getMin().getX();
    double minY = region.getMin().getY();
    double maxX = region.getMax().getX();
    double maxY = region.getMax().getY();
    int width = region.getWidth();
    int height = region.getHeight();
    int maxIt = region.getMaxIt();
    int power = region.getPower();
    int colorAlg = region.getColorAlg();
    int precisionBits = region.getPrecisionBits();
    boolean precision = region.isPrecise();
    double regionWidth = ((maxX - minX) / width) * WIDTH;
    double regionHeight = ((maxY - minY) / height) * HEIGHT;
    this.numRegionsWide = width / WIDTH;
    this.numRegionsHigh = height / HEIGHT;

    this.regions.clear();

    for (int i = 0; i < this.servers.size(); i++) {
      this.serverAssignMap.get(servers.get(i)).clear();
    }

    for (int i = 0, server = 0, id = 0; i < numRegionsHigh; i++) {
      for (int j = 0; j < numRegionsWide; j++, server++, id++) {
        server = server % servers.size();
        tmpXMin = minX + (j * regionWidth);
        tmpXMax = minX + ((j + 1) * regionWidth);
        tmpYMax = minY + ((i + 1) * regionHeight);
        tmpYMin = minY + (i * regionHeight);

        if (!precision) {
          min = new ComplexNumber(tmpXMin, tmpYMin);
          max = new ComplexNumber(tmpXMax, tmpYMax);
        } else {
          min = new ComplexNumber(new BigDecimal(tmpXMin), new BigDecimal(tmpYMin));
          max = new ComplexNumber(new BigDecimal(tmpXMax), new BigDecimal(tmpYMax));
        }

        tmpRegion = new Region(min, max, julia, WIDTH, HEIGHT, maxIt, power, id, j * WIDTH,
            i * HEIGHT, colorAlg, precisionBits, precision);

        regions.add(tmpRegion);
      }
    }

    sendInitialRegions();
  }

  /**
   * This method is repsonsible for sending the initial {@link Region}s to each server in order to
   * facilitate pipe-lining.
   */
  private void sendInitialRegions() {
    // Region tmpRegion = null;
    NetworkInterface iFace = null;
    int numCalcs = 0;

    for (int i = 0, serverNum = 0; i < (this.servers.size() * 2); i++, serverNum++) {
      serverNum = serverNum % (this.servers.size());

      iFace = servers.get(serverNum);
      numCalcs = 2;

      for (int j = 0; j < numCalcs + 2; j++) {
        sendRegion(iFace);
      }
    }
  }

  /**
   * This method is sends the next available region for processing to the specified
   * {@link NetworkInterface}.
   *
   * @param iface The {@link NetworkInterface} associated with the server which returned a region.
   */
  private synchronized void sendRegion(NetworkInterface iFace) {
    try {
      Region region = regions.remove(0);

      serverAssignMap.get(iFace).add(region);
      iFace.sendData((Data) region, this.client);
    } catch (IOException ioe) {
      System.out.println(ioe.getMessage());
    }
  }

  /**
   * Called when a region has been received back from a server. Removes the region from the servers
   * list of assigned regions.
   *
   * @param iface The {@link NetworkInterface} associated with the server which returned a region.
   */
  public synchronized void regionReceived(NetworkInterface iFace) {
    synchronized (regions) {
      if (regions.size() > 0) {
        serverAssignMap.get(iFace).remove(0);
        sendRegion(iFace);
      }
    }
  }

  /**
   * Redistributes the regions for the failed server associated with the specified
   * {@link NetworkInterface}.
   *
   * @param iface The {@link NetworkInterface} associated with the server which failed.
   */
  public void notifyNullReceived(NetworkInterface iFace) {
    if (serverAssignMap.get(iFace).size() > 0) {
      this.regions.addAll(0, serverAssignMap.get(iFace));
    }
  }

  /**
   * Adds the specified server to the list of connected servers.
   *
   * @param iface The {@link NetworkInterface} associated with the server to add.
   */
  public void addServer(NetworkInterface iface) {
    this.servers.add(iface);

    this.serverAssignMap.put(iface, Collections.synchronizedList(new LinkedList<Region>()));
  }

  /** Closes any servers connected to the client. */
  public void closeServers() {
    for (NetworkInterface server : servers) {
      server.close();
    }
  }

  /**
   * Returns the current number of servers connected to the client.
   *
   * @return The current number of servers connected to the client.
   */
  public int getNumServers() {
    return this.servers.size();
  }
}
