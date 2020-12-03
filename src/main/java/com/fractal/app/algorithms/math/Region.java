package com.fractal.app.algorithms.math;

import com.fractal.app.algorithms.color.ColoringAlgorithm;

/**
 * This class models a {@link Region} in the Complex Plane.
 *
 * @author Scott Gigawatt
 *
 * @version 6 July 2017
 */
public class Region {
  /** The lower bound of the region. */
  private ComplexNumber min;

  /** The upper bound of the region. */
  private ComplexNumber max;

  /** The point on which to base a Julia set. */
  private ComplexNumber julia;

  /** The width of the region. */
  private int width;

  /** The height of the region. */
  private int height;

  /** A unique id associated with this region. */
  private int id;

  /** The x-value for the starting point of this region. */
  private int x;

  /** The y-value for the starting point of this region. */
  private int y;

  /** The maximum number of iterations to perform. */
  private int maxIt;

  /** The power to which the set will be raised. */
  private int power;

  /** A value to indicate smooth coloring. */
  private int colorAlg;

  /** Indicates the number of bits to use for precision calculations. */
  private int precisionBits;

  /** A value to indicate the use of increased precision in calculations. */
  private boolean precision;

  /**
   * Constructs a new region with specified bounds and specified width.
   *
   * @param min The lower bound of the region.
   * @param max The upper bound of the region.
   * @param julia The point on which to base a Julia set.
   * @param width The width of the region.
   * @param height The width of the region.
   * @param maxIt The maximum number of iterations to perform.
   * @param power The power to which the set will be raised.
   * @param id A unique id associated with this region.
   * @param x A unique id associated with this region.
   * @param y A unique id associated with this region.
   * @param colorAlg Represents which coloring algorithm to use.
   * @param precision A value to indicate precision calculations.
   */
  public Region(ComplexNumber min, ComplexNumber max, ComplexNumber julia, int width, int height,
      int maxIt, int power, int id, int x, int y, int colorAlg, int precisionBits,
      boolean precision) {
    this.min = min;
    this.max = max;
    this.julia = julia;
    this.width = width;
    this.height = height;
    this.maxIt = maxIt;
    this.power = power;
    this.id = id;
    this.x = x;
    this.y = y;
    this.colorAlg = colorAlg;
    this.precisionBits = precisionBits;
    this.precision = precision;
  }

  /**
   * Returns the minimum x coordinate of the region.
   *
   * @return The minimum x coordinate of the region.
   */
  public int getX() {
    return x;
  }

  /**
   * Returns the minimum y coordinate of the region.
   *
   * @return The minimum y coordinate of the region.
   */
  public int getY() {
    return y;
  }

  /**
   * Returns the lower bound of the region.
   *
   * @return The lower bound of the region.
   */
  public ComplexNumber getMin() {
    return min;
  }

  /**
   * Sets the lower bound of the region to the specified min.
   *
   * @param min The new lower bound of the region.
   */
  public void setMin(ComplexNumber min) {
    this.min = min;
  }

  /**
   * Returns the upper bound of the region.
   * 
   * @return The upper bound of the region.
   */
  public ComplexNumber getMax() {
    return max;
  }

  /**
   * Sets the upper bound of the region to the specified max.
   *
   * @param max The new upper bound of the region.
   */
  public void setMax(ComplexNumber max) {
    this.max = max;
  }

  /**
   * Returns the power to which the set will be raised.
   * 
   * @return The power to which the set will be raised.
   */
  public int getPower() {
    return power;
  }

  /**
   * Sets the upper bound of the region to the specified max.
   *
   * @param power The new power to which the set will be raised.
   */
  public void setPower(int power) {
    this.power = power;
  }

  /**
   * Returns the Julia point.
   * 
   * @return The Julia point.
   */
  public ComplexNumber getJulia() {
    return julia;
  }

  /**
   * Sets the Julia point.
   *
   * @param max The new upper bound of the region.
   */
  public void setJulia(ComplexNumber julia) {
    this.julia = julia;
  }

  /**
   * Returns the width of the region.
   *
   * @return The width of the region.
   */
  public int getWidth() {
    return width;
  }

  /**
   * Sets the width of the region to the specified width.
   * 
   * @param width The new width of the region.
   */
  public void setWidth(int width) {
    this.width = width;
  }

  /**
   * Returns the height of the region.
   *
   * @return The height of the region.
   */
  public int getHeight() {
    return height;
  }

  /**
   * Sets the height of the region to the specified height.
   * 
   * @param height The new height of the region.
   */
  public void setHeight(int height) {
    this.height = height;
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
   * Returns the unique id associated with this region.
   *
   * @return The unique id associated with this region.
   */
  public int getId() {
    return id;
  }

  /**
   * Returns the selection for the {@link ColoringAlgorithm}.
   *
   * @return The selection for the {@link ColoringAlgorithm}.
   */
  public int getColorAlg() {
    return colorAlg;
  }

  /**
   * Returns the selection for the {@link ColoringAlgorithm}.
   *
   * @return The selection for the {@link ColoringAlgorithm}.
   */
  public void getColorAlg(int colorAlg) {
    this.colorAlg = colorAlg;
  }

  /**
   * Returns the number of bits used for performing precision calculations.
   *
   * @return The number of bits used for performing precision calculations.
   */
  public int getPrecisionBits() {
    return precisionBits;
  }

  /**
   * Returns true if using precision mode, false otherwise.
   *
   * @return True to indicate using precision mode, false otherwise.
   */
  public boolean isPrecise() {
    return precision;
  }

  /**
   * Returns the string representation of the region.
   *
   * @return The string representation of the region.
   */
  @Override
  public String toString() {
    return "Region: Min = " + min.toString() + ", Max = " + max.toString();
  }
}
