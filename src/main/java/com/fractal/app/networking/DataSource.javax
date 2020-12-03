package com.fractal.app.networking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This abstract class models an source of incoming data.
 *
 * @author Scott Gigawatt
 * @version 7 July 2017
 */
public abstract class DataSource {
  /** Listeners waiting for incoming {@link Data}. */
  private List<DataListener> listeners = new ArrayList<DataListener>();

  /**
   * Adds the specified {@link DataListener} to the list of data listeners.
   *
   * @param listener The {@link DataListener} to be added.
   */
  public void addDataListener(DataListener listener) {
    listeners.add(listener);
  }

  /**
   * Removes the specified {@link DataListener} from the list of data listeners.
   *
   * @param listener The {@link DataListener} to be removed.
   */
  public void removeDataListener(DataListener listener) {
    listeners.remove(listener);
  }

  /**
   * Notifies any listeners that the {@link Data} source has the specified number of execution
   * threads.
   * 
   * @param numCalcs The number of threads of execution.
   */
  public void notifyNumCalculators(Integer numCalcs) {
    for (DataListener listener : listeners) {
      listener.setNumCalculators(numCalcs, this);
    }
  }

  /**
   * Notifies all listeners that the specified {@link Data} has been received.
   *
   * @param data The received {@link Data}.
   */
  public void notifyReceipt(Data data) {
    for (DataListener listener : listeners) {
      try {
        listener.dataReceived(data, this);
      } catch (IOException ioe) {
        ioe.printStackTrace();
      } catch (RuntimeException re) {
        re.printStackTrace();
      }
    }
  }

  /** Notifies any listeners that the {@link DataSource} has closed. */
  public void closeDataSource() {
    for (DataListener listener : new ArrayList<DataListener>(listeners)) {
      try {
        listener.sourceClosed(this);
      } catch (IOException ioe) {
        ioe.printStackTrace();
      } catch (RuntimeException re) {
        re.printStackTrace();
      }
    }

    listeners.clear();
  }
}
