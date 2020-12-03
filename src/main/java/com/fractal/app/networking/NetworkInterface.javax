package com.fractal.app.networking;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

/**
 * This class provides an abstraction for communication over a network.
 *
 * @author Scott Gigawatt
 * @version 7 July 2017
 */
public class NetworkInterface extends DataSource implements Runnable {
  /** The connection {@link Socket}. */
  private Socket socket;

  /** An {@link ObjectInputStream} for reading data. */
  private ObjectInputStream in;

  /** An {@link ObjectOutputStream} writing data. */
  private ObjectOutputStream out;

  /**
   * Constructs a new {@link NetworkInterface} for the provided {@link Socket}.
   *
   * @param socket The {@link Socket} to use for sending data.
   * @throws IOException If any input or output error should occur.
   */
  public NetworkInterface(Socket socket) throws IOException {
    this.socket = socket;

    out = new ObjectOutputStream(socket.getOutputStream());
    out.flush();
    in = new ObjectInputStream(socket.getInputStream());

    /*
     * We might get this working, but the GZIP stuff is not working correctly and we may not even
     * worry about it as it might not save us that much time in the long run.
     *
     * try { ObjectStreamFactory osf = ObjectStreamFactory.getFactory(); out =
     * osf.getOutputStream(socket.getOutputStream()); out.flush(); in =
     * osf.getInputStream(socket.getInputStream()); } catch (ClassNotFoundException cnfe) { } catch
     * (IllegalAccessException iae) { } catch (InstantiationException ie) { } catch
     * (InvocationTargetException ite) { }
     */
  }

  /**
   * Writes the specified data to the {@link OutputStream}.
   *
   * @param data The data to write to the {@link OutputStream}.
   * @param listener The listener waiting for the data.
   * @throws IOException If the object was unable to be transmitted.
   */
  public void sendData(Data data, DataListener listener) throws IOException {
    out.writeObject(data);
  }

  /**
   * Returns whether or not the {@link Socket} associated with this {@link NetworkInterface} is
   * currently connected.
   *
   * @return True If the socket is open, false otherwise.
   */
  public boolean isConnected() {
    return !socket.isClosed();
  }

  /** Closes the {@link Socket} for the network connection. */
  public void close() {
    try {
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Returns the {@link Socket} associated with this network connection.
   *
   * @return The {@link Socket} associated with this network connection.
   */
  public Socket getSocket() {
    return socket;
  }

  /** Reads from the {@link InputStream} while data is available. */
  public void run() {
    try {
      while (!socket.isClosed()) {
        if (in.available() > -1) {
          try {
            notifyReceipt((Data) in.readObject());
          } catch (EOFException eofe) {
          }
        }
      }
    } catch (SocketException se) {
      // Used to enable "fail-over" (i.e. server crashes)
      notifyReceipt(null);
    } catch (IOException ioe) {
      ioe.printStackTrace();
    } catch (ClassNotFoundException cnfe) {
      cnfe.printStackTrace();
    } finally {
      closeDataSource();
    }
  }
}
