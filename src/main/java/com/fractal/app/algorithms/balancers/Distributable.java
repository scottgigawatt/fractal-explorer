package com.fractal.app.algorithms.balancers;

import java.io.IOException;

import com.fractal.app.algorithms.math.Region;
import com.fractal.app.networking.NetworkInterface;

/**
 * This class provides an interface to a load balancing algorithm.
 *
 * @author Scott Gigawatt
 *
 * @version 7 July 2017
 */
public interface Distributable {
  /**
   * This method is responsible for breaking apart the specified region into distributable
   * sub-regions.
   *
   * @param region The region to break apart.
   *
   * @throws IOException If any input or output exception should occur.
   */
  public void distribute(Region region) throws IOException;

  /**
   * Called when a region has been received back from a server. Removes the region from the servers
   * list of assigned regions.
   *
   * @param iface The {@link NetworkInterface} associated with the server which returned a region.
   */
  public void regionReceived(NetworkInterface iFace);

  /**
   * Adds the specified server to the list of connected servers.
   *
   * @param iface The {@link NetworkInterface} associated with the server to add.
   */
  public void addServer(NetworkInterface iface);

  /**
   * Redistributes the regions for the failed server associated with the specified
   * {@link NetworkInterface}.
   *
   * @param iface The {@link NetworkInterface} associated with the server which failed.
   */
  public void notifyNullReceived(NetworkInterface iFace);

  /**
   * Sets the number of set calculators for the server attached to the specified
   * {@link NetworkInterface} to the specified number.
   *
   * @param iFace The {@link NetworkInterface} tied to the server.
   * @param numCalcs The number of set calculators to set.
   */
  public void setNumCalcs(NetworkInterface iFace, int numCalcs);

  /**
   * Returns the current number of servers connected to the client.
   *
   * @return The current number of servers connected to the client.
   */
  public int getNumServers();

  /** Closes any servers connected to the client. */
  public void closeServers();
}
