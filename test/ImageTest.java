import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class ImageTest {

  private Image sampleImage;


  @Before
  public void setupTestFixture() {
    sampleImage = CreateImage.checkerBoard(1, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullParameterFileConstructor() {
    new Image((String) null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullParameterListConstructor() {
    new Image((List<List<Pixel>>) null);
  }

  @Test
  public void equalsTrue() {
    assertTrue(sampleImage.equals(CreateImage.checkerBoard(1, 3)));
  }

  @Test
  public void equalsFalse() {
    assertFalse(sampleImage.equals(CreateImage.checkerBoard(2, 3)));
  }

  @Test
  public void hashCodeSameWhenImagesAreEqual() {
    assertEquals(sampleImage.hashCode(), CreateImage.checkerBoard(1, 3).hashCode());
  }

  @Test
  public void hashCodeDiffWhenImagesAreUnequal() {
    assertFalse(sampleImage.hashCode() == CreateImage.checkerBoard(2, 3).hashCode());
  }

  @Test
  public void blur3by3() {
    // create 3x3 checkerboard
    Pixel whitePix1 = new Pixel(new Position(0, 0), 15, 15, 15);
    Pixel whitePix2 = new Pixel(new Position(0, 2), 15, 15, 15);
    Pixel whitePix3 = new Pixel(new Position(1, 1), 79, 79, 79);
    Pixel whitePix4 = new Pixel(new Position(2, 0), 4, 4, 4);
    Pixel whitePix5 = new Pixel(new Position(2, 2), 79, 79, 79);

    Pixel blackPix1 = new Pixel(new Position(0, 1), 31, 31, 31);
    Pixel blackPix2 = new Pixel(new Position(1, 0), 31, 31, 31);
    Pixel blackPix3 = new Pixel(new Position(1, 2), 41, 41, 41);
    Pixel blackPix4 = new Pixel(new Position(2, 1), 44, 44, 44);

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
    Image checkerboardBlur = new Image(board);
    assertEquals(checkerboardBlur, CreateImage.checkerBoard(1, 3).blurImage());
  }

  @Test
  public void blurTwice() {
    // create 3x3 checkerboard
    Pixel whitePix1 = new Pixel(new Position(0, 0), 4, 4, 4);
    Pixel whitePix2 = new Pixel(new Position(0, 2), 10, 10, 10);
    Pixel whitePix3 = new Pixel(new Position(1, 1), 35, 35, 35);
    Pixel whitePix4 = new Pixel(new Position(2, 0), 7, 7, 7);
    Pixel whitePix5 = new Pixel(new Position(2, 2), 28, 28, 28);

    Pixel blackPix1 = new Pixel(new Position(0, 1), 12, 12, 12);
    Pixel blackPix2 = new Pixel(new Position(1, 0), 12, 12, 12);
    Pixel blackPix3 = new Pixel(new Position(1, 2), 27, 27, 27);
    Pixel blackPix4 = new Pixel(new Position(2, 1), 26, 26, 26);

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
    Image checkerboardBlur = new Image(board);
    assertEquals(checkerboardBlur, CreateImage.checkerBoard(1, 3).blurImage().blurImage());
  }

  @Test
  public void sharpen3by3() {
    // create 3x3 checkerboard
    Pixel whitePix1 = new Pixel(new Position(0, 0), 31, 31, 31);
    Pixel whitePix2 = new Pixel(new Position(0, 2), 31, 31, 31);
    Pixel whitePix3 = new Pixel(new Position(1, 1), 255, 255, 255);
    Pixel whitePix4 = new Pixel(new Position(2, 0), 16, 16, 16);
    Pixel whitePix5 = new Pixel(new Position(2, 2), 255, 255, 255);

    Pixel blackPix1 = new Pixel(new Position(0, 1), 31, 31, 31);
    Pixel blackPix2 = new Pixel(new Position(1, 0), 31, 31, 31);
    Pixel blackPix3 = new Pixel(new Position(1, 2), 127, 127, 127);
    Pixel blackPix4 = new Pixel(new Position(2, 1), 159, 159, 159);

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
    Image checkerboardSharpen = new Image(board);
    assertEquals(checkerboardSharpen, CreateImage.checkerBoard(1, 3).sharpenImage());
  }

  @Test
  public void sharpenTwice() {
    // create 3x3 checkerboard
    Pixel whitePix1 = new Pixel(new Position(0, 0), 0, 0, 0);
    Pixel whitePix2 = new Pixel(new Position(0, 2), 43, 43, 43);
    Pixel whitePix3 = new Pixel(new Position(1, 1), 255, 255, 255);
    Pixel whitePix4 = new Pixel(new Position(2, 0), 39, 39, 39);
    Pixel whitePix5 = new Pixel(new Position(2, 2), 255, 255, 255);

    Pixel blackPix1 = new Pixel(new Position(0, 1), 43, 43, 43);
    Pixel blackPix2 = new Pixel(new Position(1, 0), 55, 55, 55);
    Pixel blackPix3 = new Pixel(new Position(1, 2), 255, 255, 255);
    Pixel blackPix4 = new Pixel(new Position(2, 1), 255, 255, 255);

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
    Image checkerboardSharpen = new Image(board);
    assertEquals(checkerboardSharpen, CreateImage.checkerBoard(1, 3).sharpenImage().sharpenImage());
  }

  @Test
  public void greyscale3by3() {
    // create 3x3 checkerboard
    Pixel whitePix1 = new Pixel(new Position(0, 0), 254, 254, 253);
    Pixel whitePix2 = new Pixel(new Position(0, 2), 254, 254, 253);
    Pixel whitePix3 = new Pixel(new Position(1, 1), 254, 254, 253);
    Pixel whitePix4 = new Pixel(new Position(2, 0), 254, 254, 253);
    Pixel whitePix5 = new Pixel(new Position(2, 2), 254, 254, 253);

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
    Image checkerboardGreyscale = new Image(board);
    assertEquals(checkerboardGreyscale, CreateImage.checkerBoard(1, 3).greyScaleImage());
  }

  @Test
  public void greyscaleTwice() {
    // create 3x3 checkerboard
    Pixel whitePix1 = new Pixel(new Position(0, 0), 253, 252, 251);
    Pixel whitePix2 = new Pixel(new Position(0, 2), 253, 252, 251);
    Pixel whitePix3 = new Pixel(new Position(1, 1), 253, 252, 251);
    Pixel whitePix4 = new Pixel(new Position(2, 0), 253, 252, 251);
    Pixel whitePix5 = new Pixel(new Position(2, 2), 253, 252, 251);

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
    Image checkerboardGreyscale = new Image(board);
    assertEquals(checkerboardGreyscale,
        CreateImage.checkerBoard(1, 3).greyScaleImage().greyScaleImage());
  }

  @Test
  public void sepia3by3() {
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
    Image checkerboardGreyscale = new Image(board);
    assertEquals(checkerboardGreyscale, CreateImage.checkerBoard(1, 3).sepiaImage());
  }

  @Test
  public void sepiaTwice() {
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
    Image checkerboardGreyscale = new Image(board);
    assertEquals(checkerboardGreyscale, CreateImage.checkerBoard(1, 3).sepiaImage().sepiaImage());
  }

  @Test
  public void blurSharp() {
    // create 3x3 checkerboard
    Pixel whitePix1 = new Pixel(new Position(0, 0), 0, 0, 0);
    Pixel whitePix2 = new Pixel(new Position(0, 2), 14, 14, 14);
    Pixel whitePix3 = new Pixel(new Position(1, 1), 120, 120, 120);
    Pixel whitePix4 = new Pixel(new Position(2, 0), 18, 18, 18);
    Pixel whitePix5 = new Pixel(new Position(2, 2), 164, 164, 164);

    Pixel blackPix1 = new Pixel(new Position(0, 1), 14, 14, 14);
    Pixel blackPix2 = new Pixel(new Position(1, 0), 15, 15, 15);
    Pixel blackPix3 = new Pixel(new Position(1, 2), 101, 101, 101);
    Pixel blackPix4 = new Pixel(new Position(2, 1), 119, 119, 119);

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
    Image checkerboardGreyscale = new Image(board);
    assertEquals(checkerboardGreyscale, CreateImage.checkerBoard(1, 3).blurImage().sharpenImage());
  }

  @Test
  public void blurSepia() {
    // create 3x3 checkerboard
    Pixel whitePix1 = new Pixel(new Position(0, 0), 18, 18, 14);
    Pixel whitePix2 = new Pixel(new Position(0, 2), 18, 18, 14);
    Pixel whitePix3 = new Pixel(new Position(1, 1), 105, 103, 93);
    Pixel whitePix4 = new Pixel(new Position(2, 0), 4, 3, 2);
    Pixel whitePix5 = new Pixel(new Position(2, 2), 105, 103, 93);

    Pixel blackPix1 = new Pixel(new Position(0, 1), 40, 39, 34);
    Pixel blackPix2 = new Pixel(new Position(1, 0), 40, 39, 34);
    Pixel blackPix3 = new Pixel(new Position(1, 2), 54, 52, 46);
    Pixel blackPix4 = new Pixel(new Position(2, 1), 58, 57, 50);

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
    Image checkerboardGreyscale = new Image(board);
    assertEquals(checkerboardGreyscale, CreateImage.checkerBoard(1, 3).blurImage().sepiaImage());
  }

  @Test
  public void blurGreyscale() {
    // create 3x3 checkerboard
    Pixel whitePix1 = new Pixel(new Position(0, 0), 14, 13, 12);
    Pixel whitePix2 = new Pixel(new Position(0, 2), 14, 13, 12);
    Pixel whitePix3 = new Pixel(new Position(1, 1), 77, 77, 76);
    Pixel whitePix4 = new Pixel(new Position(2, 0), 2, 2, 1);
    Pixel whitePix5 = new Pixel(new Position(2, 2), 77, 77, 76);

    Pixel blackPix1 = new Pixel(new Position(0, 1), 30, 30, 29);
    Pixel blackPix2 = new Pixel(new Position(1, 0), 30, 30, 29);
    Pixel blackPix3 = new Pixel(new Position(1, 2), 39, 39, 37);
    Pixel blackPix4 = new Pixel(new Position(2, 1), 43, 43, 42);

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
    Image checkerboardGreyscale = new Image(board);
    assertEquals(checkerboardGreyscale,
        CreateImage.checkerBoard(1, 3).blurImage().greyScaleImage());
  }

  @Test
  public void sharpenSepia() {
    // create 3x3 checkerboard
    Pixel whitePix1 = new Pixel(new Position(0, 0), 40, 39, 34);
    Pixel whitePix2 = new Pixel(new Position(0, 2), 40, 39, 34);
    Pixel whitePix3 = new Pixel(new Position(1, 1), 255, 255, 255);
    Pixel whitePix4 = new Pixel(new Position(2, 0), 21, 19, 17);
    Pixel whitePix5 = new Pixel(new Position(2, 2), 255, 255, 255);

    Pixel blackPix1 = new Pixel(new Position(0, 1), 40, 39, 34);
    Pixel blackPix2 = new Pixel(new Position(1, 0), 40, 39, 34);
    Pixel blackPix3 = new Pixel(new Position(1, 2), 170, 167, 151);
    Pixel blackPix4 = new Pixel(new Position(2, 1), 214, 209, 189);

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
    Image checkerboardGreyscale = new Image(board);
    assertEquals(checkerboardGreyscale, CreateImage.checkerBoard(1, 3).sharpenImage().sepiaImage());
  }

  @Test
  public void sharpenGreyscale() {
    // create 3x3 checkerboard
    Pixel whitePix1 = new Pixel(new Position(0, 0), 30, 30, 29);
    Pixel whitePix2 = new Pixel(new Position(0, 2), 30, 30, 29);
    Pixel whitePix3 = new Pixel(new Position(1, 1), 254, 254, 253);
    Pixel whitePix4 = new Pixel(new Position(2, 0), 15, 15, 14);
    Pixel whitePix5 = new Pixel(new Position(2, 2), 254, 254, 253);

    Pixel blackPix1 = new Pixel(new Position(0, 1), 30, 30, 29);
    Pixel blackPix2 = new Pixel(new Position(1, 0), 30, 30, 29);
    Pixel blackPix3 = new Pixel(new Position(1, 2), 126, 125, 124);
    Pixel blackPix4 = new Pixel(new Position(2, 1), 157, 157, 156);

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
    Image checkerboardGreyscale = new Image(board);
    assertEquals(checkerboardGreyscale,
        CreateImage.checkerBoard(1, 3).sharpenImage().greyScaleImage());
  }

  @Test
  public void sepiaGreyscale() {
    // create 3x3 checkerboard
    Pixel whitePix1 = new Pixel(new Position(0, 0), 254, 254, 253);
    Pixel whitePix2 = new Pixel(new Position(0, 2), 254, 254, 253);
    Pixel whitePix3 = new Pixel(new Position(1, 1), 254, 254, 253);
    Pixel whitePix4 = new Pixel(new Position(2, 0), 254, 254, 253);
    Pixel whitePix5 = new Pixel(new Position(2, 2), 254, 254, 253);

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
    Image checkerboardGreyscale = new Image(board);
    assertEquals(checkerboardGreyscale,
        CreateImage.checkerBoard(1, 3).sepiaImage().greyScaleImage());
  }

  @Test
  public void blurSharpenGreyscaleSepia() {
    // create 3x3 checkerboard
    Pixel whitePix1 = new Pixel(new Position(0, 0), 0, 0, 0);
    Pixel whitePix2 = new Pixel(new Position(0, 2), 16, 15, 13);
    Pixel whitePix3 = new Pixel(new Position(1, 1), 158, 154, 139);
    Pixel whitePix4 = new Pixel(new Position(2, 0), 20, 18, 15);
    Pixel whitePix5 = new Pixel(new Position(2, 2), 217, 212, 192);

    Pixel blackPix1 = new Pixel(new Position(0, 1), 16, 15, 13);
    Pixel blackPix2 = new Pixel(new Position(1, 0), 16, 15, 13);
    Pixel blackPix3 = new Pixel(new Position(1, 2), 133, 130, 117);
    Pixel blackPix4 = new Pixel(new Position(2, 1), 158, 154, 139);

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
    Image checkerboardGreyscale = new Image(board);
    assertEquals(checkerboardGreyscale,
        CreateImage.checkerBoard(1, 3).blurImage().sharpenImage().greyScaleImage().sepiaImage());
  }

  @Test
  public void getPixelWhiteTile() {
    assertEquals(new Pixel(new Position(0, 0), 255, 255, 255), sampleImage.getPixel(0, 0));
  }

  @Test
  public void getPixelBlackTile() {
    assertEquals(new Pixel(new Position(2, 1), 0, 0, 0), sampleImage.getPixel(2, 1));
  }
}
