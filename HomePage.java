package pageObjects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
//import io.appium.java_client.flutter.FlutterFinder;
//import io.appium.java_client.MobileBy;
//import io.github.ashwith.flutter.FlutterFinder;
import io.qualityplus.flutter.common.FlutterBy;
import io.qualityplus.flutter.driver.AppiumFlutterDriver;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverFactory;
import util.ImageMatcher;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Pattern;

//import org.devicefarm.FlutterBy;
import org.devicefarm.*;


public class HomePage extends PageObject{

    private AndroidDriver driver;



    public HomePage() {
        this.driver = (AndroidDriver) DriverFactory.getDriver();
    }

//    private final FlutterFinder finder;

//    public HomePage(final AndroidDriver driver) {
//        this.driver = driver;
//        this.finder = new FlutterFinder(driver);
//    }
//
//    @AndroidFindBy(xpath="//android.widget.Button[@content-desc=\"Open navigation menu\"]")
//    private WebElement openNavigationMenu;
//
//    @AndroidFindBy(xpath="//android.widget.Button[1]")
//    private WebElement selectLayout;
//
//    @AndroidFindBy(xpath="//android.view.View[@content-desc=\"Test Page\"]")
//    private WebElement testPage;
//
//    @AndroidFindBy(xpath="//android.view.View[@content-desc=\"Patient Banner\"]")
//    private WebElement patientBanner;
//
//    @AndroidFindBy(xpath="//android.view.View[@content-desc=\"Waveform Layout\"]")
//    private WebElement waveformLayout;
//
//    @AndroidFindBy(xpath="//android.view.View[@content-desc=\"Kyma Demo\"]")
//    private WebElement kymaDemo;
//
//    public void openNavigationMenu() {
////        HashMap<String, String> args = new HashMap<>();
////        args.put("text", "Open navigation menu");
////        WebElement element = (WebElement) driver.executeScript("flutter:findByText", args);
////        element.click();
////        openNavigationMenu.click();
//        driver.findElement(FlutterBy.SEMANTICS_LABEL, "Open navigation menu").click();
//        System.out.println("test");
////        driver.findElement(By.xpath("Open navigation menu")).click();
////        finder.bySemanticsLabel("Open navigation menu").click();
////      finder.byType("DrawerButtonIcon").click();
//    }
//
////    private FlutterFinder finder = new FlutterFinder(getDriver());
////    private FlutterFinder finder = new FlutterFinder((RemoteWebDriver) ((WebDriverFacade) getDriver()).getProxiedDriver());
//
//    public void selectLayout(String layoutName) {
////        selectLayout.click();
////        finder.byToolTip("Open navigation menu").click();
//        driver.findElement(FlutterBy.TYPE, "DropdownMenuWidget").click();
////        finder.byType("DropdownMenuWidget").click();
//        switch (layoutName){
//            case "Test Page":
////                finder.byText("Test Page").click();
////                finder.byToolTip("Open navigation menu").click();
////                testPage.click();
//                break;
//            case "Patient Banner":
//                driver.findElement(FlutterBy.TEXT, "Patient Banner").click();
////                patientBanner.click();
//                break;
//            case "Waveform Layout":
////                waveformLayout.click();
//                break;
//            case "Kyma Demo":
////                kymaDemo.click();
//                break;
//        }
////        finder.byType("V2").click();
//
//    }
//
//
//    public String isPatientWithNameAvailable(String name) {
////    return  "test";
////        Pattern pattern = Pattern.compile("Patient Name", Pattern.CASE_INSENSITIVE);
//    return driver.findElement(FlutterBy.TEXT,name).getText();
////        return driver.byText(name).getText();
//    }
//
//    public void expandPatientBanner() {
//        String isCollapsed = driver.findElement(FlutterBy.TEXT, "Collapsed View").getText();
//        if(isCollapsed.equalsIgnoreCase("Collapsed View")){
//            driver.findElement(FlutterBy.TEXT, "Expand/Collapse Banner").click();
//        }
//    }
//
//    public void collapsePatientBanner() {
////        String isExpanded = finder.byText("Expanded View").getText();
////        if(isExpanded.equalsIgnoreCase("Expanded View")){
////            finder.byText("Expand/Collapse Banner").click();
////        }
//    }
//
//    public String verifyLabelText(String label) {
//    return "test";
////        return finder.bySemanticsLabel("Key-"+label).getText();
////        return ((WebDriverFacade) getDriver()).getProxiedDriver().findElement(By.name("//*[@label='Key-"+label+"']")).getText();
//    }
//
//    public String verifyPatientDetails(String text) {
////        driver.waitFor(driver.findElement(FlutterBy.TEXT, text),10000);
//        try{
//            driver.waitFor(driver.findElement(FlutterBy.TEXT, text),10000);
//            return driver.findElement(FlutterBy.TEXT, text).getText();
//        } catch (Exception e){
//            return "Not Available";
//        }
//    }
//
//    public boolean isElementAvailable(String text){
//        try{
//            driver.waitFor(driver.findElement(FlutterBy.TEXT, text),5000);
//            return true;
//        } catch (Exception e){
//            return false;
//        }
//    }
//
//    public boolean isElementAvailableByLabel(String label){
//        try{
//            driver.waitFor(driver.findElement(FlutterBy.SEMANTICS_LABEL, label),5000);
//            return true;
//        } catch (Exception e){
//            return false;
//        }
//    }
//
//    public boolean isElementAvailableByType(String type){
//        try{
//            driver.waitFor(driver.findElement(FlutterBy.TYPE, type),5000);
//            return true;
//        } catch (Exception e){
//            return false;
//        }
//    }
//
//
//    public void uncheckInConfig(String configName) {
//        driver.findElement(FlutterBy.SEMANTICS_LABEL, "Select "+configName+" Field -true").click();
//    }
//
//    public void checkInConfig(String configName) {
//        driver.findElement(FlutterBy.SEMANTICS_LABEL, "Select "+configName+" Field -false").click();
//    }
//
//    public boolean isPatientIconAvailable() {
//        return isElementAvailableByType("SvgPicture");
//    }
//
//    public void uncheckPatientIconVisibilityInConfig() {
//        driver.findElement(FlutterBy.SEMANTICS_LABEL, "Patient Icon Visible Checkbox -true").click();
//    }
//
//    public void checkPatientIconVisibilityInConfig() {
//        driver.findElement(FlutterBy.SEMANTICS_LABEL, "Patient Icon Visible Checkbox -false").click();
//    }
//
//    public boolean isChevronButtonAvailable() {
//        return isElementAvailableByType("AnimatedRotation");
//    }
//
//    public void uncheckChevronButtonVisibilityInConfig() {
//        driver.findElement(FlutterBy.SEMANTICS_LABEL, "Chevron Button Visible Checkbox -true").click();
//    }
//
//    public void checkChevronButtonVisibilityInConfig() {
//        driver.findElement(FlutterBy.SEMANTICS_LABEL, "Chevron Button Visible Checkbox -false").click();
//    }
//
//    public void checkFirstNameFirst() {
//        driver.findElement(FlutterBy.SEMANTICS_LABEL, "First Name First Checkbox -false").click();
//    }
//
//    public void uncheckFirstNameFirst() {
//        driver.findElement(FlutterBy.SEMANTICS_LABEL, "First Name First Checkbox -true").click();
//    }
//
//    public void setNameFieldSeparator(String text) {
//        driver.findElement(FlutterBy.VALUE_KEY, "Name Field Separator TextField").click();
//        driver.findElement(FlutterBy.VALUE_KEY, "Name Field Separator TextField").sendKeys(text);
//    }
}
