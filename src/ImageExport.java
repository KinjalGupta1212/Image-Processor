import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class contains utility methods to export an Image of a list of pixels to a PPM image as a
 * file.
 */
public class ImageExport {

  /**
   * Exports a given image with a given filename as a ppm.
   *
   * @param filename the name of the file.
   * @param image    the image to be exported.
   * @throws IOException if there is an error in processing the image to be exported.
   */
  public static void exportAs(String filename, Image image) throws IOException {

    File file = new File("res/" + filename + ".ppm");

    file.createNewFile();

    FileWriter writer = new FileWriter(file);

    writer.write(image.formattedExportString());
    writer.close();
  }

}
