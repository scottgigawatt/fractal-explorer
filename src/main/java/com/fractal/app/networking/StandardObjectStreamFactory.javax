package com.fractal.app.networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * This factory provides functionality for creating {@link Object} streams.
 *
 * @author Scott Gigawatt
 * @version 7 July 2017
 */
public class StandardObjectStreamFactory extends ObjectStreamFactory {
  /**
   * Returns the specified {@link OutputStream} wrapped in an {@link ObjectOutputStream}.
   *
   * @param stream The {@link OutputStream} to wrap.
   *
   * @return The newly created {@link ObjectOutputStream}.
   *
   * @throws IOException If any input or output error should occur.
   */
  public ObjectOutputStream getOutputStream(OutputStream stream) throws IOException {
    return new ObjectOutputStream(stream);
  }

  /**
   * Returns the specified {@link InputStream} wrapped in an {@link ObjectInputStream}.
   *
   * @param stream The {@link InputStream} to wrap.
   *
   * @return The newly created {@link ObjectInputStream}.
   *
   * @throws IOException If any input or output error should occur.
   */
  public ObjectInputStream getInputStream(InputStream stream) throws IOException {
    return new ObjectInputStream(stream);
  }
}
