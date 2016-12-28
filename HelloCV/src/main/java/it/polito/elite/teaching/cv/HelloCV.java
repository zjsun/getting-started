package it.polito.elite.teaching.cv;

import static org.bytedeco.javacpp.opencv_core.CV_8UC1;
import static org.bytedeco.javacpp.opencv_core.Mat;
import static org.bytedeco.javacpp.opencv_imgcodecs.imread;
import static org.bytedeco.javacpp.opencv_imgcodecs.imwrite;
import static org.bytedeco.javacpp.opencv_imgproc.COLOR_BGR2GRAY;
import static org.bytedeco.javacpp.opencv_imgproc.cvtColor;

/**
 * A simple class that demonstrates/tests the usage of the OpenCV library in
 * Java. It prints a 3x3 identity matrix and then converts a given image in gray
 * scale.
 *
 * @author <a href="mailto:luigi.derussis@polito.it">Luigi De Russis</a>
 * @since 2013-10-20
 */
public class HelloCV {
    public static void main(String[] args) {

        // create and print on screen a 3x3 identity matrix
        System.out.println("Create a 3x3 identity matrix...");
        Mat mat = Mat.eye(3, 3, CV_8UC1).asMat();
        System.out.println("mat = " + mat);

        // prepare to convert a RGB image in gray scale
        String location = HelloCV.class.getResource("/Poli.jpg").getFile();
        System.out.print("Convert the image at " + location + " in gray scale... ");
        // get the jpeg image from the internal resource folder
        Mat image = imread(location);
        // convert the image in gray scale
        cvtColor(image, image, COLOR_BGR2GRAY);
        // write the new image on disk
        imwrite(HelloCV.class.getResource("/").getFile()+"/Poli-gray.jpg", image);
        System.out.println("Done!");
    }
}
