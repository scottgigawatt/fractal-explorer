package com.fractal.app.networking;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fractal.app.algorithms.balancers.BlockRegionBalancer;
import com.fractal.app.algorithms.balancers.Distributable;
import com.fractal.app.algorithms.math.ComplexSet;
import com.fractal.app.algorithms.math.PrecisionComplexSet;
import com.fractal.app.algorithms.math.Region;
import com.fractal.app.algorithms.math.Set;
import com.fractal.app.gui.listener.ImageCreationListener;
import com.fractal.app.image.Image;
import com.fractal.app.image.ImageByteArrayWrapper;

/**
 * This class encapsulates the client side logic of the distributed Mandelbrot application. This
 * class is responsible for distributing calculation requests among the connected servers.
 * Potentially available servers are read from the "servers.conf" configuration file.
 *
 * @author Scott Gigawatt
 * @version 7 July 2017
 */
public class Client implements DataListener, SelectionListener {
  /** The default port on which to connect. */
  private static final int DEFAULT_PORT = 8888;

  /** The server configuration file. */
  private static final String SERVER_CONFIG = "resources/server.conf";

  /** The port on which to connect. */
  private int port;

  /** The images generated by the connected {@link Servers}. */
  // private Image[][] images;

  /** A list of currently connected {@link Servers{@link . */
  private List<ImageCreationListener> listeners = new ArrayList<ImageCreationListener>();

  /** A mapping of images and the regions to which they correspond. */
  // private Map<Image, Region> imageRegionMap = new HashMap<Image, Region>();

  /** The algorithm responsible for load distribution. */
  private Distributable balancer = new BlockRegionBalancer(this);

  /** Constructs a new {@link Client} connected to the default port. */
  public Client() {
    this(DEFAULT_PORT);
  }

  /**
   * Constructs a new {@link Client} connected to the specified port.
   *
   * @param port The port on which to connect.
   */
  public Client(int port) {
    this.setPort(port);
  }

  /**
   * Parses the "server.conf" configuration file and attempts to connect to the specified
   * {@link Servers} on the specified ports.
   *
   * @throws FileNotFoundException If the configuration file does not exist.
   * @throws IOException If the connection was unsuccessful.
   */
  public void connect() throws FileNotFoundException, IOException {
    NetworkInterface netIface = null;
    Thread thread = null;
    String host = null;
    String config = SERVER_CONFIG;
    String[] info = new String[2];
    Scanner in = new Scanner(new File(config));
    int port = 0;

    // Parse the configuration file and connect to the available servers.
    while (in.hasNext()) {
      try {
        info = in.nextLine().split(":");
        host = info[0];
        port = Integer.parseInt(info[1]);

        Socket socket = new Socket(host, port);

        if (socket.isConnected()) {
          netIface = new NetworkInterface(socket);
          thread = new Thread(netIface);
          netIface.addDataListener(this);
          balancer.addServer(netIface);
          thread.start();
        }
      } catch (SocketException ex) {
        System.out.println("SocketException: " + ex.getMessage());
      } catch (UnknownHostException ex) {
        System.out.println(ex.getMessage());
      } finally {
        in.close();
      }
    }
  }

  /**
   * Sets the specified number of threads of execution for the specified {@link DataSource}.
   * 
   * @param numCalcs The number of threads of execution.
   * @param source The source of from which the numCalcs originated.
   */
  public void setNumCalculators(Integer numCalcs, DataSource source) {
    if (source instanceof NetworkInterface) {
      NetworkInterface iFace = (NetworkInterface) source;

      balancer.setNumCalcs(iFace, numCalcs);
    }
  }

  /**
   * Notify any listeners that the currently selected {@link Region} has changed.
   *
   * @param region The newly selected {@link region}.
   */
  public void selectionChanged(Region region) {
    try {
      distributeCalcRequests(region);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }

  /**
   * Processes the data returned from the server.
   *
   * @param data The data to process.
   * @param source The source of the incoming data.
   *
   * @throws IOException If the connection was unsuccessful.
   */
  public void dataReceived(Data data, DataSource source) throws IOException {
    if (source instanceof NetworkInterface) {
      NetworkInterface iFace = (NetworkInterface) source;

      if (data == null) {
        balancer.notifyNullReceived(iFace);
      } else if (data instanceof ImageByteArrayWrapper) {
        ImageByteArrayWrapper temp = (ImageByteArrayWrapper) data;
        // Integer id = new Integer(temp.getId());

        balancer.regionReceived(iFace);

        Image otherImage =
            new Image(temp.getImageByteArray(), temp.getId(), temp.getX(), temp.getY());
        notifyImageCreated(otherImage);
      }
    }
  }

  /**
   * Sends the requested {@link Region} to the servers for calculation.
   *
   * @param region The {@link Region} to be calculated.
   *
   * @throws IOException If any input or output error should occur.
   */
  public void distributeCalcRequests(Region region) throws IOException {
    if (balancer.getNumServers() == 0) {
      generateImage(region);
    } else {
      balancer.distribute(region);
    }
  }

  /**
   * Creates the appropriate {@link Set} and generates the image.
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
      notifyImageCreated(set.getImage());
    }
  }

  /**
   * Adds the specified {@link ImageCreationListener} to the list of {@link ImageCreationListener}s.
   *
   * @param listener The {@link ImageCreationListener} to be added.
   */
  public void addImageCreationListener(ImageCreationListener listener) {
    listeners.add(listener);
  }

  /**
   * Removes the specified {@link ImageCreationListener} from the list of
   * {@link ImageCreationListener}s.
   *
   * @param listener The {@link ImageCreationListener} to be removed.
   */
  public void removeImageCreationListener(ImageCreationListener listener) {
    listeners.remove(listener);
  }

  /**
   * Notifies all {@link ImageCreationListener}s that the specified image has been created.
   *
   * @param image The image that has been created.
   */
  public void notifyImageCreated(Image image) {
    for (ImageCreationListener l : listeners) {
      l.imageCreated(image);
    }
  }

  /**
   * Removes this client listener from the specified {@link DataSource}.
   *
   * @param source The {@link DataSource} from which we want to remove this client listener.
   */
  public void sourceClosed(DataSource source) {
    source.removeDataListener(this);
  }

  /** Closes any connected {@link Servers}. */
  public void close() {
    balancer.closeServers();
  }

  /**
   * Returns the port used for this {@link Client}.
   * 
   * @return the port used for this {@link Client}.
   */
  public int getPort() {
    return port;
  }

  /**
   * Sets the port used for this {@link Client}.
   * 
   * @param port The port to use for this {@link Client}.
   */
  public void setPort(int port) {
    this.port = port;
  }
}
