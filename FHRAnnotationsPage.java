package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.github.ashwith.flutter.FlutterFinder;
import net.serenitybdd.annotations.Steps;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverFactory;

import java.time.Duration;

public class FHRAnnotationsPage extends PageObject {
    private static AppiumDriver driver; // Made static to resolve static context issues
    private static FlutterFinder finder;
    WebDriverWait wait;

    @Steps
    BasicPage basicPage;
    @Steps
    AppPage appPage;

    public FHRAnnotationsPage() {
        driver = DriverFactory.getDriver();
        this.finder = new FlutterFinder(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openNavigationMenu() throws InterruptedException {
        int attempt =0;
        while(attempt > 5) {
            WebElement navigationMenu = finder.bySemanticsLabel("Open navigation menu");
            navigationMenu.click();
            if(!finder.bySemanticsLabel("Configurations").getText().isEmpty()){
                break;
            }
            attempt++;
        }
    }

    public boolean isLabelDisplayed(String label) throws InterruptedException {
//        return appPage.isElementAvailable(label);
        return  appPage.isElementAvailableByValueKey("Swipe left and right");
    }

    public String getErrorMessage() {
        return finder.byText("Error occurred while fetching data.").getText();
    }

    public void swipeFHRLayout(String direction) throws InterruptedException {
        String source = "RetroSpectiveWaveFormLayout Page";
        basicPage.dragElementBySemantics(source, direction);
    }

    public void rotateScreen(String displayMode) {
        if(displayMode.equalsIgnoreCase("landscape")){
            basicPage.rotateToLandscape();
        }else if(displayMode.equalsIgnoreCase("portrait")){
            basicPage.rotateToPortrait();
        }
    }

    public void reloadFHRApplication() throws InterruptedException {
        finder.bySemanticsLabel("Reload").click();
        Thread.sleep(3000);
    }

    public void reloadFHRApplicationForError() throws InterruptedException {
        finder.bySemanticsLabel("Retry from error message").click();
        Thread.sleep(3000);
    }

    public void ScrollUpFHRConfigurationListView(){
        basicPage.scrollToView("UP");
    }

    public void ScrollDownFHRConfigurationListView(){
        basicPage.scrollToView("DOWN");
    }

    public void openFHRConfigurationMenu() {
        finder.bySemanticsLabel("Open navigation menu").click();
    }

    public void closeFHRConfigurationMenu() throws InterruptedException {
        Thread.sleep(5000);
        int attempt = 0;
        while (attempt < 5) {
            ScrollUpFHRConfigurationListView();
            if (appPage.isElementAvailableBySemanticsLabel("close text button")) {
                break;
            }
            attempt++;
        }
        finder.bySemanticsLabel("close text button").click();
        System.out.println("Close config action DONE !!");
    }

    public void pinchOut(String position) throws InterruptedException {
        basicPage.zoomIN(position);
        Thread.sleep(5000);
    }

    public void pinchIn(String position) throws InterruptedException {
        basicPage.zoomOut(position);
        Thread.sleep(5000);
    }

    public void resetConfiguration() {
        finder.bySemanticsLabel("data reset button").click();
    }

    public String validateFHRAnnotationDetails() {
//        return  finder.byValueKey("Annotation tile content key Annotation-1").getText();
        return finder.bySemanticsLabel("Annotation tile content").getText();
    }

    public void validateFHRAnnotationFlyout() {
//        finder.byValueKey("Annotation tile content key Annotation-1").click();
//        finder.bySemanticsLabel("Annotation tile content").click();
        finder.bySemanticsLabel("Annotation tile content").click();
    }

}
