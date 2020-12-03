package com.fractal.app.gui.shape;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import com.fractal.app.gui.panel.Settings;

/**
 * This class extends {@link AbstractTwoPointShapeProducer} and implements the logic for creating
 * rectangles.
 *
 * @author Scott Gigawatt
 * @version 7 July 2017
 */
public class SquareProducer extends MouseAdapter implements ShapeProducer {
  /** The starting point of the {@link Square} */
  private Point start;

  /** Listeners that will be notified about the creation of shapes. */
  private List<ShapeCreationListener> listeners;

  /** The drawing color for the {@link Shape}. */
  private Color drawColor;

  /**
   * Initializes the {@link List} of listeners to an empty {@link List} and sets the default drawing
   * color to black.
   */
  public SquareProducer() {
    this.listeners = new ArrayList<ShapeCreationListener>();
    this.drawColor = Color.BLACK;
  }

  /**
   * Records the point at which the mouse was pressed.
   *
   * @param e The {@link MouseEvent} of interest, which for us is the mouse being pressed.
   */
  public void mousePressed(MouseEvent e) {
    this.start = new Point(e.getX(), e.getY());
  }

  /**
   * Sets the drawing color of the {@link ShapeProducer} to the specified {@link Color}.
   *
   * @param color The new {@link ShapeProducer} drawing color.
   */
  public void setDrawColor(Color color) {
    this.drawColor = color;
  }

  /**
   * Returns the drawing color of the current {@link ShapeProducer}.
   *
   * @return The current {@link ShapeProducer} drawing color.
   */
  public Color getDrawColor() {
    return this.drawColor;
  }

  /**
   * Adds the specified listener to the {@link List} of listeners.
   *
   * @param l The listener to add to the {@link List} of listeners.
   */
  public void addShapeCreationListener(ShapeCreationListener l) {
    this.listeners.add(l);
  }

  /**
   * Removes the specified listener from the {@link List} of listeners.
   *
   * @param l The listener to remove from the {@link List} of listeners.
   * @return true If the listener was successfully removed, otherwise false.
   */
  public boolean removeShapeCreationListener(ShapeCreationListener l) {
    return this.listeners.remove(l);
  }

  /**
   * Notifies any listeners that the specified {@link Shape} is currently in the process of being
   * created.
   *
   * @param shape The {@link Shape} that is currently in progress.
   */
  public void notifyShapeInProgress(Shape shape) {
    for (ShapeCreationListener scl : this.listeners) {
      scl.shapeInProgress(shape);
    }
  }

  /**
   * Notifies any listeners that the specified {@link Shape} is currently in the process of being
   * created.
   *
   * @param shape The {@link Shape} that is currently in progress.
   */
  public void notifyRegionSelected(int x0, int y0, int x1, int y1) {
    for (ShapeCreationListener scl : this.listeners) {
      scl.regionSelected(x0, y0, x1, y1);
    }
  }

  /**
   * Records the point at which the mouse was released and creates a new {@link Rectangle} from this
   * point and the starting point. This method also notifies any listeners that a new
   * {@link Rectangle} has been created.
   *
   * @param e The {@link MouseEvent} of interest, which for us is the mouse being released.
   */
  public void mouseReleased(MouseEvent e) {
    Settings settings = Settings.getInstance();

    int dx = 0;
    int dy = 0;
    int x0 = (int) Math.min(start.getX(), e.getX());
    int y0 = (int) Math.min(start.getY(), e.getY());
    int x1 = (int) Math.max(start.getX(), e.getX());
    int y1 = (int) Math.max(start.getY(), e.getY());

    if (e.getButton() == MouseEvent.BUTTON3) {
      System.out.println("SQUARE PRODUCER RIGHT CLICK.");

      dx = Math.abs(settings.getWidth() * (settings.getZoom() / 2));
      dy = dx;

      x0 = (int) start.getX() - dx;
      y0 = (int) start.getY() - dy;
      x1 = (int) start.getX() + dx;
      y1 = (int) start.getY() + dy;

      notifyRegionSelected(x0, y0, x1, y1);
      notifyShapeInProgress(new NullShape());
    } else {
      System.out.println("SQUARE PRODUCER LEFT CLICK.");

      // Point start = this.start;

      dx = Math.abs(x1 - x0);
      dy = Math.abs(y1 - y0);

      int size = Math.max(dx, dy);

      x1 = x0 + size;
      y1 = y0 + size;

      // Point end = e.getPoint();

      // if (e.getX() < start.getX() && e.getY() > start.getY()) {
      // end = new Point(x0 - size, y0 + size);
      // } else if (e.getX() < start.getX() && e.getY() < start.getY()) {
      // end = new Point(x0 - size, y0 - size);
      // } else if (e.getX() > start.getX() && e.getY() < start.getY()) {
      // end = new Point(x0 + size, y0 - size);
      // } else if (e.getX() > start.getX() && e.getY() > start.getY()) {
      // end = new Point(x0 + size, y0 + size);
      // }

      if (x0 != x1 && y0 != y1) {
        notifyRegionSelected(x0, y0, x1, y1);
        notifyShapeInProgress(new NullShape());
      }
    }
  }

  /**
   * Notifies any listeners that a {@link Rectangle} is currently in the process of being created.
   *
   * @param e The {@link MouseEvent} of interest, which for us is the mouse being dragged.
   */
  public void mouseDragged(MouseEvent e) {
    Point start = this.start;
    Point end = e.getPoint();
    int endX = e.getX();
    int endY = e.getY();
    int startX = (int) start.getX();
    int startY = (int) start.getY();
    int distX = (int) Math.abs(endX - start.getX());
    int distY = (int) Math.abs(endY - start.getY());

    if (distX > distY) {
      distY = distX;
    } else {
      distX = distY;
    }

    // end = new Point(endX, endY);
    if (e.getX() < start.getX() && e.getY() > start.getY()) {
      end = new Point(startX - distX, startY + distY);
    } else if (e.getX() < start.getX() && e.getY() < start.getY()) {
      end = new Point(startX - distX, startY - distY);
    } else if (e.getX() > start.getX() && e.getY() < start.getY()) {
      end = new Point(startX + distX, startY - distY);
    } else if (e.getX() > start.getX() && e.getY() > start.getY()) {
      end = new Point(startX + distX, startY + distY);
    }

    notifyShapeInProgress(new Rectangle(getDrawColor(), start, end));
  }
}
