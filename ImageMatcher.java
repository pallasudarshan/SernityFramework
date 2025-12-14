package util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import io.appium.java_client.AppiumDriver;
import io.qualityplus.flutter.driver.AppiumFlutterDriver;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


public class ImageMatcher {
    public static boolean waitForImage(AppiumFlutterDriver wd, String template, long durationInSeconds) {
        try {
            File tempFile = new File("." + template);
            String id = tempFile.getName();
            BufferedImage templ = ImageIO.read(tempFile);
            OpencvTemplateMatcher matcher = new OpencvTemplateMatcher(templ, 0.90);
            long start = System.currentTimeMillis();
            long duration = durationInSeconds * 1000;
            while (System.currentTimeMillis() - start < duration) {
                File srcFile = wd.getScreenshotAs(OutputType.FILE);
                File targetFile=new File("capture_images\\" + "temp" +".png");
                FileUtils.copyFile(srcFile,targetFile);
                Path source = Paths.get("capture_images\\" + "temp" +".png");
                BufferedImage screen = ImageIO.read(source.toFile());
                boolean isImageCapture = System.getProperty("isImageCapture") != null
                        ? Boolean.valueOf(System.getProperty("isImageCapture")) : false;
                if (screen != null && isImageCapture) {
                    File location = new File("capture_images");
                    if (!location.exists()) {
                        location.mkdir();
                    }
                    ImageIO.write(screen, "PNG", new File("capture_images\\" + System.currentTimeMillis() + ".png"));
                }
                Rectangle r = matcher.match(screen);
                if (r != null) {
                    drawImage(r, screen, id + ".jpg");
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static void drawImage(Rectangle r, BufferedImage image, String imageName) throws IOException {
        if (r != null) {
            Graphics2D graph = image.createGraphics();
            graph.setColor(Color.RED);
            graph.drawRect(r.x, r.y, r.width, r.height);
            graph.dispose();
            File location = new File("ImageCompareResults");
            if (!location.exists()) {
                location.mkdir();
            }
            ImageIO.write(image, "png", new File(location + "/" + imageName));
        }
    }
    public static boolean waitForImage(AppiumDriver wd, String template, long durationInSeconds,double threshold) {
        try {
            File tempFile = new File("." + template);
            String id = tempFile.getName();
            BufferedImage templ = ImageIO.read(tempFile);
            OpencvTemplateMatcher matcher = new OpencvTemplateMatcher(templ, threshold);
            long start = System.currentTimeMillis();
            long duration = durationInSeconds * 1000;
            while (System.currentTimeMillis() - start < duration) {
                File srcFile = wd.getScreenshotAs(OutputType.FILE);
                File targetFile=new File("capture_images\\" + "temp" +".png");
                FileUtils.copyFile(srcFile,targetFile);
                Path source = Paths.get("capture_images\\" + "temp" +".png");
                BufferedImage screen = ImageIO.read(source.toFile());
                boolean isImageCapture = System.getProperty("isImageCapture") != null
                        ? Boolean.valueOf(System.getProperty("isImageCapture")) : false;
                if (screen != null && isImageCapture) {
                    File location = new File("capture_images");
                    if (!location.exists()) {
                        location.mkdir();
                    }
                    ImageIO.write(screen, "PNG", new File("capture_images\\" + System.currentTimeMillis() + ".png"));
                }
                Rectangle r = matcher.match(screen);
                if (r != null) {
                    drawImage(r, screen, id + ".jpg");
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
