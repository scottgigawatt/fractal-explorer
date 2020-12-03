package com.fractal.app.gui.shape;

import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;

/**
 * This class extends {@link AbstractTwoPointShapeProducer} and implements the logic for creating
 * rectangles.
 *
 * @author Scott Gigawatt
 * @version 7 July 2017
 */
public interface ShapeProducer extends MouseListener, MouseMotionListener {
  /**
   * Adds the specified listener to the {@link List} of listeners.
   *
   * @param l The listener to add to the {@link List} of listeners.
   */
  public void addShapeCreationListener(ShapeCreationListener l);

  /**
   * Removes the specified listener from the {@link List} of listeners.
   *
   * @param l The listener to remove from the {@link List} of listeners.
   * @return true If the listener was successfully removed, otherwise false.
   */
  public boolean removeShapeCreationListener(ShapeCreationListener l);

  /**
   * Notifies any listeners that the specified {@link Shape} is currently in the process of being
   * created.
   *
   * @param shape The {@link Shape} that is currently in progress.
   */
  public void notifyShapeInProgress(Shape shape);

  /**
   * Sets the draw color to the specified color.
   *
   * @param color The new draw color.
   */
  public void setDrawColor(Color color);
}
