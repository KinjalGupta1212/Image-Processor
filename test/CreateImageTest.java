import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class CreateImageTest {

  @Test(expected = IllegalArgumentException.class)
  public void checkerboardDisallowsNegTileSize() {
    CreateImage.checkerBoard(-1, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void checkerboardDisallowsNegNumTiles() {
    CreateImage.checkerBoard(1, -3);
  }

  @Test
  public void checkerboardUnequalDiffTileSize() {
    assertNotEquals(CreateImage.checkerBoard(4, 4), CreateImage.checkerBoard(3, 4));
  }

  @Test
  public void checkerboardUnequalNumTiles() {
    assertNotEquals(CreateImage.checkerBoard(4, 4), CreateImage.checkerBoard(4, 5));
  }

  @Test
  public void checkerboardUnequalTileSizeNumTiles() {
    assertNotEquals(CreateImage.checkerBoard(3, 4), CreateImage.checkerBoard(4, 5));
  }

  @Test
  public void checkerboardWorks2by2() {
    // create 2x2 checkerboard
    Pixel whitePix1 = new Pixel(new Position(0, 0), 255, 255, 255);
    Pixel whitePix2 = new Pixel(new Position(1, 1), 255, 255, 255);
    Pixel blackPix1 = new Pixel(new Position(0, 1), 0, 0, 0);
    Pixel blackPix2 = new Pixel(new Position(1, 0), 0, 0, 0);
    List<List<Pixel>> board = new ArrayList<>();
    ArrayList<Pixel> row1 = new ArrayList<>();
    row1.add(whitePix1);
    row1.add(blackPix1);
    ArrayList<Pixel> row2 = new ArrayList<>();
    row2.add(blackPix2);
    row2.add(whitePix2);
    board.add(row1);
    board.add(row2);
    Image checkerboardSize2 = new Image(board);

    assertEquals(checkerboardSize2, CreateImage.checkerBoard(1, 2));
  }

  @Test
  public void checkerboardWorks3by3() {
    // create 3x3 checkerboard
    Pixel whitePix1 = new Pixel(new Position(0, 0), 255, 255, 255);
    Pixel whitePix2 = new Pixel(new Position(0, 2), 255, 255, 255);
    Pixel whitePix3 = new Pixel(new Position(1, 1), 255, 255, 255);
    Pixel whitePix4 = new Pixel(new Position(2, 0), 255, 255, 255);
    Pixel whitePix5 = new Pixel(new Position(2, 2), 255, 255, 255);

    Pixel blackPix1 = new Pixel(new Position(0, 1), 0, 0, 0);
    Pixel blackPix2 = new Pixel(new Position(1, 0), 0, 0, 0);
    Pixel blackPix3 = new Pixel(new Position(1, 2), 0, 0, 0);
    Pixel blackPix4 = new Pixel(new Position(2, 1), 0, 0, 0);

    List<List<Pixel>> board = new ArrayList<>();
    ArrayList<Pixel> row1 = new ArrayList<>();
    row1.add(whitePix1);
    row1.add(blackPix1);
    row1.add(whitePix2);
    ArrayList<Pixel> row2 = new ArrayList<>();
    row2.add(blackPix2);
    row2.add(whitePix3);
    row2.add(blackPix3);
    ArrayList<Pixel> row3 = new ArrayList<>();
    row3.add(whitePix4);
    row3.add(blackPix4);
    row3.add(whitePix5);
    board.add(row1);
    board.add(row2);
    board.add(row3);
    Image checkerboardSize3 = new Image(board);
    assertEquals(checkerboardSize3, CreateImage.checkerBoard(1, 3));
  }


}