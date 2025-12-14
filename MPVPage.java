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
import util.KymaConstants;

public class MPVPage extends PageObject {
    private static AppiumDriver driver; // Made static to resolve static context issues
    private static FlutterFinder finder;

    @Steps
    AppPage appPage;

    public MPVPage() {
        driver = DriverFactory.getDriver();
        this.finder = new FlutterFinder(driver);
    }

    public boolean isGELogoAvailable() {
        return appPage.isElementAvailableByValueKey("GEHC Logo");
    }

    public void openSPV(String patientId){
        WebElement patientButton = finder.byText(patientId);
        patientButton.click();
    }

    @Step
    public void openSPVPage() throws InterruptedException {
        String uuid = KymaConstants.getPatientUuid();
        System.out.println("Opening SPV for UUID: " + uuid);
        WebElement patientButton = finder.byText(uuid);
        if (patientButton == null) {
            throw new RuntimeException("Patient button not found for UUID: " + uuid);
        } else {
            patientButton.click();
        }
        Thread.sleep(3000);
    }

    public void switchTheme(){
        WebElement switchTheme = finder.bySemanticsLabel("Theme Switch Button");
        switchTheme.click();
    }

    public boolean isSwitchedToSPV() {
        return  appPage.isElementAvailable("Patient Banner");
    }

}
