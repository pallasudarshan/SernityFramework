package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import steps.AppSteps;
import steps.BasicSteps;
import steps.DataBreaksSteps;

public class DataBreaksStepDefinition {
    @Steps
    BasicSteps basicSteps;

    @Steps
    DataBreaksSteps dataBreaksSteps;

    @Steps
    AppSteps appSteps;

    @When("Click on go button")
    public void clickOnGoButton() {

    }

    @When("click on the update config")
    public void click_on_the_update_config() throws InterruptedException {
        dataBreaksSteps.clickUpdateConfig();
        Thread.sleep(8000);

    }

    @When("slide the FHR Strip on right side to live view")
    public void slideFHRStripToLiveView() {

    }

    @And("drag to the baseline {string}")
    public void dragToBaseline(String direction) {

    }

    @And("slide towards {string} direction  for {int} times")
    public void slideTowardsDirectionForTimes(String direction, Integer numberOfSwipes) throws InterruptedException {
        basicSteps.swipeTheSlide(direction, numberOfSwipes);
    }

    @And("update the {string} to a {string}")
    public void update_the_to_a(String textFieldName, String textValue) {
        dataBreaksSteps.enterTheDataInTheDataBreaksConfigurationTextFields(textFieldName, textValue);
    }

    @And("select the {string} dropdown {string} option")
    public void select_the_dropdown_option(String dropdownField, String dropdownOption) {
        dataBreaksSteps.selectTheDropdownOption(dropdownField, dropdownOption);
    }

    @And("click on the {string} checkbox")
    public void click_On_Checkbox(String checkboxField) {
        dataBreaksSteps.dataBreaksConfigurationsCheckBox(checkboxField);
    }

    @And("drag the {string} to the {string} side")
    public void dragElementToSide(String source, String direction) throws InterruptedException {
        Thread.sleep(2000);
        basicSteps.dragTheElementBySemantics(source, direction);
    }

    @Then("verify the {string} text availability is {string}")
    public void verifyTheAvailabilityIs(String textValue, String flag) throws InterruptedException {
        Thread.sleep(2000);
        dataBreaksSteps.verifyIsElementAvailable(textValue, flag);
    }

    @Then("verify the {string} availability is {string}")
    public void verifyIsElementAvailableByValueKey(String Value, String flag) throws InterruptedException {
        Thread.sleep(2000);
        dataBreaksSteps.verifyIsElementAvailableOrNot(Value, flag);
    }

    @When("click on the cheveran button")
    public void click_on_the_chevaron_Button() throws InterruptedException {
        Thread.sleep(2000);
        dataBreaksSteps.clickOnChevron();
        Thread.sleep(5000);
    }

    @And("click on the {string} button")
    public void clickOnTheButton(String value) throws InterruptedException {
        Thread.sleep(3000);
        dataBreaksSteps.clickOnTheConfigurationButton(value);
    }

    @Then("validate break start date and time text is {string}")
    public void validateBreaksStartDateAndTimeText(String flag) throws InterruptedException {
        Thread.sleep(4000);
        dataBreaksSteps.verifyBreakStartDateTimeText(flag);
        Thread.sleep(4000);
    }

    @Then("validate break end date and time text is {string}")
    public void validateBreaksEndDateAndTimeText(String flag) throws InterruptedException {
        Thread.sleep(4000);
        dataBreaksSteps.verifyBreakEndDateTimeText(flag);
        Thread.sleep(4000);
    }

    @And("Set the start break {string} to {int} {string} before the current date and time")
    public void setTheBreakStartTimeToBeforeTheCurrentDateAndTime(String breakField, int num, String type) throws InterruptedException {
        dataBreaksSteps.setTheStartBreakDateAndTime(breakField, type, num);
    }

    @And("Set the end break {string} to {int} {string} before the current date and time")
    public void setTheBreakEndTimeToBeforeTheCurrentDateAndTime(String breakField, int num, String type) throws InterruptedException {
        dataBreaksSteps.setTheEndBreakDateAndTime(breakField, type, num);
    }

    @And("Set the {string} to {int} {string} before the current date and time")
    public void setTheTimeToBeforeTheCurrentDateAndTime(String breakField, int num, String type) throws InterruptedException {
        dataBreaksSteps.setTheStartBreakDateAndTime(breakField, type, num);
    }

    @Then("verify that the application component {string} with threshold {string} is not displayed in the application within {long} seconds")
    public void verifyTheApplicationComponentIsNotDisplayed(String images, String threshold,long duration) throws InterruptedException {
        Thread.sleep(3000);
        if(System.getProperty("deviceName").equalsIgnoreCase("Google Pixel 9 Pro XL") ||
                System.getProperty("deviceName").equalsIgnoreCase("Samsung Galaxy S24 Ultra") ||
                System.getProperty("deviceName").equalsIgnoreCase("iPhone 16 Pro")) {
            appSteps.verifyTheApplicationComponentIsNotDisplayed(images, threshold,duration);
        }else {
            appSteps.verifyTheApplicationComponentIsNotDisplayed(images, "0.60",duration);
        }
    }

    @And("^Scroll '(.*)' through Navigation Menu '(.*)' times$")
    public void scrollFhrSlotConfigurationList(String direction, int noOfTimes) {
        dataBreaksSteps.scrollFHRSlotConfigurationListView(direction, noOfTimes);
    }

}


