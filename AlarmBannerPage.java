package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.github.ashwith.flutter.FlutterFinder;
import net.serenitybdd.annotations.Steps;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverFactory;

import java.time.Duration;
import java.util.NoSuchElementException;


public class AlarmBannerPage extends PageObject {
    private static AppiumDriver driver; // Made static to resolve static context issues
    private static FlutterFinder finder;
    WebDriverWait wait;

    @Steps
    BasicPage basicPage;
    @Steps
    AppPage appPage;


    public AlarmBannerPage() {
        driver = DriverFactory.getDriver();
        this.finder = new FlutterFinder(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToMPVFHRSlot(){
        finder.byValueKey("Open navigation menu MPV FHRSlot").click();
    }


//  *********Alambanner reference app elements**********


    public boolean enableCustomWidget() {
        boolean isdisabled = appPage.isElementAvailableByValueKey("Custom WidgetCheck Boxfalse");
        if (isdisabled) {
            finder.byValueKey("Custom WidgetCheck Boxfalse").click();
        } else
            System.out.println("Custom Widget is enabled");
        return isdisabled;
    }

    public boolean enableAlarmWidget() {
        boolean isdisabled = appPage.isElementAvailableByValueKey("Alarm WidgetCheck Boxfalse");
        if (isdisabled) {
            finder.byValueKey("Alarm WidgetCheck Boxfalse").click();
        } else
            System.out.println("Alarm Widget is enabled");
        return isdisabled;
    }

    public void openSPVPage(String patientId) {
         finder.byValueKey(patientId).click();
    }

    public void disableCustomWidget(){
        finder.byValueKey("Custom WidgetCheck Boxtrue").click();
    }

    public void selectMPVPage(String mpvPage) {
        basicPage.dropdownOptionSelectUsingKeyValue("MPV dropdown", mpvPage);
    }

    public void selectPrefixIconDropdown(String customType) {
        basicPage.dropdownOptionSelectUsingKeyValue("Prefix Icon Path DropdownField", customType);
    }

    public void selectCustomPrefixIconDropdown(String customType) {
        basicPage.dropdownOptionSelectUsingKeyValue("Custom Icon Path DropdownField", customType);
    }

    public void selectPrefixIconOneDropdown(String customType) {
        basicPage.dropdownOptionSelectUsingKeyValue("Icon Path DropdownField", customType);
    }

    public void alarmSortOrderDropdownField(String sortOrder) {
        basicPage.dropdownOptionSelectUsingKeyValue("Alarm Banner Sort Order DropdownField", sortOrder);
    }


    public void selectAlarmBannerConfigArrow() {
       finder.byValueKey("Alarm Banner Expansion Tile").click();
    }

    public void enableShowTwoIcons() {
        finder.byValueKey("Show Two Icon").click();
    }

    public void enableFloatingButton() {
        finder.byValueKey("Enable Floating Button false").click();
    }

    public void disableFloatingButton() {
        finder.byValueKey("Enable Floating Button true").click();
    }

    public void disableBottomSheetContent() {
        finder.byValueKey("Show Content true").click();
    }
    public void enableBottomSheetContent() {
        finder.byValueKey("Show Content false").click();
    }

    public void enableBottomSheetOverlay() {
        finder.byValueKey("Overlay On false").click();
    }

    public void disableBottomSheetOverlay() {
        finder.byValueKey("Overlay On true").click();
    }

    public void disableBottomSheetScrollBar() {
        finder.byValueKey("Scroll Bar Visibility true").click();
    }

    public void enableBottomSheetScrollBar() {
        finder.byValueKey("Scroll Bar Visibility false").click();
    }

    public void setFloatingButtonBackgroundColor(String hexaCode) {
        finder.byValueKey("Floating Button Background Color").click();
        finder.byValueKey("Floating Button Background Color").clear();
        finder.byValueKey("Floating Button Background Color").sendKeys(hexaCode);
    }

    public void floatingButtonIconDropdown(String iconName) {
        basicPage.dropdownOptionSelectUsingKeyValue("Floating Button Icon Path dropdown", iconName);
    }

    public void clickOnAcknowledgeButton() {
        finder.byValueKey("Action Button 1").click();
    }

    public void clickOnRemindMeButton() {
        finder.byValueKey("Action Button 2").click();
    }

    public boolean isMsgDisplayPostRemindMeTapGesture(String text) {
        return appPage.isElementAvailable(text);
    }

    public void tapOnTheAlarmBanner() {
        finder.byValueKey("AlarmBannerContainer alarmBanner").click();
    }

    public void tapOnTheAlarmWidget() {
        finder.byValueKey("AlarmBannerContainer alarmBannerWidget").click();
    }

    public void clickOnTheBottomSheetConfigArrow() {
        finder.byValueKey("Bottom Sheet Expansion Tile").click();
    }


    public void selectPrefixIcon1Dropdown(String customType) {
        basicPage.dropdownOptionSelectUsingKeyValue("Icon1 Path DropdownField", customType);
    }

    public void selectSuffixIconDropdown(String customType) {
        basicPage.dropdownOptionSelectUsingKeyValue("Suffix Path DropdownField", customType);
    }

    public void enterHighPriorityTimerDuration(String text) {
        finder.byValueKey("High Priority  TextField").click();
        finder.byValueKey("High Priority  TextField").clear();
        finder.byValueKey("High Priority  TextField").sendKeys(text);
    }
    public void enterMediumPriorityTimerDuration(String text) {
        finder.byValueKey("Medium Priority  TextField").click();
        finder.byValueKey("Medium Priority  TextField").clear();
        finder.byValueKey("Medium Priority  TextField").sendKeys(text);
    }
    public void enterLowPriorityTimerDuration(String text) {
        finder.byValueKey("Low Priority  TextField").click();
        finder.byValueKey("Low Priority  TextField").clear();
        finder.byValueKey("Low Priority  TextField").sendKeys(text);
    }
    public void enterInfoPriorityTimerDuration(String text) {
        finder.byValueKey("Info Priority  TextField").click();
        finder.byValueKey("Info Priority  TextField").clear();
        finder.byValueKey("Info Priority  TextField").sendKeys(text);
    }

    public void selectAlarmBannerCheckbox(String configName) {
        try {
            switch (configName) {
                case "Show Timer":
                    finder.byValueKey("numeric type dropdown").click();
                    break;
                case "disable Show Badge":
                    finder.byValueKey("Show Badge true").click();
                    break;
                case "enable Show Badge":
                    finder.byValueKey("Show Badge false").click();
                    break;
                case "disable Show Separator":
                    finder.byValueKey("Show Separator true").click();
                    break;
                case "disable Alarm Message":
                    finder.byValueKey("Show Alarm message true").click();
                    break;
                case "Show Alarm Message":
                    finder.byValueKey("Show Alarm message true").click();
                    break;
                case "Show separator":
                    finder.byValueKey("Show Separator true").click();
                    break;
                case "disable separator":
                    finder.byValueKey("Show Separator false").click();
                    break;
                case "acknowledgeFalse":
                    finder.byValueKey("acknowledge false").click();
                    break;
                case "acknowledgeTrue":
                    finder.byValueKey("acknowledge true").click();
                    break;
                case "indefinite timer":
                    finder.byValueKey("Indefinite Timer Enabled Checkbox false").click();
                    break;

                default:
                    throw new NoSuchElementException("selected alarm banner checkbox " + configName + " is not display in dropdown");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public boolean isSeparatorAvailable(String text){
       return appPage.isElementAvailableByValueKey(text);
    }

    public boolean isRequestedAlarmMessageAvailable(String text){
        return appPage.isElementAvailable(text);
    }

    public boolean isPrefixIconAvailable(){
        return appPage.isElementAvailableByValueKey("Prefix icon 2 alarmBanner");
    }

    public boolean isSuffixIcon1Available(){
        return appPage.isElementAvailableByValueKey("Suffix icon alarmBanner");
    }

    public boolean isPrefixIconBottomsheetAvailable(){
        return appPage.isElementAvailableByValueKey("Prefix icon 1 alarmBannerBottomSheet");
    }

    public boolean isSuffixIconBottomsheetAvailable(){
        return appPage.isElementAvailableByValueKey("Suffix icon alarmBannerBottomSheet");
    }

    public boolean isBadgeCountAvailable(String badgeCount){
       return appPage.isElementAvailable(badgeCount);
    }

    public boolean isBottomSheetAvailable(){
        return appPage.isElementAvailableByValueKey("Bottom Sheet");
    }

    public boolean isElementTextAvailable(String text){
        return appPage.isElementAvailable(text);
    }

    public boolean isElementTimerAvailable(){
        return appPage.isElementAvailableByValueKey("Countdown");
    }

    public boolean isElementPatientIdAvailable(){
        return appPage.isElementAvailableByValueKey("Bottom Sheet Header Text");
    }

//    yet to get semantic from dev
    public boolean isWidgetElementsAvailable(String text){
        return appPage.isElementAvailableByValueKey(text);
    }
    public void enterCategoryKey1Field(String text) {
        finder.byValueKey("Alarm Category 1 Key").click();
        finder.byValueKey("Alarm Category 1 Key").clear();
        finder.byValueKey("Alarm Category 1 Key").sendKeys(text);
    }
    public void enterCategoryKey2Field(String text) {
        finder.byValueKey("Alarm Category 2 Key").click();
        finder.byValueKey("Alarm Category 2 Key").clear();
        finder.byValueKey("Alarm Category 2 Key").sendKeys(text);
    }
    public void enterCategoryLabel1Field(String text) {
        finder.byValueKey("Alarm Category 1 Label").click();
        finder.byValueKey("Alarm Category 1 Label").clear();
        finder.byValueKey("Alarm Category 1 Label").sendKeys(text);
    }
    public void enterCategoryLabel2Field(String text) {
        finder.byValueKey("Alarm Category 2 Label").click();
        finder.byValueKey("Alarm Category 2 Label").clear();
        finder.byValueKey("Alarm Category 2 Label").sendKeys(text);
    }

    public void closeNavigationConfig(){
        finder.byValueKey("Close button key").click();
    }

    public void scrollDownToViewMPVReferenceConfiguration(int noOfTimes) {
        WebElement element = finder.byValueKey("FHR spv drawer");
        int count = 0;
        while (count < noOfTimes) {
            basicPage.scrollToView(element, "DOWN");
            count++;
        }
    }

    public void scrollUPToViewMPVReferenceConfiguration(int noOfTimes) {
        WebElement element = finder.byValueKey("FHR spv drawer");
        int count = 0;
        while (count < noOfTimes) {
            basicPage.scrollToView(element, "UP");
            count++;
        }
    }

    public boolean isBottomSheetFloatingAvailable(){
        return appPage.isElementAvailableByValueKey("Bottom Sheet Floating Button");
    }

    public boolean isIndefiniteIconAvailable(){
        return appPage.isElementAvailableByValueKey("Indefinite icon");
    }

    public void closeAlarmbannerBottomsheet(){
        finder.byValueKey("AlarmBannerContainer alarmBanner").click();
    }

    public void drogDownElement(int noOfTimes) {
        WebElement element = finder.byValueKey("Tappable Header Slide Section");
        int count = 0;
        while (count < noOfTimes) {
            basicPage.scrollToView(element, "DOWN");
            count++;
        }
    }

    public void setHightOfBottomSheet(String text) {
        finder.byValueKey("Default Height").click();
        finder.byValueKey("Default Height").clear();
        finder.byValueKey("Default Height").sendKeys(text);
    }

    public boolean isAlarmBannerTimeLabelAvailable() {
        return appPage.isElementAvailableByValueKey("Time label alarmBanner");
    }

    public void alarmBannerTimeLabel(String timeLabel) throws InterruptedException {
        boolean isAlarmBannerTimeLabel = isAlarmBannerTimeLabelAvailable();
        if(isAlarmBannerTimeLabel) {
            appPage.isElementAvailable(timeLabel);
        }else {
           System.out.println("time label is not available.");
        }
    }

    public boolean isBottomSheetMessgaeAvailable() {
        return appPage.isElementAvailableByValueKey("Alarm message alarmBannerBottomSheet");
    }

    public void enterHeightOfAlarmBannerTextField(String text) {
        finder.byValueKey("Alarm Container Height TextField").click();
        finder.byValueKey("Alarm Container Height TextField").clear();
        finder.byValueKey("Alarm Container Height TextField").sendKeys(text);
    }

    public void enterWidthOfAlarmBannerTextField(String text) {
        finder.byValueKey("Alarm Container Width Size TextField").click();
        finder.byValueKey("Alarm Container Width Size TextField").clear();
        finder.byValueKey("Alarm Container Width Size TextField").sendKeys(text);
    }

    public void enterAlarmMessageFontSize(String text) {
        finder.byValueKey("Alarm Message Text size TextField").click();
        finder.byValueKey("Alarm Message Text size TextField").clear();
        finder.byValueKey("Alarm Message Text size TextField").sendKeys(text);
    }

    public void enterAlarmMessageHighColor(String text) {
        finder.byValueKey("AlarmMessage color High").click();
        finder.byValueKey("AlarmMessage color High").clear();
        finder.byValueKey("AlarmMessage color High").sendKeys(text);
    }

    public void enterAlarmMessageMediumColor(String text) {
        finder.byValueKey("AlarmMessage color Medium").click();
        finder.byValueKey("AlarmMessage color Medium").clear();
        finder.byValueKey("AlarmMessage color Medium").sendKeys(text);
    }

    public void enterAlarmMessagelowColor(String text) {
        finder.byValueKey("AlarmMessage color Low").click();
        finder.byValueKey("AlarmMessage color Low").clear();
        finder.byValueKey("AlarmMessage color Low").sendKeys(text);
    }

    public void enterAlarmMessageInfoColor(String text) {
        finder.byValueKey("AlarmMessage color Info").click();
        finder.byValueKey("AlarmMessage color Info").clear();
        finder.byValueKey("AlarmMessage color Info").sendKeys(text);
    }
}
