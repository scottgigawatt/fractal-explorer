package com.fractal.app.image;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * This class a models an image and provides functionality for writing JPEG image files.
 *
 * @author Scott Gigawatt
 * @version 7 July 2017
 */
public class Image {
  /** The default width of an image. */
  public static final int DEFAULT_WIDTH = 800;

  /** The default height of an image. */
  public static final int DEFAULT_HEIGHT = 800;

  /** The default id number associated with this image. */
  public static final int DEFAULT_ID = -1;

  /** The default x-value image buffer index. */
  public static final int DEFAULT_X = -1;

  /** The default y-value image buffer index. */
  public static final int DEFAULT_Y = -1;

  /** The format to use for encoding the image file. */
  private final String FORMAT = "JPEG";

  /** The {@link Image}. */
  private BufferedImage image;

  /** The unique id number associated with this image. */
  private int id;

  /** The x-value image buffer index. */
  private int xCoord;

  /** The y-value image buffer index. */
  private int yCoord;

  /**
   * Constructs a new {@link Image} with a default width, height, and id number.
   */
  public Image() {
    this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
  }

  /**
   * Constructs a new {@link Image} with the specified width, height, and default id number.
   *
   * @param width The width of the image.
   * @param height The height of the image.
   */
  public Image(int width, int height) {
    this(width, height, DEFAULT_ID, DEFAULT_X, DEFAULT_Y);
  }

  /**
   * Constructs a new {@link Image} with the specified width, height, and id number.
   *
   * @param width The width of the image.
   * @param height The height of the image.
   * @param id The unique id number associated with this image.
   * @param xCoord The x-value image buffer index.
   * @param yCoord The y-value image buffer index.
   */
  public Image(int width, int height, int id, int xCoord, int yCoord) {
    this.id = id;
    this.xCoord = xCoord;
    this.yCoord = yCoord;
    image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
  }

  /**
   * Constructs a new {@link Image} from the specified byte array and id number.
   *
   * @param image The byte array to use to create the image.
   * @param id The unique id number associated with this image.
   * 
   * @throws IOException If any input or output error should occur.
   */
  public Image(byte[] image, int id, int xCoord, int yCoord) throws IOException {
    this.image = ImageIO.read(new ByteArrayInputStream(image));
    this.id = id;
    this.xCoord = xCoord;
    this.yCoord = yCoord;
  }

  /**
   * Prints the graphical representation of the set to an image file.
   *
   * @param fileName The name of the target file.
   *
   * @throws IOException If any input or output exception should occur.
   */
  public void writeToFile(String fileName) throws IOException {
    ImageIO.write(image, FORMAT, new File(fileName));
  }

  /**
   * Returns the byte array representation of this image. This method provides adds functionality
   * for serializing an {@link Image} across a network.
   *
   * @return The byte array representation of this image.
   *
   * @throws IOException If any input or output exception should occur.
   */
  public byte[] toByteArray() throws IOException {
    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    ImageIO.write(image, FORMAT, stream);

    return stream.toByteArray();
  }

  /**
   * Returns the {@link BufferedImage} associated with this image.
   *
   * @return The {@link BufferedImage} associated with this image.
   */
  public BufferedImage getImage() {
    return image;
  }

  /**
   * Returns the x-value offset into the image buffer.
   *
   * @return The x-value offset into the image buffer.
   */
  public int getX() {
    return xCoord;
  }

  /**
   * Returns the y-value offset into the image buffer.
   *
   * @return The y-value offset into the image buffer.
   */
  public int getY() {
    return yCoord;
  }

  /**
   * Returns the width of the image.
   *
   * @return The width of the image.
   */
  public int getWidth() {
    return image.getWidth();
  }

  /**
   * Returns the height of the image.
   *
   * @return The height of the image.
   */
  public int getHeight() {
    return image.getHeight();
  }

  /**
   * Returns the unique id number for this image.
   *
   * @return The unique id number for this image.
   */
  public int getId() {
    return id;
  }
}
