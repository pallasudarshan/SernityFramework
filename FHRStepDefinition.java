package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import steps.AppSteps;
import steps.FHRSteps;

public class FHRStepDefinition {

    @Steps
    FHRSteps fhrStep;

    @Steps
    AppSteps appSteps;

    @When("Click on dropdown and select {string}")
    public void click_on_dropdown_and_select(String text) {
        fhrStep.selectMPVFHRValue(text);

    }

    @When("disable the time preview bar")
    public void disable_the_time_preview_bar() {
        fhrStep.clickTimePreviewBar();

    }
    @When("click on update config")
    public void click_on_update_config() throws InterruptedException {
        fhrStep.clickUpdateConfig();
        Thread.sleep(15000);

    }
    @When("click on close button")
    public void click_on_close_button() {
        fhrStep.clickCloseButton();

    }

    @When("enable the time preview bar")
    public void enable_the_time_preview_bar() {
        fhrStep.clickOnEnableTimePreview();

    }
    @When("disable the date label")
    public void disable_the_date_label() {
        fhrStep.clickOnDisableDateLabel();

    }

    @When("Update Bgcolor {string} for time preview bar")
    public void update_bgcolor_for_time_preview_bar(String textcolor) {
        fhrStep.updateTimePreviewColor(textcolor);

    }
    @When("Update text color {string} for time label")
    public void update_text_color_for_time_label(String labelcolor) {
        fhrStep.updateTimelabelTextColor(labelcolor);

    }

    @When("click on icon path dropdown and select {string} icon")
    public void click_on_icon_path_dropdown_and_select_icon(String text) {
        fhrStep.clickOnIconPath(text);

    }

    @When("Update Icon color {string}")
    public void update_icon_color(String color) {
        fhrStep.updateIconColorValue(color);

    }

    @When("Update scale label text color {string}")
    public void update_scale_label_text_color(String textcolor) {
        fhrStep.updateScaleLabelTextColor(textcolor);

    }

    @When("Update Ymin {string} and Ymax {string} with default uom interval")
    public void update_ymin_and_ymax_with_default_uom_interval(String min, String max) {
        fhrStep.updateHrGridConfig(min, max);

    }

    @Then("Verify scale label text color {string} with threshold {string}")
    public void verify_scale_label_text_color_with_threshold(String imagePath, String threshold) {
        appSteps.verifyTheDisplayedApplicationLayout(imagePath, threshold);

    }


    @Then("Verify scale label {string} is displayed")
    public void verify_scale_label_is_displayed(String scoretext) {
        fhrStep.validateScoreLabelValue(scoretext);

    }

    @When("Update the waveform color {string}")
    public void update_the_waveform_color(String color){
        fhrStep.updateWaveFormsColorConfig(color);
    }

    @When("click on iconsize dropdown and select {string} size")
    public void click_on_iconsize_dropdown_and_select_size(String textsize) {
        fhrStep.clickOnIconSizeDropDownFiled(textsize);

    }

    @When("click on FhrConfig dropdown and select {string}")
    public void click_on_fhr_config_dropdown_and_select(String Configvalue) {
        fhrStep.clickOnFhrConfigDropDown(Configvalue);
    }

    @When("Update widthperminutepixed {string}")
    public void update_widthperminutepixed(String width) {
        fhrStep.updateWidth(width);

    }

    @When("Open on Hamburger Menu")
    public void open_on_hamburger_menu() {
        fhrStep.openNavigationMenuBar();

    }

    @When("click on MPV dropdown and select MPV FHR")
    public void click_on_mpv_dropdown_and_select_MPV_FHR() {
        fhrStep.selectMPVDropDown();
    }

    @Then("Verify by default {string} is displayed in FHR grid")
    public void verify_by_default_is_displayed_in_fhr_grid(String timePreviewBar) {
        fhrStep.verifyTimePreviewBar(timePreviewBar);

    }

    @Then("Verify by default global icon {string} is displayed")
    public void verify_by_default_global_icon_is_displayed(String icon) {
        fhrStep.verifyGlobalIcon(icon);
    }
    @Then("Verify by default date {string} is displayed")
    public void verify_by_default_date_is_displayed(String datelabel) {
        fhrStep.verifyGlobalIcon(datelabel);
    }

    @When("Update scale label text size {string}")
    public void update_scale_label_text_size(String scalesize) {
        fhrStep.updateScaleLabelTextSize(scalesize);

    }

    @When("disable the uom")
    public void disable_the_uom() {
        fhrStep.clickOnUom();
    }

    @When("enable the uom")
    public void enable_the_uom() {
        fhrStep.clickOnUomEnable();
    }

    @When("disable the Viewport")
    public void disable_the_viewport() {
        fhrStep.clickOnHrViewPort();

    }

    @When("enable the Viewport")
    public void enable_the_viewport() {
        fhrStep.clickOnEnableHrViewPort();

    }

    @When("disable saferange")
    public void disable_saferange() {
        fhrStep.clickOnSafeRangeCheckBox();

    }

    @When("enable saferange")
    public void enable_saferange() {
        fhrStep.clickSafeRange();

    }

    @When("Update saferange {string}")
    public void update_saferange(String text) {
        fhrStep.updateSafeRangeValue(text);

    }

//   ************ UA StepDefinitions *************

    @Then("Verify the by default global icon {string} is displayed")
    public void verifyByDefaultGlobalIconIsDisplayed(String label) {
        fhrStep.verifyGlobalIcon(label);
    }

    @Then("Verify the by default date {string} is displayed")
    public void verifyByDefaultDateIsDisplayed(String label) {
        fhrStep.verifyDateLabel(label);
    }

    @Then("verify the UOM is displaying  as the {string} for Lowest value of scale label")
    public void verifyTheUOMIsDisplayingAsMmHGForLowestValueOfScaleLabel(String uom) {
        fhrStep.verifyUomAvailable(uom);
    }

    @When("Click on FhrConfig and select {string}")
    public void clickOnFhrConfigAndSelect(String fhrConfig) {
        fhrStep.verifyfhrConfigDropDown(fhrConfig);
    }

    @When("Update widthPerMinuteinPixels {string}")
    public void updateWidthPerMinuteinPixels(String widthPixels) {
        fhrStep.setWidthPerMinutePixelsfhrFiled(widthPixels);
    }

    @And("click on close button for navigation menu")
    public void clickOnCloseButton() {
        fhrStep.closeNavigationConfig();
    }

    @And("Update UA wave form color {string}")
    public void updateUAWaveFormColorFF(String color) {
        fhrStep.setUAWaveformColour(color);
    }

    @And("^Update gap of HR and UA '(.*)'$")
    public void updateGapOfHRAndUA(String value) {
        fhrStep.setGapBetweenUAAndHR(value);
    }

    @Then("update configurations")
    public void updateConfigurations() throws InterruptedException {
        fhrStep.updateConfiguration();
    }

    @Then("Reset configurations")
    public void resetConfigurations() {
        fhrStep.resetConfiguration();
    }

    @And("^Update Ymin value '(.*)' Ymax value '(.*)'$")
    public void updateYminValueYmaxValueWithUomInterval(String ymin, String ymax) {
        fhrStep.setUAMinMaxIntervals(ymin,ymax);
    }

    @Given("Open Navigation Menu bar")
    public void openNavigationMenuBar() {
        fhrStep.openNavigationMenu();
    }

    @Then("Verify by default time preview bar {string} is displayed")
    public void verifyByDefaultTimePreviewBarIsDisplayed(String timePreviewBar) {
        fhrStep.verifyTimePreviewBar(timePreviewBar);
    }

    @Then("Verify the date displayed in format {string} in time preview bar {string}")
    public void verifyTheDateDisplayedInFormatInTimePreviewBar(String format,String element) {
        fhrStep.verifyDateDisplayed(format,element);
    }

    @Then("enter Scale label text size {string}")
    public void enterScaleLabelTextSize(String textSize) {
        fhrStep.setScaleLabelTextSize(textSize);
    }

    @Then("^enter scale label text colour '(.*)'$")
    public void enterScaleLabelTextColour(String color) throws InterruptedException {
        fhrStep.setScaleLabelTextColor(color);
    }

    @Then("Disable the global icon option")
    public void disableTheGlobalIconOption() {
        fhrStep.disableGlobalIcon();
    }

    @Then("Disable the UOM config option")
    public void disableTheUOMConfigOption() {
        fhrStep.disableUAUomConfig();
    }

    @Then("enable the UOM config option")
    public void enableTheUOMConfigOption() {
        fhrStep.enableUAUomConfig();
    }

    @Then("Disable the Time Preview config")
    public void disableTheTimePreviewConfig() {
        fhrStep.disableTimePreviewConfig();
    }

    @Then("enable the Time Preview config")
    public void enableTheTimePreviewConfig() {
        fhrStep.enableTimePreviewConfig();
    }

    @And("Update uom interval value {string}")
    public void updateUomIntervalValue(String uomInterval) {
        fhrStep.setUAUomIntervals(uomInterval);
    }

    @And("^wait for '(.*)'$")
    public void waitTime(String timeInterval) throws Throwable {
        fhrStep.waitWaveForm(timeInterval);
    }

    @And("delete perinatal Heart Rate Waveforms")
    public void deletePerinatalHeartRateWaveformsForPatient() throws Throwable {
        fhrStep.deletePerinatalWaveforms();
    }
}
