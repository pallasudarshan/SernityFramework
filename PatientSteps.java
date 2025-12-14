package steps;

import bdd.framework.handler.DataHandler;
import bdd.framework.service.DataService;
import com.ge.hc.kyma.FilterItem;
import com.ge.hc.kyma.bdd.model.registry.LocationData;
import com.ge.hc.kyma.bdd.model.registry.PatientData;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;
import pageObjects.AppPage;
import pageObjects.PatientPage;
import util.BDDCommonUtil;
import util.KymaCommonUtil;
import util.KymaConstants;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.log4j.Logger;


public class PatientSteps {

    private final Logger logger = Logger.getLogger(PatientSteps.class);
    private static String url = System.getProperty("base.path");
    PatientPage patientPage;
    AppPage appPage;

    @Steps
    LocationSteps locationSteps;


    public List<String> createPatientByDeviceStart(int noOfPatient) throws InterruptedException {
        DataService dataService = new DataService();
        List<String> listOfPatient;
        listOfPatient = dataService.create(FilterItem.ResourceTypeEnum.PATIENTS, null, noOfPatient);
        System.out.println(listOfPatient.get(0));
        KymaConstants.setPatientUuid(listOfPatient.get(0));
        Thread.sleep(8000);
        return listOfPatient;
    }

    public void deletePatientByUUID(String uuid) throws InterruptedException {
        DataService dataService = new DataService();
        List<String> listOfPatientUUID = Arrays.stream(uuid.split("\\;"))
                .map(str -> str.trim())
                .collect(Collectors.toList());
        dataService.delete(FilterItem.ResourceTypeEnum.PATIENTS, listOfPatientUUID, null);
        Thread.sleep(8000);
    }

    public void deletePatientByUUID() throws InterruptedException {
        String uuid = KymaConstants.getPatientUuid();
        DataService dataService = new DataService();
        List<String> listOfPatientUUID = Arrays.stream(uuid.split("\\;"))
                .map(str -> str.trim())
                .collect(Collectors.toList());
        dataService.delete(FilterItem.ResourceTypeEnum.PATIENTS, listOfPatientUUID, null);
        Thread.sleep(8000);
    }

    public void dischargeAllPatients() throws InterruptedException {
        DataService dataService = new DataService();
        dataService.delete(FilterItem.ResourceTypeEnum.PATIENTS, (List<String>) null, null);
        Thread.sleep(10000);
    }

    public String findBed(String uuid) {
        LocationData locationDetails = locationSteps.getLocationFromPatientId(uuid);
        return locationDetails.getBed();
    }

    public String findCareArea(String uuid) {
        LocationData locationDetails = locationSteps.getLocationFromPatientId(uuid);
        return locationDetails.getCareArea();
    }

    public String findFacility(String uuid) {
        LocationData locationDetails = locationSteps.getLocationFromPatientId(uuid);
        return locationDetails.getFacility();
    }

    public String findPatientAge(String birthDateTime) {
        LocalDate birthDate = LocalDate.parse(birthDateTime);
        LocalDate today = LocalDate.now();
        int age = Period.between(birthDate, today).getYears();
        return Integer.toString(age);
    }

    public String findPatientRoom(String uuid) {
        LocationData locationDetails = locationSteps.getLocationFromPatientId(uuid);
        return locationDetails.getRoom();
    }

    public String findGroup(String uuid) {
        LocationData locationDetails = locationSteps.getLocationFromPatientId(uuid);
        return locationDetails.getGroup();
    }

    @Step
    public void createPatient(String state, String gender)
            throws InterruptedException {
        HashMap<String, String> patientDetails = new HashMap<>();

        String patientID = KymaCommonUtil.randomPatientEntityID();
        String ID = patientID.split("-")[1] + ",mrn";
        String familyName = KymaCommonUtil.randomPatientName();
        String givenName = KymaCommonUtil.randomPatientName();
        String dateOfBirth = BDDCommonUtil.randomDateOfBirth().toString();

        KymaConstants.setPatientUuid(patientID);
        KymaConstants.setPatientMrn(ID);
        KymaConstants.setPatientFamilyname(familyName);
        KymaConstants.setPatientGivenname(givenName);
        KymaConstants.setPatientDob(dateOfBirth);
        KymaConstants.setPatientGender(gender);
        KymaConstants.setPatientState(state);

        patientDetails.put("id", ID);
        patientDetails.put("given", givenName);
        patientDetails.put("family", familyName);
        patientDetails.put("uuidEntity", patientID);
        patientDetails.put("state", state);
        patientDetails.put("gender", gender);
        patientDetails.put("birthDateTime", dateOfBirth);
        DataHandler handler = new DataHandler();
        PatientData patient = handler.get(patientDetails, PatientData.class);
        ArrayList<PatientData> patientList = new ArrayList<PatientData>();
        if (patient != null) {
            patientList.add(patient);
            DataService dataService = new DataService();
            dataService.create(FilterItem.ResourceTypeEnum.PATIENTS, patientList);
            Thread.sleep(10000);

        } else {
            System.out.println("Patient reference is null");
            logger.debug("Patient reference is null");
        }
    }

    @Step
    public void createPatient(String birthDateTime,String age, String ageUnit, String id, String implantedDeviceTypes, String state, String gender,
                              String given, String family, String uuidEntity,
                              String careGiverGivenName, String careGiverFamilyName, String typeOfCare, String note, String additionalFieldsJson)
            throws InterruptedException {
        HashMap<String, String> patientDetails = new HashMap<String, String>();
        patientDetails.put("id", id);
        patientDetails.put("given", given);
        patientDetails.put("family", family);
        patientDetails.put("uuidEntity", uuidEntity);
        patientDetails.put("state", state);
        patientDetails.put("gender", gender);
        patientDetails.put("birthDateTime", birthDateTime);
        patientDetails.put("implantedDeviceTypes", implantedDeviceTypes);
        patientDetails.put("age",age);
        patientDetails.put("ageUnit",ageUnit);

        if (!careGiverFamilyName.isEmpty() && !careGiverGivenName.isEmpty() && !typeOfCare.isEmpty() && !note.isEmpty()){
            patientDetails.put("careGiverGivenName", careGiverGivenName);
            patientDetails.put("careGiverFamilyName", careGiverFamilyName);
            patientDetails.put("typeOfCare", typeOfCare);
            patientDetails.put("note", note);
        }

        if (additionalFieldsJson != null && !additionalFieldsJson.isEmpty()) {
            patientDetails.put("additionalFields", additionalFieldsJson);
        }

        DataHandler handler = new DataHandler();
        PatientData patient = handler.get(patientDetails, PatientData.class);
        ArrayList<PatientData> patientList = new ArrayList<PatientData>();
        if (patient != null) {
            patientList.add(patient);
            DataService dataService = new DataService();
            dataService.create(FilterItem.ResourceTypeEnum.PATIENTS, patientList);
            Thread.sleep(10000);

        } else {
            System.out.println("Patient reference is null");
        }
    }

    public void isPatientWithNameAvailable(String name, boolean isNameDisplayed) throws InterruptedException {
        Thread.sleep(3000);
        if (isNameDisplayed) {
            Assert.assertTrue(patientPage.isPatientWithNameAvailable(name));
        } else {
            Assert.assertFalse(patientPage.isPatientWithNameAvailable(name));
        }
    }

    public void expandPatientBanner() {
        patientPage.expandPatientBanner();
    }

    public void collpasePatientBanner() {
        patientPage.collapsePatientBanner();
    }

    public void verifyPatientDetails(String text) {
        Assert.assertTrue(appPage.isElementAvailable(text));
    }

    public void verifyPatientDetails(String text1, String text2) {
        if (appPage.isElementAvailable(text1)) {
            Assert.assertTrue(appPage.isElementAvailable(text1));
        } else if (appPage.isElementAvailable(text2)) {
            Assert.assertTrue(appPage.isElementAvailable(text2));
        } else {
            Assert.fail("Patient data mismatch !!");
        }
    }

    public void verifyLocationDetailsAvailable(String locationCombination, String patientId, String delimiter) {
        System.out.println("expected location ::" + expectedLocationDetails(locationCombination, patientId, delimiter));
        Assert.assertTrue(appPage.isElementAvailable(expectedLocationDetails(locationCombination, patientId, delimiter)));
    }

    public String expectedLocationDetails(String locationText, String patientId, String delimiter) {
        String location;
        switch (locationText) {
            case "Room":
                location = findPatientRoom(patientId);
                break;
            case "Bed":
                location = findBed(patientId);
                break;
            case "Group":
                location = findGroup(patientId);
                break;
            case "RoomBedGroup":
                location = findPatientRoom(patientId) + delimiter + " " + findBed(patientId) + delimiter + " " + findGroup(patientId);
                break;
            case "RoomBed":
                location = findPatientRoom(patientId) + delimiter + " " + findBed(patientId);
                break;
            case "BedGroup":
                location = findBed(patientId) + delimiter + " " + findGroup(patientId);
                break;
            case "RoomGroup":
                location = findPatientRoom(patientId) + delimiter + " " + findGroup(patientId);
                break;
            case "GroupRoomBed":
                location = findGroup(patientId) + delimiter + " " + findPatientRoom(patientId) + delimiter + " " + findBed(patientId);
                break;
            default:
                location = "Invalid location combinations. Need to add the expected case.";
        }
        return location;
    }

    public void verifyPatientDetailsUnavailable(String text) {
        Assert.assertFalse(appPage.isElementAvailable(text));
    }

    public void verifyLocationDetailsUnavailable(String locationCombination, String patientId, String delimiter) {
        Assert.assertFalse(appPage.isElementAvailable(expectedLocationDetails(locationCombination, patientId, delimiter)));
    }

    public void uncheckInConfig(String configName) {
        patientPage.uncheckInConfig(configName);
    }

    public void checkInConfig(String configName) {
        patientPage.checkInConfig(configName);
    }

    public void verifyPatientIconIsAvailable() {
        Assert.assertTrue(patientPage.isPatientIconAvailable());
    }

    public void checkPatientIconVisibilityInConfig() {
        patientPage.checkPatientIconVisibilityInConfig();
    }

    public void checkReservedSpaceDisplayInConfig(String item) {
        patientPage.checkReservedSpaceDisplayInConfig(item);
    }

    public void tapOnAlarmSpace() {
        patientPage.tapOnAlarmSpace();
    }

    public void tapOnPatientName() {
        patientPage.tapOnPatientName();
    }

    public void tapOnPatientLocation() {
        patientPage.tapOnPatientLocation();
    }

    public void verifyTapEventOnAlarm(String text) {
        Assert.assertTrue(patientPage.isTextAvailableOnTap(text));
    }

    public void uncheckPatientIconVisibilityInConfig() {
        patientPage.uncheckPatientIconVisibilityInConfig();
    }

    public void verifyPatientIconIsUnAvailable() {
        Assert.assertFalse(patientPage.isPatientIconAvailable());
    }

    public void verifyAlarmAreaDisplayed(String isSpaceAvailable) {
        if (isSpaceAvailable.equalsIgnoreCase("available")) {
            Assert.assertTrue(patientPage.isAlarmDisplayed());
        } else if (isSpaceAvailable.equalsIgnoreCase("unavailable")) {
            Assert.assertFalse(patientPage.isAlarmDisplayed());
        } else {
            Assert.fail("Invalid response for alarm space reservation.");
        }
    }

    public void verifyBadgesDisplayed(String isSpaceAvailable) {
        if (isSpaceAvailable.equalsIgnoreCase("available")) {
            Assert.assertTrue(patientPage.isEWSBadgeDisplayed());
            Assert.assertTrue(patientPage.isCustomBadgeDisplayed());
        } else if (isSpaceAvailable.equalsIgnoreCase("unavailable")) {
            Assert.assertFalse(patientPage.isEWSBadgeDisplayed());
            Assert.assertFalse(patientPage.isCustomBadgeDisplayed());
        } else {
            Assert.fail("Invalid response for Badge space reservation.");
        }
    }

    public void verifyChevronButtonIsAvailable() {
        Assert.assertTrue(patientPage.isChevronButtonAvailable());
    }

    public void uncheckExpandedConfigurationButtonInConfig() {
        patientPage.uncheckExpandConfigDataInConfig();
    }

    public void uncheckChevronButtonVisibilityInConfig() {
        patientPage.uncheckChevronButtonVisibilityInConfig();
    }

    public void checkChevronButtonVisibilityInConfig() {
        patientPage.checkChevronButtonVisibilityInConfig();
    }

    public void verifyChevronButtonIsUnAvailable() {
        Assert.assertFalse(patientPage.isChevronButtonAvailable());
    }

    public void checkFirstNameFirstInConfig() {
        patientPage.checkFirstNameFirst();
    }

    public void setNameFieldSeparatorInConfig(String separator) {
        patientPage.setNameFieldSeparator(separator);
    }

    public void setLocationFieldSeparatorInConfig(String separator) {
        patientPage.setLocationFieldSeparator(separator);
    }

    public void setLocationFieldTextInConfig(String locationTextField) {
        patientPage.setLocationFieldsText(locationTextField);
    }

    public void checkDisplayLocationInConfig() {
        patientPage.checkDisplayLocation();
    }

    public void checkWrappedExpandedView() {
        patientPage.checkUseWrappedExpandedViewInConfig();
    }

    public void uncheckDisplayLocationInConfig() {
        patientPage.uncheckDisplayLocation();
    }

    public void verifyPatientDetailsUsingSemanticLabel(String semanticLabel) {
        Assert.assertTrue(appPage.isElementAvailableBySemanticsLabel(semanticLabel));
    }

    public void verifyPatientDetailsAbsenceUsingSemanticLabel(String semanticLabel) {
        Assert.assertFalse(appPage.isElementAvailableBySemanticsLabel(semanticLabel));
    }

    public void setWrapFieldSeparatorInConfig(String separator) {
        patientPage.setWrapFieldSeparator(separator);
    }

    public void uncheckWrapAdditionalFieldInConfig(String configName) {
        patientPage.selectWrapAdditionalFieldInConfig(configName);
        patientPage.uncheckConfigureAdditionalFieldInConfig(configName);
    }

    public void uncheckWrapAdditionalFieldSeperatorInConfig(String configName) {
        patientPage.selectWrapAdditionalFieldInConfig(configName);
        patientPage.uncheckConfigureAdditionalFieldSeperatorInConfig(configName);
    }

    public void setCustomBadgeInConfig(String text) {
        patientPage.setCustomBadgeText(text);
    }

    public void setEWSScoreInConfig(String score) {
        patientPage.setEWSBadgeScore(score);
    }

    public void applyActionOnEnableEWSBadgeInConfig() {
        patientPage.checkEWSBadgeConfigurationInConfig();
    }

    public void applyActionOnEnableCustomBadgeInConfig() {
        patientPage.checkCustomBadgeConfigurationInConfig();
    }
}
