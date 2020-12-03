package com.fractal.app.networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * This factory provides functionality for creating compressed {@link Object} streams.
 *
 * @author Scott Gigawatt
 * @version 7 July 2017
 */
public class GZIPObjectStreamFactory extends ObjectStreamFactory {
  /**
   * Returns the specified {@link OutputStream} wrapped in a compressed {@link ObjectOutputStream}.
   *
   * @param stream The {@link OutputStream} to wrap.
   * @return The newly compressed {@link ObjectOutputStream}.
   * @throws IOException If any input or output error should occur.
   */
  public ObjectOutputStream getOutputStream(OutputStream stream) throws IOException {
    return new ObjectOutputStream(new GZIPOutputStream(stream));
  }

  /**
   * Returns the specified {@link InputStream} wrapped in a compressed {@link ObjectInputStream}.
   *
   * @param stream The {@link InputStream} to wrap.
   * @return The newly compressed {@link ObjectInputStream}.
   * @throws IOException If any input or output error should occur.
   */
  public ObjectInputStream getInputStream(InputStream stream) throws IOException {
    return new ObjectInputStream(new GZIPInputStream(stream));
  }
}
