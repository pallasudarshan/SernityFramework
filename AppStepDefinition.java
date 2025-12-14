package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import steps.AppSteps;

import java.io.IOException;

public class AppStepDefinition {

    @Steps
    AppSteps appSteps;

    @And("Open {string} in SPV")
    public void open_in_spv(String patientId) {
        appSteps.openSPV(patientId);
    }

    @And("navigate to SPV page of admitted patient")
    public void openSpvForAdmittedPatient() throws InterruptedException {
        appSteps.openSPVOfTheAdmittedPatient();
    }

    @And("navigate to MPV page")
    public void navigateToMpvPage() throws InterruptedException {
        appSteps.navigateToMPVPage();
    }

    @When("Click on {string} tab")
    public void click_on_tab(String tabName) {
        appSteps.clickTab(tabName);
    }

    @Given("Open Navigation Menu")
    public void openNavigationMenu() throws InterruptedException {
        appSteps.openNavigationMenu();
    }

    @And("{string} Navigation Menu")
    public void resetAndOrCloseNavigationMenu(String action) throws InterruptedException {
        if(action.equalsIgnoreCase("Reset")){
            appSteps.resetNavigationMenu();
        }
        if(action.equalsIgnoreCase("Close")){
        appSteps.closeNavigationMenu();
        }
    }

    @And("^Scroll '(.*)' the Navigation Menu '(.*)' times$")
    public void scrollTheElementIntoView(String direction, int noOfTimes) throws InterruptedException {
        appSteps.scrollTheElementUntilVisible(direction,noOfTimes);
    }

    @And("^Scroll '(.*)' to view '(.*)' for max '(.*)' times$")
    public void scrollToViewTheElement(String direction, String text, int noOfTimes) throws InterruptedException {
        appSteps.scrollToViewTheElement(direction,text, noOfTimes);
    }

    //    @Given("Click on {string}")
    //    public void selectTab(String tabName) throws InterruptedException {
    //    appSteps.clickTab(tabName);
    //    }


    @Then("verify the displayed layout {string} with threshold {string} in the application")
    public void verifyTheDisplayedApplicationLayout(String imagePath, String threshold) throws InterruptedException {
        Thread.sleep(3000);
        if(System.getProperty("deviceName").equalsIgnoreCase("Google Pixel 9 Pro XL") ||
                System.getProperty("deviceName").equalsIgnoreCase("Samsung Galaxy S24 Ultra") ||
                System.getProperty("deviceName").equalsIgnoreCase("iPhone 16 Pro")) {
            appSteps.verifyTheDisplayedApplicationLayout(imagePath, threshold);
        }else {
            appSteps.verifyTheDisplayedApplicationLayout(imagePath, "0.60");
        }
    }

    @Then("verify the displayed layout {string} with threshold {string} in the application for orientation")
    public void verifyTheDisplayedApplicationLayoutOrientation(String imagePath, String threshold) throws InterruptedException {
        Thread.sleep(3000);
        if(System.getProperty("platformName").equalsIgnoreCase("Android")) {
            if (System.getProperty("deviceName").equalsIgnoreCase("Google Pixel 9 Pro XL") ||
                    System.getProperty("deviceName").equalsIgnoreCase("Samsung Galaxy S24 Ultra") ||
                    System.getProperty("deviceName").equalsIgnoreCase("iPhone 16 Pro")) {
                appSteps.verifyTheDisplayedApplicationLayout(imagePath, threshold);
            } else {
                appSteps.verifyTheDisplayedApplicationLayout(imagePath, "0.60");
            }
        }
        else {
            System.out.println("Screen rotation is not supported for iOS with the Flutter driver.");
        }
    }

    @When("user update the page into {string} theme")
    public void waveformThemeSwitch(String theme) throws IOException {
        appSteps.updateTheme(theme);
    }

}
