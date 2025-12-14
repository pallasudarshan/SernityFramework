package steps;

//import org.apache.commons.codec.binary.Base64;

import net.serenitybdd.annotations.Steps;
import org.junit.Assert;
import pageObjects.BasicPage;


public class BasicSteps {

    @Steps
    BasicPage basicPage;

    public void clickOnLeftExtreme() {
        basicPage.dragTimebar("0");
    }

    public void clickOnRightExtreme() {
        basicPage.dragTimebar("1");
    }

    public void clickOnMiddle() {
        basicPage.dragTimebar("0.5");
    }

    public void clickShowAlertButton() {
        basicPage.clickShowAlertButton();
    }

    public void acceptAlert() {
        basicPage.acceptAlert();
    }

    public void computeSum(String intA, String intB) {
        basicPage.computeSum(intA, intB);
    }

    public void validateSum(String expectedSum) {
        String actualSum = basicPage.getActualSum();
        Assert.assertEquals(expectedSum, actualSum);
    }

    public void zoomOnMap(String position) throws InterruptedException {
        basicPage.zoomInOut(position);
    }

    public void pinchOutOnMap(String position) throws InterruptedException {
        basicPage.pinchOut(position);

    }

    public void pinchInOnMap(String position) throws InterruptedException {
        basicPage.pinchIn(position);
    }

    public void launchMap() {
        basicPage.launchMap();
    }

    public void validateMap(String mapPath) {
        Assert.assertTrue(basicPage.isImagePatternMatch(mapPath));
    }

    public void swipeTheSlide(String direction, Integer numberOfSwipes) throws InterruptedException {
        int count = 0;
        while (count < numberOfSwipes) {
            Thread.sleep(4000);
            int xStart, yStart, xEnd, yEnd;
            switch (direction.toUpperCase()) {
                case "LEFT":
                    xStart = 800;
                    yStart = 800;
                    xEnd = 200;
                    yEnd = 1250;
                    break;
                case "RIGHT":
                    xStart = 200;
                    yStart = 1250;
                    xEnd = 800;
                    yEnd = 800;
                    break;
                default:
                    throw new IllegalArgumentException("Slide not performed both left and right ");
            }
            if (System.getProperty("platformName").trim().equals("Android")){
                BasicPage.scrollByCoordinates( xStart, yStart, xEnd,yEnd);
            } else {
                basicPage.swipeIOSFullScreen(direction);
            }
            count++;
        }
    }

    public void dragTheElementBySemantics(String source, String direction) throws InterruptedException {
        basicPage.dragElementBySemantics(source,direction);
    }

}
