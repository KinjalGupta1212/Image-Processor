import java.util.Objects;

/**
 * This class is an implementation of IPixel, representing a pixel with a position, that is the row
 * and column, and a red, green, and blue value.
 */
public class Pixel implements IPixel {

  private final Position pos;
  private int red;
  private int green;
  private int blue;

  /**
   * The main constructor of the pixel.
   *
   * @param pos   The row and column of the pixel
   * @param red   The red integer value of the pixel color
   * @param green The green integer value of the pixel color
   * @param blue  The blue integer value of the pixel color
   */
  public Pixel(Position pos, int red, int green, int blue) {
    if (pos == null) {
      throw new IllegalArgumentException("Position cannot be null.");
    }
    this.pos = pos;
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
   * The copy constructor.
   */
  public Pixel(Pixel p) {
    this(p.pos, p.red, p.green, p.blue);
  }

  @Override
  public String toString() {
    return " " + String.valueOf(this.red) + " " + String.valueOf(this.green) + " "
        + String.valueOf(this.blue);
  }

  @Override
  public double changeRGB(ChannelType type, double filterValue) throws IllegalArgumentException {
    double changedValue = 0;
    switch (type) {
      case RED:
        changedValue = (this.red * filterValue);
        break;
      case GREEN:
        changedValue = (this.green * filterValue);
        break;
      case BLUE:
        changedValue = (this.blue * filterValue);
        break;
      default:
        throw new IllegalArgumentException("Invalid ChannelType.");
    }
    return changedValue;
  }

  @Override
  public void applyFilter(ChannelType type, double pixelsValue) throws IllegalArgumentException {
    if (type == null) {
      throw new IllegalArgumentException("Invalid ChannelType.");
    }
    switch (type) {
      case RED:
        this.red = (int) pixelsValue;
        break;
      case GREEN:
        this.green = (int) pixelsValue;
        break;
      case BLUE:
        this.blue = (int) pixelsValue;
        break;
      default:
        throw new IllegalArgumentException("Invalid ChannelType.");
    }
  }

  @Override
  public void clamp() {
    if (red < 0) {
      this.red = 0;
    }
    if (blue < 0) {
      this.blue = 0;
    }
    if (green < 0) {
      this.green = 0;
    }
    if (red > 255) {
      this.red = 255;
    }
    if (blue > 255) {
      this.blue = 255;
    }
    if (green > 255) {
      this.green = 255;
    }
  }

  @Override
  public boolean equals(Object a) {
    if (this == a) {
      return true;
    }
    if (!(a instanceof Pixel)) {
      return false;
    }

    Pixel that = (Pixel) a;

    return (this.pos.equals(that.pos) && (this.red == that.red) && (this.green == that.green) && (
        this.blue == that.blue));
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.pos, this.red, this.green, this.blue);
  }

}
