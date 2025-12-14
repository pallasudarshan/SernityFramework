package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;
import steps.AppSteps;
import steps.NumericSteps;
import steps.PatientSteps;

import java.util.List;

public class NumericStepDefinition {
    @Steps
    NumericSteps numericSteps;
    @Steps
    PatientSteps patientSteps;
    @Steps
    AppSteps appSteps;

    @When("^publish all numerics '(.*)' subparameter '(.*)' with value '(.*)' UOM '(.*)' SampleInterval '(.*)' and invalidLE '(.*)'$")
    public void publishAllNumericsWithValueUOMSampleIntervalAndInvalidLE(String parameters, String numerics, String numericValues, String uoms, String sampleIntervals, String InvalidLE) throws InterruptedException {
        numericSteps.updateAllNumerics(parameters,numerics,numericValues,uoms,sampleIntervals,InvalidLE);
    }

    @When("^publish alarms for parameter '(.*)' numeric '(.*)' with priority '(.*)' eventType '(.*)' type '(.*)' eventState '(.*)' alarmInactState '(.*)' and physioTech '(.*)' and dateTime '(.*)'$")
    public void publishAlarmInfo(String parameter, String numeric, String priority, String eventType, String eventState, String type, String alarmInactState, String physioTech, String dateTime) throws InterruptedException {
            numericSteps.publishAlarmWithAlarmState(parameter,numeric,priority,eventType,eventState,type,alarmInactState,physioTech,dateTime);
    }

    @And("select the numeric Type {string} option")
    public void selectTheNumericTypeOption(String numericViewName) throws InterruptedException {
        numericSteps.selectNumericViewDropdown(numericViewName);
        Thread.sleep(5000);
    }

    @Then("Verify the numeric parameter {string} on container")
    public void verifyTheNumericParameterOnContainer(String parameter) {
        numericSteps.verifyNumericParameter(parameter);
    }

    @Then("Verify the numeric value {string} on container to {string}")
    public void verifyTheNumericValueOnContainer(String numericValue, String flag) throws InterruptedException {
        Thread.sleep(5000);
        numericSteps.verifyNumericValue(numericValue, flag);
    }

    @And("Verify the UOM {string} on container")
    public void verifyTheUOMOnContainer(String uom) {
        numericSteps.verifyUomOnContainer(uom);
    }

    @And("select the label type {string} option")
    public void selectTheLabelTypeOption(String labelType) {
        numericSteps.selectLabelTypeDropdown(labelType);
    }

    @Then("Verify the numeric label {string} on container")
    public void verifyTheNumericLabelOnContainer(String numericLabel) {
        numericSteps.verifyNumericLabel(numericLabel);
    }

    @And("Select the parameter dropdown {string} option")
    public void selectTheParameterDropdownOption(String parameter) {
        numericSteps.selectNumericParameter(parameter);
    }

    @And("enable the {string} option is updated to {string}")
    public void enableTheOptionIsUpdatedTo(String toggle, String flag) throws InterruptedException {
        numericSteps.enableToggleConfig(toggle,flag);
    }

    @When("Toggle the {string} option is updated to {string}")
    public void toggleTheOptionIsUpdatedTo(String toggleConfig, String flag) {
        numericSteps.toggleConfig(toggleConfig,flag);
    }

    @And("disable the {string} option is updated to {string}")
    public void disableTheOptionIsUpdatedTo(String toggle, String flag) {
          numericSteps.toggleConfig(toggle,flag);
    }

    @When("enter the label colour {string} in field")
    public void enterTheLabelColourInField(String colour) {
        numericSteps.enterLabelColour(colour);
    }

    @When("enter the uom colour {string} in field")
    public void enterTheUomColourInField(String colour) {
        numericSteps.enteruomColour(colour);
    }

    @When("enter label font size {string} in field")
    public void enterFontSizeInField(String fontSize) {
        numericSteps.enterLabelFontSize(fontSize);
    }

    @When("enter the uom font size {string} in field")
    public void enterTheUomFontSizeInField(String fontSize) {
        numericSteps.enterUomFontSize(fontSize);
    }

    @When("enter the numeric value font size {string} in field")
    public void enterTheNumericValueFontSizeInField(String fontSize) {
        numericSteps.enterNumericValueFontSize(fontSize);
    }

    @And("Close the Navigation Menu")
    public void closeTheNavigationMenu() throws InterruptedException {
        numericSteps.closeNavigationMenu();
    }

    @And("^Scroll to see the '(.*)' config '(.*)' times towards '(.*)' direction$")
    public void scrollNavigationShowMeanValueConfigTimesTowardsUPDirection(String config, int noOfTimes,String direction) throws InterruptedException {
        numericSteps.swipeToVisibleElement(config,noOfTimes,direction);
    }

    @And("enable the {string} option for {string}")
    public void enableTheOptionFor(String config, String numericView) {
        numericSteps.enableIconToggle(config,numericView);
    }

    @And("Select the icon type dropdown {string} option for {string}")
    public void selectTheIconTypeDropdownOptionFor(String icon, String numericView) {
        numericSteps.selectCustomIcon(icon,numericView);
    }

    @And("Select the selection icon dropdown {string} option for {string}")
    public void selectTheSelectionIconDropdownOptionFor(String icon, String numericView) {
        numericSteps.selectSelectionIcon(icon,numericView);
    }

    @When("disable the {string} option is update for {string}")
    public void disableTheOptionIsUpdateFor(String toggle, String numericConfig) {
        numericSteps.disableValueVisibility(toggle,numericConfig);
    }

    @When("enable the {string} option is update for {string}")
    public void enableTheOptionIsUpdateFor(String toggle, String numericConfig) {
        numericSteps.disableValueVisibility(toggle,numericConfig);
    }

    @When("enter the medium colour {string} in field")
    public void enterTheMediumColourInField(String colour) {
        numericSteps.enterAlarmMediumColourField(colour);
    }

    @When("enter the low colour {string} in field")
    public void enterTheLowColourInField(String colour) {
        numericSteps.enterAlarmLowColourField(colour);
    }

    @When("enter the override color {string} in field")
    public void enterTheHighColourInField(String color) {
       numericSteps.setAlarmBackgroundColor(color);
    }

    @And("Verify MIA configuration {string} is enabled")
    public void verifyMIAConfigurationIsEnabled(String label) {
        numericSteps.verifyMiaSelectionIsAvailable(label);
    }

    @And("Select the alarm sort order dropdown {string} option")
    public void selectTheAlarmSortOrderDropdownOption(String dropdownItem) {
        numericSteps.selectAlarmSorteddropDown(dropdownItem);
    }

    @Then("Verify the numeric parameter not display {string} on container for {string}")
    public void verifyTheNumericParameterNotDisplayOnContainerFor(String value, String numericView) {
        numericSteps.isNumericValueNotAvaialable(value,numericView);
    }

    @When("enable the {string} option is updated to {string} for {string}")
    public void enableTheOptionIsUpdatedToFor(String toggle, String flag, String numericView) {
       numericSteps.verifyToggleConfig(toggle,flag,numericView);
    }

    @When("disable the {string} option is updated to {string} for {string}")
    public void disableTheOptionIsUpdatedToFor(String toggle, String flag, String numericView) {
        numericSteps.verifyToggleConfig(toggle,flag,numericView);
    }

    @Then("Verify Mean value {string} display in container to {string} for {string}")
    public void verifyMeanValueDisplayInContainerToFor(String meanValue, String flag, String config) {
        numericSteps.verifyNumericMeanValue(meanValue,flag,config);
    }

    @Then("Verify the numeric value {string} for NIBP on container to {string}")
    public void verifyTheNumericValueForNIBPOnContainerTo(String numericValues, String flag) {
        numericSteps.verifyNIBPNumericValues(numericValues,flag);
    }

    @And("verify the icon display on container for {string} {string} with threshold {string} in the application")
    public void verifyTheIconDisplayOnContainerForWithThresholdInTheApplication(String numericType, String imagePath, String threshold) {
        if(numericType.equalsIgnoreCase("CondensedNumeric")||numericType.equalsIgnoreCase("spO2")){
            appSteps.verifyTheDisplayedApplicationLayout(imagePath,threshold);
        }else{
            System.out.println("Icon visibility config not require to test for TileNumeric");
        }
    }

    @And("^Scroll '(.*)' to the Navigation Menu '(.*)' times$")
    public void scrollUPToTheNavigationMenuTimes(String direction, int noOfTimes) {
        numericSteps.scrollUpNumericConfigurationListView(direction, noOfTimes);
    }

    @And("update the {string} option is updated to {string} for the {string}")
    public void disableTheOptionIsUpdatedToForThe(String toggle, String flag, String config) {
        if(config.equalsIgnoreCase("NIBPWithLabel") ||
                config.equalsIgnoreCase("NIBPSingleRow")||
                config.equalsIgnoreCase("NIBPTwoRowBracket") ) {
            numericSteps.toggleConfig(toggle, flag);
        }else{
            System.out.println("show mean config not require to test for NIBPWithOutMean and NIBPRowWithoutMean");
        }
    }

    @Then("verify the SQI visibility in NIBP {string} config {string} with threshold {string} in the application")
    public void verifyTheDisplayedApplicationLayout(String config, String imagePath, String threshold) throws InterruptedException {
        Thread.sleep(3000);
        if(config.equalsIgnoreCase("NIBPSingleRow")) {
            appSteps.verifyTheDisplayedApplicationLayout(imagePath, threshold);
        }else {
            System.out.println("SQI not implemented for the NIBPWithOutMean,NIBPRowWithoutMean,NIBPTwoRowBracket,NIBPWithLabel configurations");
        }
    }

    @And("disable the MIA logic {string} config option")
    public void disableTheMIALogicConfigOption(String config) {
        numericSteps.updateMiaLogicConfig(config);
    }

    @And("enable the MIA logic {string} config option")
    public void enableTheMIALogicConfigOption(String config) {
        numericSteps.updateMiaLogicConfig(config);
    }

    @And("verify the alarm unmerge {string} with threshold {string} for {string}")
    public void verifyTheAlarmUnmergeWithThresholdFor(String imagePath, String threshold, String config) {
        if(config.equalsIgnoreCase("NIBPSingleRow")) {
            appSteps.verifyTheDisplayedApplicationLayout(imagePath, threshold);
        }else{
            System.out.println("Alarm Merge case requirement is not require to test for NIBPWithOutMean, NIBPRowWithoutMean,NIBPWithLabel & NIBPTwoRowBracket");
        }
    }
    @And("verify the alarm merge view {string} with threshold {string} for {string}")
    public void verifyTheAlarmmergeWithThresholdFor(String imagePath, String threshold, String numericView) {
        String[] numericsArray = numericView.split(";");
        if(numericsArray.length>2) {
            appSteps.verifyTheDisplayedApplicationLayout(imagePath, threshold);
        }else{
            System.out.println("Alarm Merge case requirement is not require to test for NIBPWithOutMean, NIBPRowWithoutMean,NIBPWithLabel & NIBPTwoRowBracket");
        }
    }

    @When("^scroll to '(.*)' to the combined layout screen '(.*)' times$")
    public void scrollToUPToTheCombinedLayoutScreenTimes(String direction, int noOfTimes) {
        numericSteps.scrollUpAndDownCombinedLayoutScreen(direction,noOfTimes);
    }

    @And("enable the {string} option is updated to {string} for NIBP {string}")
    public void enableTheOptionIsUpdatedToForNIBP(String toggle, String flag, String numerics) {
        numericSteps.verifyNIBPMergeCase(toggle,flag,numerics);
    }

    @Then("^the configs and critical limits of Parameter'(.*)',Numerics'(.*)'are updated with HighLimitValue'(.*)',LowLimitValue'(.*)',CriticalLowLimit'(.*)',CriticalHighLimit'(.*)',UOM'(.*)',isEnabledLowLimit '(.*)',isEnabledHighLimit '(.*)',isEnabledCriticalLowLimit '(.*)',isEnabledCriticalHighLimit '(.*)'$")
    public void updateConfigsAndCriticals(String parameters, String numerics,
                                          String configHighLimit, String configLowLimit, String criticalLowLimit, String criticalHighLimit, String uoms,
                                          String isEnabledLowLimit, String isEnabledHighLimit, String isEnabledCriticalLowLimit, String isEnabledCriticalHighLimit) throws InterruptedException {
        numericSteps.updateConfigCriticalLimits(parameters, numerics, configHighLimit, configLowLimit, criticalLowLimit, criticalHighLimit, uoms, isEnabledLowLimit, isEnabledHighLimit,isEnabledCriticalLowLimit, isEnabledCriticalHighLimit);
    }

    @And("enable the double line limit {string} options to {string}")
    public void enableTheDoubleLineLimitOptionsTo(String doubleLine, String flag) {
        numericSteps.enableCombinedLimitConfig(doubleLine,flag);
    }
    @And("enable the critical limit values {string} double line limit {string} options to {string}")
    public void enableTheCriticalLimitValuesDoubleLineLimitOptionsTo(String criticalLimit, String showLimit, String flag) {
        numericSteps.enableCombinedLimitConfig(criticalLimit,showLimit,flag);
    }

    @Then("verify the basicHighLimit {string},basicLowLimit {string},criticalMaxLimit {string},criticalMinLimit {string}")
    public void verifyTheBasicHighLimitBasicLowLimitCriticalMaxLimitCriticalMinLimit(String basicHigh, String basicLow, String criticalHigh, String criticalLow) {
        numericSteps.verifyBasicAndCriticalLowHighValues(basicHigh,basicLow,criticalHigh,criticalLow);
    }

    @Then("Verify dashout value {string} is displayed")
    public void verifyDashoutValueIsDisplayed(String text) {
        numericSteps.verifyTextIsAvailable(text);
    }

    @Then("verify the limit labels {string} and {string} is displayed")
    public void verifyTheLimitLabelsAndOptionsTo(String regularLabel, String criticaLabel) {
        numericSteps.verifyTextIsAvailable(regularLabel);
        numericSteps.verifyTextIsAvailable(criticaLabel);
    }


    @And("Select the disable type limit {string} option")
    public void selectTheDisableTypeLimitOption(String disableLimit) {
        numericSteps.selectDisabledTypeLimit(disableLimit);
    }

    @And("select disable type off limit value for {string}, {string}, {string} and {string} options to {string}")
    public void selectDisableTypeOffLimitValueForAndOptionsTo(String basicLowOff, String basicHighOff, String criticalLowOff, String criticalHighOff, String flag) {
        numericSteps.enableBasicAndCriticalLowToHigh(basicLowOff, basicHighOff,criticalLowOff, criticalHighOff,flag);
    }

    @Then("Verify the off limit values {string} override for BasicLow, BasicigHigh, CriticalLow and CriticalHigh limits")
    public void verifyTheOffLimitValuesOverrideForBasicLowBasicigHighCriticalLowAndCriticalHighLimits(String text) {
        numericSteps.verifyTextIsAvailable(text);
    }

    @And("enter the custom text field as {string}")
    public void enterTheCustomTextFieldAs(String text) {
        numericSteps.enterCustomText(text);
    }

    @And("Select the second icon {string} and third icon {string} dropdown options")
    public void selectTheSecondIconAndThirdIconDropdownOptions(String icon2, String icon3) {
        numericSteps.selectSecondAndThirdIcon(icon2,icon3);
    }

    @Then("Verify the numeric parameter {string} on container for {string}")
    public void verifyTheNumericParameterOnContainerFor(String parameter,String viewType) {
        if(parameter.equalsIgnoreCase("ecg") || parameter.equalsIgnoreCase("NIBP") ){
            numericSteps.scrollUpCombinedLayoutScreen(2);
            numericSteps.verifyNumericParameter(parameter);
        }else if(viewType.equalsIgnoreCase("CombinedNumerics") ||parameter.equalsIgnoreCase("spO2") ){
            numericSteps.scrollUpCombinedLayoutScreen(1);
            numericSteps.verifyNumericParameter(parameter);
        }
    }

    @Then("verify the custom text {string} is displayed for {string}")
    public void verifyTheCustomTextIsDisplayedFor(String text, String parameter) {
        if(parameter.equalsIgnoreCase("spO2")) {
            numericSteps.verifyTextIsAvailable(text);
        }else{
            System.out.println("Custom text not configure for ecg displayed layouts ");
        }
    }

    @Then("Verify the current date and current time displayed for {string}")
    public void verifyTheCurrentDateAndCurrentTimeDisplayedFor(String parameter) {
        if(parameter.equalsIgnoreCase("ecg") || parameter.equalsIgnoreCase("NIBP")){
            numericSteps.verifyCurrentUTCDateAndTime();
        }else{
            System.out.println("Date and time not configure for spo2 displayed layouts");
        }
    }

    @And("Close the Navigation Menu with cross icon")
    public void closeTheNavigationMenuWithCrossIcon() throws InterruptedException {
        numericSteps.closeNavigationMenuWithCrossIcon();
    }

    @And("clear the custom text field")
    public void clearTheCustomTextField() {
        numericSteps.clearCustomText();
    }
}
