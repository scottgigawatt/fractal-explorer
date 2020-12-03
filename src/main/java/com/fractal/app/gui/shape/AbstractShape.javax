package com.fractal.app.gui.shape;

import java.awt.Color;
import java.awt.Graphics;

/**
 * This class abstractly models a {@link Shape} and includes any functionality that is common to all
 * {@link Shape} objects.
 *
 * @author Scott Gigawatt
 * @version 7 July 2017
 */
public abstract class AbstractShape implements Shape {
  /** The color of the {@link Shape}. */
  private Color color;

  /**
   * Creates a new {@link Shape} of the specified {@link Color}.
   * 
   * @param color The color of the {@link Shape} to create.
   */
  public AbstractShape(Color color) {
    this.color = color;
  }

  /**
   * Draws the shape and sets its color.
   *
   * @param g The graphic to draw.
   */
  public void draw(Graphics g) {
    g.setColor(this.color);
  }
}
