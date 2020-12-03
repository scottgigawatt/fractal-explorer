package com.fractal.app.gui.shape;

import java.awt.Color;
import java.awt.Point;

/**
 * This abstract class models a {@link Shape} which can be described by two points and includes any
 * shape functionality common to all two point shapes.
 *
 * @author Scott Gigawatt
 * @version 7 July 2017
 */
public abstract class AbstractTwoPointShape extends AbstractShape {
  /** The starting point of the {@link AbstractTwoPointShape}. */
  private Point start;

  /** The ending point of the {@link AbstractTwoPointShape}. */
  private Point end;

  /**
   * Creates a new {@link AbstractTwoPointShape} of the specified color from the two points
   * provided.
   *
   * @param color The color of the {@link AbstractTwoPointShape}.
   * @param start The starting point of the {@link AbstractTwoPointShape}.
   * @param end The ending point of the {@link AbstractTwoPointShape}.
   */
  public AbstractTwoPointShape(Color color, Point start, Point end) {
    super(color);
    this.start = start;
    this.end = end;
  }

  /**
   * Returns the starting point of the {@link AbstractTwoPointShape}.
   *
   * @return The starting point of the {@link AbstractTwoPointShape}.
   */
  protected Point getStart() {
    return this.start;
  }

  /**
   * Returns the ending point of the {@link AbstractTwoPointShape}.
   *
   * @return The ending point of the {@link AbstractTwoPointShape}.
   */
  protected Point getEnd() {
    return this.end;
  }

  /**
   * Returns a {@link Point} which is the upper left corner of the {@link AbstractTwoPointShape}.
   *
   * @return A {@link Point} which is the upper left corner of the {@link AbstractTwoPointShape}.
   */
  protected Point getNewStart() {
    Point newPoint = new Point(this.start);

    if (this.end.getX() < this.start.getX()) {
      newPoint.setLocation(this.end.getX(), newPoint.getY());
    }

    if (this.end.getY() < this.start.getY()) {
      newPoint.setLocation(newPoint.getX(), this.end.getY());
    }

    return newPoint;
  }

  /**
   * Returns the width of the {@link AbstractTwoPointShape}.
   *
   * @return The width of the {@link AbstractTwoPointShape}.
   */
  public int getWidth() {
    return (int) Math.abs(this.end.getX() - this.start.getX());
  }

  /**
   * Returns the height of the {@link AbstractTwoPointShape}.
   *
   * @return The height of the {@link AbstractTwoPointShape}.
   */
  public int getHeight() {
    return (int) Math.abs(this.end.getY() - this.start.getY());
  }
}
