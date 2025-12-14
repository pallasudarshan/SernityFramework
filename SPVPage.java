package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.github.ashwith.flutter.FlutterFinder;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.pages.NoSuchPageException;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import util.DriverFactory;

public class SPVPage extends PageObject {
    private static AppiumDriver driver; // Made static to resolve static context issues
    private static FlutterFinder finder;

    @Steps
    AppPage appPage;
    BasicPage basicPage;
    MPVPage mpvPage;

    public SPVPage() {
        driver = DriverFactory.getDriver();
        this.finder = new FlutterFinder(driver);
    }

    public boolean isGELogoAvailable() {
        return appPage.isElementAvailableByValueKey("GEHC Logo");
    }

    public void goToMPV() throws InterruptedException {
        boolean isGELogoVisible = isGELogoAvailable();
        if(isGELogoVisible) {
            WebElement geLogo = finder.byValueKey("GEHC Logo");
            geLogo.click();
            Thread.sleep(5000);
        }else {
            throw new NoSuchElementException("GEHC Logo is not available.");
        }
    }

    public void switchToDarkThemeInSPVPage() {
        boolean isDarkTheme = basicPage.isImagePatternMatch("/src/test/resources/Documents/waveform_darkTheme", 0.95);
        if (!isDarkTheme) {
            WebElement switchTheme = finder.bySemanticsLabel("Theme Switch Button");
            switchTheme.click();
        } else{
            System.out.println("It is already Dark Theme !!");
        }
    }

    public void switchToLightThemeInSPVPage() {
        boolean isDarkTheme = basicPage.isImagePatternMatch("/src/test/resources/Documents/waveform_darkTheme", 0.95);
        if (isDarkTheme) {
            WebElement switchTheme = finder.bySemanticsLabel("Theme Switch Button");
            switchTheme.click();
        }else{
            System.out.println("It is already Light Theme !!");
        }
    }

    public boolean isSwitchedToMPV() {
        return  appPage.isElementAvailable("Kyma-ReferenceApp");
    }

    public void openTheComponentPage(String patientId, String componentPage){
        mpvPage.openSPV(patientId);
        switch (componentPage){
            case "Patient Banner":
                finder.byValueKey("Patient").click();
                break;
            case "FSW":
                finder.byValueKey("FSW").click();
                break;
            case "FHR-Annotations":
                finder.byValueKey("FHR").click();
                break;
            case "Single waveform":
                finder.byValueKey("Live").click();
                break;
            case "Numerics":
                finder.byValueKey("Numerics").click();
                break;
            case "Trends":
                finder.byValueKey("Trends").click();
                break;
            default:
                throw new NoSuchPageException("No such page available.") ;
        }
    }

    public void openTheComponentPage(String componentPage){
        switch (componentPage){
            case "Patient Banner":
                finder.byValueKey("Patient").click();
                break;
            case "FSW":
                finder.byValueKey("FSW").click();
                break;
            case "FHR-Annotations":
                finder.byValueKey("FHR").click();
                break;
            case "Single waveform":
                finder.byValueKey("Live").click();
                break;
            case "Numerics":
                finder.byValueKey("Numerics").click();
                break;
            case "Trends":
                finder.byValueKey("Trends").click();
                break;
            case "FHR-Strip":
                finder.byValueKey("FHR").click();
                break;
            case "FHR-Slot":
                finder.byValueKey("FHRSlot").click();
                break;
            default:
                throw new NoSuchPageException("No such page available.") ;
        }
    }


}
