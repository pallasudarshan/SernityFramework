package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.github.ashwith.flutter.FlutterFinder;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import util.DriverFactory;


public class EWSPage extends PageObject
{
    BasicPage basicpage;
    AppPage appPage;
    private AppiumDriver driver;
    private static FlutterFinder finder;

    public EWSPage() {
        driver = DriverFactory.getDriver();
        this.finder = new FlutterFinder(driver);
    }

    public void selectEwsValuedropdown(String EWS){
        basicpage.dropdownOptionSelectUsingKeyValue("Numerics dropdown item",EWS);
    }

    public void ClickOnHamburgerMenu() {
        finder.bySemanticsLabel("Open navigation menu").click();
    }

    public void updatescorelabel(String scoreName) {
        WebElement scorelabel=finder.byValueKey("Score label textfield");
        scorelabel.click();
        scorelabel.sendKeys(scoreName);
    }

    public void levelClick() {
        basicpage.dropdownOptionsSelectUsingByText("Level 1", "Level 2");
    }

    //To click on tap for tagview
    public void clickonTagView() {
        finder.byValueKey("EWS Tag view widget").click();
    }

    //Select icon path icon from dropdown
    public void clickonIcon(String alert_icon) throws InterruptedException {
        basicpage.dropdownOptionSelectUsingKeyValue("Icon path light dropdown",alert_icon);
    }

    //To click on tap for small view
    public void clickonSmallView() {
        finder.byValueKey("EWS Combined view widget").click();
    }

    //Tap on the medium view pop-up
    public void clickonMediumView() {
        finder.byValueKey("EWS Combined view widget").click();
    }

    //To update the color
    public void updatecolor(String Bordercolor, String Scorelabelcolor, String Scorevaluecolor) {

        WebElement bordercolor=finder.byValueKey("Border color light textfield");
        bordercolor.click();
        bordercolor.sendKeys(Bordercolor);

        WebElement labelcolor=finder.byValueKey("Score label color light textfield");
        labelcolor.click();
        labelcolor.sendKeys(Scorelabelcolor);

        WebElement valuecolor=finder.byValueKey("Score value color light textfield");
        valuecolor.click();
        valuecolor.sendKeys(Scorevaluecolor);
    }

    //Tap on the tile view pop-up
    public void clickonTileView() {
        finder.byValueKey("EWS Tile view widget").click();
    }

    // close button
    public void clickclosebutton() {
        finder.byValueKey("Close button key").click();
    }

    public void toggleConfigView(String configLabel, boolean flag) {
        if (flag) {
            switch (configLabel) {
                case "Touch on/off":
                    finder.byValueKey("Touch on/off toggle button false").click();
                    break;
                case "Error text on":
                    finder.byValueKey("Error text on toggle button false").click();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid configuration label: " + configLabel);
            }
        }
    }

    //To update height and width
    public void updateheightwidth(String width, String height) {
        finder.byValueKey("Tag view dimension width").sendKeys(width);
        finder.byValueKey("Tag view dimension height").sendKeys(height);
    }

    // To click on level 3
    public void clickonThirdLevel() {
        basicpage.dropdownOptionsSelectUsingByText("Level 1", "Level 3");
    }

    // To update error text message
    public void updateErrorText(String text) {
        WebElement errortxtupdate=finder.byValueKey("Error message textfield");
        errortxtupdate.click();
        errortxtupdate.sendKeys(text);
    }

    // To click on level 4
    public void clickonfourthLevel() {
        basicpage.dropdownOptionsSelectUsingByText("Level 1", "Level 4");
    }

    //To update width and height for medium view
    public void updatewidthheightcombined(String width, String height) {
        finder.byValueKey("Combined view dimension width").sendKeys(width);
        finder.byValueKey("Combined view dimension height").sendKeys(height);
    }

    public void updatestaletime(String text) {
        finder.byValueKey("Stale time (ms) textfield").sendKeys(text);

    }
    public void scrollUpConfigurationListView(int noOfTimes){
        WebElement element = finder.byValueKey("CombinedLayout_ListView");
        int count=0;
        while (count < noOfTimes) {
            basicpage.scrollToView("UP", element);
            count++;
        }
    }

    public void scrollDownConfigurationListView(int noOfTimes){
        WebElement element = finder.byValueKey("CombinedLayout_ListView");
        int count=0;
        while (count < noOfTimes) {
            basicpage.scrollToView("DOWN", element);
            count++;
        }
    }
}