package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.github.ashwith.flutter.FlutterFinder;
import net.serenitybdd.annotations.Steps;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import util.DriverFactory;


public class AppPage extends PageObject {
    private static AppiumDriver driver; // Made static to resolve static context issues
    private static FlutterFinder finder;

    @Steps
    BasicPage basicPage;

    public AppPage() {
        driver = DriverFactory.getDriver();
        this.finder = new FlutterFinder(driver);
    }

    public void openNavigationMenu() {
        finder.bySemanticsLabel("Open navigation menu").click();
    }

    public void closeNavigationMenu() throws InterruptedException {
        Thread.sleep(3000);
        int attempt = 0;
        while (attempt < 5) {
            basicPage.scrollToView("UP");
            attempt++;
        }
        finder.bySemanticsLabel("close text button").click();
        System.out.println("Close config action DONE !!");
    }

    public void resetConfiguration() throws InterruptedException {
        Thread.sleep(3000);
        int attempt = 0;
        while (attempt < 5) {
            basicPage.scrollToView("UP");
            attempt++;
        }
        finder.bySemanticsLabel("data reset button").click();
        System.out.println("Reset config action DONE !!");
    }

    public boolean isElementAvailable(String text){
        try{
            WebElement textField = finder.byText(text);
            driver.executeScript("flutter: waitFor", textField, 5000);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean isElementAvailableByType(String type){
        try{
            WebElement typeField = finder.byType(type);
            driver.executeScript("flutter: waitFor", typeField, 5000);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean isElementAvailableBySemanticsLabel(String semanticLabel){
        try{
            WebElement semanticLabelField = finder.bySemanticsLabel(semanticLabel);
            driver.executeScript("flutter: waitFor", semanticLabelField, 5000);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean isElementAvailableByValueKey(String valueKey){
        try{
            WebElement valueField = finder.byValueKey(valueKey);
            driver.executeScript("flutter: waitFor", valueField, 5000);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public void scrollUpWaveformConfigurationListView(int noOfTimes){
        int count=0;
        while (count < noOfTimes) {
            basicPage.scrollToView("UP");
            count++;
        }
    }

    public void scrollDownWaveformConfigurationListView(int noOfTimes){
        int count=0;
        while (count < noOfTimes) {
            basicPage.scrollToView("DOWN");
            count++;
        }
    }

    public void scrollUpToViewPatientBannerExpandedWrappedView(int noOfTimes, String text) {
        WebElement element = finder.byValueKey("Patient Banner scrollable area for wrapped view");
        int count = 0;
        while (count < noOfTimes) {
            basicPage.scrollToView(element, "UP");
            if (isElementAvailable(text)) {
                break;
            }
            count++;
        }
    }

    public void scrollDownToViewPatientBannerExpandedWrappedView(int noOfTimes, String text) {
        WebElement element = finder.byValueKey("Patient Banner scrollable area for wrapped view");
        int count = 0;
        while (count < noOfTimes) {
            basicPage.scrollToView(element, "DOWN");
            if (isElementAvailable(text)) {
                break;
            }
            count++;
        }
    }

}
