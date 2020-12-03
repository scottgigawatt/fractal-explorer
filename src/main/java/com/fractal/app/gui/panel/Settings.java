package com.fractal.app.gui.panel;

import java.util.ArrayList;
import java.util.List;

import com.fractal.app.algorithms.color.ColoringAlgorithm;
import com.fractal.app.algorithms.math.ComplexNumber;
import com.fractal.app.algorithms.math.Region;
import com.fractal.app.gui.listener.StateChangeListener;
import com.fractal.app.gui.listener.ZoomListener;
import com.fractal.app.gui.shape.NullShapeProducer;
import com.fractal.app.gui.shape.ShapeProducer;

/**
 * This class encapsulates the knowledge for accessing and mutating the "Fractal Explorer"
 * application settings. This class uses the singleton design patter to ensure that only one
 * instance of the settings is ever created, allowing uniform access throughout the graphical user
 * interface.
 *
 * @author Scott Gigawatt
 * @version 7 July 2017
 */
public class Settings {
  /** A singleton for storing the application settings. */
  private static Settings settings = new Settings();

  /** Represents the size of a small image. */
  private static final int SIZE_SMALL = 500;

  /** Represents the x-value for the lower bound of the Mandelbrot set. */
  private static final double MIN_X = -2.0;

  /** Represents the y-value for the lower bound of the Mandelbrot set. */
  private static final double MIN_Y = -2.0;

  /** Represents the x-value for the upper bound of the Mandelbrot set. */
  private static final double MAX_X = 2;

  /** Represents the y-value for the upper bound of the Mandelbrot set. */
  private static final double MAX_Y = 2;

  /** Represents the default maximum number of iterations to perform. */
  private static final int DEFAULT_MAX_IT = 10000;

  /** The default power to which the Mandelbrot set will be raised. */
  private static final int DEFAULT_POWER = 2;

  /** The default magnification for zooming in on the Mandelbrot set. */
  private static final int DEFAULT_ZOOM = 2;

  /** The default algorithm for coloring the Mandelbrot set. */
  private static final int DEFAULT_COLOR_ALG = 0;

  /** The default number of precision bits for precision calculations. */
  private static final int DEFAULT_PRECISION = 256;

  /** The width of the image to generate. */
  private int width = SIZE_SMALL;

  /** The height of the image to generate. */
  private int height = SIZE_SMALL;

  /** The maximum number of iterations to perform. */
  private int maxIt = DEFAULT_MAX_IT;

  /** The power to which the Mandelbrot set will be raised. */
  private int power = DEFAULT_POWER;

  /** The magnification for zooming in on the Mandelbrot set. */
  private int zoom = DEFAULT_ZOOM;

  /** The algorithm selection for coloring the set. */
  private int colorAlg = DEFAULT_COLOR_ALG;

  /** Represents the number of precision bits for precision calculations. */
  private int precisionBits = DEFAULT_PRECISION;

  /** Represents whether or not precision calculations are enabled. */
  private boolean precision = false;

  /** The lower bound of the Mandelbrot region. */
  private ComplexNumber min;

  /** The upper bound of the Mandelbrot region. */
  private ComplexNumber max;

  /** The basis point for generating a Julia set. */
  private ComplexNumber julia = null;

  /** The current producer for the {@link DrawPanel}. For zooming. */
  private ShapeProducer producer = new NullShapeProducer();

  /** Listeners for changes in the application settings. */
  private List<StateChangeListener> listeners;

  /** Listeners for changes in the application zoom settings. */
  private List<ZoomListener> zoomListeners;

  /**
   * Creates a new {@link Settings} object for maintaining the settings associated with the "Fractal
   * Explorer" application. The private constructor ensures that only a single instance of this
   * class is created, i.e. it follows the singleton design pattern.
   */
  private Settings() {
    min = new ComplexNumber(MIN_X, MIN_Y);
    max = new ComplexNumber(MAX_X, MAX_Y);
    listeners = new ArrayList<StateChangeListener>();
    zoomListeners = new ArrayList<ZoomListener>();
  }

  /**
   * Returns the singleton containing the application settings.
   *
   * @return The singleton containing the application settings.
   */
  public static Settings getInstance() {
    return settings;
  }

  /**
   * Returns the current image width.
   *
   * @return The current image width.
   */
  public int getWidth() {
    return width;
  }

  /**
   * Returns the current image height.
   *
   * @return The current image height.
   */
  public int getHeight() {
    return height;
  }

  /**
   * Sets the width and height of the image to the specified size.
   *
   * @param size The new size for the image width and height.
   */
  public void setSize(int size) {
    width = size;
    height = size;
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
   * @param maxIt The new maximum number of iterations to perform.
   */
  public void setMaxIt(int maxIt) {
    this.maxIt = maxIt;
  }

  /**
   * Returns the power to which the Mandelbrot set will be raised.
   *
   * @return The power to which the Mandelbrot set will be raised.
   */
  public int getPower() {
    return power;
  }

  /**
   * Sets the power to which the Mandelbrot set will be raised.
   *
   * @param power The new power to which the Mandelbrot set will be raised.
   */
  public void setPower(int power) {
    this.power = power;
  }

  /**
   * Returns the magnification for zooming in on the Mandelbrot set.
   *
   * @return The magnification for zooming in on the Mandelbrot set.
   */
  public int getZoom() {
    return zoom;
  }

  /**
   * Sets the magnification for zooming in on the Mandelbrot set.
   *
   * @param zoom The new magnification for zooming in on the Mandelbrot set.
   */
  public void setZoom(int zoom) {
    this.zoom = zoom;
  }

  /**
   * Returns the selected {@link ColoringAlgorithm} choice.
   *
   * @return The selected {@link ColoringAlgorithm} choice.
   */
  public int getColorAlg() {
    return colorAlg;
  }

  /**
   * Sets the choice for the algorithm to color the set.
   *
   * @param colorAlg The choice for the algorithm to color the set.
   */
  public void setColorAlg(int colorAlg) {
    this.colorAlg = colorAlg;
  }

  /**
   * Determines if precision calculations are enabled.
   *
   * @return True if precision calculations are enabled, false otherwise.
   */
  public boolean isPrecise() {
    return precision;
  }

  /**
   * Enables or disables precision calculations.
   *
   * @param precision True for increased precision; false for normal.
   */
  public void setPrecise(boolean precision) {
    this.precision = precision;
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
   * Sets the number of bits used for performing precision calculations.
   *
   * @param precisionBits The new number of bits to use for performing precision calculations.
   */
  public void setPrecisionBits(int precisionBits) {
    this.precisionBits = precisionBits;
  }

  /**
   * Returns a point on which to base a Julia set.
   *
   * @return A point on which to base a Julia set; null if none is specified.
   */
  public ComplexNumber getJulia() {
    return julia;
  }

  /**
   * Sets the point on which to base a Julia set.
   *
   * @param julia The new point on which to base a Julia set.
   */
  public void setJulia(ComplexNumber julia) {
    this.julia = julia;
  }

  /**
   * Returns the lower bound of the Mandelbrot region.
   *
   * @return The lower bound of the Mandelbrot region.
   */
  public ComplexNumber getMin() {
    return min;
  }

  /**
   * Returns the upper bound of the Mandelbrot region.
   *
   * @return The upper bound of the Mandelbrot region.
   */
  public ComplexNumber getMax() {
    return max;
  }

  /**
   * Sets the upper and lower bounds of the Mandelbrot region.
   *
   * @param min The new lower bound of the Mandelbrot region.
   * @param max The new upper bound of the Mandelbrot region.
   */
  public void setBounds(ComplexNumber min, ComplexNumber max) {
    this.min = min;
    this.max = max;
  }

  /**
   * Returns the {@link Region} associated with the current settings.
   *
   * @return the {@link Region} associated with the current settings.
   */
  public Region getRegion() {
    return new Region(min, max, julia, width, height, maxIt, power, 0, 0, 0, colorAlg,
        precisionBits, precision);
  }

  /**
   * Returns the current {@link Producer} for the {@link DrawPanel}.
   *
   * @return The current {@link Producer} for the {@link DrawPanel}.
   */
  public ShapeProducer getProducer() {
    return producer;
  }

  /**
   * Sets the new {@link Producer} for the {@link DrawPanel}.
   *
   * @param The new {@link Producer} for the {@link DrawPanel}.
   */
  public void setProducer(ShapeProducer producer) {
    this.producer = producer;
    notifyZoomChanged();
  }

  /** Resets the application state to default values. */
  public void reset() {
    min = new ComplexNumber(MIN_X, MIN_Y);
    max = new ComplexNumber(MAX_X, MAX_Y);
    maxIt = DEFAULT_MAX_IT;
    power = DEFAULT_POWER;
    colorAlg = DEFAULT_COLOR_ALG;
    precision = false;
    julia = null;

    notifyStateChanged();
  }

  /**
   * Adds the specified {@link StateChangeListener} to the list of listeners.
   *
   * @param listener The {@link StateChangeListener} to add.
   */
  public void addStateChangeListener(StateChangeListener listener) {
    listeners.add(listener);
  }

  /**
   * Removes the specified {@link StateChangeListener} from the list of listeners.
   *
   * @param listener The {@link StateChangeListener} to remove.
   */
  public void removeStateChangeListener(StateChangeListener listener) {
    listeners.remove(listener);
  }

  /** Notifies any listeners that the application settings have changed. */
  public void notifyStateChanged() {
    for (StateChangeListener listener : listeners) {
      listener.stateChanged();
    }
  }

  /**
   * Adds the specified {@link ZoomListener} to the list of listeners.
   *
   * @param listener The {@link ZoomListener} to add.
   */
  public void addZoomListener(ZoomListener listener) {
    zoomListeners.add(listener);
  }

  /**
   * Removes the specified {@link ZoomListener} from the list of listeners.
   *
   * @param listener The {@link ZoomListener} to remove.
   */
  public void removeZoomListener(ZoomListener listener) {
    zoomListeners.remove(listener);
  }

  /** Notifies any listeners that the zoom settings have changed. */
  public void notifyZoomChanged() {
    for (ZoomListener listener : zoomListeners) {
      listener.zoomChanged();
    }
  }
}
