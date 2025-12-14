package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.github.ashwith.flutter.FlutterFinder;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import util.DriverFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FHRPage extends PageObject {

    BasicPage basicPage;
    AppPage appPage;
    private AppiumDriver driver;
    private static FlutterFinder finder;

    public FHRPage() {
        driver = DriverFactory.getDriver();
        this.finder = new FlutterFinder(driver);
    }

    public boolean verifytimepreviewbarenabled() {
        boolean isenabled=appPage.isElementAvailableByValueKey("showXAxis_checkbox_true");
        if(isenabled) {
            finder.byValueKey("showXAxis_checkbox_true").click();
        }
        else
            System.out.println("Time preview bar is disabled");

        return isenabled;
    }

    //Click on update config
    public void clickOnUpdateConfig() {
        finder.byValueKey("Update Config _ActionButton").click();

    }

    //Click on close button
    public void clickOnCloseButton() {
        finder.byValueKey("fhr close Icon").click();

    }

    public boolean enableTimePreviewBar() {
        boolean isdisabled=appPage.isElementAvailableByValueKey("showXAxis_checkbox_false");
        if(isdisabled)
        {
            finder.byValueKey("showXAxis_checkbox_false").click();
        }
        else
            System.out.println("Time preview bar is enabled");

        return isdisabled;
    }

    //Disable the date label
    public boolean disableDateLabel() {
        boolean isenabled=appPage.isElementAvailableByValueKey("showDate_checkbox_true");
        if(isenabled)
        {
            finder.byValueKey("showDate_checkbox_true").click();
        }
        else
            System.out.println("Date label is disabled");

        return isenabled;
    }

    //Update bgcolor for time preview bar
    public void updateBgColor(String textcolor) {
          WebElement TimePreviewBgColor=finder.byValueKey(textcolor);
          TimePreviewBgColor.sendKeys(textcolor);

    }

    //Update time label color
    public void updateTimeLabelColor(String labelcolor) {
          WebElement TimeLabelColor=finder.byValueKey("");
          TimeLabelColor.click();
          TimeLabelColor.sendKeys(labelcolor);

    }

    public void clickFhrConfigDropDown(String text) {
        basicPage.dropdownOptionSelectUsingKeyValue("FhrConfig_DropdownButton",text);
    }

    public void clickIconDropDown(String text){
        basicPage.dropdownOptionSelectUsingKeyValue("IconPath_DropdownButton",text);
    }

    public void clickIconSizeDropDown(String text){
        basicPage.dropdownOptionSelectUsingKeyValue("IconSize_DropdownButton",text);
    }

    public void updateIconColor(String color) {
        WebElement Iconcolor=finder.byValueKey("IconColor_TextField");
        Iconcolor.click();
        Iconcolor.sendKeys(color);
    }

    //Update scale label text color
    public void updateScaleTextColor(String textcolor) {
        WebElement scaletextcolor=finder.byValueKey("ScaleLabelTextColor_TextField");
        scaletextcolor.click();
        scaletextcolor.sendKeys(textcolor);

    }

    //Update Ymin and Ymax for HR grid
    public void updateHrGrid(String min, String max) {
        WebElement updateHrMin=finder.byValueKey("YAxisMin_TextField");
        updateHrMin.click();
        updateHrMin.sendKeys(min);

        WebElement updateHrMax=finder.byValueKey("YAxisMax_TextField");
        updateHrMax.click();
        updateHrMax.sendKeys(max);

    }

    //Update FHR and MHR color
    public void waveFormHrColor(String color) {
        WebElement HRcolor=finder.byValueKey("WaveformCfg(color,wvName,order,px)_TextField");
        HRcolor.click();
        HRcolor.sendKeys(color);

    }

    //Update width per min
    public void updateWidthPerMin(String width) {
        WebElement widthpermin=finder.byValueKey("widthPerMinuteInPixels_TextField");
        widthpermin.click();
        widthpermin.sendKeys(width);
    }

    public void openNavigationMenu() {
          finder.bySemanticsLabel("FHR Spv Open navigation menu").click();

    }

    public void selectdropdown() {
        basicPage.dropdownOptionSelectUsingKeyValue("MPV dropdown","MPV FHR");

    }

    public boolean islabelDisplayed(String label){
        return appPage.isElementAvailableBySemanticsLabel(label);

    }

    public void updateLabelSize(String scalesize) {
        WebElement labelsize=finder.byValueKey("ScaleLabelTextSize_TextField");
        labelsize.click();
        labelsize.sendKeys(scalesize);
    }


    //disable the uom
    public boolean clickOnDisableUom() {
        boolean isenabled=appPage.isElementAvailableByValueKey("ONOFFUomHRGrid_checkbox_true");
        if(isenabled)
        {
            finder.byValueKey("ONOFFUomHRGrid_checkbox_true").click();
        }
        else
            System.out.println("Uom is enabled");

        return isenabled;
    }

    //enable the uom
    public boolean clickOnEnableUom() {
        boolean isenabled=appPage.isElementAvailableByValueKey("ONOFFUomHRGrid_checkbox_false");
        if(isenabled)
        {
            finder.byValueKey("ONOFFUomHRGrid_checkbox_false").click();
        }
        else
            System.out.println("Uom is disabled");

        return isenabled;
    }

    //disable the viewport
    public boolean clickOnViewPort() {
        boolean isenabled=appPage.isElementAvailableByValueKey("showViewport_checkbox_true");
        if(isenabled)
        {
            finder.byValueKey("showViewport_checkbox_true").click();
        }
        else
            System.out.println("Viewport is enabled");

        return isenabled;
    }

    //enable the vuewport
    public boolean clickOnEnableViewPort() {
        boolean isdisabled=appPage.isElementAvailableByValueKey("showViewport_checkbox_false");
        if(isdisabled)
        {
            finder.byValueKey("showViewport_checkbox_false").click();
        }
        else
            System.out.println("ViewPort is disabled");

        return isdisabled;
    }

    //disable the saferange
    public boolean clickOnSafeRange() {
        boolean isenabled=appPage.isElementAvailableByValueKey("SafeAreaEnable_checkbox_true");
        if(isenabled)
        {
            finder.byValueKey("SafeAreaEnable_checkbox_true").click();
        }
        else
            System.out.println("safe range is enabled");

        return isenabled;
    }

    //enable the saferange
    public boolean clickOnEnableSafeRange() {
        boolean isdisabled=appPage.isElementAvailableByValueKey("SafeAreaEnable_checkbox_false");
        if(isdisabled)
        {
            finder.byValueKey("SafeAreaEnable_checkbox_false").click();
        }
        else
            System.out.println("saferange is disabled");

        return isdisabled;
    }

    //Update the safe range values
    public void updateSafeRange(String text) {

        WebElement safeRangevalue=finder.byValueKey("SafeAreaRange(Low & High)_TextField");
        safeRangevalue.sendKeys(text);
    }

//    ************** UA Page functions ***********

    public boolean isUomDisplayed(String uom){
        return appPage.isElementAvailable(uom);
    }

    // fhrconfig Dropdown Options
    public void selectfhrConfigDropdownOption(String fhrConfigOption) {
        basicPage.dropdownOptionSelectUsingKeyValue("FhrConfig_DropdownButton", fhrConfigOption);
    }
    public void setwidthPerMinuteinPixelsValue(String widthPixels) {
        finder.byValueKey("widthPerMinuteInPixels_TextField").click();
        finder.byValueKey("widthPerMinuteInPixels_TextField").clear();
        finder.byValueKey("widthPerMinuteInPixels_TextField").sendKeys(widthPixels);
        finder.byValueKey("widthPerMinuteInPixels_TextField").click();
    }

    public void closeNavigation()  {
        finder.bySemanticsLabel("close text button").click();
        System.out.println("Close config action DONE !!");
    }

    public void openNavigationMenuBar()  {
        finder.bySemanticsLabel("Open navigation menu").click();
        System.out.println("open naviagtion menu DONE !!");
    }

    public void updateConfigOption() throws InterruptedException {
        finder.byValueKey("Update Config _ActionButton").click();
        Thread.sleep(10000);
    }
    public void resetConfigOption()  {
        finder.byValueKey("Reset Config _ActionButton").click();
    }

    public void setUAYAxiMin(String min) {
        finder.byValueKey("uaYAxisMin_TextField").click();
        finder.byValueKey("uaYAxisMin_TextField").clear();
        finder.byValueKey("uaYAxisMin_TextField").sendKeys(min);
    }

    public void setUAYAxiMax(String max) {
        finder.byValueKey("uaYAxisMax_TextField").click();
        finder.byValueKey("uaYAxisMax_TextField").clear();
        finder.byValueKey("uaYAxisMax_TextField").sendKeys(max);
    }

    public void setUomInterval(String uomInterval) {
        finder.byValueKey("uaUomInterval_TextField").click();
        finder.byValueKey("uaUomInterval_TextField").clear();
        finder.byValueKey("uaUomInterval_TextField").sendKeys(uomInterval);
    }

    public void setWaveformColour(String colour) {
        finder.byValueKey("UAWaveformCfg(color,wvName,px)_TextField").click();
        finder.byValueKey("UAWaveformCfg(color,wvName,px)_TextField").clear();
        finder.byValueKey("UAWaveformCfg(color,wvName,px)_TextField").sendKeys(colour);
    }

    public void setGapPxValueBetweenUAAndHR(String gapField) {
        finder.byValueKey("Space between HR & UA grid_TextField").click();
        finder.byValueKey("Space between HR & UA grid_TextField").clear();
        finder.byValueKey("Space between HR & UA grid_TextField").sendKeys(gapField);
        finder.byValueKey("Space between HR & UA grid_TextField").click();
    }

    public String getDisplayedDate(String DisplayedDate){
        WebElement dateElement = finder.byValueKey(DisplayedDate);
        return dateElement.getText();
    }

    public String getCurrentDate(String format){
        return new SimpleDateFormat(format).format(new Date());
    }

    public boolean isDateMatchingFormat(String displayedDate, String format){
        String currentDate = getCurrentDate(format);
        return displayedDate.equals(currentDate);
    }

    public boolean isDateMatchingAnyFormat(String displayedDate, String[] formats){
        for(String format : formats)
        {
            String currentDate = getCurrentDate(format);
            if(displayedDate.equals(currentDate)){
                return true;
            }
        }
        return false;
    }

    public void uncheckTimePreviewBarConfig() {
        WebElement timePreviewCheckboxTrue = finder.bySemanticsLabel("showXAxis_checkbox_true");
        timePreviewCheckboxTrue.click();
    }

    public void uncheckGlobalIconConfig() {
        WebElement globalIconCheckboxTrue = finder.bySemanticsLabel("showIcon_checkbox_true");
        globalIconCheckboxTrue.click();
    }

    public void uncheckUAUomConfig() {
        WebElement uomCheckboxTrue = finder.bySemanticsLabel("ONOFFUomUAGrid_checkbox_true");
        uomCheckboxTrue.click();
    }

    public void enableUAUomConfig() {
        WebElement uomCheckboxFalse = finder.bySemanticsLabel("ONOFFUomUAGrid_checkbox_false");
        uomCheckboxFalse.click();
    }

    public void enableTimePreviewConfig() {
        WebElement enableCheckboxFalse = finder.bySemanticsLabel("showXAxis_checkbox_false");
        enableCheckboxFalse.click();
    }

    public void setScaleLableTextSize(String textSize) {
        finder.byValueKey("ScaleLabelTextSize_TextField").click();
        finder.byValueKey("ScaleLabelTextSize_TextField").clear();
        finder.byValueKey("ScaleLabelTextSize_TextField").sendKeys(textSize);
    }

    public void setScaleLableTextcolor(String color) throws InterruptedException {
        Thread.sleep(500);
        finder.byValueKey("ScaleLabelTextColor_TextField").click();
        finder.byValueKey("ScaleLabelTextColor_TextField").clear();
        finder.byValueKey("ScaleLabelTextColor_TextField").sendKeys(color);
        finder.byValueKey("ScaleLabelTextColor_TextField").click();
    }

}
