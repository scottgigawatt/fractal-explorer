package com.fractal.app.gui.shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * This class models a rectangle and provides a method for drawing a rectangle.
 *
 * @author Scott Gigawatt
 * @version 7 July 2017
 */
public class Rectangle extends AbstractTwoPointShape {
  /**
   * Creates a new {@link Rectangle} of the specified color from the two provided points.
   *
   * @param color The color of the {@link Rectangle}.
   * @param start The starting point of the {@link Rectangle}.
   * @param end The ending point of the {@link Rectangle}.
   */
  public Rectangle(Color color, Point start, Point end) {
    super(color, start, end);
  }

  /**
   * Draws the {@link Rectangle} from the two points which comprise the rectangle.
   *
   * @param g The graphic to draw.
   */
  public void draw(Graphics g) {
    super.draw(g);
    Point newPoint = getNewStart();
    g.drawRect((int) newPoint.getX(), (int) newPoint.getY(), getWidth(), getHeight());
  }
}
