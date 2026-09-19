import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test class for
 */
public class PixelTest {

  private Pixel samplePixelMain;
  private Pixel samplePixelCopy;


  @Before
  public void setupTestFixture() {
    samplePixelMain = new Pixel(new Position(3, 2), 34, 80, 65);
    samplePixelCopy = new Pixel(new Pixel(new Position(3, 2), 34, 80, 65));
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullPosMainConstructor() {
    new Pixel(null, 34, 80, 60);
  }

  @Test(expected = IllegalArgumentException.class)
  public void nullPosCopyConstructor() {
    new Pixel(new Pixel(null, 34, 80, 60));
  }

  @Test
  public void pixelToStringMainConstructor() {
    assertEquals(" 34 80 65", samplePixelMain.toString());
  }

  @Test
  public void pixelToStringCopyConstructor() {
    assertEquals(" 34 80 65", samplePixelCopy.toString());
  }

  @Test
  public void pixelChangeRGBRedBothConstructors1() {
    assertEquals(17.0, samplePixelCopy.changeRGB(ChannelType.RED, .5), 0.01);
    assertEquals(17.0, samplePixelMain.changeRGB(ChannelType.RED, .5), 0.01);
  }

  @Test
  public void pixelChangeRGBRedBothConstructors2() {
    assertEquals(34.0, samplePixelCopy.changeRGB(ChannelType.RED, 1), 0.01);
    assertEquals(34.0, samplePixelMain.changeRGB(ChannelType.RED, 1), 0.01);
  }

  @Test
  public void pixelChangeRGBGreenBothConstructors1() {
    assertEquals(40.0, samplePixelCopy.changeRGB(ChannelType.GREEN, .5), 0.01);
    assertEquals(40.0, samplePixelMain.changeRGB(ChannelType.GREEN, .5), 0.01);
  }

  @Test
  public void pixelChangeRGBGreenBothConstructors2() {
    assertEquals(80.0, samplePixelCopy.changeRGB(ChannelType.GREEN, 1), 0.01);
    assertEquals(80.0, samplePixelMain.changeRGB(ChannelType.GREEN, 1), 0.01);
  }

  @Test
  public void pixelChangeRGBBlueBothConstructors1() {
    assertEquals(32.5, samplePixelCopy.changeRGB(ChannelType.BLUE, .5), 0.01);
    assertEquals(32.5, samplePixelMain.changeRGB(ChannelType.BLUE, .5), 0.01);
  }

  @Test
  public void pixelChangeRGBBlueBothConstructors2() {
    assertEquals(65.0, samplePixelCopy.changeRGB(ChannelType.BLUE, 1), 0.01);
    assertEquals(65.0, samplePixelMain.changeRGB(ChannelType.BLUE, 1), 0.01);
  }

  @Test
  public void applyFilterRedBothConstructors1() {
    samplePixelMain.applyFilter(ChannelType.RED, 30.75);
    assertEquals(new Pixel(new Position(3, 2), 30, 80, 65), samplePixelMain);

    samplePixelCopy.applyFilter(ChannelType.RED, 30.75);
    assertEquals(
        new Pixel(new Pixel(new Position(3, 2), 30, 80, 65)), samplePixelMain);
  }

  @Test
  public void applyFilterRedBothConstructors2() {
    samplePixelMain.applyFilter(ChannelType.RED, 20.1);
    assertEquals(new Pixel(new Position(3, 2), 20, 80, 65), samplePixelMain);

    samplePixelCopy.applyFilter(ChannelType.RED, 20.1);
    assertEquals(
        new Pixel(new Pixel(new Position(3, 2), 20, 80, 65)), samplePixelMain);
  }

  @Test
  public void applyFilterGreenBothConstructors1() {
    samplePixelMain.applyFilter(ChannelType.GREEN, 30.75);
    assertEquals(new Pixel(new Position(3, 2), 34, 30, 65), samplePixelMain);

    samplePixelCopy.applyFilter(ChannelType.GREEN, 30.75);
    assertEquals(new Pixel(new Pixel(new Position(3, 2), 34, 30, 65)), samplePixelMain);
  }

  @Test
  public void applyFilterGreenBothConstructors2() {
    samplePixelMain.applyFilter(ChannelType.GREEN, 20.1);
    assertEquals(new Pixel(new Position(3, 2), 34, 20, 65), samplePixelMain);

    samplePixelCopy.applyFilter(ChannelType.GREEN, 20.1);
    assertEquals(new Pixel(new Pixel(new Position(3, 2), 34, 20, 65)), samplePixelMain);
  }

  @Test
  public void applyFilterBlueBothConstructors1() {
    samplePixelMain.applyFilter(ChannelType.BLUE, 30.75);
    assertEquals(new Pixel(new Position(3, 2), 34, 80, 30), samplePixelMain);

    samplePixelCopy.applyFilter(ChannelType.BLUE, 30.75);
    assertEquals(new Pixel(new Pixel(new Position(3, 2), 34, 80, 30)), samplePixelMain);
  }

  @Test
  public void applyFilterBlueBothConstructors2() {
    samplePixelMain.applyFilter(ChannelType.BLUE, 20.1);
    assertEquals(new Pixel(new Position(3, 2), 34, 80, 20), samplePixelMain);

    samplePixelCopy.applyFilter(ChannelType.BLUE, 20.1);
    assertEquals(new Pixel(new Pixel(new Position(3, 2), 34, 80, 20)), samplePixelMain);
  }

  @Test(expected = IllegalArgumentException.class)
  public void applyFilterNullChannelBothConstructors() {
    samplePixelMain.applyFilter(null, 20.1);
    samplePixelCopy.applyFilter(null, 20.1);
  }

  @Test
  public void clampRedBelowMinBothConstructors() {
    Pixel pixelRedBelowMinMain = new Pixel(new Position(3, 2), -1, 80, 65);
    Pixel pixelRedBelowMinCopy = new Pixel(new Pixel(new Position(3, 2), -1, 80, 65));

    pixelRedBelowMinMain.clamp();
    assertEquals(new Pixel(new Position(3, 2), 0, 80, 65), pixelRedBelowMinMain);

    pixelRedBelowMinCopy.clamp();
    assertEquals(new Pixel(new Position(3, 2), 0, 80, 65), pixelRedBelowMinCopy);
  }

  @Test
  public void clampGreenBelowMinBothConstructors() {
    Pixel pixelGreenBelowMinMain = new Pixel(new Position(3, 2), 34, -1, 65);
    Pixel pixelGreenBelowMinCopy = new Pixel(new Pixel(new Position(3, 2), 34, -1, 65));

    pixelGreenBelowMinMain.clamp();
    assertEquals(new Pixel(new Position(3, 2), 34, 0, 65), pixelGreenBelowMinMain);

    pixelGreenBelowMinCopy.clamp();
    assertEquals(new Pixel(new Position(3, 2), 34, 0, 65), pixelGreenBelowMinCopy);
  }

  @Test
  public void clampBlueBelowMinBothConstructors() {
    Pixel pixelBlueBelowMinMain = new Pixel(new Position(3, 2), 34, 80, -1);
    Pixel pixelBlueBelowMinCopy = new Pixel(new Pixel(new Position(3, 2), 34, 80, -1));

    pixelBlueBelowMinMain.clamp();
    assertEquals(new Pixel(new Position(3, 2), 34, 80, 0), pixelBlueBelowMinMain);

    pixelBlueBelowMinCopy.clamp();
    assertEquals(new Pixel(new Position(3, 2), 34, 80, 0), pixelBlueBelowMinCopy);
  }

  @Test
  public void clampAllBelowMinBothConstructors() {
    Pixel pixelAllBelowMinMain = new Pixel(new Position(3, 2), -1, -1, -1);
    Pixel pixelAllBelowMinCopy = new Pixel(new Pixel(new Position(3, 2), -1, -1, -1));

    pixelAllBelowMinMain.clamp();
    assertEquals(new Pixel(new Position(3, 2), 0, 0, 0), pixelAllBelowMinMain);

    pixelAllBelowMinCopy.clamp();
    assertEquals(new Pixel(new Position(3, 2), 0, 0, 0), pixelAllBelowMinCopy);
  }

  @Test
  public void clampRedAboveMaxBothConstructors() {
    Pixel pixelRedAboveMaxMain = new Pixel(new Position(3, 2), 300, 80, 65);
    Pixel pixelRedAboveMaxCopy = new Pixel(new Pixel(new Position(3, 2), 300, 80, 65));

    pixelRedAboveMaxMain.clamp();
    assertEquals(new Pixel(new Position(3, 2), 255, 80, 65), pixelRedAboveMaxMain);

    pixelRedAboveMaxCopy.clamp();
    assertEquals(new Pixel(new Position(3, 2), 255, 80, 65), pixelRedAboveMaxCopy);
  }

  @Test
  public void clampGreenAboveMaxBothConstructors() {
    Pixel pixelGreenAboveMaxMain = new Pixel(new Position(3, 2), 34, 300, 65);
    Pixel pixelGreenAboveMaxCopy = new Pixel(new Pixel(new Position(3, 2), 34, 300, 65));

    pixelGreenAboveMaxMain.clamp();
    assertEquals(new Pixel(new Position(3, 2), 34, 255, 65), pixelGreenAboveMaxMain);

    pixelGreenAboveMaxCopy.clamp();
    assertEquals(new Pixel(new Position(3, 2), 34, 255, 65), pixelGreenAboveMaxCopy);
  }

  @Test
  public void clampBlueAboveMaxBothConstructors() {
    Pixel pixelBlueAboveMaxMain = new Pixel(new Position(3, 2), 34, 80, 300);
    Pixel pixelBlueAboveMaxCopy = new Pixel(new Pixel(new Position(3, 2), 34, 80, 300));

    pixelBlueAboveMaxMain.clamp();
    assertEquals(new Pixel(new Position(3, 2), 34, 80, 255), pixelBlueAboveMaxMain);

    pixelBlueAboveMaxCopy.clamp();
    assertEquals(new Pixel(new Position(3, 2), 34, 80, 255), pixelBlueAboveMaxCopy);
  }

  @Test
  public void clampAllAboveMaxBothConstructors() {
    Pixel pixelAllAboveMaxMain = new Pixel(new Position(3, 2), 300, 300, 300);
    Pixel pixelAllAboveMaxCopy = new Pixel(new Pixel(new Position(3, 2), 300, 300, 300));

    pixelAllAboveMaxMain.clamp();
    assertEquals(new Pixel(new Position(3, 2), 255, 255, 255), pixelAllAboveMaxMain);

    pixelAllAboveMaxCopy.clamp();
    assertEquals(new Pixel(new Position(3, 2), 255, 255, 255), pixelAllAboveMaxCopy);
  }

  @Test
  public void clampMinAndMaxBothConstructors() {
    Pixel pixelMinAndMaxMain = new Pixel(new Position(3, 2), 300, 120, -1);
    Pixel pixelMinAndMaxCopy = new Pixel(new Pixel(new Position(3, 2), 300, 120, -1));

    pixelMinAndMaxMain.clamp();
    assertEquals(new Pixel(new Position(3, 2), 255, 120, 0), pixelMinAndMaxMain);

    pixelMinAndMaxCopy.clamp();
    assertEquals(new Pixel(new Position(3, 2), 255, 120, 0), pixelMinAndMaxCopy);
  }

  @Test
  public void EqualsTrueBothConstructors() {
    assertTrue(new Pixel(new Position(3, 2), 34, 80, 65).equals(samplePixelMain));
    assertTrue(new Pixel(new Pixel(new Position(3, 2), 34, 80, 65)).equals(samplePixelCopy));
  }

  @Test
  public void EqualsFalseBothConstructors() {
    assertFalse(new Pixel(new Position(1, 6), 3, 40, 30).equals(samplePixelMain));
    assertFalse(new Pixel(new Pixel(new Position(1, 6), 3, 40, 30)).equals(samplePixelCopy));
  }

  @Test
  public void notEqualsIntObjBothConstructors() {
    assertFalse(samplePixelMain.equals(34));
    assertFalse(samplePixelCopy.equals(34));
  }

  @Test
  public void notEqualsStringObjBothConstructors() {
    assertFalse(samplePixelMain.equals("Hi"));
    assertFalse(samplePixelCopy.equals("Hi"));
  }

  @Test
  public void hashCodeSameWhenPixelsAreEqualBothConstructors() {
    assertTrue(new Pixel(new Position(3, 2), 30, 120, 1).hashCode() ==
        new Pixel(new Position(3, 2), 30, 120, 1).hashCode());

    assertTrue(new Pixel(new Pixel(new Position(3, 2), 30, 120, 1)).hashCode() ==
        new Pixel(new Pixel(new Position(3, 2), 30, 120, 1)).hashCode());
  }

  @Test
  public void hashCodeDiffWhenPixelsAreUnequalBothConstructors() {
    assertFalse(new Pixel(new Position(3, 2), 30, 128, 1).hashCode() ==
        new Pixel(new Position(3, 2), 60, 120, 1).hashCode());

    assertFalse(new Pixel(new Pixel(new Position(3, 2), 30, 128, 1)).hashCode() ==
        new Pixel(new Pixel(new Position(3, 2), 60, 120, 1)).hashCode());
  }


}