package com.fractal.app.networking;

import java.io.IOException;

/**
 * This class provides an interface for classes which listen for incoming data.
 *
 * @author Scott Gigawatt
 * @version 7 July 2017
 */
public interface DataListener {
  /**
   * Processes the received data.
   *
   * @param data The received data.
   * @param source The source of the received data.
   * @throws IOException If any input or output error should occur.
   */
  public void dataReceived(Data data, DataSource source) throws IOException;

  /**
   * Notifies any listeners that the specified {@link DataSource} has been closed.
   *
   * @param source The source which has been closed.
   * @throws IOException If any input or output error should occur.
   */
  public void sourceClosed(DataSource source) throws IOException;

  /**
   * Sets the specified number of threads of execution for the specified {@link DataSource}.
   * 
   * @param numCalcs The number of threads of execution.
   * @param source The source of from which the numCalcs originated.
   */
  public void setNumCalculators(Integer numCalcs, DataSource source);
}
