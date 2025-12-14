package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.github.ashwith.flutter.FlutterFinder;
import io.qualityplus.flutter.common.FlutterBy;
import io.qualityplus.flutter.driver.AppiumFlutterDriver;
import net.serenitybdd.annotations.Steps;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverFactory;

import java.time.Duration;
import java.util.HashMap;

public class PatientPage extends PageObject {

    private static AppiumDriver driver; // Made static to resolve static context issues
    private static FlutterFinder finder;

    @Steps
    AppPage appPage;


    public PatientPage() {
        driver = DriverFactory.getDriver();
        this.finder = new FlutterFinder(driver);
    }

    public boolean isPatientWithNameAvailable(String name) {
        return appPage.isElementAvailable(name);
    }

    public void expandPatientBanner() {
        WebElement collapsedView = finder.byText("Collapsed View");
        String isCollapsed = collapsedView.getText();
        if(isCollapsed.equalsIgnoreCase("Collapsed View")){
            WebElement expandCollapseBanner = finder.byValueKey("Chevron Button");
            expandCollapseBanner.click();
        }
    }

    public void collapsePatientBanner() {
        WebElement expandedView = finder.byText("Expanded View");
        String isCollapsed = expandedView.getText();
        if(isCollapsed.equalsIgnoreCase("Expanded View")){
            WebElement expandCollapseBanner = finder.byValueKey("Chevron Button");
            expandCollapseBanner.click();
        }
    }

    public boolean isPatientIconAvailable() {
        return appPage.isElementAvailableByType("SvgPicture");
    }

    public void checkPatientIconVisibilityInConfig() {
        WebElement patientIconVisibleCheckboxfalse = finder.bySemanticsLabel("Patient Icon Visible Checkbox -false");
        patientIconVisibleCheckboxfalse.click();
    }

    public void uncheckPatientIconVisibilityInConfig() {
        WebElement patientIconVisibleCheckboxTrue = finder.bySemanticsLabel("Patient Icon Visible Checkbox -true");
        patientIconVisibleCheckboxTrue.click();
    }

    public boolean isChevronButtonAvailable() {
        return appPage.isElementAvailableByType("AnimatedRotation");
    }

    public void uncheckChevronButtonVisibilityInConfig() {
        WebElement chevronButtonVisibleCheckboxTrue = finder.bySemanticsLabel("Chevron Button Visible Checkbox -true");
        chevronButtonVisibleCheckboxTrue.click();
    }

    public void checkChevronButtonVisibilityInConfig() {
        WebElement chevronButtonVisibleCheckboxFalse = finder.bySemanticsLabel("Chevron Button Visible Checkbox -false");
        chevronButtonVisibleCheckboxFalse.click();
    }

    public void checkExpandConfigDataVisibilityInConfig() {
        WebElement expandConfigDataCheckboxFalse = finder.bySemanticsLabel("Expanded Configuration Data Checkbox -false");
        expandConfigDataCheckboxFalse.click();
    }

    public void uncheckExpandConfigDataInConfig() {
        WebElement expandConfigDataCheckboxTrue = finder.bySemanticsLabel("Expanded Configuration Data Checkbox -true");
        expandConfigDataCheckboxTrue.click();
    }

    public void checkUseWrappedExpandedViewInConfig() {
        WebElement expandConfigDataCheckboxFalse = finder.bySemanticsLabel("Use Wrapped Expanded View ? false");
        expandConfigDataCheckboxFalse.click();
    }

    public void uncheckUseWrappedExpandedViewInConfig() {
        WebElement expandConfigDataCheckboxTrue = finder.bySemanticsLabel("Use Wrapped Expanded View ? true");
        expandConfigDataCheckboxTrue.click();
    }

    public void checkReservedSpaceDisplayInConfig(String value) {
        WebElement displayAlarmDropdown = finder.bySemanticsLabel("Select Additional Widget Dropdown Button");
        displayAlarmDropdown.click();
        finder.byText(value).click();
    }

    public boolean isAlarmDisplayed(){
        return  appPage.isElementAvailableByValueKey("Alarm Dummy Container");
    }

    public void tapOnAlarmSpace(){
        finder.byValueKey("Alarm Dummy Container").click();
    }

    public void tapOnPatientName(){
        finder.byValueKey("Patient Name Key").click();
    }

    public void tapOnPatientLocation(){
        finder.byValueKey("Patient Location Key").click();
    }

    public boolean isTextAvailableOnTap(String text) {
        return appPage.isElementAvailable(text);
    }

    public boolean isEWSBadgeDisplayed(){
        return  appPage.isElementAvailableByValueKey("ews score badge");
    }

    public boolean isCustomBadgeDisplayed(){
        return  appPage.isElementAvailableByValueKey("custom badge");
    }

    public void checkFirstNameFirst() {
        WebElement firstNameFirstCheckboxFalse = finder.bySemanticsLabel("First Name First Checkbox -false");
        firstNameFirstCheckboxFalse.click();
    }

    public void setNameFieldSeparator(String text) {
        WebElement nameFieldSeparatorTextField = finder.byValueKey("Name Field Separator TextField");
        nameFieldSeparatorTextField.click();
        nameFieldSeparatorTextField.sendKeys(text);
    }

    public void setLocationFieldSeparator(String text) {
        WebElement locationFieldSeparatorTextField = finder.byValueKey("Location Field Separator TextField");
        locationFieldSeparatorTextField.click();
        locationFieldSeparatorTextField.sendKeys(text);
    }

    public void setLocationFieldsText(String locationTextField) {
        WebElement locationFieldTextField = finder.byValueKey("Location Fields TextField");
        WebElement locationFieldTextFieldUpdateButton = finder.byValueKey("Location Fields Update Button");
        locationFieldTextField.click();
        locationFieldTextField.sendKeys(locationTextField);
        locationFieldTextFieldUpdateButton.click();
    }

    public void uncheckInConfig(String configName) {
        WebElement conifgField = finder.bySemanticsLabel("Select "+configName+" Field -true");
        conifgField.click();
    }

    public void checkInConfig(String configName) {
        WebElement conifgField = finder.bySemanticsLabel("Select "+configName+" Field -false");
        conifgField.click();
    }

    public void checkDisplayLocation() {
        WebElement displayIconCheckboxFalse = finder.bySemanticsLabel("Display Location ? false");
        displayIconCheckboxFalse.click();
    }

    public void uncheckDisplayLocation() {
        WebElement displayIconCheckboxTrue = finder.bySemanticsLabel("Display Location ? true");
        displayIconCheckboxTrue.click();
    }

    public void setWrapFieldSeparator(String text) {
        WebElement wrapFieldFieldSeparatorTextField = finder.byValueKey("Wrap Field Separator TextField");
        wrapFieldFieldSeparatorTextField.click();
        wrapFieldFieldSeparatorTextField.sendKeys(text);
    }

    public void selectWrapAdditionalFieldInConfig(String value) {
        WebElement displayDropdown = finder.byValueKey("dropDownItem additionalFields");
        displayDropdown.click();
        finder.byText(value).click();
    }

    public void uncheckConfigureAdditionalFieldInConfig(String value) {
        WebElement wrapFieldCheckbox = finder.byValueKey("Show Field additionalFields");
        wrapFieldCheckbox.click();
    }

    public void uncheckConfigureAdditionalFieldSeperatorInConfig(String value) {
        WebElement wrapFieldSeperatorCheckbox = finder.byValueKey("Show Separator additionalFields");
        wrapFieldSeperatorCheckbox.click();
    }

    public void setCustomBadgeText(String text) {
        WebElement wrapFieldFieldSeparatorTextField = finder.byValueKey("custom badge label key");
        wrapFieldFieldSeparatorTextField.click();
        wrapFieldFieldSeparatorTextField.sendKeys(text);
    }

    public void setEWSBadgeScore(String text) {
        WebElement wrapFieldFieldSeparatorTextField = finder.byValueKey("EWS badge score key");
        wrapFieldFieldSeparatorTextField.click();
        wrapFieldFieldSeparatorTextField.sendKeys(text);
    }

    public void checkEWSBadgeConfigurationInConfig() {
        WebElement ewsBadgeConfiguration = finder.byValueKey("Enable ews badge");
        ewsBadgeConfiguration.click();
    }

    public void checkCustomBadgeConfigurationInConfig() {
        WebElement customBadgeConfiguration = finder.byValueKey("Enable custom badge");
        customBadgeConfiguration.click();
    }

}
