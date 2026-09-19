import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PositionTest {

  private Position samplePosMain;
  private Position samplePosCopy;


  @Before
  public void setupTestFixture() {
    samplePosMain = new Position(10, 12);
    samplePosCopy = new Position(new Position(10, 12));

  }

  @Test(expected = IllegalArgumentException.class)
  public void negRowMainConstructor() {
    new Position(-10, 12);
  }

  @Test(expected = IllegalArgumentException.class)
  public void negColMainConstructor() {
    new Position(10, -12);
  }

  @Test(expected = IllegalArgumentException.class)
  public void negRowColMainConstructor() {
    new Position(-10, -12);
  }

  @Test(expected = IllegalArgumentException.class)
  public void negRowCopyConstructor() {
    new Position(new Position(-10, 12));
  }

  @Test(expected = IllegalArgumentException.class)
  public void negColCopyConstructor() {
    new Position(new Position(10, -12));
  }

  @Test(expected = IllegalArgumentException.class)
  public void negRowColCopyConstructor() {
    new Position(new Position(-10, -12));
  }

  @Test
  public void toStringBothConstructors() {
    assertEquals("(10, 12)", samplePosMain.toString());
    assertEquals("(10, 12)", samplePosCopy.toString());
  }

  @Test
  public void equalTrueBothConstructors() {
    assertTrue(new Position(10, 12).equals(samplePosMain));
    assertTrue(new Position(new Position(10, 12)).equals(samplePosCopy));
  }

  @Test
  public void equalFalseBothConstructors() {
    assertFalse(new Position(1, 9).equals(samplePosMain));
    assertFalse(new Position(new Position(1, 9)).equals(samplePosCopy));
  }

  @Test
  public void notEqualsIntObjBothConstructors() {
    assertFalse(samplePosMain.equals(34));
    assertFalse(samplePosCopy.equals(34));
  }

  @Test
  public void notEqualsStringObjBothConstructors() {
    assertFalse(samplePosMain.equals("Hi"));
    assertFalse(samplePosCopy.equals("Hi"));
  }

  @Test
  public void hashCodeSameWhenPositionsAreEqualBothConstructors() {
    assertTrue(new Position(1, 9).hashCode() ==
        new Position(1, 9).hashCode());

    assertTrue(new Position(new Position(1, 9)).hashCode() ==
        new Position(new Position(1, 9)).hashCode());
  }

  @Test
  public void hashCodeDiffWhenPositionsAreUnequalBothConstructors() {
    assertFalse(new Position(1, 9).hashCode() ==
        new Position(10, 19).hashCode());

    assertFalse(new Position(new Position(1, 9)).hashCode() ==
        new Position(new Position(10, 19)).hashCode());
  }
}
