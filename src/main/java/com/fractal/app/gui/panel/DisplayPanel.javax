package com.fractal.app.gui.panel;

import java.awt.BorderLayout;
import java.io.Serializable;

import javax.swing.JPanel;

import com.fractal.app.gui.listener.ImageCreationListener;
import com.fractal.app.image.Image;

/**
 * This class encapsulates the knowledge for creating the {@link DisplayPanel} which contains the
 * {@link DrawPanel} for displaying the Mandelbrot and and Julia set images as well as the
 * {@link StatPanel} for displaying the application statistics.
 *
 * @author Scott Gigawatt
 * @version 7 July 2017
 */
public class DisplayPanel extends JPanel implements ImageCreationListener {
  /** A unique id associated with this {@link Serializable} object. */
  private static final long serialVersionUID = 3898368301748325766L;

  /** The settings for the graphical user interface. */
  // private Settings settings = Settings.getInstance();

  /** The panel for drawing the Mandelbrot and Julia set images. */
  private DrawPanel drawPanel;

  /** The panel for displaying the buttons. */
  private ButtonPanel buttonPanel;

  /** The panel for displaying the application statistics. */
  // private StatPanel statPanel;

  /**
   * Creates a new panel for displaying the current region of the Mandelbrot set as well as
   * statistical information about the application.
   */
  public DisplayPanel() {
    createDisplayPanel();
  }

  /**
   * Notifies the {@link DrawPanel} that a new image was created.
   *
   * @param image The newly created image.
   */
  public void imageCreated(Image image) {
    drawPanel.imageCreated(image);
  }

  /** Creates the panel for displaying the Mandelbrot and stat panel. */
  private void createDisplayPanel() {
    setLayout(new BorderLayout());

    drawPanel = new DrawPanel();
    // statPanel = new StatPanel();
    buttonPanel = new ButtonPanel();

    add(drawPanel, BorderLayout.CENTER);
    // add(statPanel, BorderLayout.EAST);
    add(buttonPanel, BorderLayout.WEST);
  }

  /**
   * Returns the {@link DrawPanel} associated with this {@link DisplayPanel}.
   *
   * @return The {@link DrawPanel} associated with this {@link DisplayPanel}.
   */
  public DrawPanel getDrawPanel() {
    return this.drawPanel;
  }
}
