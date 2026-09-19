import java.util.Objects;

/**
 * This class represents a position that has a row and column.
 */
public final class Position {

  private final int row;
  private final int col;

  /**
   * Initializes a position with a given row and column.
   *
   * @param row the row for the position of something
   * @param col the column for the position of something
   */
  public Position(int row, int col) {
    if ((row < 0) || (col < 0)) {
      throw new IllegalArgumentException("Row and column cannot be negative.");
    }
    this.row = row;
    this.col = col;
  }

  /**
   * The copy constructor.
   */
  public Position(Position v) {
    this(v.row, v.col);
  }

  @Override
  public String toString() {
    return String.format("(%d, %d)", this.row, this.col);
  }

  @Override
  public boolean equals(Object a) {
    if (this == a) {
      return true;
    }
    if (!(a instanceof Position)) {
      return false;
    }

    Position that = (Position) a;

    return ((this.row == that.row) && (this.col == that.col));
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.row, this.col);
  }


}


