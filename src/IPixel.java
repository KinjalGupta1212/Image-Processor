/**
 * This is the interface representing a pixel in an image.
 */
public interface IPixel {

  @Override
  String toString();

  /**
   * Multiplies the current value of the red (R), green (G), or blue (B) channel by a value given.
   *
   * @param type        the ChannelType to determine whether R, G, or B should have the filter
   *                    applied to
   * @param filterValue the value to multiply the current R, G, or B value by
   * @return a double representing the computation of the current value of the red (R), green (G),
   * or blue (B) channel by a value given
   * @throws IllegalArgumentException if the ChannelType is not valid (Red, Green, or Blue)
   */
  double changeRGB(ChannelType type, double filterValue) throws IllegalArgumentException;

  /**
   * Applies the filter by changing the red (R), green (G), or blue (B) value of a pixel to a given
   * value.
   *
   * @param type        the ChannelType to determine whether R, G, or B should have the filter
   *                    applied to
   * @param pixelsValue the new pixel value for a pixel's R, G, or B
   * @throws IllegalArgumentException if the ChannelType is not valid (Red, Green, or Blue)
   */
  void applyFilter(ChannelType type, double pixelsValue) throws IllegalArgumentException;

  /**
   * Ensures that the RGB values of a pixel are within the 0-255 range. It sets any value below 0 to
   * 0 and sets any value over 255 to 255.
   */
  void clamp();

  @Override
  boolean equals(Object object);

  @Override
  int hashCode();
}
