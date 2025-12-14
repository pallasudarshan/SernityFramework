package pageObjects;

import com.google.common.collect.ImmutableList;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.github.ashwith.flutter.FlutterFinder;
import io.qualityplus.flutter.driver.AppiumFlutterDriver;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.devicefarm.FlutterCommands;
import org.devicefarm.models.ScrollOptions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.FindBy;
import util.DriverFactory;
import util.ImageMatcher;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BasicPage extends PageObject {

    private static AppiumDriver driver; // Made static to resolve static context issues
    private static FlutterFinder finder;

    public BasicPage() {
        driver = DriverFactory.getDriver();
        this.finder = new FlutterFinder(driver);
    }

    @FindBy(xpath = "//XCUIElementTypeSlider[@name=\"AppElem\"]")
    private WebElement slider;

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"show alert\"]")
    private WebElement showAlert;

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
    private WebElement okAlert;

    @FindBy(xpath = "//XCUIElementTypeTextField[@name=\"IntegerA\"]")
    private WebElement integerA;

    @FindBy(xpath = "//XCUIElementTypeTextField[@name=\"IntegerB\"]")
    private WebElement integerB;

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"ComputeSumButton\"]")
    private WebElement computeSumButton;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Answer\"]")
    private WebElement sumValue;

    @FindBy(xpath = "//XCUIElementTypeButton[@name=\"Test Gesture\"]")
    private WebElement gestureTest;

    @FindBy(xpath = "//XCUIElementTypeApplication[@name=\"TestApp\"]/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeMap")
    private WebElement map;

    public void dragTimebar(String value) {
        slider.sendKeys(value);
    }

    public void clickShowAlertButton() {
        showAlert.click();
    }

    public void acceptAlert() {
        okAlert.click();
    }

    public void computeSum(String A, String B) {
        integerA.sendKeys(A);
        integerB.sendKeys(B);
        computeSumButton.click();
        integerA.sendKeys(Keys.ENTER);
    }

    public String getActualSum() {
        System.out.println("test");
        return sumValue.getAttribute("value");
    }

    public void zoomInOut(String position) throws InterruptedException {
        gestureTest.click();
        zoomIN(position);
        Thread.sleep(5000);
        zoomOut(position);
        Thread.sleep(5000);
    }

    public void launchMap() {
        gestureTest.click();
    }

    public void pinchOut(String position) throws InterruptedException {
        zoomIN(position);
        Thread.sleep(5000);
    }

    public void pinchIn(String position) throws InterruptedException {
        zoomOut(position);
        Thread.sleep(5000);
    }

    public static void switchContext(AppiumDriver theDriver, String context) {
        try {
            if (theDriver instanceof AndroidDriver && context.equals("NATIVE_APP")) {
                ((AndroidDriver) theDriver).context("NATIVE_APP");
            } else if (theDriver instanceof IOSDriver && context.equals("NATIVE_APP")) {
                ((IOSDriver) theDriver).context("NATIVE_APP");
            } else if (theDriver instanceof AndroidDriver && context.equals("FLUTTER")) {
                ((AndroidDriver) theDriver).context("FLUTTER");
            } else if (theDriver instanceof IOSDriver && context.equals("FLUTTER")) {
                ((IOSDriver) theDriver).context("FLUTTER");
            }
        } catch (Exception e) {
            System.err.println("Error during Context Switching " + e.getMessage());
        }
    }

    private Point getCenterOfElement(Point location, Dimension size) {
        return new Point(location.getX() + size.getWidth() / 2, location.getY() + size.getHeight() / 2);
    }

    public void zoomIN(String position) {
        switchContext(driver, "NATIVE_APP");
        // Get the screen dimensions
        int screenWidth = driver.manage().window().getSize().getWidth();
        int screenHeight = driver.manage().window().getSize().getHeight();
        int centerX = 0;
        int centerY = 0;

        if (position.equalsIgnoreCase("center")) {
            // Calculate the center of the screen
            centerX = screenWidth / 2;
            centerY = screenHeight / 2;
        } else if (position.equalsIgnoreCase("right")) {
            // Calculate the center of the right side of the screen
            centerX = (int) (screenWidth * 0.75);
            centerY = screenHeight / 2;
        } else if (position.equalsIgnoreCase("left")) {
            // Calculate the center of the left side of the screen
            centerX = (int) (screenWidth * 0.25);
            centerY = screenHeight / 2;
        } else if (position.equalsIgnoreCase("top")) {
            // Calculate the center of the top side of the screen
            centerX = screenWidth / 2;
            centerY = (int) (screenHeight * 0.25);
        } else if (position.equalsIgnoreCase("bottom")) {
            // Calculate the center of the bottom side of the screen
            centerX = screenWidth / 2;
            centerY = (int) (screenHeight * 0.75);
        } else {
            throw new IllegalArgumentException("Invalid position: " + position);
        }

        // Define touch actions for zoom in from the center
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

        Sequence zoomIn1 = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX - 100, centerY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger1.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), centerX - 200, centerY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        Sequence zoomIn2 = new Sequence(finger2, 1)
                .addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX + 100, centerY))
                .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger2.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), centerX + 200, centerY))
                .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(zoomIn1, zoomIn2));
        switchContext(driver, "FLUTTER");
    }

    public void zoomOut(String position) {
        switchContext(driver, "NATIVE_APP");
        // Get the screen dimensions
        int screenWidth = driver.manage().window().getSize().getWidth();
        int screenHeight = driver.manage().window().getSize().getHeight();
        int centerX = 0;
        int centerY = 0;

        if (position.equalsIgnoreCase("center")) {
            // Calculate the center of the screen
            centerX = screenWidth / 2;
            centerY = screenHeight / 2;
        } else if (position.equalsIgnoreCase("right")) {
            // Calculate the center of the right side of the screen
            centerX = (int) (screenWidth * 0.75);
            centerY = screenHeight / 2;
        } else if (position.equalsIgnoreCase("left")) {
            // Calculate the center of the left side of the screen
            centerX = (int) (screenWidth * 0.25);
            centerY = screenHeight / 2;
        } else if (position.equalsIgnoreCase("top")) {
            // Calculate the center of the top side of the screen
            centerX = screenWidth / 2;
            centerY = (int) (screenHeight * 0.25);
        } else if (position.equalsIgnoreCase("bottom")) {
            // Calculate the center of the bottom side of the screen
            centerX = screenWidth / 2;
            centerY = (int) (screenHeight * 0.75);
        } else {
            throw new IllegalArgumentException("Invalid position: " + position);
        }

        // Define touch actions for zoom out from the center
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

        Sequence zoomOut1 = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX - 200, centerY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger1.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), centerX - 100, centerY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        Sequence zoomOut2 = new Sequence(finger2, 1)
                .addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX + 200, centerY))
                .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger2.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), centerX + 100, centerY))
                .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(zoomOut1, zoomOut2));
        switchContext(driver, "FLUTTER");
    }

    public void doubleTapZoom(String locatorType, String locator) {
        WebElement element = null;
        if (locatorType.equalsIgnoreCase("keyValue")) {
            element = finder.byValueKey(locator);
        } else if (locatorType.equalsIgnoreCase("semanticsLabel")) {
            element = finder.bySemanticsLabel(locator);
        }
        assert element != null;
        element.click();
        try {
            Thread.sleep(300); // Short delay between taps
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        element.click();
    }

    public void rotateToLandscape() {
        switchContext(driver, "NATIVE_APP");
        if (driver instanceof AndroidDriver) {
            ((AndroidDriver) driver).rotate(ScreenOrientation.LANDSCAPE);
        } else if (driver instanceof IOSDriver) {
            ((IOSDriver) driver).rotate(ScreenOrientation.LANDSCAPE);
            System.out.println("Screen rotation is not supported for iOS with the Flutter driver.");
        } else {
            throw new IllegalStateException("Unsupported driver type for screen rotation");
        }
        switchContext(driver, "FLUTTER");
    }

    public void rotateToPortrait() {
        switchContext(driver, "NATIVE_APP");
        if (driver instanceof AndroidDriver) {
            ((AndroidDriver) driver).rotate(ScreenOrientation.PORTRAIT);
        } else if (driver instanceof IOSDriver) {
            ((IOSDriver) driver).rotate(ScreenOrientation.PORTRAIT);
            System.out.println("Screen rotation is not supported for iOS with the Flutter driver.");
        } else {
            throw new IllegalStateException("Unsupported driver type for screen rotation");
        }
        switchContext(driver, "FLUTTER");
    }

    public static void scrollByCoordinates(int xStart, int yStart, int xEnd, int yEnd) throws InterruptedException {
        switchContext(driver, "NATIVE_APP");
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragNDrop = new Sequence(finger, 1);
        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), xStart, yStart));
        dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(200),
                PointerInput.Origin.viewport(), xEnd, yEnd));
        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(ImmutableList.of(dragNDrop));
        switchContext(driver, "FLUTTER");
        Thread.sleep(100);
    }

    public boolean isImagePatternMatch(String patternImage) {
        switchContext(driver, "NATIVE_APP");
        boolean status = ImageMatcher.waitForImage((AppiumFlutterDriver) ((WebDriverFacade) getDriver()).getProxiedDriver(), patternImage, 180);
        switchContext(driver, "FLUTTER");
        return status;
    }

    public boolean isImagePatternMatch(String patternImage, double threshold) {
        switchContext(driver, "NATIVE_APP");
        boolean status = ImageMatcher.waitForImage(driver, patternImage, 180, threshold);
        switchContext(driver, "FLUTTER");
        return status;
    }

    public boolean isImagePatternMatch(String patternImage, double threshold,long duration) {
        switchContext(driver, "NATIVE_APP");
        boolean status = ImageMatcher.waitForImage(driver, patternImage, duration, threshold);
        switchContext(driver, "FLUTTER");
        return status;
    }

    public void scrollUpDown() {
        switchContext(driver, "NATIVE_APP");
        Point size = driver.manage().window().getPosition();
        System.out.println("Size : " + size);
        Point midPoint = new Point((int) (size.getX() * 0.5), (int) (size.getY() * 0.5));
        int bottom = midPoint.y + (int) (midPoint.y * 0.75);
        int top = midPoint.y - (int) (midPoint.y * 0.75);
        Point start = new Point(midPoint.x, bottom);
        Point end = new Point(midPoint.x, top);
        swipe(start, end, Duration.ofMillis(300));
        switchContext(driver, "FLUTTER");
    }

    public void scrollLeftRight() {
        switchContext(driver, "NATIVE_APP");
        Dimension size = finder.byType("ListView").getSize();
        System.out.println("Size : " + size);
        Point midPoint = new Point((int) (size.width * 0.5), (int) (size.height * 0.5));
        int left = midPoint.x - (int) (midPoint.x * 0.75);
        int right = midPoint.x + (int) (midPoint.x * 0.75);
        Point start = new Point(right, midPoint.y);
        Point end = new Point(left, midPoint.y);
        swipe(start, end, Duration.ofMillis(300));
        switchContext(driver, "FLUTTER");
    }

    public void swipe(Point start, Point end, Duration duration) {
        switchContext(driver, "NATIVE_APP");
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(input, 0);
        swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
        swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(ImmutableList.of(swipe));
        switchContext(driver, "FLUTTER");
    }

    public void swipeIOSFullScreen(String direction) {
        switchContext(driver, "NATIVE_APP");
        Dimension screenSize = driver.manage().window().getSize();
        int screenWidth = screenSize.getWidth();
        int screenHeight = screenSize.getHeight();
        int fromX, fromY, toX, toY;
        switch (direction.toLowerCase()) {
            case "right":
                fromX = (int) (screenWidth * 0.3);
                toX = (int) (screenWidth * 0.9);
                fromY = toY = (int) (screenHeight * 0.6);
                break;
            case "left":
                fromX = (int) (screenWidth * 0.9);
                toX = (int) (screenWidth * 0.3);
                fromY = toY = (int) (screenHeight * 0.6);
                break;
            default:
                throw new IllegalArgumentException("Invalid direction: " + direction + ". Use 'left' or 'right'.");
        }
        Map<String, Object> params = new HashMap<>();
        params.put("duration", 1.0); // Duration in seconds
        params.put("fromX", fromX);
        params.put("fromY", fromY);
        params.put("toX", toX);
        params.put("toY", toY);
        ((JavascriptExecutor) driver).executeScript("mobile: dragFromToForDuration", params);
        switchContext(driver, "FLUTTER");
    }

    public void scrollToElement(String listElement, String labelElement) {
        switchContext(driver, "NATIVE_APP");
        WebElement scrollable = finder.byType("ListView");
        ScrollOptions scrollOptions = new ScrollOptions(org.devicefarm.FlutterBy.text(labelElement), ScrollOptions.ScrollDirection.UP);
        scrollOptions.setMaxScrolls(50);
        scrollOptions.setScrollView(scrollable);
        WebElement element = FlutterCommands.scrollTillVisible(driver, scrollOptions);
        element.click();
        switchContext(driver, "FLUTTER");
    }

    // Horizontal scroll amount,Vertical scroll amount (negative to scroll up, positive to scroll down),Duration of the scroll,Frequency of the scroll
    public void scrollToView(String direction) {
        WebElement element = finder.byType("ListView");
        int yValue = 0;
        switch (direction) {
            case "UP":
                yValue = -400;
                break;
            case "DOWN":
                yValue = 400;
                break;
            default:
                throw new IllegalArgumentException("Invalid direction: " + direction);
        }
        int finalYValue = yValue;
        driver.executeScript("flutter: scroll", element, new HashMap<String, Object>() {{
            put("dx", 90);
            put("dy", finalYValue);
            put("durationMilliseconds", 300);
            put("frequency", 30);
        }});
    }
    public void scrollToViewTheMenuSPV(String direction) {
        WebElement element = finder.byValueKey("FHR Slot spv drawer");
        int yValue = 0;
        switch (direction) {
            case "UP":
                yValue = -400;
                break;
            case "DOWN":
                yValue = 400;
                break;
            default:
                throw new IllegalArgumentException("Invalid direction: " + direction);
        }
        int finalYValue = yValue;
        driver.executeScript("flutter: scroll", element, new HashMap<String, Object>() {{
            put("dx", 90);
            put("dy", finalYValue);
            put("durationMilliseconds", 300);
            put("frequency", 30);
        }});
    }

    // Generic Horizontal scroll amount,Vertical scroll amount (negative to scroll up, positive to scroll down),Duration of the scroll,Frequency of the scroll
    public void scrollToView(WebElement element, String direction) {
        int yValue = 0;
        switch (direction) {
            case "UP":
                yValue = -400;
                break;
            case "DOWN":
                yValue = 400;
                break;
            default:
                throw new IllegalArgumentException("Invalid direction: " + direction);
        }
        int finalYValue = yValue;
        driver.executeScript("flutter: scroll", element, new HashMap<String, Object>() {{
            put("dx", 90);
            put("dy", finalYValue);
            put("durationMilliseconds", 300);
            put("frequency", 30);
        }});
    }

    public void dragElementByValueKey(String source, String direction) throws InterruptedException {
        Thread.sleep(3000);
        WebElement sourceElement = finder.byValueKey(source);
        int yValue = 0, xValue = 0;
        switch (direction.toUpperCase()) {
            case "UP":
                yValue = -200;
                break;
            case "DOWN":
                yValue = 200;
                break;
            case "LEFT":
                xValue = -100;
                break;
            case "RIGHT":
                xValue = 100;
                break;
            default:
                throw new IllegalArgumentException("Invalid direction: " + direction);
        }
        int finalYValue = yValue;
        int finalXValue = xValue;
        driver.executeScript("flutter: scroll", sourceElement, new HashMap<String, Object>() {{
            put("dx", finalXValue);
            put("dy", finalYValue);
            put("durationMilliseconds", 300);
            put("frequency", 30);
        }});
    }

    public void dragElementBySemantics(String source, String direction) throws InterruptedException {
        Thread.sleep(3000);
        WebElement sourceElement = finder.bySemanticsLabel(source);
        int yValue = 0, xValue = 0;
        switch (direction.toUpperCase()) {
            case "UP":
                yValue = -200;
                break;
            case "DOWN":
                yValue = 200;
                break;
            case "LEFT":
                xValue = -100;
                break;
            case "RIGHT":
                xValue = 100;
                break;
            default:
                throw new IllegalArgumentException("Invalid direction: " + direction);
        }
        int finalYValue = yValue;
        int finalXValue = xValue;
        driver.executeScript("flutter: scroll", sourceElement, new HashMap<String, Object>() {{
            put("dx", finalXValue);
            put("dy", finalYValue);
            put("durationMilliseconds", 300);
            put("frequency", 30);
        }});
    }

    public void dropdownOptionSelectUsingKeyValue(String keyValue, String value) {
        finder.byValueKey(keyValue).click();
        finder.byText(value).click();
    }

    public void dropdownOptionsSelectUsingByText(String Text, String value) {
        finder.byText(Text).click();
        finder.byText(value).click();
    }

    public void scrollToViewElement(String direction) {
        WebElement element = finder.byValueKey("Configurations_ListView");
        int yValue = 0;
        switch (direction) {
            case "UP":
                yValue = -600;
                break;
            case "DOWN":
                yValue = 400;
                break;
            default:
                throw new IllegalArgumentException("Invalid direction: " + direction);
        }
        int finalYValue = yValue;
        driver.executeScript("flutter: scroll", element, new HashMap<String, Object>() {{
            put("dx", 90);
            put("dy", finalYValue);
            put("durationMilliseconds", 300);
            put("frequency", 30);
        }});
    }

    public void scrollToView(String direction, WebElement element) {
        int yValue = 0;
        switch (direction) {
            case "UP":
                yValue = -400;
                break;
            case "DOWN":
                yValue = 400;
                break;
            default:
                throw new IllegalArgumentException("Invalid direction: " + direction);
        }
        int finalYValue = yValue;
        driver.executeScript("flutter: scroll", element, new HashMap<String, Object>() {{
            put("dx", 90);
            put("dy", finalYValue);
            put("durationMilliseconds", 300);
            put("frequency", 30);
        }});
    }



}
