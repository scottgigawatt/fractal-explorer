package com.fractal.app.networking;

import com.fractal.app.algorithms.math.Region;

/**
 * This class provides an interface to classes which listen for user selections.
 *
 * @author Scott Gigawatt
 * @version 7 July 2017
 */
public interface SelectionListener {
  /**
   * Notify any listeners that the currently selected {@link Region} has changed.
   *
   * @param region The newly selected {@link Region}.
   */
  public void selectionChanged(Region region);
}
