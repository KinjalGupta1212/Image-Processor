import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * An implementation of the ImageProcessor interface. It represents an image as a list of list of
 * Pixel and contains operations that can be performed on the image.
 */
public final class Image implements ImageProcessorModel {

  private final List<List<Pixel>> imagePixels;

  /**
   * Reads a given file to determine initialize the Image as list of list Pixel.
   *
   * @param file the file name
   * @throws IllegalArgumentException if the file name is null
   */
  public Image(String file) throws IllegalArgumentException {
    if (file == null) {
      throw new IllegalArgumentException("Image cannot be null.");
    }
    this.imagePixels = ImageUtil.readPPM(file);
  }

  /**
   * Initializes an Image as a given list of list Pixel.
   *
   * @param pixels the list containing all the pixels in an image
   * @throws IllegalArgumentException if the list ontaining all the pixels is null
   */
  public Image(List<List<Pixel>> pixels) throws IllegalArgumentException {
    if (pixels == null) {
      throw new IllegalArgumentException("Image cannot be null.");
    }
    this.imagePixels = pixels;
  }

  @Override
  public Pixel getPixel(int row, int column) {
    return this.imagePixels.get(row).get(column);
  }

  @Override
  public String formattedExportString() {
    StringBuilder sb = new StringBuilder();
    sb.append("P3 ").append(this.imagePixels.get(0).size() + " ")
        .append(this.imagePixels.size() + " ").append("255");
    for (int i = 0; i < this.imagePixels.size(); i++) {
      for (int j = 0; j < this.imagePixels.get(i).size(); j++) {
        sb.append("\n" + getPixel(i, j).toString());
      }
    }
    return sb.toString();
  }

  @Override
  public Image blurImage() {
    double[][] blur = {
        {.0625, .125, .0625},
        {.125, .25, .125},
        {.0625, .125, .0625}
    };
    return getFilteredImage(blur);
  }

  @Override
  public Image sharpenImage() {
    double[][] sharpen = {
        {-.125, -.125, -.125, -.125, -.125},
        {-.125, .25, .25, .25, -.125},
        {-.125, .25, 1, .25, -.125},
        {-.125, .25, .25, .25, -.125},
        {-.125, -.125, -.125, -.125, -.125}
    };

    return getFilteredImage(sharpen);
  }

  /**
   * Filters an image using a given kernel.
   *
   * @param kernel the kernel (matrix) to be applied to pixels in an image
   * @return the filtered image
   */
  private Image getFilteredImage(double[][] kernel) {
    List<List<Pixel>> copyImage = copyImage(this.imagePixels);

    filterEachPixel(kernel, copyImage);
    return new Image(copyImage);
  }

  /**
   * Makes a copy of an image's list of list of Pixel.
   *
   * @param pixels list of list of Pixel of an image
   * @return a copy of an image's list of list of Pixel
   */
  private List<List<Pixel>> copyImage(List<List<Pixel>> pixels) {
    List<List<Pixel>> height = new ArrayList<>();
    for (int i = 0; i < pixels.size(); i++) {
      height.add(new ArrayList<Pixel>(pixels.get(i)));
    }
    return height;
  }

  /**
   * Filters each pixel by performing a series of computations on the red, green, and blue channels
   * for each pixel using a given kernel.
   *
   * @param kernel    the kernel (matrix) to be applied to pixels in an image
   * @param copyImage a copy of an image's list of list of Pixel
   */
  private void filterEachPixel(double[][] kernel, List<List<Pixel>> copyImage) {
    for (int i = 0; i < this.imagePixels.size(); i++) {
      for (int j = 0; j < this.imagePixels.get(i).size(); j++) {
        double redPixelsValue = this.newPixelVal(ChannelType.RED, kernel, i, j);
        copyImage.get(i).get(j).applyFilter(ChannelType.RED, redPixelsValue);

        double greenPixelsValue = this.newPixelVal(ChannelType.GREEN, kernel, i, j);
        copyImage.get(i).get(j).applyFilter(ChannelType.GREEN, greenPixelsValue);

        double bluePixelsValue = this.newPixelVal(ChannelType.BLUE, kernel, i, j);
        copyImage.get(i).get(j).applyFilter(ChannelType.BLUE, bluePixelsValue);

        copyImage.get(i).get(j).clamp();
      }
    }
  }

  /**
   * Applies the kernel onto a particular pixel to return the value of a channel of the pixel
   *
   * @param type   the ChannelType, either Red, Green, or Blue
   * @param filter the kernel (matrix) to be applied to pixels in an image
   * @param row    the row of the pixel that is being worked on
   * @param column the column of the pixel that is being worked on
   * @return the value f a channel of the pixel after being filtered
   */
  private double newPixelVal(ChannelType type, double[][] filter, int row, int column) {
    double sum = 0;
    int centerKernel = filter.length / 2;

    for (int x = 0; x < filter.length; x++) {
      for (int y = 0; y < filter.length; y++) {
        if (((row - centerKernel + x) > 0) && ((row - centerKernel + x) < this.imagePixels.size())
            && ((column - centerKernel + y) > 0) && ((column - centerKernel + y) < this.imagePixels
            .get(row).size())) {
          sum = sum + (getPixel((row - centerKernel + x), (column - centerKernel + y)))
              .changeRGB(type, filter[x][y]);
        }
      }
    }
    return sum;
  }

  @Override
  public Image greyScaleImage() {
    double[][] grey = {
        {.2126, .7152, .0722},
        {.2126, .7152, .0722},
        {.2126, .7152, .0722}
    };
    return getTransformedImage(grey);
  }

  @Override
  public Image sepiaImage() {
    double[][] sepia = {
        {.393, .769, .189},
        {.349, .686, .168},
        {.272, .534, .131}
    };
    return getTransformedImage(sepia);
  }

  /**
   * Transforms an image using a given kernel.
   *
   * @param sepia the kernel for a sepia transformation
   * @return the transformed image
   */
  private Image getTransformedImage(double[][] sepia) {
    List<List<Pixel>> copyImage = copyImage(this.imagePixels);

    colorTransformEachPixel(sepia, copyImage);
    return new Image(copyImage);
  }

  /**
   * Transforms each pixel in a given image using a given kernel that allows for the
   * transformation.
   *
   * @param kernel    the kernel (matrix) to be applied to an image
   * @param copyImage a copy of the list of list of Pixel of an image.
   */
  private void colorTransformEachPixel(double[][] kernel, List<List<Pixel>> copyImage) {
    for (int i = 0; i < this.imagePixels.size(); i++) {
      for (int j = 0; j < this.imagePixels.get(i).size(); j++) {

        int sumRed = getSum(kernel, i, j, ChannelType.RED);
        copyImage.get(i).get(j).applyFilter(ChannelType.RED, sumRed);
        int sumGreen = getSum(kernel, i, j, ChannelType.GREEN);
        copyImage.get(i).get(j).applyFilter(ChannelType.GREEN, sumGreen);
        int sumBlue = getSum(kernel, i, j, ChannelType.BLUE);
        copyImage.get(i).get(j).applyFilter(ChannelType.BLUE, sumBlue);
        copyImage.get(i).get(j).clamp();
      }
    }
  }

  /**
   * Gets the sum of values that represent applying a kernel onto a pixel.
   *
   * @param kernel the kernel (matrix) to be applied to an image
   * @param i      the row of the pixel to be transformed
   * @param j      the column of the pixel to be transformed
   * @param type   the ChannelType, either Red, Green, or Blue
   * @return the sum of values that represent applying a kernel onto a pixel
   * @throws IllegalArgumentException if the ChannelType is null
   */
  private int getSum(double[][] kernel, int i, int j, ChannelType type)
      throws IllegalArgumentException {
    if (type == null) {
      throw new IllegalArgumentException("Invalid channel.");
    }
    int sum = 0;
    for (int x = 0; x < kernel.length; x++) {
      ArrayList<ChannelType> values = new ArrayList<ChannelType>(
          Arrays.asList(ChannelType.values()));
      sum = sum + (int) getPixel(i, j).changeRGB(values.get(x), kernel[values
          .indexOf(type)][x]);
    }
    return sum;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Image)) {
      return false;
    }

    Image that = (Image) o;

    if (!((this.imagePixels.size() == that.imagePixels.size())
        && (this.imagePixels.get(0).size() == that.imagePixels.get(0).size()))) {
      return false;
    } else {
      for (int i = 0; i < this.imagePixels.size(); i++) {
        for (int j = 0; j < this.imagePixels.get(i).size(); j++) {
          if (!(getPixel(i, j).equals(that.getPixel(i, j)))) {
            return false;
          }
        }
      }
      return true;
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.imagePixels);
  }


}
