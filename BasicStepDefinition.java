package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import steps.BasicSteps;

public class BasicStepDefinition {

    @Steps
    BasicSteps basicSteps;

    @Given("Click on Left Extreme")
    public void clickOnLeftExtreme() throws InterruptedException {
        basicSteps.clickOnLeftExtreme();
        Thread.sleep(10000);
    }

    @When("Click on Right Extreme")
    public void clickOnRightExtreme() {
        basicSteps.clickOnRightExtreme();
    }

    @Then("Click on Middle")
    public void clickOnMiddle() {
        basicSteps.clickOnMiddle();
    }

    @And("Click Show Alert Button")
    public void clickShowAlertButton() {
        basicSteps.clickShowAlertButton();
    }

    @When("Compute sum of {string} and {string}")
    public void computeSum(String intA, String intB) {
        basicSteps.computeSum(intA, intB);
    }

    @Then("Validate sum as {string}")
    public void validateSum(String expectedSum) {
        basicSteps.validateSum(expectedSum);
    }

    @And("Zoom on Map")
    public void zoomOnMap(String position) throws InterruptedException {
        basicSteps.zoomOnMap(position);
    }

    @Then("Accept Alert")
    public void acceptAlert() {
        basicSteps.acceptAlert();
    }

    @And("Pinch In on Map")
    public void pinchInOnMap(String position) throws InterruptedException {
        basicSteps.pinchInOnMap(position);
    }

    @And("Pinch Out on Map")
    public void pinchOutOnMap(String position) throws InterruptedException {
        basicSteps.pinchOutOnMap(position);
    }

    @And("Launch Map")
    public void launchMap() {
        basicSteps.launchMap();
    }

    @Then("Validate Map as per {string}")
    public void validateMap(String mapPath) {
        basicSteps.validateMap(mapPath);
    }
}
