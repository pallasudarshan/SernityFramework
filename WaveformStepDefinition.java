package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.json.simple.parser.ParseException;
import steps.WaveformSteps;

import java.io.IOException;

public class WaveformStepDefinition {
    @Steps
    WaveformSteps waveformSteps;

    @Then("publish the waveform {string} as {string} waveform")
    public void publishWaveform(String payload, String waveformType) throws IOException, ParseException, InterruptedException {
        waveformSteps.updateWaveform(payload, waveformType);
    }

    @And("Reload the application")
    public void reloadApplication() throws InterruptedException {
        waveformSteps.refreshFSWApplication();
    }

    @And("Reload the application for error")
    public void reloadApplicationFromErrorPage() throws InterruptedException {
        waveformSteps.refreshFSWApplicationFromErrorPage();
    }

    @Then("validate the error message {string}")
    public void verifyWaveformErrorMessage(String errorMessage) {
        waveformSteps.verifyErrorMessage(errorMessage);

    }


    @Then("verify expected page header {string} is displayed")
    public void verify_expected_page_header_is_displayed(String title) {
        waveformSteps.isTitleDisplayed(title);
    }

    @Given("verify expceted waveform label {string} available")
    public void verify_expceted_waveform_label_available(String waveforms) {
        String[] WaveformsList = waveforms.split(",");
        for(String waveform : WaveformsList){
            waveformSteps.isECGWaveformsAvailable(waveform);
        }
    }

    @Then("set the waveform {string} for launching the caliper")
    public void setWaveformToLaunchTheCaliper(String waveform) {
        waveformSteps.setCaliperLaunchLead(waveform);
    }

    @Then("set the waveform {string} for as rhythm lead")
    public void setWaveformAsRhythmLead(String waveform) {
        waveformSteps.setRhythmLead(waveform);
    }

    @Then("validate {string} value should be {string}")
    public void validateCaliperVitals(String key, String value) {
        waveformSteps.getCaliperVitals(key, value);
    }

    @Then("validate {string} value should be {string} for {string} mode")
    public void validateCaliperVitals(String key, String value, String mode) {
        if (mode.equalsIgnoreCase("landscape") && System.getProperty("platformName").trim().equals("iOS")) {
            System.out.println("Screen rotation is not supported for iOS with the Flutter driver.");
        } else {
            waveformSteps.getCaliperVitals(key, value);
        }
    }

    @When("waveform configuration like {string} is updated to {string}")
    public void waveformConfigurationUpdate(String leadConfig, String flag) throws InterruptedException {
        waveformSteps.updateWaveformToggleConfiguration(leadConfig, flag);
    }

    @Then("apply waveform width {string} in the waveform")
    public void waveform_width_in_the_waveform(String waveformWidth) {
        waveformSteps.setWaveformWidth(waveformWidth);
    }

    @Then("apply lead label width {string} in the waveform")
    public void waveform_lead_label_width_in_the_waveform(String leadLabelWidth) {
        waveformSteps.setLeadLabelWidth(leadLabelWidth);
    }

    @Then("set divider height {string} in the waveform")
    public void waveform_divider_height_in_the_waveform(String dividerHeight) {
        waveformSteps.setDividerHeight(dividerHeight);
    }

    @Then("set double tap zoom max level {string} in the waveform")
    public void waveform_doubleTap_zoom_max_level_in_the_waveform(String maxZoomLevel) {
        waveformSteps.setDoubleTapZoomMaxValue(maxZoomLevel);
    }

    @Then("apply waveform color {string} for {string} in the waveform")
    public void setWaveformStrokeColor(String waveformStrokeColor, String waveform){
        waveformSteps.setWaveformStrokeColor(waveformStrokeColor, waveform);
    }

    @Then("apply lead label color {string} for {string} in the waveform")
    public void setLeadLabelColor(String leadLabelColor, String waveform){
        waveformSteps.setLeadLabelColor(leadLabelColor, waveform);
    }

    @Then("apply outer grid color {string} and inner grid color {string} in the waveform")
    public void setGridColor(String outerGridColor, String innerGridColor){
        waveformSteps.setGridColor(outerGridColor, innerGridColor);
    }

    @Then("^apply '(.*)' '(.*)' times on the '(.*)' of the waveform$")
    public void apply_Zoom_in_the_waveform(String pinchAction, int noOfTime, String waveformPosition) throws InterruptedException {
        if (pinchAction.equalsIgnoreCase("pinch-out")) {
            waveformSteps.zoomIn(noOfTime, waveformPosition);
        } else if (pinchAction.equalsIgnoreCase("pinch-in")) {
            waveformSteps.zoomOut(noOfTime, waveformPosition);
        }
    }

    @Then("apply double tap on the the {string} in FSW")
    public void apply_double_tap_in_the_FSW(String component) throws InterruptedException {
       Thread.sleep(3000); // Adding a sleep to ensure the component is loaded before double tap
       waveformSteps.doubleTapOnComponent(component);
    }

    @Then("apply gain {string} to the waveform")
    public void apply_gain_to_the_waveform(String gain) {
        waveformSteps.setGain(gain);
    }

    @Then("apply {string} gain {string} to the waveform")
    public void applyLeadGainInWaveform(String leadGainType, String gainValue) {
        waveformSteps.setLeadGain(leadGainType, gainValue);
    }

    @Given("the caliper is active")
    public void the_caliper_is_active() {
        waveformSteps.isCaliperLaunched();
    }

    @Given("^verify Caliper dots displayed '(.*)'$")
    public void the_caliper_dots_present(boolean dotsDisplayed) throws Exception {
        waveformSteps.areCaliperDotsDisplayed(dotsDisplayed);
    }

    @Given("^verify Caliper marchout lines are displayed '(.*)'$")
    public void the_caliper_marchout_lines_present(boolean marchoutLinesDisplayed) throws Exception {
        waveformSteps.areCaliperMarchoutLinesDisplayed(marchoutLinesDisplayed);
    }

    @And("click on waveform layout area")
    public void click_on_the_waveform_area() {
        waveformSteps.clickOnWaveformLayout();
    }

    @When("^the user checks the caliper proximity by moving caliper '(.*)' times towards '(.*)' direction$")
    public void the_user_checks_the_caliper_proximity(int count, String direction) throws InterruptedException {
        waveformSteps.dragAndDropTheCaliper(count, direction);
    }

    @When("^the user resize the '(.*)' arms of the Caliper by dragging it '(.*)' times towards '(.*)' direction$")
    public void the_user_adjusts_the_caliper_arms(String caliperArm, int noOftimes, String armAdjustmentDirection) throws InterruptedException {
        waveformSteps.dragAndDropTheCaliperArm(caliperArm, noOftimes, armAdjustmentDirection);
    }

    @When("^the user dragging waveform layout '(.*)' times towards '(.*)' direction$")
    public void the_user_adjusts_the_caliper_arms(int noOftimes, String direction) throws InterruptedException {
        waveformSteps.swipeWaveformLayout(noOftimes, direction);
    }

    @Then("rotate the screen to {string} mode")
    public void rotateMobileScreen(String displayMode) {
        waveformSteps.rotateTheScreen(displayMode);
    }
    @Then("the heart rate measurement should be displayed")
    public void the_heart_rate_measurement_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the user measures the amplitude")
    public void the_user_measures_the_amplitude() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the amplitude measurement should be displayed")
    public void the_amplitude_measurement_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the user measures the interval")
    public void the_user_measures_the_interval() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the interval measurement should be displayed")
    public void the_interval_measurement_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user views the tracking dots")
    public void the_user_views_the_tracking_dots() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the tracking dots should be visible")
    public void the_tracking_dots_should_be_visible() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user views the March out lines")
    public void the_user_views_the_march_out_lines() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the March out lines should be visible")
    public void the_march_out_lines_should_be_visible() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user applies Gain to the waveform")
    public void the_user_applies_gain_to_the_waveform() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the caliper tool should adjust accordingly")
    public void the_caliper_tool_should_adjust_accordingly() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user applies Zoom to the waveform")
    public void the_user_applies_zoom_to_the_waveform() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user selects default lead configuration")
    public void the_user_selects_default_lead_configuration() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the caliper should display the default lead configuration")
    public void the_caliper_should_display_the_default_lead_configuration() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the user selects default duration configuration")
    public void the_user_selects_default_duration_configuration() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the caliper should display the default duration configuration")
    public void the_caliper_should_display_the_default_duration_configuration() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the user selects height configuration")
    public void the_user_selects_height_configuration() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the caliper should display the height configuration")
    public void the_caliper_should_display_the_height_configuration() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
