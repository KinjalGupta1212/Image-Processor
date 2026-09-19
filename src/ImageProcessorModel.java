/**
 * The interface for model implementations that is able to process an image based on filters and
 * color transformations.
 */
public interface ImageProcessorModel {

  /**
   * Gets the pixel at a given row and column from a list of list of Pixel.
   *
   * @param row    the row to get the pixel from
   * @param column the column to get the pixel from
   * @return the pixel at a given row and column from a list of list of Pixel
   */
  Pixel getPixel(int row, int column);

  /**
   * Uses information about the image to create a string with a PPM format.
   *
   * @return a String that represents the image information and can be used in exporting as a PPM.
   */
  String formattedExportString();

  /**
   * Makes a blurred version of the image in the model.
   *
   * @return the new image that is a blurred copy of the original
   */
  Image blurImage();

  /**
   * Makes a sharpened version of the image in the model.
   *
   * @return the new image that is a sharpened copy of the original
   */
  Image sharpenImage();

  /**
   * Makes a grey-scale version of the image in the model.
   *
   * @return the new image that is a grey-scale copy of the original
   */
  Image greyScaleImage();

  /**
   * Makes a sepia version of the image in the model.
   *
   * @return the new image that is a sepia copy of the original
   */
  Image sepiaImage();

}
