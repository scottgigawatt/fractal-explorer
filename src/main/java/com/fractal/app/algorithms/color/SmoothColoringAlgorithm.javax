package com.fractal.app.algorithms.color;

import java.awt.Color;

import com.fractal.app.algorithms.math.ComplexNumber;

/**
 * This class provides an interface for a {@link ColoringAlgorithm}.
 *
 * @author Scott Gigawatt
 *
 * @version 6 July 2017
 */
public class SmoothColoringAlgorithm implements ColoringAlgorithm {
  /** The default range of the colors for coloring points. */
  public static final int DEFAULT_COLOR_RANGE = 768;

  /** The maximum allowable value for an RGB value. */
  private static final int MAX_RGB_VALUE = 255;

  /** Colors to use for coloring points. */
  private static int[] colors;

  /** The maximum number of iterations. */
  private int maxIt;

  /** The range of the colors for coloring points. */
  private int colorRange;

  /** The escape value of the point. */
  private ComplexNumber z;

  /** The point to color. */
  private ComplexNumber c;

  /**
   * Creates a new {@link SmoothColoringAlgorithm} and initializes the colors to the default colors.
   *
   * @param maxIt The maximum number of iterations.
   */
  public SmoothColoringAlgorithm(int maxIt) {
    this(maxIt, DEFAULT_COLOR_RANGE);
  }

  /**
   * Creates a new {@link SmoothColoringAlgorithm} and initializes the colors to the default colors.
   *
   * @param colorRange The range of the colors for coloring points.
   * @param maxIt The maximum number of iterations.
   */
  public SmoothColoringAlgorithm(int maxIt, int colorRange) {
    this.maxIt = maxIt;
    this.colorRange = colorRange;
    SmoothColoringAlgorithm.colors = new int[colorRange];

    initializeColors();
  }

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
  public int getColor(ComplexNumber z, ComplexNumber c, int iterations, boolean isMandelbrot) {
    this.z = z;
    this.c = c;
    int color;

    if (isMandelbrot) {
      color = getMandelbrotColor(iterations);
    } else {
      color = getJuliaColor();
    }

    return color;
  }

  /**
   * Gets the RGB color value for a Mandelbrot point with the "escape" value specified by the number
   * of iterations taken to escape and the maximum number of iterations.
   *
   * @param iterations The number of iterations taken to "escape".
   *
   * @return The RGB value of the color to assign to the point.
   */
  private int getMandelbrotColor(int iterations) {
    // Extra iterations to reduce the error in mu.
    for (int i = 0; i < 3; ++i, ++iterations) {
      z = z.mult(z).add(c);
    }

    double mag = Math.sqrt(z.mag());
    double mu = iterations - (Math.log(Math.log(mag)) / Math.log(2));
    int index = (int) (mu / maxIt * colorRange);

    if (index >= colorRange || index < 0) {
      index = 0;
    }

    if (Double.isNaN(mu) || Double.isInfinite(mu)) {
      index = 0;
    }

    /*
     * This block of code will add color to the points in the set, but it does not do it for all of
     * the points in the set.
     *
     * if (Double.isNaN(mu) || Double.isInfinite(mu)) { index = colorRange - 1; }
     *
     */
    return colors[index];
  }

  /**
   * Gets the RGB color value for a Julia set point.
   *
   * @return The RGB value of the color to assign to the point.
   */
  private int getJuliaColor() {
    double smoothColor = Math.exp(Math.sqrt(-z.mag()));

    for (int i = 0; i < maxIt && z.mag() < 900; ++i) {
      z = z.mult(z).add(c);
      smoothColor += Math.exp(Math.sqrt(-z.mag()));
    }

    smoothColor /= maxIt;
    int colorIndex = (int) (smoothColor % colorRange);

    if (colorIndex >= colorRange || colorIndex < 0) {
      colorIndex = 0;
    }

    return colors[colorIndex];
  }

  /** Initializes the array of {@link Color}s used to color points. */
  private void initializeColors() {
    for (int i = 0; i < colorRange; ++i) {
      int colorValueR = 0;
      int colorValueG = 0;
      int colorValueB = 0;

      if (i >= (2 * MAX_RGB_VALUE + 2)) {
        colorValueR = i - (2 * MAX_RGB_VALUE + 2);
        colorValueG = MAX_RGB_VALUE - colorValueR;
      } else if (i >= MAX_RGB_VALUE + 1) {
        colorValueG = i - (MAX_RGB_VALUE + 1);
        colorValueB = MAX_RGB_VALUE - colorValueG;
      } else {
        colorValueB = i;
      }

      colors[i] = colorValueB | colorValueG << 8 | colorValueR << 16;
    }
  }
}
