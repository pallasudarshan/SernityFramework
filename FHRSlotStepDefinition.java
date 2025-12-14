package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import steps.FHRSlotSteps;

public class FHRSlotStepDefinition {

    @Steps
    FHRSlotSteps slotSteps;

    @Given("click on the MPV dropdown and Select {string}")
    public void click_on_the_mpv_dropdown_and_select(String text) throws InterruptedException {
        slotSteps.clickOnMPVDropDownO(text);
    }

    @Then("verify patient with name {string} is available")
    public void verify_patient_with_name_is_available(String name) throws InterruptedException {
        slotSteps.validatePatientName(name);

    }
    @When("Disable the Patient Banner")
    public void disable_the_patient_banner() {
        slotSteps.clickPatientBannerDisable();
    }

    @Then("Validate patient name {string} is not displayed")
    public void validate_patient_name_is_not_displayed(String name) {
        slotSteps.validateName(name);
    }

    @When("Enable the patient Banner")
    public void enable_the_patient_banner() throws InterruptedException {
        slotSteps.clickPatientBannerEnable();
    }
    @When("Enable the Alarm widget")
    public void enable_the_alarm_widget() {
        slotSteps.enableAlarmWidget();
    }

    @When("disable FHRStripWidget")
    public void disable_fhr_strip_widget() {
       slotSteps.disableFHRStrip();
    }

    @When("Enable FHRStripWidget")
    public void enable_fhr_strip_widget() {
       slotSteps.enableFHRStrip();
    }

    @Then("Validate numeric label {string} is displayed")
    public void validate_numeric_label_is_displayed(String name) {
        slotSteps.validateLabelName(name);
    }

    @Then("Validate numeric value {string} is displayed")
    public void validate_numeric_value_is_displayed(String value) {
       slotSteps.validateNumericValue(value);
    }

    @When("Disable FHR Numerics")
    public void disable_fhr_numerics() {
        slotSteps.clickOnFHRNumeirc();
    }

    @Then("Validate numeric label {string} is not displayed")
    public void validate_numeric_label_is_not_displayed(String name) {
        slotSteps.validateLabelNotDisplayed(name);
    }

    @Then("Validate numeric value {string} is not displayed")
    public void validate_numeric_value_is_not_displayed(String value) {
       slotSteps.validateValueNotDisplayed(value);
    }

    @When("Tap on the Alarm widget")
    public void tap_on_the_alarm_widget() {
        slotSteps.clickAlarmWidget();
    }

    @When("Click on Alarm config")
    public void click_on_alarm_config() {
       slotSteps.clickAlarmConfig();
    }

    @When("Disable Tap Alarm widget")
    public void disable_tap_alarm_widget() throws InterruptedException {
      slotSteps.clickAlarmWidgetTap();
    }

    @When("disable badge icon")
    public void disable_badge_icon() {
        slotSteps.clickBadgetIcon();
    }

    @Then("verify {string} is not available")
    public void verify_is_not_available(String text) {
        slotSteps.validatePatientInfo(text);
    }

    @Then("Verify AlarmWidgetNotDisplayed in the Patient Banner")
    public void verify_alarm_widget_not_displayed_in_the_patient_banner() {
        slotSteps.verifyAlarmWidgetNotAvailable();
    }

    @Then("Verify ChervoniconNotDisplayed in the Patient Banner")
    public void verify_chervonicon_displayed_in_the_patient_banner() {
        slotSteps.verifyChervonIconNotAvailable();
    }

    @Then("verify BellIconDisplayed in the AlarmWidget")
    public void verify_bell_icon_displayed_in_the_alarm_widget() {
        slotSteps.verifyBellIconAvailable();
    }
    @Then("verify BadgetIconDisplayed in the AlarmWidget")
    public void verify_badget_icon_displayed_in_the_alarm_widget() {
        slotSteps.verifyBadgetIconAvailable();
    }

    @Then("verify BadgetIconNotDisplayed in the AlarmWidget")
    public void verify_badget_icon_not_displayed_in_the_alarm_widget() {
     slotSteps.verifyBadgetIconNotAvailable();
    }

    @When("^publish numerics '(.*)' subparameter '(.*)' with value '(.*)' UOM '(.*)' SampleInterval '(.*)' and invalidLE '(.*)'$")
    public void publishNumericsWithValueUOMSampleIntervalAndInvalidLE(String parameters, String numerics, String numericValues, String uoms, String sampleIntervals, String InvalidLE) throws InterruptedException {
            slotSteps.updateAllNumerics(parameters, numerics, numericValues, uoms, sampleIntervals, InvalidLE);
    }

    @When("^publish alarms parameter '(.*)' numeric '(.*)' with priority '(.*)' eventType '(.*)' type '(.*)' eventState '(.*)' alarmInactState '(.*)' and physioTech '(.*)' and dateTime '(.*)'$")
    public void publishAlarmInfo(String parameter, String numeric, String priority, String eventType, String eventState, String type, String alarmInactState, String physioTech, String dateTime) throws InterruptedException {
        String[] numericsArray = numeric.split(";");
        if (numericsArray.length > 1) {
            slotSteps.publishAlarmWithAlarmState(parameter,numeric,priority,eventType,eventState,type,alarmInactState,physioTech,dateTime);
        } else {
            slotSteps.publishEventWithAlarmInfo(parameter,numeric,priority,eventType,eventState,type,alarmInactState,physioTech,dateTime);
        }
    }

    @Given("Tap on Chevron Icon")
    public void tap_on_chevron_icon() {
      slotSteps.clickChervonIcon();
    }

    @Given("Tap on uncollapsed Chevron Icon")
    public void tap_on_uncollapsed_chevron_icon() {
     slotSteps.clickChervonIcon();
    }

    @When("Click on Patient banner")
    public void click_on_patient_banner() throws InterruptedException {
        slotSteps.tapPatientBanner();
    }

    @Then("Validate SPV {string} page is displayed")
    public void validate_spv_page_is_displayed(String text) {
      slotSteps.validateSPVPageDisplayed(text);
    }

    @When("Select the alarm sort order dropdown {string}")
    public void select_the_alarm_sort_order_dropdown(String text) throws InterruptedException {
       slotSteps.clickOnPriorityDropDown(text);
    }

    @Then("Validate an event {string} is displayed")
    public void validate_an_event_is_displayed(String text) {
        slotSteps.validateAlarmEvent(text);
    }

    @Then("click on Prefix Icon size dropdown and select {string} size")
    public void click_on_prefix_icon_size_dropdown_and_select_size(String text) throws InterruptedException {
        slotSteps.clickOnPrefixDropDown(text);
    }

    @Then("click on Prefix Icon dropdown and select {string} Icon")
    public void click_on_prefix_icon_dropdown_and_select_icon(String text) throws InterruptedException {
       slotSteps.clickOnIconDropDown(text);
    }

    @Given("Update color {string} for alarm priority")
    public void update_color_for_alarm_priority(String text) {
        slotSteps.updateLowPriorityColor(text);
    }

    @Given("update bellicon {string} color for alarm widget")
    public void update_bellicon_color_for_alarm_widget(String text) {
        slotSteps.updateBellIconColor(text);
    }

    @When("Update {string} card dimensions")
    public void update_card_dimensions_and(String text) {
        slotSteps.updateCardDetails(text);
    }

    @When("Enable FHR Numerics")
    public void enable_fhr_numerics() {
        slotSteps.clickOnNumeric();
    }

    @Then("Validate an event {string} not displayed")
    public void validate_an_event_not_displayed(String text) {
       slotSteps.validateAlarmEventNotAvaiabale(text);
    }

    @Then("Enable Tap Alarm widget")
    public void enable_tap_alarm_widget() {
        slotSteps.clickEnableAlarmWidgetTap();
    }

    @Then("Validate badget count {string} is displayed")
    public void validate_badget_count_is_displayed(String text) {
        slotSteps.validateBadgetCount(text);
    }

    @When("Tap on the Alarm widget PlaceHolder")
    public void tap_on_the_alarm_widget_PlaceHolder() {
        slotSteps.clickOnPlaceHolderWidget();
    }

    @When("Tap on the Alarm widget PlaceHolder in MPV Page")
    public void tap_on_the_alarm_widget_PlaceHolder_in_MPV_Page() {
        slotSteps.clickOnPriorityIcon();
    }

    @Given("Update color {string} for alarm info priority")
    public void update_color_for_alarm_info_priority(String text) {
        slotSteps.updateInfoPriorityColor(text);
    }

    @Given("update bellicon {string} color for alarm info widget")
    public void update_bellicon_color_for_alarm_info_widget(String text) {
        slotSteps.updateBellIconInfoColor(text);
    }

    @And("^drag the bottomSheet down '(.*)' close$")
    public void dragTheBottomSheetDownClose(int noOfTimes) throws InterruptedException {
        slotSteps.dragDownToVisibleElement(noOfTimes);
    }
    @When("Click on Bottom sheet Dropdown")
    public void click_on_bottom_sheet_dropdown() {
        slotSteps.clickonBottomSheetdownArrow();
    }

    @When("Update the default height as {string}")
    public void update_the_default_height_as(String text) {
        slotSteps.updateOnDefaultHeight(text);
    }

    @When("Tap on the Alarm widget PlaceHolder for icon")
    public void tap_on_the_alarm_widget_PlaceHolder_for_icon() {
        slotSteps.clickOnPriorityBellIcon();
    }

    @And("^Scroll slot '(.*)' '(.*)' the Navigation Menu '(.*)' times$")
    public void scrollTheElementIntoViewMPV(String path,String direction, int noOfTimes) throws InterruptedException {
        slotSteps.scrollElementUntilVisible(direction,noOfTimes,path);
    }
    @Given("Open Navigation MPV Menu")
    public void openNavigationMPVMenu() {
        slotSteps.openNavigationMPVMenu();
    }

}
