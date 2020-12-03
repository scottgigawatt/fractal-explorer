package com.fractal.app.gui.panel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import com.fractal.app.algorithms.math.Region;
import com.fractal.app.gui.listener.ImageCreationListener;
import com.fractal.app.gui.listener.StateChangeListener;
import com.fractal.app.image.Image;
import com.fractal.app.networking.SelectionListener;

/**
 * The primary frame for the fractal explorer user interface. This frame will serve as a container
 * for the display and selection panels.
 *
 * @author Scott Gigawatt
 * @version 7 July 2017
 */
public class MainFrame extends JFrame implements ImageCreationListener, StateChangeListener {
  /** A unique id associated with this {@link Serializable} object. */
  private static final long serialVersionUID = 379052863138523019L;

  /** The title for the {@link MainFrame}. */
  private static final String FRAME_TITLE = "Fractal Explorer";

  /** The menu bar. */
  private JMenuBar menuBar;

  /** The "file" menu. */
  private JMenu fileMenu;

  /** The "help" menu. */
  private JMenu helpMenu;

  /** The "save" menu item. */
  private JMenuItem saveItem;

  /** The "exit" menu item. */
  private JMenuItem exitItem;

  /** The "about" menu item. */
  private JMenuItem aboutItem;

  /** The settings for the graphical user interface. */
  private Settings settings = Settings.getInstance();

  /** The panel containing the fractal draw panel and fractal statistics. */
  private DisplayPanel displayPanel;

  /** The panel containing the fractal draw panel and fractal statistics. */
  private SelectionPanel selectionPanel;

  /** Listeners for change in region. */
  private List<SelectionListener> listeners;

  /**
   * Constructs a new {@link MainFrame} setting up all GUI components, setting up listeners for the
   * {@link ModeSelectionPanel}, and initializing all fields.
   */
  public MainFrame() {
    super(FRAME_TITLE);
    listeners = new ArrayList<SelectionListener>();

    createMainFrame();
  }

  /** Creates the main frame for the fractal explorer user interface. */
  public void createMainFrame() {
    displayPanel = new DisplayPanel();
    selectionPanel = new SelectionPanel();

    settings.addStateChangeListener(this);

    setLayout(new BorderLayout());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setJMenuBar(createMenuBar());


    // take the menu bar off the jframe
    System.setProperty("apple.laf.useScreenMenuBar", "true");

    // set the name of the application menu item
    System.setProperty("com.apple.mrj.application.apple.menu.about.name", "Fractal Explorer");

    // set the look and feel
    // UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    // String lcOSName = System.getProperty("os.name").toLowerCase();
    // boolean IS_MAC = lcOSName.startsWith("mac os x");

    // if (IS_MAC) {
    // }

    getContentPane().add(displayPanel, BorderLayout.CENTER);
    getContentPane().add(selectionPanel, BorderLayout.SOUTH);
    addActionListeners();
    setSize(1000, 1000);
    settings.notifyStateChanged();
    pack();
  }

  /**
   * Creates the menu bar for the {@link MainFrame}. This method creates the menus and menu items
   * for the fractal explorer.
   *
   * @return The menu bar after it is populated.
   */
  private JMenuBar createMenuBar() {
    menuBar = new JMenuBar();
    fileMenu = new JMenu("File");
    saveItem = new JMenuItem("Save");
    exitItem = new JMenuItem("Exit");
    helpMenu = new JMenu("Help");
    aboutItem = new JMenuItem("About");

    fileMenu.add(saveItem);
    fileMenu.add(exitItem);
    helpMenu.add(aboutItem);
    menuBar.add(fileMenu);
    menuBar.add(helpMenu);

    return menuBar;
  }

  /** Adds action listeners to all menu items. */
  private void addActionListeners() {
    addSaveItemListener();
    addExitItemListener();
    addAboutItemListener();
  }

  /** Adds a listener to "Save" that saves the current image to disk. */
  private void addSaveItemListener() {
    this.saveItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          JFileChooser chooser = new JFileChooser();

          int returnVal = chooser.showSaveDialog(null);

          if (returnVal == JFileChooser.APPROVE_OPTION) {
            displayPanel.getDrawPanel().save(chooser.getSelectedFile());
          }
        } catch (IOException ex) {
          ex.printStackTrace();
        }
      }
    });

    this.saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
  }

  /** Adds a listener to "Exit" that exits the program when clicked. */
  private void addExitItemListener() {
    exitItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
  }

  /**
   * Adds a listener to "About" which opens a new window containing the About information.
   */
  private void addAboutItemListener() {
    aboutItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JDialog dialog = new JDialog(MainFrame.this, "About", true);
        JPanel panel = new JPanel();

        dialog.setLayout(new BorderLayout());
        dialog.setSize(400, 400);
        dialog.setResizable(false);

        StringBuilder builder = new StringBuilder();

        builder.append("<html><center><h2>Fractal Explorer</h2>");
        builder.append("A dynamically load balanced ");
        builder.append("distributed system.<p><p><p>Written by:<p><p>");
        builder.append("Scott Gigawatt and Russell T. Gaskey<p><p><p>");
        builder.append("Special Thanks To:<p><p>Dr. William Kreahling");
        builder.append(" - Capstone Instructor Extraordinaire<p>");
        builder.append("Dr. Andrew Dalton - Design Pattern Guru<p>");
        builder.append("Dr. Julia Barnes - Fractal Specialist<p>");
        builder.append("Ben Casses - Math & Debugging Consultant<p>");
        builder.append("Greg Ferrin - User Interface Advisor<p>");
        builder.append("Randy Yang - Custom Graphics<p><p>");
        builder.append("And everyone else who has helped<br>to make ");
        builder.append("this project a success!</center></html>");

        panel.add(new JLabel(builder.toString()));
        dialog.add(panel, BorderLayout.CENTER);
        dialog.setVisible(true);
        dialog.setLocationByPlatform(true);
      }
    });
  }

  /**
   * Returns the current region to calculate.
   *
   * @return The current region to calculate.
   */
  public Region getRegion() {
    return settings.getRegion();
  }

  /**
   * Notifies that the specified image has been created.
   *
   * @param image The newly created image.
   */
  public void imageCreated(Image image) {
    displayPanel.imageCreated(image);
  }

  /**
   * Adds the specified {@link SelectionListener} to the list of listeners.
   *
   * @param listener The {@link SelectionListener} to add.
   */
  public void addSelectionListener(SelectionListener listener) {
    listeners.add(listener);
  }

  /**
   * Removes the specified {@link SelectionListener} from the list of listeners.
   *
   * @param listener The {@link SelectionListener} to remove.
   */
  public void removeSelectionListener(SelectionListener listener) {
    listeners.remove(listener);
  }

  /**
   * Notifies any {@link SelectionListener}s that the current region has changed.
   */
  public void notifySelectionChanged() {
    for (SelectionListener listener : listeners) {
      listener.selectionChanged(settings.getRegion());
    }
    pack();
  }

  /** Notify any listeners of a change in state. */
  public void stateChanged() {
    notifySelectionChanged();
  }
}

