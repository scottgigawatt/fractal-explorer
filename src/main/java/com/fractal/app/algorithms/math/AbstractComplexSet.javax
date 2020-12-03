package com.fractal.app.algorithms.math;

import java.math.BigDecimal;

import com.fractal.app.image.Image;

/**
 * This class abstractly represents a set of {@link ComplexNumber complex numbers}. It provides
 * state and behaviors which are common to {@link ComplexSet complex sets}.
 *
 * @author Scott Gigawatt
 *
 * @version 6 July 2017
 */
public abstract class AbstractComplexSet implements Set {
  /** The escape threshold for testing points. */
  public static final double THRESHOLD = 4.0;

  /** The minimum point of the region for the set. */
  private ComplexNumber min;

  /** The maximum point of the region for the set. */
  private ComplexNumber max;

  /** The image on which to draw the set. */
  private Image image;

  /** Represents whether or not calculations need increased precision. */
  private boolean precision;

  /** The maximum number of iterations to perform. */
  private int maxIt;

  /**
   * Creates a new {@link AbstractComplexSet} based on the specified {@link Region}.
   *
   * @param region The {@link Region} on which to base the set.
   */
  public AbstractComplexSet(Region region) {
    this.min = region.getMin();
    this.max = region.getMax();
    this.precision = region.isPrecise();
    this.maxIt = region.getMaxIt();
    this.image = new Image(region.getWidth(), region.getHeight(), region.getId(), region.getX(),
        region.getY());
  }

  /**
   * Computes a color value for each pixel representing a point within the set.
   *
   * @param basisPoint The point on which to base the set, can be null.
   */
  public void generate(ComplexNumber basisPoint) {
    if (!precision) {
      doubleSet(basisPoint);
    } else {
      precisionSet(basisPoint);
    }
  }

  /**
   * Returns whether or not precision calculations are enabled.
   *
   * @return True if precision calculations are enabled, false otherwise.
   */
  public boolean isPrecise() {
    return precision;
  }

  /**
   * Returns the maximum number of iterations to perform.
   *
   * @return The maximum number of iterations to perform.
   */
  public int getMaxIt() {
    return maxIt;
  }

  /**
   * Sets the maximum number of iterations to perform.
   *
   * @param maxIt The maximum number of iterations to perform.
   */
  public void setMaxIt(int maxIt) {
    this.maxIt = maxIt;
  }

  /**
   * Gets the current image.
   *
   * @return The current image.
   */
  public Image getImage() {
    return image;
  }

  /**
   * Determines whether or not a point is in the set by iterating over a function.
   *
   * @param z The point to test for set inclusion.
   * @param c The point on which to base set, can be null.
   *
   * @return The number of iterations performed.
   */
  public abstract int testPoint(ComplexNumber z, ComplexNumber c);

  /**
   * Computes a color value for each pixel representing a point within the set.
   *
   * @param c The point on which to base the set, can be null.
   */
  private void doubleSet(ComplexNumber c) {
    double xMin = min.getX();
    double yMin = min.getY();
    double xMax = max.getX();
    double yMax = max.getY();
    double dx = (xMax - xMin) / image.getWidth();
    double dy = (yMax - yMin) / image.getHeight();
    ComplexNumber z = new ComplexNumber(xMin, yMin);

    // Loop through the pixels.
    for (int i = 0; i < image.getHeight(); z.translate(0.0, dy), ++i) {
      z.setX(xMin);
      for (int j = 0; j < image.getWidth(); z.translate(dx, 0.0), ++j) {
        // For each pixel, call testPoint() to determine a value,
        // then map that value to a color and set it in the image.
        image.getImage().setRGB(j, i, testPoint(z, c));
      }
    }
  }

  /**
   * Computes a color value for each pixel representing a point within the set using
   * {@link BigDecimal}s.
   *
   * @param c The point on which to base the set, can be null.
   */
  private void precisionSet(ComplexNumber c) {
    BigDecimal xMin = min.getPx();
    BigDecimal yMin = min.getPy();
    BigDecimal xMax = max.getPx();
    BigDecimal yMax = max.getPy();
    BigDecimal zero = new BigDecimal(0.0);
    BigDecimal w = new BigDecimal(image.getWidth() + 0.0);
    BigDecimal h = new BigDecimal(image.getHeight() + 0.0);
    BigDecimal dx = xMax.subtract(xMin).divide(w);
    BigDecimal dy = yMax.subtract(yMin).divide(h);
    ComplexNumber z = new ComplexNumber(xMin, yMin);

    // Loop through the pixels.
    for (int i = 0; i < image.getHeight(); z.pTranslate(zero, dy), ++i) {
      z.setPx(xMin);
      for (int j = 0; j < image.getWidth(); z.pTranslate(dx, zero), ++j) {
        // For each pixel, call testPoint() to determine a value,
        // then map that value to a color and set it in the image.
        image.getImage().setRGB(j, i, testPoint(z, c));
      }
    }
  }
}
