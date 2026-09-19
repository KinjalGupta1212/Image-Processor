import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;


/**
 * This class contains utility methods to read a PPM image from file and simply print its contents.
 * Feel free to change this method as required.
 *
 */
public class ImageUtil {

  /**
   * Read an image file in the PPM format and print the colors.
   *
   * @param filename the path of the file.
   */
  public static List<List<Pixel>> readPPM(String filename) {
    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(filename));
    }
    catch (FileNotFoundException e) {
      throw new IllegalArgumentException("File not found.");
    }

    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string. This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0)!='#') {
        builder.append(s+System.lineSeparator());
      }
    }

    //now set up the scanner to read from the string we just built
    sc = new Scanner(builder.toString());

    String token;

    token = sc.next();
    if (!token.equals("P3")) {
      throw new IllegalArgumentException("Invalid PPM file.");
    }
    int width = sc.nextInt();
    int height = sc.nextInt();
    int maxValue = sc.nextInt();

    List<List<Pixel>> image = new ArrayList<>();
    for (int i=0;i<height;i++) {
      ArrayList<Pixel> pixels = new ArrayList<>();
      image.add(pixels);
      for (int j=0;j<width;j++) {
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        pixels.add(new Pixel(new Position(i, j), r, g, b));
      }
    }
    return image;
  }

  /**
   * The main method that is able to demo the the processing of an image and application of a
   * filter or transformation.
   *
   * @param args An array of arguments, or inputs, given.
   * @throws IOException if the processing of a file fails
   */
  public static void main(String []args) throws IOException {
/*
      String filename;

      if (args.length>0) {
          filename = args[0];
      }
      else {
          filename = "res/Koala.ppm";
      }

      ImageUtil.readPPM(filename);
  }
*/

    Image model = new Image("res/ukulele.ppm");
    //Image check = CreateImage.checkerBoard(1,3);
    //check.sepiaImage().sepiaImage();
    model.sepiaImage();

    ImageExport.exportAs("UkuleleSepia", model);
  }
}

