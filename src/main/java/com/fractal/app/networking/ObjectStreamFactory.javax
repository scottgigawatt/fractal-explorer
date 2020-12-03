package com.fractal.app.networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;

/**
 * This abstract factory provides common functionality for creating various {@link Object} streams.
 *
 * @author Scott Gigawatt
 * @version 7 July 2017
 */
public abstract class ObjectStreamFactory {
  /**
   * Returns the specified {@link OutputStream} wrapped in an {@link ObjectOutputStream}.
   *
   * @param stream The {@link OutputStream} to wrap.
   *
   * @return The newly created {@link ObjectOutputStream}.
   *
   * @throws IOException If any input or output error should occur.
   */
  public abstract ObjectOutputStream getOutputStream(OutputStream stream) throws IOException;

  /**
   * Returns the specified {@link InputStream} wrapped in an {@link ObjectInputStream}.
   *
   * @param stream The {@link InputStream} to wrap.
   * 
   * @return The newly created {@link ObjectInputStream}.
   *
   * @throws IOException If any input or output error should occur.
   */
  public abstract ObjectInputStream getInputStream(InputStream stream) throws IOException;

  /**
   * Returns the appropriate {@link ObjectStreamFactory} for creating {@link Object} streams.
   *
   * @return The {@link ObjectStreamFactory}.
   *
   * @throws ClassNotFoundException If the class type could not be found.
   * @throws IllegalAccessException If accessing the constructor fails.
   * @throws InstantiationException If any instantiation error occurs.
   * @throws InvocationTargetException If the constructor invocation failed.
   */
  public static ObjectStreamFactory getFactory() throws ClassNotFoundException,
      IllegalAccessException, InstantiationException, InvocationTargetException {

    String factoryType = "StandardObjectStreamFactory";
    Class<?> klass = Class.forName(factoryType);
    // Constructor<?> constructor = klass.getConstructors()[0];

    return (ObjectStreamFactory) klass.newInstance();
  }
}
