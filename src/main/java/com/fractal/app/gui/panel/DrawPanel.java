package com.fractal.app.gui.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.fractal.app.algorithms.math.ComplexNumber;
import com.fractal.app.gui.listener.ImageCreationListener;
import com.fractal.app.gui.listener.StateChangeListener;
import com.fractal.app.gui.listener.ZoomListener;
import com.fractal.app.gui.shape.NullShape;
import com.fractal.app.gui.shape.Shape;
import com.fractal.app.gui.shape.ShapeCreationListener;
import com.fractal.app.gui.shape.ShapeProducer;
import com.fractal.app.image.Image;

/**
 * This class models the panel on which Mandelbrot and Julia sets will be displayed.
 *
 * @author Scott Gigawatt
 * @version 7 July 2017
 */
public class DrawPanel extends JPanel
    implements ImageCreationListener, ShapeCreationListener, StateChangeListener, ZoomListener {
  /** A unique id associated with this {@link Serializable} object. */
  private static final long serialVersionUID = 796834345181573584L;

  /** The settings for the graphical user interface. */
  private Settings settings = Settings.getInstance();

  /** The canvas on which we are drawing. */
  private BufferedImage canvas;

  /** Represents the selection rectangle. */
  private Shape selectionRectangle;

  private ShapeProducer producer;

  /** Creates a new panel for displaying Mandelbrot and Julia sets. */
  public DrawPanel() {
    canvas =
        new BufferedImage(settings.getWidth(), settings.getHeight(), BufferedImage.TYPE_INT_RGB);
    selectionRectangle = new NullShape();
    producer = settings.getProducer();

    addMouseListener(producer);
    addMouseMotionListener(producer);
    producer.addShapeCreationListener(this);
    producer.setDrawColor(Color.BLACK);
    settings.addStateChangeListener(this);
    settings.addZoomListener(this);
  }

  /**
   * Calculates the new region to display.
   *
   * @param x0 The lower bound x coordinate of the new region to display.
   * @param y0 The lower bound y coordinate of the new region to display.
   * @param x1 The upper bound x coordinate of the new region to display.
   * @param y1 The upper bound y coordinate of the new region to display.
   */
  public void regionSelected(int x0, int y0, int x1, int y1) {
    double dx = x1 - x0;
    double dy = y1 - y0;
    // double xRatio = dx / settings.getWidth();
    // double yRatio = dy / settings.getHeight();
    double xFactor = (settings.getWidth() - dx) / 2;
    double yFactor = (settings.getHeight() - dy) / 2;
    double cX = x0 + (dx / 2);
    double cY = y0 + (dy / 2);
    double regionWidth = Math.abs(settings.getMin().getX() - settings.getMax().getX());
    double regionHeight = Math.abs(settings.getMin().getY() - settings.getMax().getY());
    double xConvert = regionWidth / settings.getWidth();
    double yConvert = regionHeight / settings.getHeight();

    double xOffset = ((settings.getWidth() / 2) - cX) * xConvert;
    double yOffset = ((settings.getHeight() / 2) - cY) * yConvert;

    centerZoom(xFactor * xConvert, yFactor * yConvert);
    settings.getMin().translate(-xOffset, -yOffset);
    settings.getMax().translate(-xOffset, -yOffset);

    settings.notifyStateChanged();
  }

  /**
   * Calculates the zoom area based on the specified zoom distance.
   *
   * @param dx The x distance to zoom.
   * @param dy The y distance to zoom.
   */
  public void centerZoom(double dx, double dy) {
    double xMin = settings.getMin().getX();
    double yMin = settings.getMin().getY();
    double xMax = settings.getMax().getX();
    double yMax = settings.getMax().getY();
    ComplexNumber min = new ComplexNumber(xMin + dx, yMin + dy);
    ComplexNumber max = new ComplexNumber(xMax - dx, yMax - dy);

    settings.setBounds(min, max);
  }

  /**
   * Repaints the current shape in progress to the {@link DrawPanel}.
   *
   * @param shape The current shape in progress.
   */
  public void shapeInProgress(Shape shape) {
    this.selectionRectangle = shape;
    repaint();
  }

  /**
   * Adds the newly created image to the canvas and repaints the screen.
   *
   * @param image The newly created image.
   */
  public void imageCreated(Image image) {
    int w = image.getWidth();
    int h = image.getHeight();
    int x = image.getX();
    int y = image.getY();
    int[] rgbArray = image.getImage().getRGB(0, 0, w, h, null, 0, w);
    canvas.setRGB(x, y, w, h, rgbArray, 0, w);
    repaint();
  }

  /** Resizes the canvas and {@link DrawPanel} upon state change. */
  public void stateChanged() {
    int w = settings.getWidth();
    int h = settings.getHeight();

    setPreferredSize(new Dimension(w, h));
    invalidate();

    if (canvas.getWidth() != w) {
      canvas = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
    }
  }

  /** Updates the mouse listener for changes in zooming options. */
  public void zoomChanged() {
    removeMouseListener(producer);
    removeMouseMotionListener(producer);

    producer = settings.getProducer();
    addMouseListener(producer);
    addMouseMotionListener(producer);
    producer.addShapeCreationListener(this);
    producer.setDrawColor(Color.BLACK);
  }

  public void save(File file) throws IOException {
    ImageIO.write(this.canvas, "JPEG", file);
  }

  /**
   * Repaints the {@link DrawPanel} to reflect any changes made to the canvas.
   *
   * @param g The graphics to draw.
   */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(canvas, 0, 0, canvas.getWidth(), canvas.getHeight(), this);
    selectionRectangle.draw(g);
  }
}
