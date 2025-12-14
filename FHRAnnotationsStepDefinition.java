package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.json.simple.parser.ParseException;
import steps.FHRAnnotationsSteps;
import steps.WaveformSteps;

import java.io.IOException;

public class FHRAnnotationsStepDefinition {
    @Steps
    FHRAnnotationsSteps fhrAnnotationsSteps;

    @Then("publish the FHR Annotation payload {string} with interval {string}")
    public void publishFhrAnnotation(String payload, String interval) throws IOException, ParseException, InterruptedException {
        fhrAnnotationsSteps.createFhrAnnotation(payload, interval);
    }

    @And("Validate value, text, uom of published data {string} for {string} and {string} in FHR Annotations")
    public void validateFHRData(String payload, String parameter, String numeric) throws IOException, ParseException {
        fhrAnnotationsSteps.validateFHRData(payload, parameter, numeric);
    }

    @Then("validate annotation text")
    public void validate_annotation_text() {
        fhrAnnotationsSteps.validateFHRAnnotationDetails();
    }

    @And("Reload the FHR application")
    public void reloadApplication() throws InterruptedException {
        fhrAnnotationsSteps.refreshFHRApplication();
    }

    @And("Reload the FHR application for error")
    public void reloadApplicationFromErrorPage() throws InterruptedException {
        fhrAnnotationsSteps.refreshFHRApplicationFromErrorPage();
    }

    @Then("validate the FHR error message {string}")
    public void verifyFHRErrorMessage(String errorMessage) {
        fhrAnnotationsSteps.verifyErrorMessage(errorMessage);
    }

    @When("^the user swiping FHR waveform layout '(.*)' times towards '(.*)' direction$")
    public void the_user_swipe_the_FHR_Waveform(int noOftimes, String direction) throws InterruptedException {
        fhrAnnotationsSteps.swipeWaveformLayout(noOftimes, direction);
    }

    @Then("configure FHR with {string} parameter, {string} numeric and UOM {string}")
    public void configure_fhr_with_parameter_numeric_and_uom(String string, String string2, String string3) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("configure FHR with {string} tile colour and  {string} bar colour")
    public void configure_fhr_with_tile_colour_and_bar_colour(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("validate tile colour {string} and bar colour {string}")
    public void validate_tile_colour_and_bar_colour(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("verify expected page header {string} is displayed for FHR Annotation")
    public void verify_expected_page_header_is_displayed_for_fhr(String title) throws InterruptedException {
        fhrAnnotationsSteps.isTitleDisplayed(title);
    }

    @Then("^apply '(.*)' '(.*)' times on the '(.*)' of the FHR")
    public void apply_Zoom_in_the_waveform(String pinchAction, int noOfTime, String waveformPosition) throws InterruptedException {
        if (pinchAction.equalsIgnoreCase("pinch-out")) {
            fhrAnnotationsSteps.zoomIn(noOfTime, waveformPosition);
        } else if (pinchAction.equalsIgnoreCase("pinch-in")) {
            fhrAnnotationsSteps.zoomOut(noOfTime, waveformPosition);
        }
    }

    @Then("rotate the FHR screen to {string} mode")
    public void rotateMobileScreen(String displayMode) {
        fhrAnnotationsSteps.rotateTheScreen(displayMode);
    }

}
