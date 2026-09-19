import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for creating images programatically, such as a checkerboard.
 */
public class CreateImage {

  /**
   * Creates an image of a checkerboard given the size of each tile and dimensions of the board.
   *
   * @param tileSize   the size of each tile in a checkerboard
   * @param dimensions the dimension for the row and column of the board
   * @return an image of a checkerboard
   */
  public static Image checkerBoard(int tileSize, int dimensions) {
    if (tileSize < 0 || dimensions < 0) {
      throw new IllegalArgumentException("Cannot have negative number of tiles or tile size.");
    }

    List<List<Pixel>> board = new ArrayList<>();
    for (int i = 0; i < dimensions; i++) {
      ArrayList<Pixel> column = new ArrayList<>();
      board.add(column);
      for (int j = 0; j < dimensions * tileSize; j++) {
        int remainder = j / tileSize;
        if (((i % 2 == 0) && (remainder % 2 == 0)) || (!(i % 2 == 0) && !(remainder % 2 == 0))) {
          column.add(new Pixel(new Position(i, j), 255, 255, 255));
        } else if (((i % 2 == 0) && !(remainder % 2 == 0))
            || (!(i % 2 == 0) && (remainder % 2 == 0))) {
          column.add(new Pixel(new Position(i, j), 0, 0, 0));
        }
      }
    }
    return new Image(board);
  }

}
