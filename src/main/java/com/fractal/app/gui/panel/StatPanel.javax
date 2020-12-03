package com.fractal.app.gui.panel;

import java.awt.GridLayout;
import java.io.Serializable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
 * The class provides the framework for a panel for displaying the statistics about the current
 * region being calculated.
 *
 * @author Scott Gigawatt
 * @version 7 July 2017
 */
public class StatPanel extends JPanel {
  /** A unique id associated with this {@link Serializable} object. */
  private static final long serialVersionUID = 3261286869298491727L;

  /** Represents the number of rows in the panel layout. */
  private static final int NUM_ROWS = 3;

  /** Represents the number of columns in the panel layout. */
  private static final int NUM_COLS = 0;

  /** Creates a new panel for selecting different viewing options. */
  public StatPanel() {
    createStatPanel();
  }

  /** Creates the panel containing statistics about the current region. */
  public void createStatPanel() {
    setLayout(new GridLayout(NUM_ROWS, NUM_COLS));
    add(new JLabel("Coordinate Information"));
    add(new JSeparator());
    add(new JLabel("Server Information"));
  }
}
