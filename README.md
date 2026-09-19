# Image-Processor
ImageProcessorModel Interface ---------------------------------------------------------------------

This is the model interface that has all of the functions which process an image.
It also declares one observer method to get a Pixel, which becomes more useful when
implementing the view.

ImageModel Class ----------------------------------------------------------------------------------

This class implements ImageProcessor. It implements the declared methods in image processor,
which allow a client to create a filtered or color transformed version of Images, as well as get a
Pixel at a given location in the Image.

We store an Image as a 2D list of Pixel.
One constructor takes in a 2D list of pixels as the pixels in the image, and another takes in a
file which is read and converted to the 2d list of Pixel.

ImageUtil class -----------------------------------------------------------------------------------

This class was given to us- we only changed it so that instead of printing out each RGB value,
readPPM(String filename) returns a 2d list of Pixel
(which can then be used in initializing an Image), containing their respective and correct
RGB values.

ImageExport class ---------------------------------------------------------------------------------

This class is similar to ImageUtil class except instead of importing an image, it deals with
exporting an image. It’s static method, when given a name for a file and an Image,
delegates to the image class to first convert the pixels to a ppm formatted string, and then
creates a file and writes that string to it, putting the exported ppm file in the res folder.

IPixel interface ----------------------------------------------------------------------------------

This is the interface to represent Pixels in images.
It contains all of the public methods that an implementation should be able to use.

Pixel class --------------------------------------------------------------------------------------

Tthe pixels class implements IPixel and its methods.

The pixels are the building blocks of the Image. Each pixel has a position dictating its location
in an Image and a r, g, and b value (as integers).

Position class ------------------------------------------------------------------------------------

This class is used in the Pixel class, as the Pixel has a position field. It allows us to
effectively keep track of a row and column that a Pixel is located at, such as in an image.

CreateImage class ---------------------------------------------------------------------------------

This class is where programatic images are created. It has a static method that allows the user to
create an image of a black and white checkerboard. The user is allowed to specify the size of each
tile (in terms of number of pixels) and the number of tiles they want (as a dimension, the
checkerboards are always square). It returns an Image.

ChannelType enum ----------------------------------------------------------------------------------

This is an enum containing RED, GREEN, and BLUE. It is frequently used when determining which
channel of a pixel to operate upon (such as in the changeRGB(ChannelType type, double filterValue)
and applyFilter(ChannelType type, double pixelsValue) methods in the Pixel class.

Icecream and Ukulele Image Citations: These are original images. They are taken by Kinjal Gupta,
one of the authors of this code. Kinjal Gupta authorizes the use of these images for this project.
