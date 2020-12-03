package com.fractal.app.algorithms.color;

import com.fractal.app.algorithms.math.ComplexNumber;

/**
 * This class provides an interface for a {@link ColoringAlgorithm}.
 *
 * @author Scott Gigawatt
 *
 * @version 7 July 2017
 */
public interface ColoringAlgorithm {
  /**
   * Gets the RGB color value for a specified point with the "escape" value specified by the number
   * of iterations taken to escape and the maximum number of iterations.
   * 
   * @param z The value of the point when it "escaped".
   * @param c The point to color.
   * @param iterations The number of iterations taken to "escape".
   *
   * @return The RGB value of the color to assign to the point.
   */
  public int getColor(ComplexNumber z, ComplexNumber c, int iterations, boolean isMandelbrot);
}
