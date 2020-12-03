package com.fractal.app.algorithms.math;

import java.math.BigDecimal;

import com.fractal.app.algorithms.color.BandedColoringAlgorithm;
import com.fractal.app.algorithms.color.ColoringAlgorithm;
import com.fractal.app.algorithms.color.SmoothColoringAlgorithm;

/**
 * This class models and displays a graphical representations of the well known Mandelbrot and Julia
 * sets and provides support for performing calculations with increased precision.
 *
 * @author Scott Gigawatt
 *
 * @version 6 July 2017
 */
public class PrecisionComplexSet extends AbstractComplexSet {
  /** Represents the selection of the {@link BandedColoringAlgorithm}. */
  private static final int COLOR_ALG_BANDED = 0;

  /** Represents the selection of the {@link SmoothColoringAlgorithm}. */
  private static final int COLOR_ALG_SMOOTH = COLOR_ALG_BANDED + 1;

  /** Represents the number zero. */
  private static final BigDecimal ZERO = new BigDecimal(0.0);

  /** The maximum number of iterations to perform. */
  private int maxIt;

  /** The power to which the set will be raised. */
  private int power;

  /** The number used to calculate the precision set. */
  private ComplexNumber z;

  /** The algorithm used to choose colors for points within the set. */
  private ColoringAlgorithm colorAlg;

  /**
   * Creates a new {@link PrecisionComplexSet} based on the specified {@link Region}.
   *
   * @param region The {@link Region} on which to base the set.
   */
  public PrecisionComplexSet(Region region) {
    super(region);

    this.power = region.getPower();
    this.maxIt = region.getMaxIt();
    this.z = new ComplexNumber(ZERO, ZERO);

    z.setPrecision(region.getPrecisionBits());
    setColorAlg(region.getColorAlg());
  }

  /**
   * Tests for point inclusion within the set. Point inclusion can be based on a specified point, c,
   * e.g. calculating Julia sets.
   *
   * @param z The point to test for set inclusion.
   * @param c The point on which to base set, can be null.
   *
   * @return The RGB value of the color for the point.
   */
  public int testPoint(ComplexNumber z, ComplexNumber c) {
    int color = 0;

    if (c == null) {
      color = testMandelbrotPoint(z);
    } else {
      color = testJuliaPoint(z, c);
    }

    return color;
  }

  /**
   * Sets the {@link ColoringAlgorithm} of the set to the specified algorithm.
   *
   * @param color The new {@link ColoringAlgorithm} to use.
   */
  public void setColoringAlgorithm(ColoringAlgorithm colorAlg) {
    this.colorAlg = colorAlg;
  }

  /**
   * The primary method for generating the regions of the Mandelbrot set. For each point z in the
   * complex plane, we iterate over z = z^power + c using complex arithmetic. Iteration halts when
   * the squared magnitude of z is greater than our threshold or we have reached the maximum number
   * of iterations. The number of iterations is returned and mapped to a color.
   *
   * @param c The point to test for set inclusion.
   *
   * @return The RGB value of the color for the point.
   */
  private int testMandelbrotPoint(ComplexNumber c) {
    z.setPx(ZERO);
    z.setPy(ZERO);

    for (int i = 0; i < maxIt; ++i) {
      for (int j = 1; j < power; ++j) {
        // Numbers could potentially get very large here
        try {
          z = z.pMult(z);
        } catch (ArithmeticException ae) {
        }
      }

      // Numbers could potentially get very large here
      try {
        z = z.pAdd(c);
      } catch (ArithmeticException ae) {
      }

      try {
        // Numbers could potentially get very large here
        if (z.pMag().intValue() > THRESHOLD) {
          // System.out.println(z.pToString());

          return colorAlg.getColor(z, c, i, true);
        }
      } catch (ArithmeticException ae) {
      }
    }

    // System.out.println(z.pToString());
    return colorAlg.getColor(z, c, maxIt - 1, true);
  }

  /**
   * The primary method for computing a Julia set. For each point z in the complex plane, we iterate
   * over z = z^2 + c using complex arithmetic, where c is the Julia point on which the set will be
   * based. Iteration halts when the squared magnitude of z is greater than our threshold or we have
   * reached the maximum number of iterations. The number of iterations is returned and mapped to a
   * color.
   *
   * @param z The point to test for set inclusion.
   * @param c The point which serves as a basis for a Julia set.
   *
   * @return The RGB value of the color for the point.
   */
  private int testJuliaPoint(ComplexNumber z, ComplexNumber c) {
    // int smoothJulia;

    for (int i = 0; i < maxIt; ++i) {
      for (int j = 1; j < power; ++j) {
        // Numbers could potentially get very large here
        try {
          z = z.pMult(z);
        } catch (ArithmeticException ae) {
        }
      }

      // Numbers could potentially get very large here
      try {
        z = z.pAdd(c);
      } catch (ArithmeticException ae) {
      }

      try {
        // Numbers could potentially get very large here
        if (z.pMag().intValue() > THRESHOLD) {
          return colorAlg.getColor(z, c, i, false);
        }
      } catch (ArithmeticException ae) {
      }
    }

    return colorAlg.getColor(z, c, maxIt - 1, false);
  }

  /**
   * Instantiates the appropriate {@link ColoringAlgorithm}.
   *
   * @param choice The {@link ColoringAlgorithm} choice.
   */
  private void setColorAlg(int choice) {
    switch (choice) {
      case COLOR_ALG_BANDED:
        colorAlg = new BandedColoringAlgorithm(maxIt);
        break;
      case COLOR_ALG_SMOOTH:
        colorAlg = new SmoothColoringAlgorithm(maxIt);
        break;
    }
  }
}
