package util;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.opencv.core.Core;
import org.opencv.core.Core.MinMaxLocResult;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import nu.pattern.OpenCV;

public class OpencvTemplateMatcher {
    private static final int MATCH_METHOD = Imgproc.TM_CCOEFF_NORMED;

    static {
        OpenCV.loadLocally();
    }

    private Mat template;
    private double threshold;// between 0 to 1

    public OpencvTemplateMatcher(BufferedImage templ, double threshold) {
        this.template = preprocessImage(getMat(templ));
        this.threshold = threshold;
    }

    public OpencvTemplateMatcher(BufferedImage templ) {
        this(templ, 0.8);
    }

    public Rectangle match(BufferedImage img) {

        Mat image = preprocessImage(getMat(img));
        Mat result = new Mat();

        int result_cols = image.cols() - this.template.cols() + 1;
        int result_rows = image.rows() - this.template.rows() + 1;
        result.create(result_rows, result_cols, CvType.CV_32FC1);

        Imgproc.matchTemplate(image, this.template, result, MATCH_METHOD);
        MinMaxLocResult mmlc = Core.minMaxLoc(result);

        System.out.println(mmlc.maxVal);
        System.out.println(mmlc.minVal);
        System.out.println(mmlc.maxLoc);
        System.out.println(mmlc.minLoc);

        if (mmlc.maxVal >= this.threshold) {
            return new Rectangle((int) mmlc.maxLoc.x, (int) mmlc.maxLoc.y, this.template.width(),
                    this.template.height());
        }
        return null;
    }

    private Mat getMat(BufferedImage im) {
        // Ensure the BufferedImage is in the correct format
        if (im.getType() != BufferedImage.TYPE_3BYTE_BGR) {
            BufferedImage convertedImg = new BufferedImage(im.getWidth(), im.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
            convertedImg.getGraphics().drawImage(im, 0, 0, null);
            im = convertedImg;
        }
        // Convert BufferedImage to byte array
        byte[] pixels = ((DataBufferByte) im.getRaster().getDataBuffer()).getData();
        // Create a Matrix the same size as the image
        Mat image = new Mat(im.getHeight(), im.getWidth(), CvType.CV_8UC3);
        // Fill Matrix with image values
        image.put(0, 0, pixels);

        return image;
    }

    private Mat preprocessImage(Mat image) {
        Mat blurredImage = new Mat();
        Imgproc.GaussianBlur(image, blurredImage, new Size(5, 5), 0);
        return blurredImage;
    }

    public static void main(String[] args) throws IOException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080","--headless","--disable-gpu");

        WebDriver wd = new ChromeDriver(options);
        wd.get("http://localhost:8181");
        File image = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
        File im = new File("scree.png");
        FileUtils.copyFile(image, im);
		/*
		//"C:\\Users\\1016142\\Downloads\\opencv\\Template_Matching_Template_Image.jpg"
		//"C:\\Users\\1016142\\Downloads\\images.jpg"
		BufferedImage template = ImageIO
				.read(new File("C:\\Users\\1016142\\Downloads\\opencv\\Template_Matching_Template_Image.jpg"));
		OpencvTemplateMatcher im = new OpencvTemplateMatcher(template);
		BufferedImage image = ImageIO
				.read(new File("C:\\Users\\1016142\\Downloads\\opencv\\Template_Matching_Original_Image.jpg"));
		long t = System.currentTimeMillis();
		Rectangle r = null;//im.find(image);
		System.out.println("Time taken :: "+(System.currentTimeMillis()-t));
		if (r != null) {
			System.out.println(r);
			Graphics2D graph = image.createGraphics();
			graph.setColor(Color.RED);
			graph.drawRect(r.x,r.y,r.width,r.height);
			graph.dispose();

			ImageIO.write(image, "jpg", new File("altered.jpg"));

		} else {
			System.out.println("Failed!!!!!");
		}*/
    }
}
