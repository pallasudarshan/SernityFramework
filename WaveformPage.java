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

public class WaveformPage extends PageObject {
    private static AppiumDriver driver; // Made static to resolve static context issues
    private static FlutterFinder finder;
    WebDriverWait wait;

    @Steps
    BasicPage basicPage;
    @Steps
    AppPage appPage;

    public WaveformPage() {
        driver = DriverFactory.getDriver();
        this.finder = new FlutterFinder(driver);
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

    public boolean isLabelDisplayed(String label) {
        return appPage.isElementAvailable(label);
    }

    public String getErrorMessage() {
        return finder.byText("Error occurred while fetching data.").getText();
    }

    public String getLaunchedCaliperLeadName() {
        return finder.byValueKey("Lead key").getText();
    }

    public String getCaliperInterval() {
        return finder.byValueKey("Interval key").getText();
    }

    public String getCaliperHeartRate() {
        return finder.byValueKey("HeartRate key").getText();
    }

    public String getCaliperAmplitude() {
        return finder.byValueKey("Amplitude key").getText();
    }

    public void dragAndDropTheCaliper(String direction) throws InterruptedException {
            String source = "GestureDetector for caliper key";
            basicPage.dragElementByValueKey(source, direction);
    }

    public void dragTheCaliperArms(String arm, String direction) throws InterruptedException {
        String source;
        if (arm.equalsIgnoreCase("LEFT")) {
            source = "Left Arm GestureDetector key";
            basicPage.dragElementByValueKey(source, direction);
        } else if (arm.equalsIgnoreCase("RIGHT")) {
            source = "Right Arm GestureDetector key";
            basicPage.dragElementByValueKey(source, direction);
        }
    }

    public void swipeWaveformLayout(String direction) throws InterruptedException {
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

    public void reloadFSWApplication() throws InterruptedException {
        finder.bySemanticsLabel("Reload").click();
        Thread.sleep(3000);
    }

    public void reloadFSWApplicationForError() throws InterruptedException {
        finder.bySemanticsLabel("Retry from error message").click();
        Thread.sleep(3000);
    }

    public void ScrollUpWaveformConfigurationListView(){
        basicPage.scrollToView("UP");
    }

    public void ScrollDownWaveformConfigurationListView(){
        basicPage.scrollToView("DOWN");
    }

    public void openWavformConfigurationMenu() {
        finder.bySemanticsLabel("Open navigation menu").click();
    }

    public void closeWavformConfigurationMenu() throws InterruptedException {
        Thread.sleep(5000);
        int attempt = 0;
        while (attempt < 5) {
            ScrollUpWaveformConfigurationListView();
            if (appPage.isElementAvailableBySemanticsLabel("close text button")) {
                break;
            }
            attempt++;
        }
        finder.bySemanticsLabel("close text button").click();
        System.out.println("Close config action DONE !!");
    }

    public void pinchOut(String position) throws InterruptedException {
        Thread.sleep(2000);
        basicPage.zoomIN(position);
        Thread.sleep(3000);
    }

    public void pinchIn(String position) throws InterruptedException {
        Thread.sleep(2000);
        basicPage.zoomOut(position);
        Thread.sleep(3000);
    }

    public void setCaliperLaunchLeadValue(String caliperLaunchLead) {
        basicPage.dropdownOptionSelectUsingKeyValue("caliper lead dropdown", caliperLaunchLead);
    }

    public void setRhythmLeadValue(String rhythmLead) {
        basicPage.dropdownOptionSelectUsingKeyValue("Rhythm lead dropdown", rhythmLead);
    }

    public void setGainValue(String gain) {
        basicPage.dropdownOptionSelectUsingKeyValue("Gain dropdown", gain);
    }

    public void setMinDurationOfCaliperValue(String minDurationOfCaliper) {
        basicPage.dropdownOptionSelectUsingKeyValue("Minimum Duration dropdown", minDurationOfCaliper);
    }

    public void setMinHeightOfCaliperValue(String minHeightOfCaliper) {
        basicPage.dropdownOptionSelectUsingKeyValue("Minimum Height dropdown", minHeightOfCaliper);
    }

    public void setDefaultDurationOfCaliperValue(String defaultDurationOfCaliper) {
        basicPage.dropdownOptionSelectUsingKeyValue("Default Duration dropdown", defaultDurationOfCaliper);
    }

    public void setLeadGainValue(String gainType, String leadGain) {
        if (gainType.equalsIgnoreCase("preCordial")) {
            basicPage.dropdownOptionSelectUsingKeyValue("PreCordial lead gain", leadGain);
        } else if (gainType.equalsIgnoreCase("limb lead")) {
            basicPage.dropdownOptionSelectUsingKeyValue("Limb lead gain dropdown", leadGain);
        }
    }

    public void enableToggleConfigView(String leadConfigLabel, String flag) throws InterruptedException {
        Thread.sleep(5000);
        int attempt = 0;
        while (attempt < 5) {
            ScrollUpWaveformConfigurationListView();
            attempt++;
        }
        toggleConfigView(leadConfigLabel, flag);
    }

    public void toggleConfigView(String configLabel, String flag) {
        if (Boolean.valueOf(flag)) {
            switch (configLabel){
                case "12-lead / 15-lead":
                    finder.bySemanticsLabel("Lead Switch Button").click();
                    break;
                case "PreCordial&LimbLeadMarker":
                    finder.bySemanticsLabel("PreCordialAndLimbLeadMarker").click();
                    break;
                case "Caliper on/off":
                    finder.bySemanticsLabel("Caliper Switch Button").click();
                    break;
                case "Caliper March Out":
                    finder.bySemanticsLabel("Caliper March Out Button").click();
                    break;
                case "Light / Dark":
                    finder.bySemanticsLabel("Theme Switch Button").click();
                    break;
                case "PaceMakerMarker":
                    finder.bySemanticsLabel("PaceMaker Marker Switch Button").click();
                    break;
                case "PaceMakerMarker Single/Double":
                    finder.bySemanticsLabel("PaceMaker Marker single or double type selection").click();
                    break;
                case "DCAR DATA":
                    finder.bySemanticsLabel("DCAR DATA").click();
                    break;
                case "dynamic layout":
                    finder.bySemanticsLabel("dynamic layout").click();
                    break;
                case "Rhythm lead Off":
                    finder.bySemanticsLabel("Rhythm Off").click();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid configuration label: " + configLabel);
            }
        }
    }

    public void setWaveformWidth(String text) {
        finder.byValueKey("Waveform width TextField").click();
        finder.byValueKey("Waveform width TextField").clear();
        finder.byValueKey("Waveform width TextField").sendKeys(text);
        finder.byText("Waveform Width").click();
    }

    public void setLeadLabelWidth(String text) {
        finder.byValueKey("lead label TextField").click();
        finder.byValueKey("lead label TextField").clear();
        finder.byValueKey("lead label TextField").sendKeys(text);
        finder.byText("leadLabel Width").click();
    }

    public void setWaveformforStrokeAndLabelColor(String text) {
        finder.byValueKey("Lead Label Key").click();
        finder.byValueKey("Lead Label Key").clear();
        finder.byValueKey("Lead Label Key").sendKeys(text);
        finder.byText("Lead Label").click();
    }

    public void setWaveformColor(String text) {
        finder.byValueKey("Waveform Stroke Color TextField").click();
        finder.byValueKey("Waveform Stroke Color TextField").clear();
        finder.byValueKey("Waveform Stroke Color TextField").sendKeys(text);
        finder.byText("Waveform Color").click();
    }

    public void setLeadLabelColor(String text) {
        finder.byValueKey("Lead Label Color TextField").click();
        finder.byValueKey("Lead Label Color TextField").clear();
        finder.byValueKey("Lead Label Color TextField").sendKeys(text);
        finder.byText("Lead Label Color").click();
    }

    public void setGraphOuterGridColor(String text) {
        finder.byValueKey("Outer Grid Color TextField").click();
        finder.byValueKey("Outer Grid Color TextField").clear();
        finder.byValueKey("Outer Grid Color TextField").sendKeys(text);
        finder.byText("OuterGrid Color").click();
    }

    public void setGraphInnerGridColor(String text) {
        finder.byValueKey("Inner Grid Color TextField").click();
        finder.byValueKey("Inner Grid Color TextField").clear();
        finder.byValueKey("Inner Grid Color TextField").sendKeys(text);
        finder.byText("InnerGrid Color").click();
    }

    public void setDeviderHeight(String height) {
        finder.byValueKey("Divider Mv Height").click();
        finder.byValueKey("Divider Mv Height").clear();
        finder.byValueKey("Divider Mv Height").sendKeys(height);
        finder.byText("DividerMvHeight").click();
    }

    public void setDoubleTapZoomValue(String maxZoomLevel) {
        finder.byValueKey("DoubleTapZoom").click();
        finder.byValueKey("DoubleTapZoom").clear();
        finder.byValueKey("DoubleTapZoom").sendKeys(maxZoomLevel);
        finder.byText("DoubleTap zoom").click();
    }

    public void resetConfiguration() {
        finder.bySemanticsLabel("data reset button").click();
    }

    public boolean isTheWaveformAvailable(String waveform) {
        return appPage.isElementAvailable(waveform);
    }
    public boolean iSEcgIAvailable() {
        return finder.byText("I").isDisplayed();
    }
    public boolean iSecgIIAvailable() {
        return finder.byText("II").isDisplayed();
    }
    public boolean iSecgIIIAvailable() {
        return finder.byText("III").isDisplayed();
    }
    public boolean iSecgAVRAvailable() {
        return finder.byText("AVR").isDisplayed();
    }
    public boolean iSecgAVLAvailable() {
        return finder.byText("AVL").isDisplayed();
    }
    public boolean iSecgAVFAvailable() {
        return finder.byText("AVF").isDisplayed();
    }
    public boolean iSecgV1Available() {
        return finder.byText("V1").isDisplayed();
    }
    public boolean iSecgV2Available() {
        return finder.byText("V2").isDisplayed();
    }
    public boolean iSecgV3Available() {
        return finder.byText("V3").isDisplayed();
    }
    public boolean iSecgV4Available() {
        return finder.byText("V4").isDisplayed();
    }
    public boolean iSecgV5Available() {
        return finder.byText("V5").isDisplayed();
    }
    public boolean iSecgV6Available() {
        return finder.byText("V6").isDisplayed();
    }


    public void clickOnTheWaveformArea(){
        finder.bySemanticsLabel("RetroSpectiveWaveFormLayout Page").click();;
    }

    public boolean isCaliperDisplayed(){
        return appPage.isElementAvailableByValueKey("GestureDetector for caliper key");
    }

    public boolean areCaliperArmsAreDisplayed(){
        boolean areCaliperLeftArmDotDisplayed = appPage.isElementAvailableByValueKey("Left arm dot key");
        boolean areCaliperRightArmDotDisplayed = appPage.isElementAvailableByValueKey("Right arm dot key");
        if(areCaliperLeftArmDotDisplayed && areCaliperRightArmDotDisplayed){
            return true;
        }else{
            return false;
        }
    }

    public boolean areCaliperMarchoutLinesDisplayed(){
        return  appPage.isElementAvailableByValueKey("march out lines key");
    }

    public void doubleTapOnWaveformLayout() {
        basicPage.doubleTapZoom("semanticsLabel","RetroSpectiveWaveFormLayout Page");
    }
    public void doubleTapOnCaliper(){
        basicPage.doubleTapZoom("keyValue", "Caliper container key");
    }

    public void uncheckChevronButtonVisibilityInConfig() {
        finder.bySemanticsLabel("Chevron Button Visible Checkbox -true").click();
    }

}
