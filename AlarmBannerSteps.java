package steps;

import bdd.framework.handler.DataHandler;
import bdd.framework.service.DataService;
import com.ge.hc.kyma.FilterItem;
import com.ge.hc.kyma.bdd.model.streaming.ConfigData;
import com.ge.hc.kyma.bdd.model.streaming.EventData;
import com.ge.hc.kyma.bdd.model.streaming.NumericData;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.springframework.web.client.RestClientException;
import pageObjects.*;
import util.BDDCommonUtil;
import util.KymaConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AlarmBannerSteps {

    private static String restURL = System.getProperty("bdd.rest.url");
    @Steps
    BasicPage basicPage;
    @Steps
    AlarmBannerPage alarmBannerPage;
    @Steps
    AppPage appPage;
    @Steps
    SPVPage spvPage;
    @Steps
    MPVPage mpvPage;

    public void enableCustomWidget() {
        alarmBannerPage.enableCustomWidget();
    }

    public void enableAlarmWidget() {
        alarmBannerPage.enableAlarmWidget();
    }

    public void clickOnHembergerMenuMPV(){
        alarmBannerPage.navigateToMPVFHRSlot();
    }

    public void clickOnPatient(String patientId){
        alarmBannerPage.openSPVPage(patientId);
    }

        public void disableCustomWidget() {
        alarmBannerPage.disableCustomWidget();
    }

    public void selectFHRSlotPages(String mpv, String spv,String fhrSlotPage) throws InterruptedException {
        if(fhrSlotPage.equalsIgnoreCase("MPV")){
            alarmBannerPage.selectMPVPage(mpv);
        }else if(fhrSlotPage.equalsIgnoreCase("SPV")){
            mpvPage.openSPVPage();
            spvPage.openTheComponentPage(spv);
        }
    }

    public void selectNavigationbackForTimerCheck(String mpv, String spv,String fhrSlotPage) throws InterruptedException {
        if(fhrSlotPage.equalsIgnoreCase("MPV")){
            alarmBannerPage.selectMPVPage(fhrSlotPage);
            mpvPage.openSPVPage();
            spvPage.openTheComponentPage(spv);
        }else if(fhrSlotPage.equalsIgnoreCase("SPV")){
            alarmBannerPage.selectMPVPage(mpv);
        }else{
            System.out.println("MPV and SPV pages are not available");
        }
    }

    public void publishAlarmWitCustomDateFormat
            (String parameters,String numerics,String priority,String eventType,String eventState,String alarmInactState,String physioTech,String eventMessage,String dateTime,String type) {

        List<EventData> eventList = new ArrayList<EventData>();

        String[] parameterArray = parameters.split(";");
        String[] numericsArray = numerics.split(";");
        String[] priorityArray = priority.split(";");
        String[] eventTypeArray = eventType.split(";");
        String[] eventMessageArray = eventMessage.split(";");
        String[] eventStateArray = eventState.split(";");
        String[] alarmInactStates = alarmInactState.split(";");
        String[] physioTechArray = physioTech.split(";");
        String[] dateTimeArray = dateTime.split(";");
        String[] typeArray = type.split(";");

        String entityID = KymaConstants.getPatientUuid();
//        String entityID = "Patient-11";
        for (int i = 0; i <= numericsArray.length - 1; i++) {
            HashMap<String, String> eventDetails = new HashMap<String, String>();
            eventDetails.put("entityID", entityID);
            eventDetails.put("sourceID", "");
//            String zoneDateTime = BDDCommonUtil.convertTimeToGivenZoneName(BDDCommonUtil.getCurrentDate(eventTimeFormat), publishedtimeZone);
//            eventDetails.put("dateTime", zoneDateTime);
            if (parameterArray.length > 1) {
                eventDetails.put("parameter", parameterArray[i]);
            } else {
                eventDetails.put("parameter", parameters);
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
			if (eventMessageArray.length > 1) {
				eventDetails.put("eventMessage", eventMessageArray[i]);
			} else {
				eventDetails.put("eventMessage", eventMessage);
			}
            if (alarmInactStates.length > 1) {
                eventDetails.put("alarmInactState", alarmInactStates[i]);
            } else {
                eventDetails.put("alarmInactState", alarmInactState);
            }
            if (physioTechArray.length > 1) {
                eventDetails.put("physioTech", physioTechArray[i]);
            } else {
                eventDetails.put("physioTech", physioTech);
            }
            if (dateTimeArray.length > 1) {
                eventDetails.put("dateTime", dateTimeArray[i]);
            } else {
                eventDetails.put("dateTime", dateTime);
//                eventDetails.put("dateTime", BDDCommonUtil.getCurrentDate("ISO_DateFormat"));

            }
            if (typeArray.length > 1) {
                eventDetails.put("type", typeArray[i]);
            } else {
                eventDetails.put("type", type);
            }
            DataHandler handler = new DataHandler();
            EventData event = handler.get(eventDetails, EventData.class);
            eventList.add(event);
            KymaConstants.setEventDate(event.getDateTime());
        }
        DataService dataService = new DataService();
        dataService.create(FilterItem.ResourceTypeEnum.EVENTS, entityID, eventList);
    }


    public void selectPrefixIConDropdown(String text,String customText){
        alarmBannerPage.selectPrefixIconDropdown(text);
        alarmBannerPage.selectCustomPrefixIconDropdown(customText);
    }

    public void selectAlarmBannerArrow(){
        alarmBannerPage.selectAlarmBannerConfigArrow();
    }

    public void enableShowTwoIcons(){
        alarmBannerPage.enableShowTwoIcons();
    }

    public void enablePrefixIcon1Dropdown(String text){
        alarmBannerPage.selectPrefixIcon1Dropdown(text);
    }

    public void enableSuffixIconDropdown(String text){
        alarmBannerPage.selectSuffixIconDropdown(text);
    }

    public void enableShowTimerCheckbox(String text){

        alarmBannerPage.selectAlarmBannerCheckbox(text);
    }

    public void selectShowAlarmBannerElements(String text){
            alarmBannerPage.selectAlarmBannerCheckbox(text);
    }

    public void enterHighPriorityTimerDuration(String text){
        alarmBannerPage.enterHighPriorityTimerDuration(text);
    }

    public void enterMediumPriorityTimerDuration(String text){
        alarmBannerPage.enterMediumPriorityTimerDuration(text);
    }

    public void enterLowPriorityTimerDuration(String text){
        alarmBannerPage.enterLowPriorityTimerDuration(text);
    }
    public void enterInfoPriorityTimerDuration(String text){
        alarmBannerPage.enterInfoPriorityTimerDuration(text);
    }

    public void disableShowBadge(String text){
        alarmBannerPage.selectAlarmBannerCheckbox(text);
    }

    public void disableShowSeparator(String text){
        alarmBannerPage.selectAlarmBannerCheckbox(text);
    }

    public void enableFloatingButton(){
        alarmBannerPage.enableFloatingButton();
    }

    public void ClickOnAcknowledgeButton(){
        alarmBannerPage.clickOnAcknowledgeButton();
    }

    public void ClickOnRemindMeButton(){
        alarmBannerPage.clickOnRemindMeButton();
    }

    public void isMsgDisplayPostRemindMeTapGesture(String txt){
        Assert.assertTrue(alarmBannerPage.isMsgDisplayPostRemindMeTapGesture(txt));
    }

    public void tapOnTheAlarmBannerGesture(){
        alarmBannerPage.tapOnTheAlarmBanner();
    }

    public void tapOnTheAlarmWidgetGesture(){
        alarmBannerPage.tapOnTheAlarmWidget();
    }

    public void clickOnBottomSheetConfigArrow(){
        alarmBannerPage.clickOnTheBottomSheetConfigArrow();
    }

    public void setFloatingButtonBackgroundColor(String hexaCode){
        alarmBannerPage.setFloatingButtonBackgroundColor(hexaCode);
    }

    public void selectFloatingButtonIcon(String iconName){
        alarmBannerPage.floatingButtonIconDropdown(iconName);
    }

    public void disableBottomSheetContent(){
        alarmBannerPage.disableBottomSheetContent();
    }

    public void enableBottomSheetContent(){
        alarmBannerPage.enableBottomSheetContent();
    }

    public void enableBottomSheetOverlay(){
        alarmBannerPage.enableBottomSheetOverlay();
    }

    public void disableBottomSheetOverlay(){
        alarmBannerPage.disableBottomSheetOverlay();
    }

    public void disableBottomSheetScrollBar(){
        alarmBannerPage.disableBottomSheetScrollBar();
    }

    public void enableBottomSheetScrollBar(){
        alarmBannerPage.enableBottomSheetScrollBar();
    }

    public void isSeparatorAvailable(String flag, String text){
        if(flag.equalsIgnoreCase("true")){
            Assert.assertTrue(alarmBannerPage.isSeparatorAvailable(text));
        }else if(flag.equalsIgnoreCase("false")){
            Assert.assertFalse(alarmBannerPage.isSeparatorAvailable(text));
        }

    }

    public void isRequestedAlarmMessageAvailable(String text,String flag){
        if(flag.equalsIgnoreCase("true")) {
            Assert.assertTrue(alarmBannerPage.isRequestedAlarmMessageAvailable(text));
        }else if(flag.equalsIgnoreCase("false")){
            Assert.assertFalse(alarmBannerPage.isRequestedAlarmMessageAvailable(text));
        }
    }

    public void isBadgeCountDisplay(String text, String flag){
        if(flag.equalsIgnoreCase("true")){
            Assert.assertTrue(alarmBannerPage.isBadgeCountAvailable(text));
        }else if(flag.equalsIgnoreCase("false")){
            Assert.assertFalse(alarmBannerPage.isBadgeCountAvailable(text));
        }else{
            System.out.println("Badge count not displayed");
        }
    }

    public void isBottomSteetAvailable(){
        Assert.assertTrue(alarmBannerPage.isBottomSheetAvailable());
    }

    public void isTimerAvailable(String flag){
        if(flag.equalsIgnoreCase("true")){
            Assert.assertTrue(alarmBannerPage.isElementTimerAvailable());
        }else if(flag.equalsIgnoreCase("false")){
            Assert.assertFalse(alarmBannerPage.isElementTimerAvailable());
        }
    }

    public void isPatientIdAvailable(String flag){
        if(flag.equalsIgnoreCase("true")){
            Assert.assertTrue(alarmBannerPage.isElementPatientIdAvailable());
        }else if(flag.equalsIgnoreCase("false")){
            Assert.assertFalse(alarmBannerPage.isElementPatientIdAvailable());
        }
    }

    public void isWidgetElementsAvailable(String text){
            Assert.assertTrue(alarmBannerPage.isWidgetElementsAvailable(text));
    }

    public void setCategoryFields(String key1, String key2,String label1, String label2){
        alarmBannerPage.enterCategoryKey1Field(key1);
        alarmBannerPage.enterCategoryKey2Field(key2);
        alarmBannerPage.enterCategoryLabel1Field(label1);
        alarmBannerPage.enterCategoryLabel2Field(label2);
    }

    public void clickOnGELogo(String page) throws InterruptedException {
        if(page.equalsIgnoreCase("SPV")) {
            spvPage.goToMPV();
        }else{
            System.out.println("Already in MPV screen!");
        }
    }

    public void isCategoryLabelAvailable(String label1 ,String label2){
        alarmBannerPage.isElementTextAvailable(label1);
        alarmBannerPage.isElementTextAvailable(label2);
    }

    public void closeNavigationMenuConfig(){
        alarmBannerPage.closeNavigationConfig();
    }

    public void scrollUPAndDownUntilElementVisible(String direction, int noOfTimes,String pages) {
        if(pages.equalsIgnoreCase("SPV")) {
          if(direction.equalsIgnoreCase("UP")) {
             appPage.scrollUpWaveformConfigurationListView(noOfTimes);
            } else if (direction.equalsIgnoreCase("DOWN")){
             appPage.scrollDownWaveformConfigurationListView(noOfTimes);
            }
        } else if (pages.equalsIgnoreCase("MPV")) {
            if(direction.equalsIgnoreCase("UP")) {
                alarmBannerPage.scrollUPToViewMPVReferenceConfiguration(noOfTimes);
            } else if (direction.equalsIgnoreCase("DOWN")){
                alarmBannerPage.scrollDownToViewMPVReferenceConfiguration(noOfTimes);
            }
        }
    }

    public void alarmSortOderDropdownField(String sortOrder){
        alarmBannerPage.alarmSortOrderDropdownField(sortOrder);
    }

    public void isPrefixAndSuffixIconsAvailable(String flag){
        if(flag.equalsIgnoreCase("true")) {
            Assert.assertTrue(alarmBannerPage.isPrefixIconAvailable());
            Assert.assertTrue(alarmBannerPage.isSuffixIcon1Available());
        }else if(flag.equalsIgnoreCase("false")){
            Assert.assertFalse(alarmBannerPage.isPrefixIconAvailable());
            Assert.assertFalse(alarmBannerPage.isSuffixIcon1Available());
        }
    }

    public void isPrefixAndSuffixBottomsheetIconsAvailable(String flag){
        if(flag.equalsIgnoreCase("true")) {
            Assert.assertTrue(alarmBannerPage.isPrefixIconBottomsheetAvailable());
            Assert.assertTrue(alarmBannerPage.isSuffixIconBottomsheetAvailable());
        }else if(flag.equalsIgnoreCase("false")){
            Assert.assertFalse(alarmBannerPage.isSuffixIconBottomsheetAvailable());
            Assert.assertFalse(alarmBannerPage.isSuffixIconBottomsheetAvailable());
        }
    }

    public void isBottomSheetFloatingButtonAvailable(String flag){
        if(flag.equalsIgnoreCase("true")){
           Assert.assertTrue(alarmBannerPage.isBottomSheetFloatingAvailable());
        }else if(flag.equalsIgnoreCase("false")){
            Assert.assertFalse(alarmBannerPage.isBottomSheetFloatingAvailable());
        }

    }

    public void isIndefiniteIconIsAvailable(){
            Assert.assertTrue(alarmBannerPage.isIndefiniteIconAvailable());
    }

    public void closeAlarmBannerBootomSheet(){
       alarmBannerPage.closeAlarmbannerBottomsheet();
    }
    public void dragDownToVisibleElement(int noOfTime) throws InterruptedException {
        int count = 0;
        while (count < noOfTime) {
            alarmBannerPage.drogDownElement(noOfTime);
            Thread.sleep(3000);
            count++;
        }
    }

    public void setHightOfBottomSheet(String text){
        alarmBannerPage.setHightOfBottomSheet(text);
    }

    public void isTimeLabelAvailable(String timeLabel) throws InterruptedException {
        alarmBannerPage.alarmBannerTimeLabel(timeLabel);
    }

    public void isBottoSheetMessageAvailable(String flag){
        if(flag.equalsIgnoreCase("true")){
            Assert.assertTrue(alarmBannerPage.isBottomSheetMessgaeAvailable());
        }else if(flag.equalsIgnoreCase("false")){
            Assert.assertFalse(alarmBannerPage.isBottomSheetMessgaeAvailable());
        }

    }

    public void setHeightAndWidthOfAlarmBanner(String height,String width)  {
        alarmBannerPage.enterHeightOfAlarmBannerTextField(height);
        alarmBannerPage.enterWidthOfAlarmBannerTextField(width);
    }

    public void setAlarmMessageFontSize(String fontSize)  {
        alarmBannerPage.enterAlarmMessageFontSize(fontSize);
    }

    public void setAlarmMessageFontColorHighMediumPriority(String highColor,String mediumColor)  {
        alarmBannerPage.enterAlarmMessageHighColor(highColor);
        alarmBannerPage.enterAlarmMessageMediumColor(mediumColor);
    }

    public void setAlarmMessageFontColorLowInfoPriority(String infoColor, String lowColor)  {
        alarmBannerPage.enterAlarmMessageInfoColor(infoColor);
        alarmBannerPage.enterAlarmMessagelowColor(lowColor);

    }
}
