package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.github.ashwith.flutter.FlutterFinder;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import util.DriverFactory;
import java.util.NoSuchElementException;

public class DatabreaksPage extends PageObject {
    BasicPage basicpage;
    private static AppiumDriver driver;
    private static FlutterFinder finder;

    public DatabreaksPage() {
        driver = DriverFactory.getDriver();
        this.finder = new FlutterFinder(driver);
    }

    public void clickOnChevron() {
        finder.byValueKey("Chevron Button icon").click();
    }

    public void clickOnButton(String value) {
        WebElement configurationBtn = finder.byValueKey(value);
        configurationBtn.click();
        driver.getSessionId();
    }

    public void clickOnUpdateConfig() {
        finder.byValueKey("Update Config _ActionButton").click();
    }

    public void dropdownOptionSelectUsingKeyValueWithSemantic(String keyValue, String value) {
        finder.byValueKey(keyValue).click();
        finder.bySemanticsLabel(value).click();
    }

    public void clearTextAndEnterNewText(String keyValue, String value) {
        WebElement goButtonBorderColor = finder.byValueKey(keyValue);
        goButtonBorderColor.click();
        goButtonBorderColor.clear();
        goButtonBorderColor.sendKeys(value);
    }

    public void dataBreaksConfigurationTextFields(String textFieldName, String textValue) {
        switch (textFieldName) {
            case "Mark Line Indicator Color":
                clearTextAndEnterNewText("Mark line indicator Color_TextField", textValue);
                break;
            case "Monitor Indicator Color":
                clearTextAndEnterNewText("Monitor indicator Color_TextField", textValue);
                break;
            case "Session Break Container Width":
                clearTextAndEnterNewText("Session Break Indicator Width_TextField", textValue);
                break;
            case "Session Break Container Bg":
                clearTextAndEnterNewText("Session Break Container Bg_TextField", textValue);
                break;
            case "Session Break Date Value color":
                clearTextAndEnterNewText("Session Break Date Value color_TextField", textValue);
                break;
            case "Session Break Date Label color":
                clearTextAndEnterNewText("Session Break Date Label color_TextField", textValue);
                break;
            case "Session Break Data Separator Color":
                clearTextAndEnterNewText("Session Break Data Separator colour_TextField", textValue);
                break;
            case "Visit Break Container Width":
                clearTextAndEnterNewText("visit Break Indicator Width_TextField", textValue);
                break;
            case "Visit break Container Bg":
                clearTextAndEnterNewText("Visit Break Container Bg_TextField", textValue);
                break;
            case "Visit Break Date Value Color":
                clearTextAndEnterNewText("Visit Break Date Value color_TextField", textValue);
                break;
            case "Visit Break Date Label Color":
                clearTextAndEnterNewText("Visit Break Date Label color_TextField", textValue);
                break;
            case "Visit Break Data Separator Color":
                clearTextAndEnterNewText("Visit Break Data Separator colour_TextField", textValue);
                break;
            case "Jump Button Bg Color":
                clearTextAndEnterNewText("Background Color_TextField", textValue);
                break;
            case "Jump Button Border color":
                clearTextAndEnterNewText("Border Color_TextField", textValue);
                break;
            case "Jump Button Icon Color":
                clearTextAndEnterNewText("Icon Color_TextField", textValue);
                break;
            case "Jump Button Corner Radius":
                clearTextAndEnterNewText("Corner Radius_TextField", textValue);
                break;
            case "Jump Button Dimension":
                clearTextAndEnterNewText("Dimension (width, height)_TextField", textValue);
                break;
            case "Fhr Strip Height":
                clearTextAndEnterNewText("widthPerMinuteInPixels_TextField", textValue);
                break;
            case "Icon Dimension":
                clearTextAndEnterNewText("IconDimension_TextField", textValue);
                break;
            case "Icon Color":
                clearTextAndEnterNewText("IconColor_TextField", textValue);
                break;
            case "Left Handler Size":
                clearTextAndEnterNewText("leftHandlerSize (width, height)_TextField", textValue);
                break;
            case "Left Handler Bg Color":
                clearTextAndEnterNewText("leftHandlerBg Color_TextField", textValue);
                break;
            case "Left Handler Border Color":
                clearTextAndEnterNewText("leftHandlerBorderColor_TextField", textValue);
                break;
            case "Inner Line color":
                clearTextAndEnterNewText("innerLineColor_TextField", textValue);
                break;
            case "Inner Line Stroke Width":
                clearTextAndEnterNewText("innerLineStrokeWidth_TextField", textValue);
                break;
            case "Reader Text Size":
                clearTextAndEnterNewText("readerTextSize_TextField", textValue);
                break;
            case "Reader Dimensions":
                clearTextAndEnterNewText("readerDimension (width, height)_TextField", textValue);
                break;
            case "Reader Bg Color":
                clearTextAndEnterNewText("readerBgColor_TextField", textValue);
                break;
            case "Reader Border Color":
                clearTextAndEnterNewText("readerBorderColor_TextField", textValue);
                break;
            case "Reader Text Color":
                clearTextAndEnterNewText("readerTextColor_TextField", textValue);
                break;
            case "Session Break Start Text":
                clearTextAndEnterNewText("Session Break Start text_TextField", textValue);
                break;
            case "Session Break End Text":
                clearTextAndEnterNewText("Session Break End text_TextField", textValue);
                break;
            case "Visit Break Start Text":
                clearTextAndEnterNewText("visit Break Start text_TextField", textValue);
                break;
            case "Visit Break End Text":
                clearTextAndEnterNewText("visit Break End text_TextField", textValue);
                break;
            case "Session Start Time":
                clearTextAndEnterNewText("sessionBreak_start_textField", textValue);
                break;
            case "Session End Time":
                clearTextAndEnterNewText("sessionBreak_end_textField", textValue);
                break;
            case "Visit Start Time":
                clearTextAndEnterNewText("visitBreak_start_textField", textValue);
                break;
            case "Visit End Time":
                clearTextAndEnterNewText("visitBreak_end_textField", textValue);
                break;
            case "Mark Line":
                clearTextAndEnterNewText("markLine_date_textField", textValue);
                break;
            case "Monitor Status":
                clearTextAndEnterNewText("monitorStatus_date_textField", textValue);
                break;
            default:
                throw new NoSuchElementException("Entered text field " + textFieldName + " is not display in config screen");
        }
    }

    public void dataBreaksConfigurationDropdownFields(String dropdownField, String dropdownOption) {
        switch (dropdownField) {
            case "Session Break Right Icon":
                dropdownOptionSelectUsingKeyValueWithSemantic("Session RightIconPath_DropdownButton", dropdownOption);
                break;
            case "Session Break Left Icon":
                dropdownOptionSelectUsingKeyValueWithSemantic("Session LeftIconPath_DropdownButton", dropdownOption);
                break;
            case "Visit Break Right Icon":
                dropdownOptionSelectUsingKeyValueWithSemantic("Visit RightIconPath_DropdownButton", dropdownOption);
                break;
            case "Visit Break Left Icon":
                dropdownOptionSelectUsingKeyValueWithSemantic("Visit LeftIconPath_DropdownButton", dropdownOption);
                break;
            case "Jump Button Icon Size":
                dropdownOptionSelectUsingKeyValueWithSemantic("LiveNavigationButtonIconSize_DropdownButton", dropdownOption);
                break;
            case "Fhr config":
                dropdownOptionSelectUsingKeyValueWithSemantic("FhrConfig_DropdownButton", dropdownOption);
                break;
            case "Icon Path":
                dropdownOptionSelectUsingKeyValueWithSemantic("IconPath_DropdownButton", dropdownOption);
                break;
            case "Icon Size":
                dropdownOptionSelectUsingKeyValueWithSemantic("IconSize_DropdownButton", dropdownOption);
                break;
            default:
                throw new NoSuchElementException("Dropdown field " + dropdownField + " is not display in config screen");
        }
    }

    public void dataBreaksConfigurationCheckBox(String checkboxField) {
        switch (checkboxField) {
            case "Mark Line Indicator":
                WebElement markLineIndictor = finder.bySemanticsLabel("Mark line Indicator_checkbox_true");
                markLineIndictor.click();
                break;
            case "Uncheck Mark Line Indicator":
                WebElement uncheckMarkLineIndictor = finder.bySemanticsLabel("Mark line Indicator_checkbox_false");
                uncheckMarkLineIndictor.click();
                break;
            case "Monitor Indicator":
                WebElement monitorIndictor = finder.bySemanticsLabel("Monitor Indicator_checkbox_true");
                monitorIndictor.click();
                break;
            case "Uncheck Monitor Indicator":
                WebElement unCheckMonitorIndictor = finder.bySemanticsLabel("Monitor Indicator_checkbox_false");
                unCheckMonitorIndictor.click();
                break;
            case "Show Icon":
                WebElement showIcon = finder.bySemanticsLabel("showIcon_checkbox_true");
                showIcon.click();
                break;
            case "Baseline Indicator":
                WebElement baselineIndicator = finder.bySemanticsLabel("BaselineIndicatorToggle_checkbox_false");
                baselineIndicator.click();
                break;
            case "Uncheck Baseline Indicator":
                WebElement uncheckBaselineIndicator = finder.bySemanticsLabel("BaselineIndicatorToggle_checkbox_true");
                uncheckBaselineIndicator.click();
                break;
            default:
                throw new NoSuchElementException("CheckBox field " + checkboxField + " is not display in config screen");
        }
    }

    public void clickOnTheConfigurationButtons(String buttonValue) {
        switch (buttonValue) {
            case "Go/Jump":
                clickOnButton("FhrGoToButton_Semantics");
                break;
            case "Fhr Strip Expansion":
                clickOnButton("Fhr Strip Expansion Tile");
                break;
            case "Session Break Add":
                clickOnButton("sessionBreak_add_button");
                break;
            case "Visit Break Add":
                clickOnButton("visitBreak_add_button");
                break;
            case "Mark Line Add":
                clickOnButton("markLine_add_button");
                break;
            case "Monitor Status Add":
                clickOnButton("monitorStatus_add_button");
                break;
            case "Historic View Enable/Disable Gesture":
                clickOnButton("enableDisableGesture");
                break;

            default:
                throw new NoSuchElementException("CheckBox field " + buttonValue + " is not display in config screen");
        }
    }

    public String availabilityOfElement(String value) {
        switch (value) {
            case "Baseline indicator reader":
                return "Baseline indicator reader";
            case "FhrGoToButton":
                return "FhrGoToButton_Semantics";
            default:
                throw new NoSuchElementException("Button " + value + " is not displayed in config screen");
        }
    }
}
