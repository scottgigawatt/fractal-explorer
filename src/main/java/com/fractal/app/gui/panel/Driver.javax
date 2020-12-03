package com.fractal.app.gui.panel;

import java.io.IOException;

import com.fractal.app.networking.Client;

/**
 * This class provides an entry point for the distributed Mandelbrot client application graphical
 * user interface. It simply creates an instance of the client and calls its connect method as well
 * as creating an instance of the user interface main frame and sets it to visible.
 *
 * @author Scott Gigawatt
 * @version 7 July 2017
 */
public class Driver {
  /** Represents the default port on which to listen. */
  public static final int DEFAULT_PORT = 8888;

  /**
   * The entry point for the distributed Mandelbrot client graphical user interface.
   *
   * @param args The command line arguments to the program.
   */
  public static void main(String[] args) {
    try {
      Client client = new Client(DEFAULT_PORT);
      MainFrame frame = new MainFrame();

      frame.setVisible(true);
      frame.addSelectionListener(client);
      client.connect();
      client.addImageCreationListener(frame);
      client.distributeCalcRequests(frame.getRegion());
    } catch (IOException ioe) {
      System.out.println(ioe.getMessage());
      System.exit(1);
    }
  }
}
