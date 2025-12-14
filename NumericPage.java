package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import io.github.ashwith.flutter.FlutterFinder;
import net.serenitybdd.annotations.Steps;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverFactory;

import java.time.Duration;
import java.util.NoSuchElementException;


public class NumericPage extends PageObject {
    private static AppiumDriver driver; // Made static to resolve static context issues
    private static FlutterFinder finder;
    WebDriverWait wait;

    @Steps
    BasicPage basicPage;
    @Steps
    AppPage appPage;

    public NumericPage() {
        driver = DriverFactory.getDriver();
        this.finder = new FlutterFinder(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Numeric Type dropdown
    public void selectNumericDropdownItems(String dropdownOptionName) {
        try {
            switch (dropdownOptionName) {
                case "numericTypeDropdown":
                    finder.bySemanticsLabel("numeric type dropdown").click();
                    break;
                case "Combined view":
                    finder.bySemanticsLabel("combinedNumeric").click();
                    break;
                case "Condensed view":
                    finder.bySemanticsLabel("condensedNumeric").click();
                    break;
                case "Tile view":
                    finder.bySemanticsLabel("tileNumeric").click();
                    break;
                case "Tile without numeric":
                    finder.bySemanticsLabel("tileWithoutNumeric").click();
                    break;
                case "labelDropdownOption":
                    finder.bySemanticsLabel("select label type dropdown").click();
                    break;
                case "UseParameter":
                    finder.bySemanticsLabel("useParameterAsLabel").click();
                    break;
                case "UseLabel":
                    finder.bySemanticsLabel("useLabel").click();
                    break;
                case "parameterDropdownOption":
                    finder.bySemanticsLabel("select parameter type dropdown").click();
                    break;
                case "ecg":
                    finder.bySemanticsLabel("ecg").click();
                    break;
                case "spO2":
                    finder.bySemanticsLabel("spO2").click();
                    break;
                case "gasMon":
                    finder.bySemanticsLabel("gasMon").click();
                    break;
                case "NIBPWithOutMean":
                    finder.byValueKey("NIBPWithOutMean").click();
                    break;
                case "NIBPWithLabel":
                    finder.byValueKey("NIBPWithLabel").click();
                    break;
                case "NIBPSingleRow":
                    finder.byValueKey("NIBPSingleRow").click();
                    break;
                case "NIBPRowWithoutMean":
                    finder.byValueKey("NIBPRowWithoutMean").click();
                    break;
                case "NIBPTwoRowBracket":
                    finder.byValueKey("NIBPTwoRowBracket").click();
                    break;
                default:
                    throw new NoSuchElementException("selected numeric dropdown iteam " + dropdownOptionName + " is not display in dropdown");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Numeric Type Dropdown Options
    public void selectNumericTypeDropdownOption(String numericTypeOption) {
        basicPage.dropdownOptionSelectUsingKeyValue("numeric type dropdown", numericTypeOption);
    }

    // Label Type Dropdown Options
    public void selectLabelTypeDropdownOption(String labelTypeOption) {
        basicPage.dropdownOptionSelectUsingKeyValue("select label type dropdown", labelTypeOption);
    }

    // Parameter Dropdown Options
    public void selectParameterDropdownOption(String parameterOption) {
        basicPage.dropdownOptionSelectUsingKeyValue("select parameter type dropdown", parameterOption);
    }

    //    Custom Icon Dropdown Options
    public void selectCustomIconDropdownOption(String iconOption) {
        basicPage.dropdownOptionSelectUsingKeyValue("select icon type dropdown", iconOption);
    }

    //    Selection icon Dropdown Options
    public void selectSelectionIconDropdownOption(String selectionIconOption) {
        basicPage.dropdownOptionSelectUsingKeyValue("select icon dropdown", selectionIconOption);
    }

    //    Mia sorted order dropdown
    public void selectSortedOrderDropdownOption(String alarmSortedOption) {
        basicPage.dropdownOptionSelectUsingKeyValue("Alarm sorted order dropdown key", alarmSortedOption);
    }

    public void selectDisabledTypeLimit(String disabledLimit) {
        basicPage.dropdownOptionSelectUsingKeyValue("select disabled type type dropdown", disabledLimit);
    }

    public void selectSecondIconDropdown(String disabledLimit) {
        basicPage.dropdownOptionSelectUsingKeyValue("select second icon dropdown", disabledLimit);
    }

    public void selectThirdIconDropdown(String disabledLimit) {
        basicPage.dropdownOptionSelectUsingKeyValue("select third icon dropdown", disabledLimit);
    }

    //Numeric toggle configurations
    public void numericToggleConfiguration(String configOption, String flag) {
        if (Boolean.valueOf(flag)) {
            switch (configOption) {
                case "UOM Visibility":
                    finder.byValueKey("uom visibility key").click();
                    break;
                case "Icon Visibility":
                    finder.byValueKey("icon visibility key").click();
                    break;
                case "isLearning Mode":
                    finder.byValueKey("is learning mode visibility key").click();
                    break;
                case "SqiIconVisibility":
                    finder.byValueKey("Sqi icon visibility key").click();
                    break;
                case "Alarm Highlight":
                    finder.byValueKey("Alarm Highlight visibility key").click();
                    break;
                case "Trend slot":
                    finder.byValueKey("Trend slot visibility key").click();
                    break;
                case "Show Mean Value":
                    finder.byValueKey("Show mean value key").click();
                    break;
                case "Show Merged View":
                    finder.byValueKey("Merged view key").click();
                    break;
                case "stale toggle":
                    finder.byValueKey("stale key").click();
                    break;
                case "Show critical limit":
                    finder.byValueKey("show critical values limit key").click();
                    break;
                case "Double line limit":
                    finder.byValueKey("Double line limit key").click();
                    break;
                case "show limit Label":
                    finder.byValueKey("Limit Label visibility key").click();
                    break;
                case "basic low off":
                    finder.byValueKey("Basic low off key").click();
                    break;
                case "basic high off":
                    finder.byValueKey("Basic high off key").click();
                    break;
                case "critical high off":
                    finder.byValueKey("Critical High off key").click();
                    break;
                case "critical low off":
                    finder.byValueKey("Critical low off key").click();
                    break;
                case "Show date text":
                    finder.byValueKey("Show text instead date key").click();
                    break;
                case "Show uom text":
                    finder.byValueKey("Show text instead uom key").click();
                    break;
                case "Show text icon":
                    finder.byValueKey("Show icon instead text key").click();
                    break;
                case "Show Limit icon":
                    finder.byValueKey("Show icon instead limit key").click();
                    break;

                default:
                    throw new NoSuchElementException("selected numeric " + configOption + " toggle is not display in config screen");
            }
        }
    }

    public void toggleConfiguration(String configOption) {
        switch (configOption) {
            case "Icon Visibility":
                finder.byValueKey("icon visibility key").click();
                break;
            case "value Visibility":
                finder.byValueKey("value visibility key").click();
                break;
            case "Mia logic":
                finder.byValueKey("Mia logic selection key").click();
                break;
            default:
                throw new NoSuchElementException("selected numeric " + configOption + " toggle is not display in config screen");
        }
    }

    //    Mia logic selection
    public boolean isMiaSelectionAvaialable(String label) {
        return appPage.isElementAvailableBySemanticsLabel(label);
    }

    // Verify elements in container/widget
    public boolean isParameterDisplayed(String parameter) {
        return appPage.isElementAvailable(parameter);
    }

    public boolean isNumericValueDisplayed(String value) {
        return appPage.isElementAvailable(value);
    }

    public boolean isUomDisplayed(String uom) {
        return appPage.isElementAvailable(uom);
    }

    public boolean isnumericLabel(String label) {
        return appPage.isElementAvailable(label);
    }

    public boolean isnumericValueNotAvailable(String label) {
        return !(appPage.isElementAvailable(label));
    }

    public void dragElementByValueKeyUntilVisible(String config, String direction) throws InterruptedException {
        String source = null;
        switch (config) {
            case "Label color":
                source = "Label Color  TextField";
                basicPage.dragElementByValueKey(source, direction);
                break;
            case "Show Mean Value":
                source = "value visibility key";
                basicPage.dragElementByValueKey(source, direction);
                break;
            case "MIA Shorting":
                source = "Mia logic selection key";
                basicPage.dragElementByValueKey(source, direction);
                break;
            case "icon visibility":
                source = "icon visibility key";
                basicPage.dragElementByValueKey(source, direction);
                break;
            case "MIA sortoder dropdown":
                source = "Alarm sorted order dropdown key";
                basicPage.dragElementByValueKey(source, direction);
                break;
            case "Show limt icon":
                source = "Show icon instead limit key";
                basicPage.dragElementByValueKey(source, direction);
                break;
            case "Show text icon":
                source = "Show icon instead text key";
                basicPage.dragElementByValueKey(source, direction);
                break;
            case "Layout 6":
                source = "Show icon instead text key";
                basicPage.dragElementByValueKey(source, direction);
                break;
            case "show critical values":
                source = "show critical values limit key";
                basicPage.dragElementByValueKey(source, direction);
                break;

            default:
                throw new NoSuchElementException("Scroll is not working to visibility for the  " + config + " toggle");
        }

    }


    // Numeric config fields
    public void setLabelColor(String text) {
        finder.byValueKey("Label Color  TextField").click();
        finder.byValueKey("Label Color  TextField").clear();
        finder.byValueKey("Label Color  TextField").sendKeys(text);
    }

    public void setUomColor(String text) {
        finder.byValueKey("Uom Color TextField").click();
        finder.byValueKey("Uom Color TextField").clear();
        finder.byValueKey("Uom Color TextField").sendKeys(text);
    }

    public void setPrimaryNumericValueColor(String text) {
        finder.byValueKey("Label Color  TextField").click();
        finder.byValueKey("Label Color  TextField").clear();
        finder.byValueKey("Label Color  TextField").sendKeys(text);
    }

    public void setSecondryNumericValueColor(String text) {
        finder.byValueKey("Label Color  TextField").click();
        finder.byValueKey("Label Color  TextField").clear();
        finder.byValueKey("Label Color  TextField").sendKeys(text);
    }

    public void setLabelFontSize(String text) {
        finder.byValueKey("Label font size").click();
        finder.byValueKey("Label font size").clear();
        finder.byValueKey("Label font size").sendKeys(text);
    }

    public void setUomFontSize(String text) {
        finder.byValueKey("Uom font size TextField").click();
        finder.byValueKey("Uom font size TextField").clear();
        finder.byValueKey("Uom font size TextField").sendKeys(text);
    }

    public void setNumericvalueFontSize(String text) {
        finder.byValueKey("Value font size TextField").click();
        finder.byValueKey("Value font size TextField").clear();
        finder.byValueKey("Value font size TextField").sendKeys(text);
    }

    //    Alarm colour override fields
    public void setAlarmHighColorFiled(String text) {
        finder.byValueKey("High priority Value Color TextField").click();
        finder.byValueKey("High priority Value Color TextField").clear();
        finder.byValueKey("High priority Value Color TextField").sendKeys(text);
    }

    public void setAlarmMediumColorFiled(String text) {
        finder.byValueKey("Medium priority Value Color TextField").click();
        finder.byValueKey("Medium priority Value Color TextField").clear();
        finder.byValueKey("Medium priority Value Color TextField").sendKeys(text);
    }

    public void setAlarmLowColorFiled(String text) {
        finder.byValueKey("Low priority Value Color TextField").click();
        finder.byValueKey("Low priority Value Color TextField").clear();
        finder.byValueKey("Low priority Value Color TextField").sendKeys(text);
    }

    public void setAlarmInfoColorFiled(String text) {
        finder.byValueKey("Informative Value Color TextField").click();
        finder.byValueKey("Informative Value Color TextField").clear();
        finder.byValueKey("Informative Value Color TextField").sendKeys(text);
    }

    public void closeNavigation() throws InterruptedException {
        finder.bySemanticsLabel("close text button").click();
    }

    public void clickOnCrossIcon() throws InterruptedException {
        finder.byValueKey("Close button key").click();
    }

    public void scrollUpConfigurationCombinedView(int noOfTimes) {
        WebElement element = finder.byValueKey("CombinedLayout_ListView");
        int count = 0;
        while (count < noOfTimes) {
            basicPage.scrollToView("UP", element);
            count++;
        }
    }

    public void scrollDownConfigurationCombinedView(int noOfTimes) {
        WebElement element = finder.byValueKey("CombinedLayout_ListView");
        int count = 0;
        while (count < noOfTimes) {
            basicPage.scrollToView("DOWN", element);
            count++;
        }
    }

    public boolean isLimitValueAvailable(String limit) {
        return appPage.isElementAvailable(limit);
    }

    public void setCustomText(String text) {
        finder.byValueKey("custom text TextField").click();
        finder.byValueKey("custom text TextField").clear();
        finder.byValueKey("custom text TextField").sendKeys(text);
    }
    public void clearCustomText() {
        finder.byValueKey("custom text TextField").click();
        finder.byValueKey("custom text TextField").clear();
    }
}
