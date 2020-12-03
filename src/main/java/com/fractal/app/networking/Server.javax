package com.fractal.app.networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.fractal.app.algorithms.math.ComplexSet;
import com.fractal.app.algorithms.math.PrecisionComplexSet;
import com.fractal.app.algorithms.math.Region;
import com.fractal.app.algorithms.math.Set;
import com.fractal.app.image.Image;
import com.fractal.app.image.ImageByteArrayWrapper;

/**
 * The class encapsulates the server-side logic for handling incoming client connections and
 * generating Mandelbrot and Julia set images. A buffer of {@link Regions} to be calculated is
 * contained within the {@link Server}. The {@link Regions} are processed by a private
 * {@link SetGenerator} inner class.
 *
 * @author Scott Gigawatt
 * @version 7 July 2017
 */
public class Server implements DataListener {
  /** The port on which to connect. */
  private int port;

  /** The {@link Regions} to calculate. */
  private List<Region> regions = Collections.synchronizedList(new LinkedList<Region>());

  /** The set calculation threads of execution. */
  private List<Thread> threads = new ArrayList<Thread>();

  /** The socket responsible for accepting incoming client connections. */
  private ServerSocket serverSocket;

  /** The {@link NetworkInterface} for the {@link Client}. */
  private NetworkInterface netIface;

  /**
   * Creates a new {@link Server} listening on the specified port.
   *
   * @param port The port on which to listen.
   */
  public Server(int port) {
    this.port = port;
  }

  /**
   * Retrieves the {@link Region} object from the incoming {@link Data}. This method adds the
   * {@link Region} to the list of {@link Regions} to be calculated.
   *
   * @param data The incoming {@link Data}.
   * @param source The source of the incoming data.
   *
   * @throws IOException If any error should occur retrieving the {@link Region}.
   */
  public void dataReceived(Data data, DataSource source) throws IOException {
    synchronized (regions) {
      regions.add((Region) data);
      regions.notify();
    }
  }

  /**
   * Sends the specified {@link Data} through the {@link NetworkInterface} associated with the
   * currently connected {@link Client}.
   *
   * @param data The {@link Data} to send.
   *
   * @throws IOException If any error should occur sending the {@link Data}.
   */
  private synchronized void send(Data data) throws IOException {
    netIface.sendData(data, this);
  }

  /**
   * Closes the specified {@link DataSource}.
   *
   * @param source The {@link DataSource} to close.
   *
   * @throws IOException If any error should occur closing the connection.
   */
  public synchronized void sourceClosed(DataSource source) throws IOException {
    netIface.close();
  }

  /**
   * Returns the {@link NetworkInterface} associated with this server.
   *
   * @return The {@link NetworkInterface} associated with this server.
   */
  public NetworkInterface getIface() {
    return netIface;
  }

  /** Listens for incoming {@link Client} connections. */
  public void listen() {
    Thread thread = null;
    Runtime runtime = Runtime.getRuntime();
    Integer processors = new Integer(runtime.availableProcessors());
    int numThreads = processors.intValue();

    try {
      serverSocket = new ServerSocket(port);

      while (!serverSocket.isClosed()) {
        netIface = new NetworkInterface(serverSocket.accept());
        netIface.addDataListener(this);
        thread = new Thread(netIface);
        thread.start();

        System.out.println("NetworkInterface Created!");

        if (threads.size() == 0) {
          for (int i = 0; i < numThreads; ++i) {
            thread = new Thread(new SetGenerator());
            thread.start();
            threads.add(thread);

            System.out.println("Thread " + i + " Created!");
          }
        }

        System.out.println(processors + " Processors available");
      }
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  /** This method is unused. Do-nothing implementation. */
  public void setNumCalculators(Integer numCalcs, DataSource source) {}

  /** A private inner class for threaded set calculations. */
  private class SetGenerator implements Runnable {
    /** The list of {@link Regions} to calculate. */
    private List<Region> regions = Server.this.regions;

    /** Entry point for thread calculations. */
    public void run() {
      Region region = null;

      while (Server.this.netIface.isConnected()) {
        synchronized (regions) {
          while (regions.isEmpty()) {
            try {
              regions.wait();
            } catch (InterruptedException ie) {
            }
          }

          region = regions.remove(0);
        }

        generateImage(region);
      }
    }

    /**
     * Creates the appropriate {@link Set} and generates the corresponding image.
     *
     * @param region The {@link Region} to be calculated.
     */
    private void generateImage(Region region) {
      if (region != null) {
        Set set = null;

        if (!region.isPrecise()) {
          set = new ComplexSet(region);
        } else {
          set = new PrecisionComplexSet(region);
        }

        set.generate(region.getJulia());

        try {
          Image image = set.getImage();
          Data data = new ImageByteArrayWrapper(image.toByteArray(), region.getId(), region.getX(),
              region.getY());
          Server.this.send(data);
        } catch (IOException ioe) {
          ioe.printStackTrace();
        }
      }
    }
  }
}
