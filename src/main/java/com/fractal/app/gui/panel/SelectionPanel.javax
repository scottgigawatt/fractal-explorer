package com.fractal.app.gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.Serializable;
import java.math.BigDecimal;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.fractal.app.algorithms.math.ComplexNumber;
import com.fractal.app.gui.shape.NullShapeProducer;
import com.fractal.app.gui.shape.SquareProducer;

/**
 * This panel encapsulates the knowledge for making the various selections for changing the
 * application settings for the "Fractal Explorer".
 *
 * @author Scott Gigawatt
 * @version 7 July 2017
 */
public class SelectionPanel extends JPanel {
  /** A unique id associated with this {@link Serializable} object. */
  private static final long serialVersionUID = -6986539816345839837L;

  /** Represents the selection choice for a small image. */
  private static final int SMALL = 0;

  /** Represents the selection choice for a medium image. */
  private static final int MEDIUM = SMALL + 1;

  /** Represents the selection choice for a large image. */
  private static final int LARGE = MEDIUM + 1;

  /** Represents the selection choice for minimal zoom magnification. */
  private static final int MIN = 0;

  /** Represents the selection choice for normal zoom magnification. */
  private static final int NORM = MIN + 1;

  /** Represents the selection choice for maximum zoom magnification. */
  private static final int MAX = NORM + 1;

  /** Represents the selection choice for a set power of 2. */
  private static final int POWER_2 = 0;

  /** Represents the selection choice for a set power of 3. */
  private static final int POWER_3 = POWER_2 + 1;

  /** Represents the selection choice for a set power of 4. */
  private static final int POWER_4 = POWER_3 + 1;

  /** Represents the selection choice for a set power of 5. */
  private static final int POWER_5 = POWER_4 + 1;

  /** Represents the selection choice for a set power of 6. */
  private static final int POWER_6 = POWER_5 + 1;

  /** Represents the selection choice for a set power of 7. */
  private static final int POWER_7 = POWER_6 + 1;

  /** Represents the selection choice for a set power of 8. */
  private static final int POWER_8 = POWER_7 + 1;

  /** Represents the selection choice for a set power of 9. */
  private static final int POWER_9 = POWER_8 + 1;

  /** Represents the selection choice for a set power of 10. */
  private static final int POWER_10 = POWER_9 + 1;

  /** Represents the selection choice for the first predefined region. */
  private static final int PRESET_1 = 0;

  /** Represents the selection choice for the second predefined region. */
  private static final int PRESET_2 = PRESET_1 + 1;

  /** Represents the selection choice for the third predefined region. */
  private static final int PRESET_3 = PRESET_2 + 1;

  /** Represents the selection choice for the fourth predefined region. */
  private static final int PRESET_4 = PRESET_3 + 1;

  /** Represents the selection choice for the fifth predefined region. */
  private static final int PRESET_5 = PRESET_4 + 1;

  /** Represents the selection choice for the sixth predefined region. */
  private static final int PRESET_6 = PRESET_5 + 1;

  /** Represents the selection choice for normal set precision. */
  private static final int BIT_1 = 0;

  /** Represents the selection choice for 256-bit set precision. */
  private static final int BIT_2 = BIT_1 + 1;

  /** Represents the selection choice for 512-bit set precision. */
  private static final int BIT_3 = BIT_2 + 1;

  /** Represents the selection choice for 1024-bit set precision. */
  private static final int BIT_4 = BIT_3 + 1;

  /** Represents the selection choice for power for smooth set coloring. */
  private static final int COLOR_ALG_BANDED = 0;

  /** Represents the selection choice for power for banded set coloring. */
  private static final int COLOR_ALG_SMOOTH = COLOR_ALG_BANDED + 1;

  /** Represents the size of a small image. */
  private static final int SIZE_SMALL = 500;

  /** Represents the size of a medium image. */
  private static final int SIZE_MEDIUM = SIZE_SMALL + 100;

  /** Represents the size of a large image. */
  private static final int SIZE_LARGE = SIZE_MEDIUM + 100;

  /** Represents the minimal zoom magnification. */
  private static final int ZOOM_MIN = 2;

  /** Represents the normal zoom magnification. */
  private static final int ZOOM_NORM = ZOOM_MIN + 2;

  /** Represents the maximum zoom magnification. */
  private static final int ZOOM_MAX = ZOOM_NORM + 2;

  /** Represents the width of a text field. */
  private static final int TEXT_WIDTH = 6;

  /** Represents a set power of 2. */
  private static final int POW_2 = 2;

  /** Represents a set power of 3. */
  private static final int POW_3 = POW_2 + 1;

  /** Represents a set power of 4. */
  private static final int POW_4 = POW_3 + 1;

  /** Represents a set power of 5. */
  private static final int POW_5 = POW_4 + 1;

  /** Represents a set power of 6. */
  private static final int POW_6 = POW_5 + 1;

  /** Represents a set power of 7. */
  private static final int POW_7 = POW_6 + 1;

  /** Represents a set power of 8. */
  private static final int POW_8 = POW_7 + 1;

  /** Represents a set power of 9. */
  private static final int POW_9 = POW_8 + 1;

  /** Represents a set power of 10. */
  private static final int POW_10 = POW_9 + 1;

  /** Represents the selection choice for normal set precision. */
  private static final int PRECISION_256 = 256;

  /** Represents the selection choice for 256-bit set precision. */
  private static final int PRECISION_512 = 512;

  /** Represents the selection choice for 512-bit set precision. */
  private static final int PRECISION_1024 = 1024;

  /** The application settings. */
  private Settings settings = Settings.getInstance();

  /** A field for entering the maximum number of iterations to perform. */
  private JTextField maxItTextField = new JTextField(TEXT_WIDTH);

  /** A field for entering the x-value of the region's lower bound. */
  private JTextField xMinTextField = new JTextField(TEXT_WIDTH);

  /** A field for entering the y-value of the region's lower bound. */
  private JTextField yMinTextField = new JTextField(TEXT_WIDTH);

  /** A field for entering the x-value of the region's upper bound. */
  private JTextField xMaxTextField = new JTextField(TEXT_WIDTH);

  /** A field for entering the y-value of the region's upper bound. */
  private JTextField yMaxTextField = new JTextField(TEXT_WIDTH);

  /** A field for entering the x-value of a Julia set basis point. */
  private JTextField xJuliaTextField = new JTextField(TEXT_WIDTH);

  /** A field for entering the y-value of a Julia set basis point. */
  private JTextField yJuliaTextField = new JTextField(TEXT_WIDTH);

  /** A radio button for zooming based on a fixed magnification. */
  private JRadioButton zoomRadio;

  /** A radio button for zooming based on a user selected region. */
  private JRadioButton dragRadio;

  /** A radio button for viewing Julia sets. */
  private JRadioButton juliaRadio;

  /** A button for specifying the maximum number of iterations to perform. */
  private JButton maxItButton;

  /** A button for entering a specific Mandelbrot region to view. */
  private JButton regionButton;

  /** A button for entering a specific Julia set to view. */
  private JButton juliaButton;

  /** A check box for enabling or disabling smooth coloring. */
  private JCheckBox smoothCheckBox;

  /** A combo box for selecting the size of the image to compute. */
  private JComboBox<String> sizeComboBox;

  /** A combo box for selecting the equation for computing the set. */
  private JComboBox<String> eqnComboBox;

  /** A combo box for selecting the zoom magnification. */
  private JComboBox<String> zoomComboBox;

  /** A combo box for selecting pre-definied regions of the Mandelbrot set. */
  private JComboBox<String> regionComboBox;

  /** A combo box for selecting the Mandelbrot set precision. */
  private JComboBox<String> precisionComboBox;

  /** A dialog for changing the application settings. */
  private JDialog dialog;

  /** Creates a new panel for selecting different viewing options. */
  public SelectionPanel() {
    createSelectionPanel();
    createSelectionListeners();
  }

  /** Creates the panel for selecting different viewing options. */
  private void createSelectionPanel() {
    JPanel panel = null;
    JFrame owner = (JFrame) SwingUtilities.getWindowAncestor(this);
    dialog = new JDialog(owner, true);

    setLayout(new GridLayout(1, 3));

    panel = new JPanel();
    panel.add(createRadioPanel());
    add(panel);

    panel = new JPanel();
    panel.add(createButtonPanel());
    add(panel);

    panel = new JPanel();
    panel.add(createCheckBoxPanel());
    add(panel);
  }

  /**
   * Returns the panel containing the radio buttons for changing the application settings.
   *
   * @return The panel containing the radio buttons for changing the application settings.
   */
  private JPanel createRadioPanel() {
    JPanel panel = new JPanel();
    JPanel row = new JPanel();
    JPanel col = new JPanel();
    JLabel label = new JLabel("When I Click:");
    String[] items = {"In 2x", "In 4x", "In 6x"};
    TitledBorder title = null;
    Border line = BorderFactory.createLineBorder(Color.BLACK);

    panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
    col.setLayout(new BoxLayout(col, BoxLayout.Y_AXIS));
    col.setAlignmentX(Component.LEFT_ALIGNMENT);
    row.setLayout(new BoxLayout(row, BoxLayout.X_AXIS));
    row.setAlignmentX(Component.LEFT_ALIGNMENT);

    zoomComboBox = new JComboBox<String>(items);
    zoomRadio = new JRadioButton("Zoom", true);
    dragRadio = new JRadioButton("Drag and Zoom", false);
    juliaRadio = new JRadioButton("Show Julia Set", false);

    row.add(zoomRadio);
    row.add(zoomComboBox);
    col.add(Box.createRigidArea(new Dimension(0, 5)));
    col.add(label);
    col.add(Box.createRigidArea(new Dimension(0, 10)));
    col.add(row);
    col.add(Box.createRigidArea(new Dimension(0, 5)));
    col.add(dragRadio);
    // col.add(Box.createRigidArea(new Dimension(0, 5)));
    // col.add(juliaRadio);
    panel.add(Box.createRigidArea(new Dimension(12, 0)));
    panel.add(col);
    panel.add(Box.createRigidArea(new Dimension(12, 0)));

    title = BorderFactory.createTitledBorder(line, "Zooming Options");
    title.setTitleJustification(TitledBorder.CENTER);
    panel.setBorder(title);

    return panel;
  }

  /**
   * Returns the panel containing the buttons for changing the application settings.
   *
   * @return The panel containing the buttons for changing the application settings.
   */
  private JPanel createButtonPanel() {
    JPanel panel = new JPanel();
    JPanel col = new JPanel();
    JPanel row = null;
    TitledBorder title = null;
    Border line = BorderFactory.createLineBorder(Color.BLACK);
    String[] items = {"SW 4-Body", "Star Wheel", "Clockwise Spiral", "NW Spire",
        "Towers & 3 Spirals", "Mini Mandelbrot"};

    regionComboBox = new JComboBox<String>(items);

    title = BorderFactory.createTitledBorder(line, "Selection Options");
    title.setTitleJustification(TitledBorder.CENTER);
    col.setBorder(title);
    col.setLayout(new BoxLayout(col, BoxLayout.Y_AXIS));

    maxItButton = new JButton("Set Max Iterations");
    regionButton = new JButton("Set Region Bounds");
    juliaButton = new JButton("Set Julia Seed");

    row = new JPanel(new BorderLayout());
    row.add(maxItButton, BorderLayout.CENTER);
    col.add(row);
    col.add(Box.createRigidArea(new Dimension(0, 5)));

    row = new JPanel(new BorderLayout());
    row.add(regionButton, BorderLayout.CENTER);
    col.add(row);
    col.add(Box.createRigidArea(new Dimension(0, 5)));

    row = new JPanel(new BorderLayout());
    row.add(juliaButton, BorderLayout.CENTER);
    col.add(row);
    col.add(Box.createRigidArea(new Dimension(0, 5)));

    row = new JPanel();
    row.add(new JLabel("<html>Known<br>Regions</html>"));
    row.add(regionComboBox);
    col.add(row);
    col.add(Box.createRigidArea(new Dimension(0, 5)));

    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.add(Box.createRigidArea(new Dimension(50, 0)));
    panel.add(col);
    panel.add(Box.createRigidArea(new Dimension(12, 0)));

    return panel;
  }

  /**
   * Returns the panel containing the check boxes for enabling and disabling smooth coloring and
   * precision calculations.
   *
   * @return The panel containing the check boxes for enabling and disabling smooth coloring and
   *         precision calculations.
   */
  private JPanel createCheckBoxPanel() {
    JPanel panel = new JPanel();
    JPanel col = new JPanel();
    JPanel row = null;
    JLabel label = null;
    TitledBorder title = null;
    Border line = BorderFactory.createLineBorder(Color.BLACK);
    String[] sizeItems = {"500 x 500", "600 x 600", "700 x 700"};
    String[] eqnItems = {"z^2 + c", "z^3 + c", "z^4 + c", "z^5 + c", "z^6 + c", "z^7 + c",
        "z^8 + c", "z^9 + c", "z^10 + c"};
    String[] bitItems = {"64-bit", "256-bit", "512-bit", "1024-bit"};

    title = BorderFactory.createTitledBorder(line, "Additional Options");
    title.setTitleJustification(TitledBorder.CENTER);
    col.setBorder(title);
    col.setLayout(new BoxLayout(col, BoxLayout.Y_AXIS));
    col.setAlignmentX(Component.LEFT_ALIGNMENT);

    sizeComboBox = new JComboBox<String>(sizeItems);
    eqnComboBox = new JComboBox<String>(eqnItems);
    precisionComboBox = new JComboBox<String>(bitItems);
    smoothCheckBox = new JCheckBox("Use Logarithmic Smoothing");
    sizeComboBox.setMaximumSize(new Dimension(120, 20));
    eqnComboBox.setMaximumSize(new Dimension(120, 20));
    precisionComboBox.setMaximumSize(new Dimension(120, 20));

    row = new JPanel();
    label = new JLabel("Equation:    ");
    row.setLayout(new BoxLayout(row, BoxLayout.X_AXIS));
    row.setAlignmentX(Component.LEFT_ALIGNMENT);
    row.add(label);
    row.add(eqnComboBox);
    col.add(row);
    col.add(Box.createRigidArea(new Dimension(0, 5)));

    row = new JPanel();
    label = new JLabel("Image Size: ");
    row.setLayout(new BoxLayout(row, BoxLayout.X_AXIS));
    row.setAlignmentX(Component.LEFT_ALIGNMENT);
    row.add(label);
    row.add(sizeComboBox);
    col.add(row);
    col.add(Box.createRigidArea(new Dimension(0, 5)));

    row = new JPanel();
    label = new JLabel("Precision:    ");
    row.setLayout(new BoxLayout(row, BoxLayout.X_AXIS));
    row.setAlignmentX(Component.LEFT_ALIGNMENT);
    row.add(label);
    row.add(precisionComboBox);
    col.add(row);
    col.add(Box.createRigidArea(new Dimension(0, 5)));
    col.add(smoothCheckBox);
    col.add(Box.createRigidArea(new Dimension(0, 15)));

    panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
    panel.add(Box.createRigidArea(new Dimension(12, 0)));
    panel.add(col);
    panel.add(Box.createRigidArea(new Dimension(12, 0)));

    return panel;
  }

  /**
   * Returns the dialog panel for specifying the maximum number of iterations to perform.
   *
   * @return The dialog panel for specifying the maximum number of iterations to perform.
   */
  private JPanel createMaxItDialogPanel() {
    JPanel panel = new JPanel(new GridLayout(2, 0));
    JPanel row = null;
    JButton button = null;
    JLabel label = new JLabel("Max Iterations:");

    row = new JPanel();
    row.add(label);
    row.add(maxItTextField);
    panel.add(row);

    row = new JPanel();
    button = new JButton("Ok");
    button.grabFocus();
    row.add(button);

    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        getMaxItInput();
      }
    });

    button = new JButton("Cancel");
    row.add(button);
    panel.add(row);

    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dialog.setVisible(false);
      }
    });

    return panel;
  }

  /**
   * Returns the dialog panel for entering a specific Mandelbrot region to view.
   *
   * @return The dialog panel for entering a specific Mandelbrot region to view.
   */
  private JPanel createRegionDialogPanel() {
    JPanel panel = new JPanel(new GridLayout(5, 0));
    JPanel row = null;
    JButton button = null;
    JLabel label = null;

    row = new JPanel();
    label = new JLabel("xMin:");
    row.add(label);
    row.add(xMinTextField);
    panel.add(row);

    row = new JPanel();
    label = new JLabel("yMin:");
    row.add(label);
    row.add(yMinTextField);
    panel.add(row);

    row = new JPanel();
    label = new JLabel("xMax:");
    row.add(label);
    row.add(xMaxTextField);
    panel.add(row);

    row = new JPanel();
    label = new JLabel("yMax:");
    row.add(label);
    row.add(yMaxTextField);
    panel.add(row);

    row = new JPanel();
    button = new JButton("Ok");
    button.grabFocus();
    row.add(button);

    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        getRegionInput();
      }
    });

    button = new JButton("Cancel");
    row.add(button);

    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dialog.setVisible(false);
      }
    });

    panel.add(row);

    return panel;
  }

  /**
   * Returns the dialog panel for entering a specific Julia set to view.
   *
   * @return The dialog panel for entering a specific Julia set to view.
   */
  private JPanel createJuliaDialogPanel() {
    JPanel panel = new JPanel(new GridLayout(3, 0));
    JPanel row = null;
    JButton button = null;
    JLabel label = null;

    row = new JPanel();
    label = new JLabel("x:");
    row.add(label);
    row.add(xJuliaTextField);
    panel.add(row);

    row = new JPanel();
    label = new JLabel("y:");
    row.add(label);
    row.add(yJuliaTextField);
    panel.add(row);

    row = new JPanel();
    button = new JButton("Ok");
    button.grabFocus();
    row.add(button);

    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        getJuliaInput();
      }
    });

    button = new JButton("Cancel");
    row.add(button);
    panel.add(row);

    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dialog.setVisible(false);
      }
    });

    return panel;
  }

  /** Retrieves the user entered maximum number of iterations to perform. */
  private void getMaxItInput() {
    try {
      String val = maxItTextField.getText();

      if (val != null) {
        settings.setMaxIt(Integer.parseInt(val));
      }

      dialog.setVisible(false);
      System.out.println("Iterations are: " + settings.getMaxIt());
    } catch (NumberFormatException nfe) {
      System.out.println(nfe.getMessage());
    }
  }

  /** Retrieves the user entered Mandelbrot region. */
  private void getRegionInput() {
    try {
      String xMin = xMinTextField.getText();
      String yMin = yMinTextField.getText();
      String xMax = xMaxTextField.getText();
      String yMax = yMaxTextField.getText();
      boolean valid = xMin != null && yMin != null && xMax != null && yMax != null;

      if (valid) {
        double minX = Double.parseDouble(xMin);
        double minY = Double.parseDouble(yMin);
        double maxX = Double.parseDouble(xMax);
        double maxY = Double.parseDouble(yMax);
        double xdiff = Math.abs(minX - maxX);
        double ydiff = Math.abs(minY - maxY);
        double diff = xdiff - ydiff;

        if (diff != 0) {
          minX += diff / 2;
          maxX -= diff / 2;
        }

        ComplexNumber min = null;
        ComplexNumber max = null;

        if (!settings.isPrecise()) {
          min = new ComplexNumber(minX, minY);
          max = new ComplexNumber(maxX, maxY);
        } else {
          min = new ComplexNumber(new BigDecimal(minX), new BigDecimal(minY));
          max = new ComplexNumber(new BigDecimal(maxX), new BigDecimal(maxY));
        }

        settings.setBounds(min, max);
      }

      dialog.setVisible(false);
      System.out.println(
          "Min is: " + settings.getMin().toString() + " Max is: " + settings.getMax().toString());
    } catch (NumberFormatException nfe) {
      System.out.println(nfe.getMessage());
    }
  }

  /** Retrieves the user entered point on which to base a Julia set. */
  private void getJuliaInput() {
    try {
      String x = xJuliaTextField.getText();
      String y = yJuliaTextField.getText();

      if (x != null && y != null) {
        double jX = Double.parseDouble(x);
        double jY = Double.parseDouble(y);
        ComplexNumber julia = null;

        if (!settings.isPrecise()) {
          julia = new ComplexNumber(jX, jY);
        } else {
          julia = new ComplexNumber(new BigDecimal(jX), new BigDecimal(jY));
        }

        settings.setJulia(julia);
      }

      dialog.setVisible(false);
      System.out.println("Julia is: " + settings.getJulia().toString());
    } catch (NumberFormatException nfe) {
      System.out.println(nfe.getMessage());
    }
  }

  /** Creates the listeners for all of the selection options. */
  private void createSelectionListeners() {
    createZoomComboBoxListener();
    createZoomRadioListener();
    createDragRadioListener();
    createJuliaRadioListener();

    createMaxItButtonListener();
    createRegionButtonListener();
    createJuliaButtonListener();
    createRegionComboBoxListener();

    createSizeComboBoxListener();
    createEqnComboBoxListener();
    createPrecisionComboBoxListener();
    createSmoothCheckBoxListener();
  }

  /** Creates the listener for the zoom selection combo box. */
  private void createZoomComboBoxListener() {
    zoomComboBox.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int selection = zoomComboBox.getSelectedIndex();

        if (selection == MIN) {
          settings.setZoom(ZOOM_MIN);
        } else if (selection == NORM) {
          settings.setZoom(ZOOM_NORM);
        } else if (selection == MAX) {
          settings.setZoom(ZOOM_MAX);
        }

        System.out.println("Zoom is: " + settings.getZoom());
      }
    });
  }

  /** Creates the listener for the zoom radio button. */
  private void createZoomRadioListener() {
    zoomRadio.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        zoomRadio.setSelected(true);
        dragRadio.setSelected(false);
        juliaRadio.setSelected(false);

        settings.setProducer(new NullShapeProducer());
        System.out.println("Click zoom " + settings.getZoom() + "x");
      }
    });
  }

  /** Creates the listener for the drag radio button. */
  private void createDragRadioListener() {
    dragRadio.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dragRadio.setSelected(true);
        zoomRadio.setSelected(false);
        juliaRadio.setSelected(false);

        settings.setProducer(new SquareProducer());
        System.out.println("Drag zoom selected");

      }
    });
  }

  /** Creates the listener for the Julia radio button. */
  private void createJuliaRadioListener() {
    juliaRadio.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        juliaRadio.setSelected(true);
        zoomRadio.setSelected(false);
        dragRadio.setSelected(false);
      }
    });
  }

  /** Creates the listener for the max iterations button. */
  private void createMaxItButtonListener() {
    maxItButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dialog.setContentPane(createMaxItDialogPanel());
        dialog.setTitle("Set Max Iterations");
        dialog.setSize(300, 120);
        dialog.setLocationByPlatform(true);
        dialog.setVisible(true);
      }
    });
  }

  /** Creates the listener for the region button. */
  private void createRegionButtonListener() {
    regionButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dialog.setContentPane(createRegionDialogPanel());
        dialog.setTitle("Set Region Bounds");
        dialog.setSize(300, 250);
        dialog.setLocationByPlatform(true);
        dialog.setVisible(true);
      }
    });
  }

  /** Creates the listener for the Julia set button. */
  private void createJuliaButtonListener() {
    juliaButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dialog.setContentPane(createJuliaDialogPanel());
        dialog.setTitle("Set Julia Seed");
        dialog.setSize(300, 170);
        dialog.setLocationByPlatform(true);
        dialog.setVisible(true);
      }
    });
  }

  /** Creates the listener for the region selection combo box. */
  private void createRegionComboBoxListener() {
    regionComboBox.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int selection = regionComboBox.getSelectedIndex();
        ComplexNumber min = null;
        ComplexNumber max = null;

        switch (selection) {
          case PRESET_1:
            min = new ComplexNumber(-0.671665, 0.49216);
            max = new ComplexNumber(-0.449535, 0.71429);
            break;
          case PRESET_2:
            min = new ComplexNumber(-0.74745, 0.10671);
            max = new ComplexNumber(-0.74637, 0.10779);
            break;
          case PRESET_3:
            min = new ComplexNumber(-0.74591, 0.11196);
            max = new ComplexNumber(-0.74448, 0.11339);
            break;
          case PRESET_4:
            min = new ComplexNumber(-0.74542995, 0.1130076);
            max = new ComplexNumber(-0.74542905, 0.1130085);
            break;
          case PRESET_5:
            min = new ComplexNumber(-1.253879, 0.046252);
            max = new ComplexNumber(-1.253006, 0.047125);
            break;
          case PRESET_6:
            min = new ComplexNumber(-0.1325, -0.992);
            max = new ComplexNumber(-0.1235, -0.983);
            break;
        }

        settings.setBounds(min, max);

        System.out.println(
            "Min is: " + settings.getMin().toString() + " Max is: " + settings.getMax().toString());
      }
    });
  }

  /** Creates the listener for the size selection combo box. */
  private void createSizeComboBoxListener() {
    sizeComboBox.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int selection = sizeComboBox.getSelectedIndex();

        if (selection == SMALL) {
          settings.setSize(SIZE_SMALL);
        } else if (selection == MEDIUM) {
          settings.setSize(SIZE_MEDIUM);
        } else if (selection == LARGE) {
          settings.setSize(SIZE_LARGE);
        }

        System.out
            .println("Height is: " + settings.getHeight() + " Width is: " + settings.getWidth());
      }
    });
  }

  /** Creates the listener for the equation selection combo box. */
  private void createEqnComboBoxListener() {
    eqnComboBox.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int selection = eqnComboBox.getSelectedIndex();

        switch (selection) {
          case POWER_2:
            settings.setPower(POW_2);
            break;
          case POWER_3:
            settings.setPower(POW_3);
            break;
          case POWER_4:
            settings.setPower(POW_4);
            break;
          case POWER_5:
            settings.setPower(POW_5);
            break;
          case POWER_6:
            settings.setPower(POW_6);
            break;
          case POWER_7:
            settings.setPower(POW_7);
            break;
          case POWER_8:
            settings.setPower(POW_8);
            break;
          case POWER_9:
            settings.setPower(POW_9);
            break;
          case POWER_10:
            settings.setPower(POW_10);
            break;
        }

        System.out.println("Power is: " + settings.getPower());
      }
    });
  }

  /** Creates the listener for the precision calculations combo box. */
  private void createPrecisionComboBoxListener() {
    precisionComboBox.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int selection = precisionComboBox.getSelectedIndex();

        switch (selection) {
          case BIT_1:
            settings.setPrecise(false);
            break;
          case BIT_2:
            settings.setPrecise(true);
            settings.setPrecisionBits(PRECISION_256);
            break;
          case BIT_3:
            settings.setPrecise(true);
            settings.setPrecisionBits(PRECISION_512);
            break;
          case BIT_4:
            settings.setPrecise(true);
            settings.setPrecisionBits(PRECISION_1024);
            break;
        }

        System.out.println("Precise is: " + settings.isPrecise());

        if (settings.isPrecise()) {
          System.out.println("Precision is: " + settings.getPrecisionBits());
        }
      }
    });
  }

  /** Creates the listener for the smooth coloring check box. */
  private void createSmoothCheckBoxListener() {
    smoothCheckBox.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        if (smoothCheckBox.isSelected()) {
          settings.setColorAlg(COLOR_ALG_SMOOTH);
        } else {
          settings.setColorAlg(COLOR_ALG_BANDED);
        }

        System.out.println("Color is: " + settings.getColorAlg());
      }
    });
  }

  /**
   * Creates an icon from the specified file path.
   *
   * @param path The file path where the image file is located.
   * @return The {@link ImageIcon} that was created.
   */
  @SuppressWarnings("unused")
  private ImageIcon createIcon(String path) {
    URL imageURL = getClass().getResource(path);
    ImageIcon icon = null;

    if (imageURL != null) {
      icon = new ImageIcon(imageURL);
    }

    return icon;
  }
}
