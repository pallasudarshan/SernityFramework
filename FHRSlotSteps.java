package steps;

import bdd.framework.handler.DataHandler;
import bdd.framework.service.DataService;
import com.ge.hc.kyma.FilterItem;
import com.ge.hc.kyma.bdd.model.streaming.EventData;
import com.ge.hc.kyma.bdd.model.streaming.NumericData;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;
import org.springframework.web.client.RestClientException;
import pageObjects.AppPage;
import pageObjects.FHRSlotPage;
import util.BDDCommonUtil;
import util.KymaConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FHRSlotSteps {

    @Steps
    FHRSlotPage slotPage;

    @Steps
    AppPage appPage;

    private static String restURL = System.getProperty("base.path");

    public void clickOnMPVDropDownO(String text) throws InterruptedException {
        slotPage.selectMPVDropDown(text);
        Thread.sleep(5000);
    }

    //To validate Patient Name
    public void validatePatientName(String name) throws InterruptedException {
        Assert.assertTrue(appPage.isElementAvailable(name));
        Thread.sleep(5000);
    }

    public void verifyAlarmWidgetNotAvailable() {
        Assert.assertFalse(slotPage.isAlarmWidgetDisplayed());
    }

    public void verifyChervonIconNotAvailable() {
        Assert.assertFalse(slotPage.isChervonIconNotDisplayed());
    }

    public void clickPatientBannerDisable(){
        slotPage.disablePatientBanner();
    }

    public void validateName(String name) {
        Assert.assertFalse(appPage.isElementAvailable(name));
    }

    public void clickPatientBannerEnable() throws InterruptedException {
        slotPage.enablePatientBanner();
        Thread.sleep(5000);
    }

    public void enableAlarmWidget(){
        slotPage.clickEnableAlarmWidget();
    }

    public void disableFHRStrip() {
        slotPage.clickDisableFHRStrip();
    }

    public void enableFHRStrip() {
        slotPage.clickEnableFHRStrip();
    }

    public void validateLabelName(String name) {
        Assert.assertTrue(appPage.isElementAvailable(name));
    }

    public void validateNumericValue(String value) {
        Assert.assertTrue(appPage.isElementAvailable(value));
    }

    public void clickOnFHRNumeirc() {
        slotPage.clickOnDisableFHRNumeic();
    }

    public void validateLabelNotDisplayed(String name) {
        Assert.assertFalse(appPage.isElementAvailable(name));
    }

    public void validateValueNotDisplayed(String value) {
        Assert.assertFalse(appPage.isElementAvailable(value));
    }

    public void verifyBellIconAvailable() {
        Assert.assertTrue(slotPage.isBellIconDisplayed());
    }

    public void verifyBadgetIconAvailable() {
        Assert.assertTrue(slotPage.isBadgetIconDisplayed());
    }

    public void clickAlarmWidget() {
        slotPage.clickOnAlarmWidget();
    }

    public void clickAlarmConfig() {
        slotPage.clickOnAlarmConfig();
    }

    public void clickAlarmWidgetTap() throws InterruptedException {
        slotPage.clickOnDisableTapAlarmWidget();
        Thread.sleep(3000);
    }

    public void clickBadgetIcon() {
        slotPage.clickOnDisableBadgetIcon();
    }

    public void verifyBadgetIconNotAvailable() {
        Assert.assertFalse(slotPage.isBadgetIconNotDisplayed());
    }

    public void clickChervonIcon() {
        slotPage.clickOnChervonIcon();
    }

    public void validatePatientInfo(String value) {
        Assert.assertFalse(appPage.isElementAvailable(value));
    }

    public void updateAllNumerics(String parameters, String numerics, String numericValues, String UOMs, String sampleInterval, String invalidLE)
            throws InterruptedException, RestClientException {

        List<NumericData> numericDatas = new ArrayList<>();
        String[] parameterArray = parameters.split(";");
        String[] numericsArray = numerics.split(";");
        String[] numericValuesArray = numericValues.split(";");
        String[] UOMArray = UOMs.split(";");
        String entityID = KymaConstants.getPatientUuid();
        for (int i = 0; i < numericsArray.length; i++) {
            HashMap<String, String> numericDetails = new HashMap<String, String>();
            numericDetails.put("entityID", entityID);
            numericDetails.put("sourceID", "");
            if (parameterArray.length > i) {
                numericDetails.put("parameter", parameterArray[i]);
            } else {
                numericDetails.put("parameter", parameters);
            }
            numericDetails.put("invalidLE", invalidLE);
            numericDetails.put("numeric", numericsArray[i]);
            if (UOMArray.length > 1) {
                numericDetails.put("uom", UOMArray[i]);
            } else {
                numericDetails.put("uom", UOMs);
            }
            numericDetails.put("value", numericValuesArray[i]);

            DataHandler handler = new DataHandler();
            NumericData numericData = handler.get(numericDetails, NumericData.class);
            numericDatas.add(numericData);
        }
        DataService dataService = new DataService(restURL);
        dataService.update(FilterItem.ResourceTypeEnum.NUMERICS, numericDatas, entityID, Integer.valueOf(sampleInterval), "UPDATEALL");
    }

    public void publishAlarmWithAlarmState(String parameter, String numeric, String priority, String eventType,String type,
                                           String eventState,  String alarmInactState, String physioTech,String dateTime) throws RestClientException{

        List<EventData> eventList = new ArrayList<EventData>();

        String[] parameterArray = parameter.split(";");
        String[] numericsArray = numeric.split(";");
        String[] priorityArray = priority.split(";");
        String[] alarmStateArray = alarmInactState.split(";");
        String[] eventTypeArray = eventType.split(";");
        String[] eventStateArray = eventState.split(";");
        String[] typeArray = type.split(";");
        String[] physioTechArray = physioTech.split(";");
        String[] dateTimeArray = dateTime.split(";");
        String entityID = KymaConstants.getPatientUuid();
        for (int i = 0; i <numericsArray.length; i++) {
            HashMap<String, String> eventDetails = new HashMap<String, String>();
            eventDetails.put("entityID", entityID);

            if (parameterArray.length > 1) {
                eventDetails.put("parameter", parameterArray[i]);
            } else {
                eventDetails.put("parameter", parameter);
            }
            eventDetails.put("numeric", numericsArray[i]);
            if (eventStateArray.length > 1) {
                eventDetails.put("eventState", eventStateArray[i]);
            } else {
                eventDetails.put("eventState", eventState);
            }
            if (eventTypeArray.length > 1) {
                eventDetails.put("eventType", eventTypeArray[i]);
            } else {
                eventDetails.put("eventType", eventType);
            }
            if (priorityArray.length > 1) {
                eventDetails.put("priority", priorityArray[i]);
            } else {
                eventDetails.put("priority", priority);
            }
            if (alarmStateArray.length > 1) {
                eventDetails.put("alarmState", alarmStateArray[i]);
            } else {
                eventDetails.put("alarmInactState", alarmInactState);
            }
            if (typeArray.length > 1) {
                eventDetails.put("type", typeArray[i]);
            } else {
                eventDetails.put("type", type);
            }
            if (physioTechArray.length > 1) {
                eventDetails.put("physioTech", physioTechArray[i]);
            } else {
                eventDetails.put("physioTech", physioTech);
            }
            if(dateTimeArray.length > 1){
                eventDetails.put("dateTime", dateTimeArray[i]);
            }else {
                eventDetails.put("dateTime", BDDCommonUtil.getCurrentDate("ISO_DateFormat"));

            }

            DataHandler handler = new DataHandler();
            EventData event = handler.get(eventDetails, EventData.class);
            eventList.add(event);
            KymaConstants.setEventDate(event.getDateTime());
        }
        DataService dataService = new DataService(restURL);
        dataService.create(FilterItem.ResourceTypeEnum.EVENTS, entityID, eventList);
    }

    public void publishEventWithAlarmInfo
            (String parameter, String numeric, String priority, String eventType,String type,
             String eventState,  String alarmInactState, String physioTech,String dateTime)
            throws RestClientException{
        String entityID = KymaConstants.getPatientUuid();
        HashMap<String, String> eventDetails = new HashMap<String, String>();
        eventDetails.put("parameter", parameter);
        eventDetails.put("numeric", numeric);
        eventDetails.put("entityID", entityID);
        eventDetails.put("eventState", eventState);
        eventDetails.put("eventType", eventType);
        eventDetails.put("priority", priority);
        if(dateTime.length() > 1){
            eventDetails.put("dateTime", BDDCommonUtil.getCurrentDate("ISO_DateFormat"));
        }
        eventDetails.put("type", type);
        eventDetails.put("alarmInactState", alarmInactState);
        eventDetails.put("physioTech", physioTech);

        DataHandler handler = new DataHandler();
        EventData event = handler.get(eventDetails, EventData.class);
        ArrayList<EventData> eventList = new ArrayList<EventData>();
        assert event != null;
        eventList.add(event);
        KymaConstants.setEventDate(event.getDateTime());
        DataService dataService = new DataService(restURL);
        dataService.create(FilterItem.ResourceTypeEnum.EVENTS, entityID, eventList);
    }

    public void tapPatientBanner() throws InterruptedException {
        slotPage.clickPatientBanner();
        Thread.sleep(5000);
    }

    public void validateSPVPageDisplayed(String name) {
        Assert.assertTrue(appPage.isElementAvailable(name));
    }

    public void clickOnPriorityDropDown(String text) throws InterruptedException {
        slotPage.selectPriorityDropDown(text);
        Thread.sleep(5000);
    }

    public void validateAlarmEvent(String name) {
        Assert.assertTrue(appPage.isElementAvailable(name));
    }

    public void clickOnPrefixDropDown(String text) throws InterruptedException {
        slotPage.selectPrefixDropDown(text);
        Thread.sleep(5000);
    }

    public void clickOnIconDropDown(String text) throws InterruptedException {
        slotPage.selectIconDropDown(text);
        Thread.sleep(5000);
    }

    public void updateLowPriorityColor(String text) {
        slotPage.updateAlarmColor(text);
    }

    public void updateBellIconColor(String text) {
        slotPage.updateBellColor(text);
    }

    public void updateCardDetails(String text) {
        slotPage.updateCardDimensions(text);
    }

    public void clickOnNumeric() {
        slotPage.clickOnEnableFHRNumeic();
    }

    public void validateAlarmEventNotAvaiabale(String name) {
        Assert.assertFalse(appPage.isElementAvailable(name));
    }

    public void clickEnableAlarmWidgetTap() {
        slotPage.clickOnEnableTapAlarmWidget();
    }

    public void validateBadgetCount(String name) {
        Assert.assertTrue(appPage.isElementAvailable(name));
    }

    public void clickOnPlaceHolderWidget() {
        slotPage.clickOnAlarmWidgetPlaceHolder();
    }

    public void clickOnPriorityIcon() {
        slotPage.clickOnBellIconMPVPageWidget();
    }

    public void updateInfoPriorityColor(String text) {
        slotPage.updateInfoColorText(text);
    }

    public void updateBellIconInfoColor(String text) {
        slotPage.updateBellInfoColor(text);
    }

    public void dragDownToVisibleElement(int noOfTime) throws InterruptedException {
        int count = 0;
        while (count < noOfTime) {
            slotPage.drogDownElement(noOfTime);
            Thread.sleep(3000);
            count++;
        }
    }

    public void clickonBottomSheetdownArrow() {
        slotPage.clickOnBottomDownArrow();
    }

    public void updateOnDefaultHeight(String text){
        slotPage.updateDefaultHeight(text);
    }

    public void clickOnPriorityBellIcon() {
        slotPage.clickOnIconPriority();
    }

    public void scrollElementUntilVisible(String direction, int noOfTimes, String path) {
        if(direction.equalsIgnoreCase("UP")) {
            slotPage.scrollUpConfigurationListView(noOfTimes, path);
        } else if (direction.equalsIgnoreCase("DOWN")){
            slotPage.scrollDownConfigurationListView(noOfTimes,path);
        }
    }

    public void openNavigationMPVMenu() {
         slotPage.openNavigationMPVMenu();
    }
}
