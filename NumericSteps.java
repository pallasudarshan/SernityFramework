package steps;

import bdd.framework.handler.DataHandler;
import bdd.framework.service.DataService;
import com.ge.hc.kyma.FilterItem;
import com.ge.hc.kyma.bdd.model.streaming.ConfigData;
import com.ge.hc.kyma.bdd.model.streaming.EventData;
import com.ge.hc.kyma.bdd.model.streaming.NumericData;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;
import org.springframework.web.client.RestClientException;
import pageObjects.AppPage;
import pageObjects.BasicPage;
import pageObjects.NumericPage;
import util.BDDCommonUtil;
import util.KymaConstants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NumericSteps {

    private static String restURL = System.getProperty("bdd.rest.url");
    @Steps
    BasicPage basicPage;
    @Steps
    NumericPage numericPage;
    @Steps
    AppPage appPage;

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
            if (parameterArray.length > 1) {
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
        DataService dataService = new DataService();
        dataService.update(FilterItem.ResourceTypeEnum.NUMERICS, numericDatas, entityID, Integer.valueOf(sampleInterval), "UPDATEALL");
    }

    public void publishAlarmWithAlarmState(String parameter, String numeric, String priority, String eventType, String type,
                                           String eventState, String alarmInactState, String physioTech, String dateTime) throws RestClientException, InterruptedException {

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

        for (int i = 0; i <= numericsArray.length - 1; i++) {
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
            if (dateTimeArray.length > 1) {
                eventDetails.put("dateTime", dateTimeArray[i]);
            } else {
                eventDetails.put("dateTime", BDDCommonUtil.getCurrentDate("ISO_DateFormat"));

            }

            DataHandler handler = new DataHandler();
            EventData event = handler.get(eventDetails, EventData.class);
            eventList.add(event);
            KymaConstants.setEventDate(event.getDateTime());
        }
        DataService dataService = new DataService();
        dataService.create(FilterItem.ResourceTypeEnum.EVENTS, entityID, eventList);
        Thread.sleep(5000);
    }

    public void publishEventWithAlarmInfo
            (String parameter, String numeric, String priority, String eventType, String type,
             String eventState, String alarmInactState, String physioTech, String dateTime)
            throws RestClientException {
        String entityID = KymaConstants.getPatientUuid();

        HashMap<String, String> eventDetails = new HashMap<String, String>();
        eventDetails.put("parameter", parameter);
        eventDetails.put("numeric", numeric);
        eventDetails.put("entityID", entityID);
        eventDetails.put("eventState", eventState);
        eventDetails.put("eventType", eventType);
        eventDetails.put("priority", priority);
        eventDetails.put("dateTime", BDDCommonUtil.getCurrentDate("ISO_DateFormat"));
        eventDetails.put("type", type);
        eventDetails.put("alarmInactState", alarmInactState);
        eventDetails.put("physioTech", physioTech);

        DataHandler handler = new DataHandler();
        EventData event = handler.get(eventDetails, EventData.class);
        ArrayList<EventData> eventList = new ArrayList<EventData>();
        assert event != null;
        eventList.add(event);
        KymaConstants.setEventDate(event.getDateTime());
        DataService dataService = new DataService();
        dataService.create(FilterItem.ResourceTypeEnum.EVENTS, entityID, eventList);
    }

    public void selectNumericViewDropdown(String viewName) {
        numericPage.selectNumericTypeDropdownOption(viewName);
    }

    public void verifyNumericParameter(String parameter) {
        Assert.assertTrue(numericPage.isParameterDisplayed(parameter));
    }

    public void verifyNumericValue(String numericValue, String flag) {
        if (flag.equalsIgnoreCase("true")) {
            Assert.assertTrue(numericPage.isNumericValueDisplayed(numericValue));
        } else {
            Assert.assertFalse(numericPage.isNumericValueDisplayed(numericValue));
        }
    }

    public void updateConfigCriticalLimits(String parameters, String numerics,
                                           String configHigh, String configLow, String criticalLow, String criticalHigh, String uoms,
                                           String isEnabledLowLimit, String isEnabledHighLimit, String isEnabledCriticalHighLimit, String isEnabledCriticalLowLimit) throws InterruptedException {
        List<ConfigData> configDataList = new ArrayList<>();
        String[] numericArray = numerics.split(";");
        String entityID = KymaConstants.getPatientUuid();

        for (int i = 0; i < numericArray.length; i++) {
            HashMap<String, String> configDetails = new HashMap<String, String>();
            configDetails.put("dateTime", BDDCommonUtil.getCurrentDate("Date_Only_Format"));
            configDetails.put("entityID", entityID);
            configDetails.put("parameter", parameters);
            configDetails.put("numeric", numericArray[i]);
            configDetails.put("highLimitValue", configHigh);
            configDetails.put("lowLimitValue", configLow);
            configDetails.put("isEnabledLowLimit", isEnabledLowLimit);
            configDetails.put("isEnabledHighLimit", isEnabledHighLimit);
            configDetails.put("isEnabledCriticalLowLimit", isEnabledCriticalLowLimit);
            configDetails.put("isEnabledCriticalHighLimit", isEnabledCriticalHighLimit);
            configDetails.put("criticalMax", criticalHigh);
            configDetails.put("criticalMin", criticalLow);
            configDetails.put("uom", uoms);
            DataHandler handler = new DataHandler();
            ConfigData configData = handler.get(configDetails, ConfigData.class);
            configDataList.add(configData);
        }

        DataService dataService = new DataService();
        dataService.update(FilterItem.ResourceTypeEnum.CONFIGS, configDataList, entityID, 0, "UPDATEALL");
        Thread.sleep(10000);
    }

    public void verifyNumericMeanValue(String meanValue, String flag, String config) {
        String[] numericValuesArray = meanValue.split(";");
        int targetIndex = (numericValuesArray.length >= 3) ? 2 : 1;
        if (config.equalsIgnoreCase("NIBPSingleRow") || config.equalsIgnoreCase("NIBPWithLabel")
                || config.equalsIgnoreCase("NIBPTwoRowBracket")) {
            if (flag.equalsIgnoreCase("true")) {
                Assert.assertTrue("Expected value to be displayed: " + numericValuesArray[targetIndex],
                        numericPage.isNumericValueDisplayed(numericValuesArray[targetIndex]));
            } else if (flag.equalsIgnoreCase("false")) {
                Assert.assertFalse("Expected value not to be displayed: " + numericValuesArray[targetIndex],
                        numericPage.isNumericValueDisplayed(numericValuesArray[targetIndex]));
            }
        } else {
            System.out.println("Mean configuration not require to test for NIBPRowWithoutMean and NIBPWithOutMean ");
        }
    }

    public void verifyNIBPNumericValues(String numericValue, String flag) {
        String[] numericValuesArray = numericValue.split(";");
        if (flag.equalsIgnoreCase("true")) {
            for (String value : numericValuesArray) {
                Assert.assertTrue("Numeric value not displayed: " + value,
                        numericPage.isNumericValueDisplayed(value));
            }
        } else {
            for (String value : numericValuesArray) {
                Assert.assertFalse("Numeric value not displayed: " + value,
                        numericPage.isNumericValueDisplayed(value));
            }
        }
    }

    public void verifyUomOnContainer(String uom) {
        Assert.assertTrue(numericPage.isNumericValueDisplayed(uom));
    }

    public void selectLabelTypeDropdown(String labelType) {
        numericPage.selectLabelTypeDropdownOption(labelType);
    }

    public void verifyNumericLabel(String label) {
        Assert.assertTrue(numericPage.isnumericLabel(label));
    }

    public void selectNumericParameter(String parameter) {
        numericPage.selectParameterDropdownOption(parameter);
    }

    public void enableToggleConfig(String toggle, String flag) throws InterruptedException {
        Thread.sleep(5000);
        numericPage.numericToggleConfiguration(toggle, flag);
    }

    public void toggleConfig(String config, String flag) {
        numericPage.numericToggleConfiguration(config, flag);
    }

    public void disableToggleConfig(String toggle, String flag) {
        numericPage.numericToggleConfiguration(toggle, flag);
    }

    public void enterLabelColour(String colour) {
        numericPage.setLabelColor(colour);
    }

    public void enteruomColour(String colour) {
        numericPage.setUomColor(colour);
    }

    public void enterNumericValueFontSize(String fontSize) {
        numericPage.setNumericvalueFontSize(fontSize);
    }

    public void enterLabelFontSize(String fontSize) {
        numericPage.setLabelFontSize(fontSize);
    }

    public void enterUomFontSize(String fontSize) {
        numericPage.setUomFontSize(fontSize);
    }

    public void closeNavigationMenu() throws InterruptedException {
        Thread.sleep(3000);
        numericPage.closeNavigation();
    }

    public void scrollUpNumericConfigurationListView(String direction, int noOfTimes) {
        int count = 0;
        while (count < noOfTimes) {
            if (direction.equalsIgnoreCase("UP")) {
                basicPage.scrollToViewElement("UP");
            } else if (direction.equalsIgnoreCase("DOWN")) {
                basicPage.scrollToViewElement("DOWN");
            }
            count++;
        }
    }

    public void swipeToVisibleElement(String config, int noOfTime, String direction) throws InterruptedException {
        int count = 0;
        while (count < noOfTime) {
            numericPage.dragElementByValueKeyUntilVisible(config, direction);
            Thread.sleep(3000);
            count++;
        }
    }

    public void enableIconToggle(String toggle, String numericView) {
        if (numericView.equals("CondensedNumeric") || numericView.equals("CombinedNumerics")) {
            numericPage.toggleConfiguration(toggle);
        } else if (numericView.equals("TileNumeric")) {
            System.out.println("Icon visibility not require to test for TileNumerics");
        } else {
            System.out.println("Toggle not configurable");
        }
    }

    public void selectCustomIcon(String icon, String numericView) {
        if (numericView.equals("CondensedNumeric") || numericView.equals("CombinedNumerics")) {
            numericPage.selectCustomIconDropdownOption(icon);
        } else if (numericView.equals("TileNumeric")) {
            System.out.println("Icon visibility not require to test for TileNumerics");
        } else {
            System.out.println("Toggle not configurable");
        }
    }

    public void selectSelectionIcon(String icon, String numericView) {
        if (numericView.equals("CondensedNumeric") || numericView.equals("CombinedNumerics")) {
            numericPage.selectSelectionIconDropdownOption(icon);
        } else if (numericView.equals("TileNumeric")) {
            System.out.println("Icon visibility not require to test for TileNumerics");
        } else {
            System.out.println("Toggle not configurable");
        }
    }

    public void disableValueVisibility(String toggle, String numericConfig) {
        if (numericConfig.equals("TileNumeric")) {
            numericPage.toggleConfiguration(toggle);
        } else if (numericConfig.equals("CondensedNumeric")) {
            System.out.println("Tile without numeric not require to test for CondensedNumeric");
        } else {
            System.out.println("Toggle not configurable");
        }
    }

    public void isNumericValueNotAvaialable(String value, String numericView) {
        if (numericView.equals("TileNumeric")) {
            Assert.assertTrue(numericPage.isnumericValueNotAvailable(value));
        } else if (numericView.equals("CondensedNumeric")) {
            System.out.println("Tile without numeric not require to test for CondensedNumeric");
        } else {
            System.out.println("Toggle not configurable");
        }
    }

    public void enterAlarmHighColourField(String colour) {
        basicPage.scrollToViewElement("UP");
        numericPage.setAlarmHighColorFiled(colour);
    }

    public void enterAlarmMediumColourField(String colour) {
        basicPage.scrollToViewElement("UP");
        numericPage.setAlarmMediumColorFiled(colour);
    }

    public void enterAlarmLowColourField(String colour) {
        basicPage.scrollToViewElement("UP");
        numericPage.setAlarmLowColorFiled(colour);
    }

    public void enterAlarmInformativeColourField(String colour) {
        basicPage.scrollToViewElement("UP");
        numericPage.setAlarmInfoColorFiled(colour);
    }

    public void setAlarmBackgroundColor(String color) {
        String[] colourArray = color.split(";");
        enterAlarmHighColourField(colourArray[0]);
        enterAlarmMediumColourField(colourArray[1]);
        enterAlarmLowColourField(colourArray[2]);
        enterAlarmInformativeColourField(colourArray[3]);
    }

    public void verifyMiaSelectionIsAvailable(String label) {
        numericPage.isMiaSelectionAvaialable(label);
    }

    public void selectAlarmSorteddropDown(String label) {
        numericPage.selectSortedOrderDropdownOption(label);
    }

    public void verifyToggleConfig(String toggle, String flag, String numericView) {
        String[] numericsArray = numericView.split(";");
        if (numericView.equals("TileNumeric") || numericView.equals("NIBPSingleRow")) {
            numericPage.numericToggleConfiguration(toggle, flag);
        } else if (numericView.equals("CondensedNumeric")) {
            System.out.println("Sqi config not require to test for CondensedNumeric");
        } else {
            System.out.println("There is no requirement to verify this NIBP merge case for" + numericView);
        }
    }

    public void updateMiaLogicConfig(String config) {
        numericPage.toggleConfiguration(config);
    }

    public void scrollUpAndDownCombinedLayoutScreen(String direction, int noOfTimes) {
        if (direction.equalsIgnoreCase("UP")) {
            numericPage.scrollUpConfigurationCombinedView(noOfTimes);
        } else if (direction.equalsIgnoreCase("DOWN")) {
            numericPage.scrollDownConfigurationCombinedView(noOfTimes);
        }
    }

    public void scrollUpCombinedLayoutScreen(int noOfTimes) {
        numericPage.scrollUpConfigurationCombinedView(noOfTimes);
    }

    public void verifyNIBPMergeCase(String toggle, String flag, String numericView) {
        String[] numericsArray = numericView.split(";");
        System.out.println("View: " + numericView + ", Array Length: " + numericsArray.length);
        if (numericsArray.length > 2) {
            numericPage.numericToggleConfiguration(toggle, flag);
        } else {
            System.out.println("NIBP merge case not require to verify for without mean" + numericView);
        }
    }

    public void enableCombinedLimitConfig(String doubleLine, String flag) {
        numericPage.numericToggleConfiguration(doubleLine, flag);
    }
    public void enableCombinedLimitConfig(String criticalLimit, String showLimit, String flag) {
        numericPage.numericToggleConfiguration(criticalLimit, flag);
        numericPage.numericToggleConfiguration(showLimit, flag);
    }

    public void verifyBasicAndCriticalLowHighValues(String basicHigh, String basicLow, String criticalHigh, String criticalLow) {
        Assert.assertTrue(numericPage.isLimitValueAvailable(basicHigh));
        Assert.assertTrue(numericPage.isLimitValueAvailable(basicLow));
        Assert.assertTrue(numericPage.isLimitValueAvailable(criticalHigh));
        Assert.assertTrue(numericPage.isLimitValueAvailable(criticalLow));
    }

    public void verifyTextIsAvailable(String text) {
        Assert.assertTrue(appPage.isElementAvailable(text));
    }

    public void selectDisabledTypeLimit(String disableLimit) {
        numericPage.selectDisabledTypeLimit(disableLimit);
    }

    public void enableBasicAndCriticalLowToHigh(String basicLowOff, String basicHighOff, String criticalLowOff, String criticalHighOff, String flag) {
        numericPage.numericToggleConfiguration(basicLowOff, flag);
        numericPage.numericToggleConfiguration(basicHighOff, flag);
        numericPage.numericToggleConfiguration(criticalLowOff, flag);
        numericPage.numericToggleConfiguration(criticalHighOff, flag);
    }

    public void enterCustomText(String text) {
        numericPage.setCustomText(text);
    }

    public void clearCustomText() {
        numericPage.clearCustomText();
    }

    public void verifyCurrentUTCDateAndTime() {
        String currentDate = BDDCommonUtil.getCurrentUTCDate();
        String currentTime = BDDCommonUtil.getCurrentUTCTime();
        System.out.println("Current date : " + currentDate);
        System.out.println("Current time : " + currentTime);
        Assert.assertTrue(appPage.isElementAvailable(currentDate));
        Assert.assertTrue(appPage.isElementAvailable(currentTime));
    }

    public void selectSecondAndThirdIcon(String icon2, String icon3) {
        numericPage.selectSecondIconDropdown(icon2);
        numericPage.selectThirdIconDropdown(icon3);
    }

    public void closeNavigationMenuWithCrossIcon() throws InterruptedException {
        Thread.sleep(3000);
        numericPage.clickOnCrossIcon();
    }
}
