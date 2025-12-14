package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.github.ashwith.flutter.FlutterFinder;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import util.DriverFactory;

public class FHRSlotPage extends PageObject {

    BasicPage basicpage;
    AppPage appPage;
    private AppiumDriver driver;
    private static FlutterFinder finder;

    public FHRSlotPage() {
        driver = DriverFactory.getDriver();
        this.finder = new FlutterFinder(driver);
    }

    public void selectMPVDropDown(String text) throws InterruptedException {
        basicpage.dropdownOptionSelectUsingKeyValue("MPV dropdown",text);
        Thread.sleep(5000);
    }

    public boolean isAlarmWidgetDisplayed() {
        return appPage.isElementAvailableByValueKey("Non Acknowledge icon");

    }

    public boolean isChervonIconNotDisplayed() {
        return appPage.isElementAvailableByValueKey("Chevron Button");
    }

    public boolean disablePatientBanner() {
        boolean isenabled = appPage.isElementAvailableByValueKey("Patient BannerCheck Boxtrue");
        if (isenabled) {
            finder.byValueKey("Patient BannerCheck Boxtrue").click();
        } else
            System.out.println("Patient banner is disabled");

        return isenabled;
    }

    public boolean enablePatientBanner() {
        boolean isdisabled = appPage.isElementAvailableByValueKey("Patient BannerCheck Boxfalse");
        if (isdisabled) {
            finder.byValueKey("Patient BannerCheck Boxfalse").click();
        } else
            System.out.println("Patient banner is enabled");

        return isdisabled;
    }

    //Enable the alarm widget
    public boolean clickEnableAlarmWidget()
    {
        boolean isdisabled=appPage.isElementAvailableByValueKey("Alarm WidgetCheck Boxfalse");
        if(isdisabled){
            finder.byValueKey("Alarm WidgetCheck Boxfalse").click();
        }
        else
            System.out.println("Alarm widget is enabled");
        return isdisabled;

    }

    //Disable FHR Strip
    public boolean clickDisableFHRStrip()
    {
        boolean isenabled=appPage.isElementAvailableByValueKey("Fhr Strip WidgetCheck Boxtrue");
        if(isenabled){
            finder.byValueKey("Fhr Strip WidgetCheck Boxtrue").click();
        }
        else
            System.out.println("FHRStrip is disabled");
        return isenabled;
    }

    //Enable FHR Strip
    public boolean clickEnableFHRStrip()
    {
        boolean isdisabled=appPage.isElementAvailableByValueKey("Fhr Strip WidgetCheck Boxfalse");
        if(isdisabled){
            finder.byValueKey("Fhr Strip WidgetCheck Boxfalse").click();
        }
        else
            System.out.println("FHRStrip is enabled");
        return isdisabled;
    }

    //Disable FHR Numeric
    public boolean clickOnDisableFHRNumeic() {
        boolean isenabled=appPage.isElementAvailableByValueKey("FHR NumericsCheck Boxtrue");
        if(isenabled){
            finder.byValueKey("FHR NumericsCheck Boxtrue").click();
        }
        else
            System.out.println("FHR Numeric is disabled");
        return isenabled;
    }

    //To validate BellIcon displayed
    public boolean isBellIconDisplayed() {
        return appPage.isElementAvailableByValueKey("Non Acknowledge icon");
    }

    //To Validate Badget Icon displayed
    public boolean isBadgetIconDisplayed() {
        return appPage.isElementAvailableByValueKey("Badge counter alarmBannerWidget");
    }

    //Tap on the Alarm widget
    public void clickOnAlarmWidget() {
        finder.byValueKey("Non Acknowledge icon").click();
    }

    //Click on Alarm config in reference app side
    public void clickOnAlarmConfig() {
        finder.byValueKey("Alarm Banner Expansion Tile").click();
    }

    //Disable Alarm widget tap functionality
    public boolean clickOnDisableTapAlarmWidget() {
        boolean isenabled=appPage.isElementAvailableByValueKey("Gesture Enabled Checkbox true");
        if(isenabled){
            finder.byValueKey("Gesture Enabled Checkbox true").click();
        }
        else
            System.out.println("Alarm widget tap is disabled");
        return isenabled;
    }

    //Disable Badget Icon in Alarm widget
    public boolean clickOnDisableBadgetIcon() {
        boolean isenabled=appPage.isElementAvailableByValueKey("Show Badge true");
        if(isenabled){
            finder.byValueKey("Show Badge true").click();
        }
        else
            System.out.println("Badget Icon is disabled");
        return isenabled;
    }

    //To Validate Badget Icon Not displayed
    public boolean isBadgetIconNotDisplayed() {
        return appPage.isElementAvailableByValueKey("Badge counter alarmBannerWidget");
    }

    //Tap on the chervon icon
    public void clickOnChervonIcon() {
        finder.byValueKey("Chevron Button icon").click();
    }

    public void clickPatientBanner() {
        finder.byText("DOE, JOHN0").click();
    }

    public void selectPriorityDropDown(String text) throws InterruptedException {
        basicpage.dropdownOptionSelectUsingKeyValue("Alarm Banner Sort Order DropdownField",text);
        Thread.sleep(5000);
    }

    public void selectPrefixDropDown(String text) throws InterruptedException {
        basicpage.dropdownOptionSelectUsingKeyValue("Prefix Icon Size DropdownField",text);
        Thread.sleep(5000);
    }

    public void selectIconDropDown(String text) throws InterruptedException {
        basicpage.dropdownOptionSelectUsingKeyValue("Prefix Icon Path DropdownField",text);
        Thread.sleep(5000);
    }

    //To update the color
    public void updateAlarmColor(String text) {
        WebElement lowPriority=finder.byValueKey("Alarm Priority High TextField");
        lowPriority.sendKeys(text);
    }

    //To update bellicon color
    public void updateBellColor(String text) {
        WebElement belliconColor=finder.byValueKey("PrefixIcon color High");
        belliconColor.sendKeys(text);
    }

    public void updateCardDimensions(String text) {
        WebElement cardDimesnion=finder.byValueKey("Portrait Dimensionkey");
        cardDimesnion.sendKeys(text);
    }

    //Enable FHR Numeric
    public boolean clickOnEnableFHRNumeic() {
        boolean isdisabled=appPage.isElementAvailableByValueKey("FHR NumericsCheck Boxfalse");
        if(isdisabled){
            finder.byValueKey("FHR NumericsCheck Boxfalse").click();
        }
        else
            System.out.println("FHR Numeric is enabled");
        return isdisabled;
    }

    //Disable Alarm widget tap functionality
    public boolean clickOnEnableTapAlarmWidget() {
        boolean isdisabled=appPage.isElementAvailableByValueKey("Gesture Enabled Checkbox false");
        if(isdisabled){
            finder.byValueKey("Gesture Enabled Checkbox false").click();
        }
        else
            System.out.println("Alarm widget tap is enabled");
        return isdisabled;
    }

    //Tap on the Alarm widget PlaceHolder
    public void clickOnAlarmWidgetPlaceHolder() {
        finder.byValueKey("Priority icon").click();
    }

    //Tap on the BellIcon in MPV Page
    public void clickOnBellIconMPVPageWidget() {
        finder.byValueKey("Non Acknowledge icon").click();
    }

    //To update the info color
    public void updateInfoColorText(String text) {
        WebElement infoPriority=finder.byValueKey("Alarm Priority info TextField");
        infoPriority.sendKeys(text);
    }

    //To update bellicon info color
    public void updateBellInfoColor(String text) {
        WebElement belliconinfoColor=finder.byValueKey("PrefixIcon color Info");
        belliconinfoColor.sendKeys(text);
    }

    public void drogDownElement(int noOfTimes) {
        WebElement element = finder.byValueKey("Tappable Header Slide Section");
        int count = 0;
        while (count < noOfTimes) {
            basicpage.scrollToView(element, "DOWN");
            count++;
        }
    }

    public void clickOnBottomDownArrow() {
        finder.byValueKey("Bottom Sheet Expansion Tile").click();
    }

    public void updateDefaultHeight(String text){
        finder.byValueKey("Default Height").sendKeys(text);
    }

    public void clickOnIconPriority() {
        finder.byValueKey("Priority icon").click();
    }

    public void scrollUpConfigurationListView(int noOfTimes, String path){
        WebElement element = finder.byValueKey(path);
        int count=0;
        while (count < noOfTimes) {
            basicpage.scrollToView("UP", element);
            count++;
        }
    }

    public void scrollDownConfigurationListView(int noOfTimes, String path){
        WebElement element = finder.byValueKey(path);
        int count=0;
        while (count < noOfTimes) {
            basicpage.scrollToView("DOWN", element);
            count++;
        }
    }

    public void openNavigationMPVMenu() {
        finder.bySemanticsLabel("Open navigation menu MPV FHRSlot").click();
    }
}
