package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import steps.AppSteps;
import steps.EWSSteps;
import steps.PatientSteps;


public class EWSStepDefinition
{
    @Steps
    EWSSteps ewssteps;

    @Steps
    PatientSteps patientSteps;

    @Steps
    AppSteps appSteps;

    @When("deleting all patients")
    public void deletingAllPatients() throws InterruptedException {
        ewssteps.deleteAllPatient();
    }
    @When("admiting {int} patients")
    public void admiting_patients(int noOfPatient) throws InterruptedException {
        patientSteps.createPatientByDeviceStart(noOfPatient);
    }

    @When("publish all numerics {string} {string} with Value {string} UOM {string} SampleInterval {string} invalidLE {string}")
    public void publish_all_numerics_with_value_uom_sample_interval_invalid_le(String parameters, String numerics, String numericValues, String UOMs, String sampleInterval, String invalidLE) throws InterruptedException {
        ewssteps.updateAllNumerics(parameters, numerics, numericValues, UOMs, sampleInterval, invalidLE);
    }

    @When("Click on drop down and select {string} text")
    public void click_on_drop_down_and_select_text(String EWS) throws InterruptedException {
        ewssteps.selectEWSvalue(EWS);
        Thread.sleep(4000);
    }

    @When("Click on Hamburger Menu")
    public void click_on_hamburger_menu() {
        ewssteps.clickOnHamburgeroption();
    }
    @When("Update Score label {string}")
    public void update_score_label(String scoreName) throws InterruptedException {
        ewssteps.enterScoreName(scoreName);
        Thread.sleep(3000);
    }

    @When("Click on level dropdown and And Select Level 2")
    public void click_on_level_dropdown_and_and_select() {
        ewssteps.selectlevelonevalue();
    }

    @Then("Validate background color icon and scorevalue is displayed for level1 {string} with threshold {string}")
    public void validate_background_color_icon_and_scorevalue_is_displayed_for_level_image_comparsion(String imagePath, String threshold) throws InterruptedException {
        appSteps.verifyTheDisplayedApplicationLayout(imagePath, threshold);
        Thread.sleep(5000);
    }

    @Then("Validate the score label {string} is displayed")
    public void validate_the_score_label_is_displayed(String scorelabel) {
        ewssteps.validateScoreLabel(scorelabel);

    }

    @Then("Validate the score value {string} is displayed")
    public void validate_the_score_value_is_displayed(String scorevalue){
        ewssteps.validateScoreValue(scorevalue);

    }
    @When("Tap on the Tag view")
    public void tap_on_the_tag_view(){
        ewssteps.tapOnTheTagView();

    }
    //To validate pop-up is not displayed
    @Then("Validate text {string} is not displayed in the pop-up")
    public void validate_text_is_not_displayed_in_the_pop_up(String text) {
        ewssteps.validateEventPopUp(text);

    }
    // To validate small numeric view
    @Then("Validate default background color is displayed for small view {string} with threshold {string}")
    public void validate_default_background_color_is_displayed_for_small_view_with_threshold(String imagePath, String threshold) throws InterruptedException {
        appSteps.verifyTheDisplayedApplicationLayout(imagePath,threshold);

    }
    @When("Click on iconpathlight dropdown and select {string}")
    public void click_on_iconpathlight_dropdown_and_select(String alert_icon) throws InterruptedException {
        ewssteps.clickOnIcon(alert_icon);

    }

    @Then("Validate the alert_icon is displayed {string} with threshold {string}")
    public void validate_the_alert_icon_is_displayed_with_threshold(String imagePath, String threshold) throws InterruptedException {
        appSteps.verifyTheDisplayedApplicationLayout(imagePath,threshold);

    }
    @Then("Tap on the small size combined view")
    public void tap_on_the_small_size_combined_view() {
        ewssteps.tapOnTheSmallView();

    }
    @Then("Validate the bgcolor icon message and score value label truncation is displayed for medium view {string} with threshold {string}")
    public void validate_the_bgcolor_icon_message_and_score_value_label_truncation_is_displayed_for_medium_view_is_displayed_with_threshold(String imagePath, String threshold) throws InterruptedException {
        appSteps.verifyTheDisplayedApplicationLayout(imagePath,threshold);
    }
    @Then("Validate Error message {string} is displayed")
    public void validate_error_message_is_displayed(String text) {
        ewssteps.validateErrorMessage(text);

    }
    @Then("Tap on the medium size numeric view")
    public void tap_on_the_medium_size_numeric_view() {
        ewssteps.tapOnTheMediumView();
    }

    @When("Update Bordercolorlight {string} Scorelabelcolorlight {string} Scorevaluecolorlight {string}")
    public void update_bordercolorlight_scorelabelcolorlight_scorevaluecolorlight_iconcolorlight(String Bordercolor, String Scorelabelcolor, String Scorevaluecolor) {
        ewssteps.updateLevelColor(Bordercolor,Scorelabelcolor,Scorevaluecolor);
    }


    @Then("Validate background color is displayed for tile view {string} with threshold {string}")
    public void validate_background_color_is_displayed_for_tile_view_with_threshold(String imagePath, String threshold) throws InterruptedException {
        appSteps.verifyTheDisplayedApplicationLayout(imagePath,threshold);

    }

    @When("Tap on the Tile view")
    public void tap_on_the_tile_view() {
        ewssteps.clickOnTileView();
    }

    @When("Click on close button")
    public void clickbutton() throws InterruptedException {
        ewssteps.clickOnCloseButton();
        Thread.sleep(3000);
    }

    //To update height and with for tag view
    @When("update {string} and {string} for the tag view")
    public void update_and_for_the_tag_view(String width, String height)  {
        ewssteps.updateHeightWidth(width, height);
    }

    //To validate truncation for the label of tag view
    @Then("Validate label is getting truncated for the fixed behaviour {string} with threshold {string}")
    public void validate_label_is_getting_truncated_for_the_fixed_behaviour_with_threshold(String imagePath, String threshold) throws InterruptedException {
        appSteps.verifyTheDisplayedApplicationLayout(imagePath,threshold);

    }

    @When("Click on level dropdown and Select Level 3")
    public void click_on_level_dropdown_and_select() {
        ewssteps.updateLevelThird();
    }

    @When("enable toggle {string} is updated to {string}")
    public void enable_toggle_is_updated_to(String configLabel, String flag) throws InterruptedException {
        boolean booleanFlag = Boolean.parseBoolean(flag);
        ewssteps.updateEWSToggleConfiguration(configLabel, booleanFlag);
        Thread.sleep(5000);
    }

    @When("Update Error text {string}")
    public void update_error_text(String text) {
        ewssteps.UpdateErrorMessage(text);
    }

    // To select level 4 from dropdown
    @When("Click on level dropdown and Select Level 4")
    public void click_on_level_dropdown_and_select_level4() {
        ewssteps.updateLevelFourth();
    }
    //To update width and height for medium view
    @When("update {string} and {string} for combined view")
    public void update_and_for_combined_view(String width, String height) {
        ewssteps.updateMediumHeightwidth(width,height);
    }
    @When("Enable {string} is updated to {string}")
    public void enable_is_updated_to(String togglebutton, String flag) throws InterruptedException {
        boolean booleanFlag = Boolean.parseBoolean(flag);
        ewssteps.updateEWSToggleConfiguration(togglebutton, booleanFlag);
        Thread.sleep(5000);

    }
    @Then("Validate defaut background color is displayed for Invalid view {string} with threshold {string}")
    public void validate_defaut_background_color_is_displayed_for_invalid_view_with_threshold(String imagePath, String threshold) throws InterruptedException {
        appSteps.verifyTheDisplayedApplicationLayout(imagePath,threshold);
    }

    @Then("Validate score value {string} is displayed")
    public void validate_score_value_is_displayed(String text) {
        ewssteps.validateTextMessage(text);

    }

    @Then("Validate text {string} is displayed in the pop-up")
    public void validate_text_is_displayed_in_the_pop_up(String text) {
        ewssteps.validateTextMessage(text);

    }

    @Then("Validate background score value color is displayed {string} with threshold {string}")
    public void validate_background_score_value_color_is_displayed_with_threshold(String imagePath, String threshold) throws InterruptedException {
        appSteps.verifyTheDisplayedApplicationLayout(imagePath,threshold);

    }

    @When("Update stale time {string}")
    public void update_stale_time(String text) {
        ewssteps.updatestaletimefield(text);

    }
    @And("^Scroll EWS '(.*)' the Navigation Menu '(.*)' times$")
    public void scrollTheElementIntoViewEws(String direction, int noOfTimes) throws InterruptedException {
        ewssteps.scrollElementUntilVisible(direction,noOfTimes);
    }


}
