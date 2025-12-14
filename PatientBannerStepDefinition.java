package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import steps.LayoutSteps;
import steps.PatientSteps;
import java.util.List;

public class PatientBannerStepDefinition {
    @Steps
    PatientSteps patientSteps;

    @And("^admit '(.*)' patients$")
    public List<String> deviceStart(int noOfPatient) throws InterruptedException{
        return patientSteps.createPatientByDeviceStart(noOfPatient);
    }

    @Given("^delete patient with uuid '(.*)'$")
    public void deletePatientByUUID(String uuid) throws InterruptedException{
        patientSteps.deletePatientByUUID(uuid);
    }

    @Given("^delete the recent created patient$")
    public void deletePatientByUUID() throws InterruptedException{
        patientSteps.deletePatientByUUID();
    }

    @Given("^discharge all patients$")
    public void dischargeAllPatients() throws InterruptedException{
        patientSteps.dischargeAllPatients();
    }

    @Given("^a patient with '(.*)','(.*)' and other auto generated data is admitted$")
    public void createRandomPatient(String state, String gender) throws Throwable {
        patientSteps.createPatient(state, gender);
    }

    @Given("Kyma platform service is invoked with requests to create a patient with {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void createPatient(String birthDateTime,String age, String ageUnit, String id, String implantedDeviceTypes, String state, String gender,String given,String family,String uuidEntity,String careGiverGivenName,String careGiverFamilyName,String typeOfCare,String note, String additionalFieldsJson) throws Throwable {
        patientSteps.createPatient(birthDateTime, age, ageUnit, id , implantedDeviceTypes, state, gender,given,family,uuidEntity,careGiverGivenName,careGiverFamilyName,typeOfCare,note, additionalFieldsJson);
    }

    @Then("^patient with name '(.*)' available '(.*)'$")
    public void isPatientWithNameAvailable(String name, boolean isNameDisplayed) throws InterruptedException {
        patientSteps.isPatientWithNameAvailable(name, isNameDisplayed);
    }

    @And("Expand Patient Banner")
    public void expandPatientBanner() throws InterruptedException {
        patientSteps.expandPatientBanner();
    }

//    @Given("^a patient with '(.*)','(.*)' and other auto generated data is admitted$")
//    public void createAutomationPatient(String state, String gender) throws Throwable {
//        patientSteps.createPatient(state, gender);
//    }

    @And("Collapse Patient Banner")
    public void collapsePatientBanner() {
        patientSteps.collpasePatientBanner();
    }

    @Then("verify {string} available")
    public void verifyPatientDetails(String text) {
        patientSteps.verifyPatientDetails(text);
    }

    @Then("verify {string} or {string} available")
    public void verifyPatientDetails(String text1, String text2) {
        patientSteps.verifyPatientDetails(text1, text2);
    }

    @Then("verify location details for combination {string} for {string} with delimiter {string} available")
    public void verifyLocationDetailsAvailable(String locationCombination, String patientId, String delimiter) {
        patientSteps.verifyLocationDetailsAvailable(locationCombination, patientId, delimiter);
    }

    @Then("verify location details for combination {string} for {string} with delimiter {string} unAvailable")
    public void verifyLocationDetailsUnavailable(String locationCombination, String patientId, String delimiter) {
        patientSteps.verifyLocationDetailsUnavailable(locationCombination, patientId, delimiter);
    }

    @And("Uncheck {string} in config")
    public void uncheckInConfig(String configName) throws InterruptedException {
        patientSteps.uncheckInConfig(configName);
        Thread.sleep(1000);
    }

    @And("Check {string} in config")
    public void checkInConfig(String configName) throws InterruptedException {
        patientSteps.checkInConfig(configName);
        Thread.sleep(1000);
    }

    @Then("verify {string} unAvailable")
    public void verifyIsUnAvailable(String text) {
        patientSteps.verifyPatientDetailsUnavailable(text);
    }

    @Then("Verify Patient Icon is available")
    public void verifyPatientIconIsAvailable() {
        patientSteps.verifyPatientIconIsAvailable();
    }

    @And("check Patient Icon Visibility in config")
    public void checkPatientIconVisibilityInConfig() {
        patientSteps.checkPatientIconVisibilityInConfig();
    }

    @And("select display {string} in config")
    public void checkReservedSpaceDisplayInConfig(String item) {
        patientSteps.checkReservedSpaceDisplayInConfig(item);
    }

    @And("tap on alarm reserved space")
    public void tapOnAlarmSpace() {
        patientSteps.tapOnAlarmSpace();
    }

    @And("tap on patient name")
    public void tapOnPatientName() {
        patientSteps.tapOnPatientName();
    }

    @And("tap on patient location")
    public void tapOnPatientLocation() {
        patientSteps.tapOnPatientLocation();
    }

    @Then("verify {string} message displayed")
    public void verifyTapEventOnAlarm(String text) {
        patientSteps.verifyTapEventOnAlarm(text);
    }

    @And("Uncheck Patient Icon Visibility in config")
    public void uncheckPatientIconVisibilityInConfig() {
        patientSteps.uncheckPatientIconVisibilityInConfig();
    }

    @Then("Verify Patient Icon is unavailable")
    public void verifyPatientIconIsUnavailable() {
        patientSteps.verifyPatientIconIsUnAvailable();
    }

    @Then("verify whether there is a reserved space {string} for displaying {string}")
    public void verifyReservedSpaceDisplayed(String isSpaceAvailable, String item) {
        if(item.equalsIgnoreCase("ALARM")) {
            patientSteps.verifyAlarmAreaDisplayed(isSpaceAvailable);
        } else if (item.equalsIgnoreCase("BADGE")){
            patientSteps.verifyBadgesDisplayed(isSpaceAvailable);
        }
    }

    @Then("Verify Chevron Button is available")
    public void verifyChevronButtonIsAvailable() {
        patientSteps.verifyChevronButtonIsAvailable();
    }

    @And("uncheck Expanded configuration data in config")
    public void uncheckExpandedConfigurationButtonInConfig() {
        patientSteps.uncheckExpandedConfigurationButtonInConfig();
    }

    @And("Uncheck Chevron Button Visibility in config")
    public void uncheckChevronButtonVisibilityInConfig() {
        patientSteps.uncheckChevronButtonVisibilityInConfig();
    }

    @And("Check Chevron Button Visibility in config")
    public void checkChevronButtonVisibilityInConfig() {
        patientSteps.checkChevronButtonVisibilityInConfig();
    }

    @Then("Verify Chevron Button is unavailable")
    public void verifyChevronButtonIsUnavailable() {
        patientSteps.verifyChevronButtonIsUnAvailable();
    }

    @And("check First Name First in config")
    public void checkFirstNameFirstInConfig() {
        patientSteps.checkFirstNameFirstInConfig();
    }

    @And("set {string} Name field separator in config")
    public void setNameFieldSeparatorInConfig(String separator) {
        patientSteps.setNameFieldSeparatorInConfig(separator);
    }

    @And("set {string} Location field separator in config")
    public void setLocationeFieldSeparatorInConfig(String separator) {
        patientSteps.setLocationFieldSeparatorInConfig(separator);
    }

    @And("set {string} Location field text in config")
    public void setLocationeFieldTextInConfig(String locationField) {
        patientSteps.setLocationFieldTextInConfig(locationField);
    }

    @And("check Display Location field at the place of name in config")
    public void checkDisplayLocationInConfig() {
        patientSteps.checkDisplayLocationInConfig();
    }

    @And("Uncheck Display Location field at the place of name in config")
    public void uncheckDisplayLocationInConfig() {
        patientSteps.uncheckDisplayLocationInConfig();
    }

    @And("Check Wrapped Expanded View in config")
    public void checkWrappedExpandedViewInConfig() {
        patientSteps.checkWrappedExpandedView();
    }

    @Then("verify {string} label available")
    public void verifyPatientDetailsUsingSemanticLevel(String semanticsLabel) {
        patientSteps.verifyPatientDetailsUsingSemanticLabel(semanticsLabel);
    }

    @Then("verify {string} label unAvailable")
    public void verifyPatientDetailsAbsenceUsingSemanticLevel(String semanticsLabel) {
        patientSteps.verifyPatientDetailsAbsenceUsingSemanticLabel(semanticsLabel);
    }

    @And("set {string} wrap field separator in config")
    public void setWrapFieldSeparatorInConfig(String separator) {
        patientSteps.setWrapFieldSeparatorInConfig(separator);
    }

    @And("Uncheck {string} field in config")
    public void uncheckWrapAdditionalFieldInConfig(String configName) throws InterruptedException {
        patientSteps.uncheckWrapAdditionalFieldInConfig(configName);
    }

    @And("Uncheck {string} field seperator in config")
    public void uncheckWrapAdditionalFieldSeperatorInConfig(String configName) throws InterruptedException {
        patientSteps.uncheckWrapAdditionalFieldSeperatorInConfig(configName);
    }

    @And("set {string} custom badge text in config")
    public void setCustomBadgeInConfig(String text) {
        patientSteps.setCustomBadgeInConfig(text);
    }

    @And("set {string} as EWS score value in config")
    public void setEWSScoreInConfig(String score) {
        patientSteps.setEWSScoreInConfig(score);
    }

    @And("apply action on enable EWS badge in config")
    public void applyActionOnEnableEWSBadgeInConfig() {
        patientSteps.applyActionOnEnableEWSBadgeInConfig();
    }

    @And("apply action on enable custom badge in config")
    public void applyActionOnEnableCustomBadgeInConfig() {
        patientSteps.applyActionOnEnableCustomBadgeInConfig();
    }

}


