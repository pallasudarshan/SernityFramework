package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import steps.BasicSteps;
import steps.LayoutSteps;

public class LayoutStepDefinition {

    @Steps
    LayoutSteps layoutSteps;

//    @Given("Click on {string}")
//    public void clickOnLeftExtreme(String tabName) throws InterruptedException {
//        layoutSteps.clickTab(tabName);
////        Thread.sleep(10000);
//    }

//    @Given("Open Navigation Menu")
//    public void openNavigationMenu() throws InterruptedException {
////        Thread.sleep(10000);
//        layoutSteps.openNavigationMenu();
//    }

//    @Then("is patient with name {string} available")
//    public void isPatientWithNameAvailable(String name) {
//        layoutSteps.isPatientWithNameAvailable(name);
//    }

//    @And("Expand Patient Banner")
//    public void expandPatientBanner() throws InterruptedException {
//        layoutSteps.expandPatientBanner();
//    }

//    @And("Collapse Patient Banner")
//    public void collapsePatientBanner() {
//        layoutSteps.collpasePatientBanner();
//    }
//
//    @Then("Verify label text of {string}")
//    public void verifyLabelTextOf(String label) {
//        String[] labels = label.split(",");
//        for (String l : labels) {
//            layoutSteps.verifyLabelText(label.trim());
//        }
//    }

//    @Then("verify {string} available")
//    public void verifyPatientDetails(String text) {
//        layoutSteps.verifyPatientDetails(text);
//    }

//    @And("Uncheck {string} in config")
//    public void uncheckInConfig(String configName) throws InterruptedException {
//        layoutSteps.uncheckInConfig(configName);
//        Thread.sleep(1000);
//    }

//    @Then("verify {string} unAvailable")
//    public void verifyIsUnAvailable(String text) {
//        layoutSteps.verifyPatientDetailsUnavailable(text);
//    }

//    @Then("Verify Patient Icon is available")
//    public void verifyPatientIconIsAvailable() {
//        layoutSteps.verifyPatientIconIsAvailable();
//    }

//    @And("Uncheck Patient Icon Visibility in config")
//    public void uncheckPatientIconVisibilityInConfig() {
//        layoutSteps.uncheckPatientIconVisibilityInConfig();
//    }

//    @Then("Verify Patient Icon is unavailable")
//    public void verifyPatientIconIsUnavailable() {
//        layoutSteps.verifyPatientIconIsUnAvailable();
//    }

//    @Then("Verify Chevron Button is available")
//    public void verifyChevronButtonIsAvailable() {
//        layoutSteps.verifyChevronButtonIsAvailable();
//    }

//    @And("Uncheck Chevron Button Visibility in config")
//    public void uncheckChevronButtonVisibilityInConfig() {
//        layoutSteps.uncheckChevronButtonVisibilityInConfig();
//    }

//    @Then("Verify Chevron Button is unavailable")
//    public void verifyChevronButtonIsUnavailable() {
//        layoutSteps.verifyChevronButtonIsUnAvailable();
//    }

//    @And("check First Name First in config")
//    public void checkFirstNameFirstInConfig() {
//        layoutSteps.checkFirstNameFirstInConfig();
//    }

//    @And("set {string} Name field separator in config")
//    public void setNameFieldSeparatorInConfig(String separator) {
//        layoutSteps.setNameFieldSeparatorInConfig(separator);
//    }
}
