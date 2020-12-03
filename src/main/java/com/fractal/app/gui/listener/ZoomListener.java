package com.fractal.app.gui.listener;

/**
 * This class provides an interface to classes which listen for changes in zoom state.
 *
 * @author Scott Gigawatt
 *
 * @version 7 July 2017
 */
public interface ZoomListener {
  /** Notify any listeners of a change in zoom state. */
  public void zoomChanged();
}
