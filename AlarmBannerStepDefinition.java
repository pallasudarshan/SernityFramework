package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import steps.AlarmBannerSteps;
import steps.AppSteps;
import steps.NumericSteps;
import steps.PatientSteps;

public class AlarmBannerStepDefinition {
    @Steps
    AlarmBannerSteps alarmBannerSteps;
    @Steps
    PatientSteps patientSteps;
    @Steps
    AppSteps appSteps;


    @Then("Enable the Custom widget configuration")
    public void enableTheCustomWidgetConfiguration() {
        alarmBannerSteps.enableCustomWidget();
    }

    @Then("Enable the Alarm widget configuration")
    public void enableTheAlarmWidgetConfiguration() {
        alarmBannerSteps.enableAlarmWidget();
    }

    @When("Click on the MPV {string} and SPV {string} pages of {string} tab")
    public void clickOnFHRSlotPageTab(String mpv,String spv,String fhrSlotPage) throws InterruptedException {
        alarmBannerSteps.selectFHRSlotPages(mpv,spv,fhrSlotPage);
    }

    @Then("When Click on the MPV {string} and SPV {string} based on {string} selection")
    public void clickOnMPVAndSPVBasedOnFHRSlotPageSelection(String mpv,String spv,String fhrSlotPage) throws InterruptedException {
        alarmBannerSteps.selectNavigationbackForTimerCheck(mpv,spv,fhrSlotPage);
    }

    @When("^publish alarms for parameter '(.*)' numeric '(.*)' with priority '(.*)' eventType '(.*)' eventState '(.*)' alarmInactState '(.*)',physioTech '(.*)',eventMessage '(.*)',dateTime '(.*)' and type '(.*)'$")
    public void publishAlarmEvent
            (String parameter,String numeric,String priority,String eventType,String eventState,String alarmInactState,String physioTech,String eventMessage,String dateTime,String type) {
        alarmBannerSteps.publishAlarmWitCustomDateFormat(parameter,numeric,priority,eventType,eventState,alarmInactState,physioTech,eventMessage,dateTime,type);
    }

    @And("select prfix icon path as {string} and custom icon path as {string}")
    public void selectPrfixIconPathAsAndCustomIconPathAs(String text, String customIcon) {
        alarmBannerSteps.selectPrefixIConDropdown(text,customIcon);
    }

    @And("select the Alarm banner dropdown")
    public void selectTheAlarmBannerDropdown() {
        alarmBannerSteps.selectAlarmBannerArrow();
    }

    @And("Enable the show two icons {string}")
    public void enableTheShowTwoIcons(String text) {
        alarmBannerSteps.enableShowTwoIcons();
    }

    @And("select Prefix icon1 {string} and suffix icon {string} in alarm banner")
    public void selectPrefixIconAndPrefixIconInAlarmBanner(String prefixIcon1, String suffixIcon) {
        alarmBannerSteps.enablePrefixIcon1Dropdown(prefixIcon1);
        alarmBannerSteps.enableSuffixIconDropdown(suffixIcon);
    }

    @And("select the {string} configuration")
    public void selectTheConfiguration(String text) {
        alarmBannerSteps.enableShowTimerCheckbox(text);

    }


    @And("Enter the time for high priority {string} medium priority {string} low priority {string} and info priority {string} timer duration")
    public void enterPriorityWiseTimerDuration(String highTimer, String mediumTimer, String lowTimer, String infoTimer) {
        alarmBannerSteps.enterHighPriorityTimerDuration(highTimer);
        alarmBannerSteps.enterMediumPriorityTimerDuration(mediumTimer);
        alarmBannerSteps.enterLowPriorityTimerDuration(lowTimer);
        alarmBannerSteps.enterInfoPriorityTimerDuration(infoTimer);
    }

    @And("Disable the show badge count {string}")
    public void disableTheShowBadgeCount(String text) {
        alarmBannerSteps.disableShowBadge(text);
    }

    @And("Disable the separator {string}")
    public void disableTheSeparator(String text) {
        alarmBannerSteps.disableShowSeparator(text);
    }

    @When("Enable the Floating button option in bottomSheet")
    public void enableTheFloatingButtonOption() {
        alarmBannerSteps.enableFloatingButton();
    }

    @And("Click on the acknowledge button in bottomSheet")
    public void clickOnTheAcknowledgeButton() throws InterruptedException {
        alarmBannerSteps.ClickOnAcknowledgeButton();
        Thread.sleep(10000);
    }

    @And("Click on the RemindMe button in bottomSheet")
    public void clickOnTheRemindMeButtonInBottomSheet() {
        alarmBannerSteps.ClickOnRemindMeButton();
    }

    @Then("Verify toast message {string} display on post tap gesture on remindMe button in bottomSheet")
    public void verifyToastMessageDisplayOnPostTapGestureOnRemindMeButtonInBottomSheet(String txt) {
        alarmBannerSteps.isMsgDisplayPostRemindMeTapGesture(txt);
    }

    @And("tap on the Alarm banner then bottomsheet should displayed")
    public void tapOnTheAlarmBannerThenBottomsheetShouldDisplayed() {
        alarmBannerSteps.tapOnTheAlarmBannerGesture();
    }

    @And("tap on the Alarm widget then bottomSheet should displayed")
    public void tapOnTheAlarmWidgetThenBottomSheetShouldDisplayed() {
        alarmBannerSteps.tapOnTheAlarmWidgetGesture();
    }

    @And("Click on the bottom sheet down arrow for configurations")
    public void clickOnTheBottomSheetDownArrowForConfigurations() {
        alarmBannerSteps.clickOnBottomSheetConfigArrow();
    }

    @And("Enter the Floating background color {string} in bottomSheet")
    public void enterTheFloatingBackgroundColorInBottomSheet(String hexaCode) {
        alarmBannerSteps.setFloatingButtonBackgroundColor(hexaCode);
    }

    @And("select the Floating icon {string} in dropdown in bottomSheet")
    public void selectTheFloatingIconInDropdownInBottomSheet(String icon) {
        alarmBannerSteps.selectFloatingButtonIcon(icon);
    }

    @When("disable the show content in bottom sheet")
    public void disableTheShowContentInBottomSheet() {
        alarmBannerSteps.disableBottomSheetContent();
    }

    @When("enable the show content in bottom sheet")
    public void enableTheShowContentInBottomSheet() {
        alarmBannerSteps.enableBottomSheetContent();
    }

    @When("Enable the overlayOn option in bottom sheet")
    public void enableTheOverlayOnOptionInBottomSheet() {
        alarmBannerSteps.enableBottomSheetOverlay();
    }

    @When("disable the overlay option in bottom sheet")
    public void disableTheOverlayOptionInBottomSheet() {
        alarmBannerSteps.disableBottomSheetOverlay();
    }

    @When("disable the scroll bar option in bottom sheet")
    public void disableTheScrollBarOptionInBottomSheet() {
        alarmBannerSteps.disableBottomSheetScrollBar();
    }

    @When("enable the scroll bar option in bottom sheet")
    public void enableTheScrollBarOptionInBottomSheet() {
        alarmBannerSteps.enableBottomSheetScrollBar();
    }


    @Then("Verify the display separator to {string} in alarmBanner and bottomSheet {string}")
    public void verifyTheDisplaySeparatorToInAlarmBannerAndBottomSheet(String flag, String text) {
        alarmBannerSteps.isSeparatorAvailable(flag,text);
    }

    @Then("Verify the badge count {string} in alarmBanner to {string}")
    public void verifyTheBadgeCountInAlarmBannerTo(String badgeCount, String flag) throws InterruptedException {
        Thread.sleep(10000);
        alarmBannerSteps.isBadgeCountDisplay(badgeCount,flag);
    }

    @Then("verify the bottom sheet displayed in bottom screen")
    public void verifyTheBottomSheetDisplayedInBottomScreen() throws InterruptedException {
        Thread.sleep(1000);
        alarmBannerSteps.isBottomSteetAvailable();
    }

    @Then("verify the alarm event message {string} is displayed to  {string} in alarmBanner")
    public void verifyTheAlarmEventMessageIsDisplayedToInAlarmBanner(String text, String flag) {
        alarmBannerSteps.isRequestedAlarmMessageAvailable(text,flag);
    }


    @And("select the banner elements {string} option")
    public void selectTheBannerElementsOption(String text) {
        alarmBannerSteps.selectShowAlarmBannerElements(text);
    }

    @Then("Verify the timer duration based on priority to {string}")
    public void verifyTheTimerDurationBasedOnPriority(String flag) throws InterruptedException {
        Thread.sleep(10000);
        alarmBannerSteps.isTimerAvailable(flag);
    }


    @Then("verify the acknowledgement button {string} disabled on post operation")
    public void verifyTheAcknowledgementButtonDisabledOnPostOperationTo(String text) throws InterruptedException {
        Thread.sleep(10000);
        alarmBannerSteps.isWidgetElementsAvailable(text);
    }

    @Then("verify the selected patient id display to {string}")
    public void verifyTheSelectedPatientIdDisplayTo(String flag) {
        alarmBannerSteps.isPatientIdAvailable(flag);
    }

    @And("Enter the category key1 {string} category key2 {string} category label1 {string} and category label2 {string} fields")
    public void enterTheCategoryKeyCategoryKeyCategoryLabelAndCategoryLabelFields(String key1, String key2, String label1, String label2) {
        alarmBannerSteps.setCategoryFields(key1,key2,label1,label2);
    }


    @Then("click on the GE logo for navigation back for {string}")
    public void clickOnTheGELogoForNavigationBackFor(String page) throws InterruptedException {
        alarmBannerSteps.clickOnGELogo(page);
    }

    @Then("verify the category label1 {string} and category Label2 {string} in bottomSheet")
    public void verifyTheCategoryLabelAndCategoryLabelInBottomSheet(String label1, String label2) {
        alarmBannerSteps.isCategoryLabelAvailable(label1,label2);
    }

    @And("Close the navigation menu config")
    public void closeTheNavigationMenuConfig() {
        alarmBannerSteps.closeNavigationMenuConfig();
    }


    @And("Open {string} in SPV page {string}")
    public void openPatientInSPVPageFHRSlotPages(String patientId, String page) {
        if(page.equalsIgnoreCase("SPV")){
            appSteps.openSPV(patientId);
        }else{
            System.out.println("Not require to click on SPV patientID for MPV screen");
        }
    }

    @And("^Scroll '(.*)' the Navigation Menu '(.*)' times for '(.*)'$")
    public void scrollUPTheNavigationMenuTimesForFHRSlotPages(String direction, int noOfTimes,String pages) {
        alarmBannerSteps.scrollUPAndDownUntilElementVisible(direction,noOfTimes,pages);
    }

    @And("Select the alarm sort order dropdown {string} field")
    public void selectTheAlarmSortOrderDropdownField(String sortOrder) {
        alarmBannerSteps.alarmSortOderDropdownField(sortOrder);
    }


    @Then("Verify the selected PrefixIcon and suffixIcons are display to {string}")
    public void verifyTheSelectedPrefixIconAndSuffixIconsAreDisplayTo(String flag) {
        alarmBannerSteps.isPrefixAndSuffixIconsAvailable(flag);
    }


    @Then("verify the infinite icon display in alarm banner")
    public void verifyTheInfiniteIconDisplayInAlarmBanner() {
        alarmBannerSteps.isIndefiniteIconIsAvailable();
    }


    @Then("Verify the PrefixIcon and suffixIcons are display in bottomSheet to {string}")
    public void verifyThePrefixIconAndSuffixIconsAreDisplayInBottomSheetTo(String flag) {
        alarmBannerSteps.isPrefixAndSuffixBottomsheetIconsAvailable(flag);
    }

    @Then("verify floating option display in bottomSheet to {string}")
    public void verifyFloatingOptionDisplayInBottomSheetTo(String flag) {
        alarmBannerSteps.isBottomSheetFloatingButtonAvailable(flag);
    }

    @And("close the alarm banner bottomSheet")
    public void closeTheAlarmBannerBottomSheet() {
        alarmBannerSteps.closeAlarmBannerBootomSheet();
    }

    @And("^drag the bottomSheet down '(.*)' to close$")
    public void dragTheBottomSheetDownToClose(int noOfTimes) throws InterruptedException {
        alarmBannerSteps.dragDownToVisibleElement(noOfTimes);
    }

    @And("update the default hight of the bottomSheet field {string}")
    public void updateTheDefaultHightOfTheBottomSheetField(String hight) {
        alarmBannerSteps.setHightOfBottomSheet(hight);
    }


    @Then("Verify the alarm message displayed in bottomSheet to {string}")
    public void verifyTheAlarmMessageDisplayedInBottomSheetTo(String flag) {
        alarmBannerSteps.isBottoSheetMessageAvailable(flag);
    }

    @Then("verify the time label display in alarm banner and bottomSheet as {string}")
    public void verifyTheTimeLabelDisplayInAlarmBannerAndBottomSheetAs(String timeLabel) throws InterruptedException {
        alarmBannerSteps.isTimeLabelAvailable(timeLabel);
    }

    @And("set the height {string} and width {string} of the alarm banner")
    public void setTheHeightAndWidthFieldsOfAlarmBanner(String height, String width) {
        alarmBannerSteps.setHeightAndWidthOfAlarmBanner(height,width);
    }

    @And("set the alarm event message font size {string}")
    public void setTheAlarmEventMessageFontSize(String fontSize) {
        alarmBannerSteps.setAlarmMessageFontSize(fontSize);
    }


    @And("set the alarm event message color for high {string} medium {string} priority")
    public void setTheAlarmEventMessageColorForHighMediumPriority(String highColor, String mediumColor) {
        alarmBannerSteps.setAlarmMessageFontColorHighMediumPriority(highColor,mediumColor);
    }

    @And("set the alarm event message color for info {string} and low {string} priority")
    public void setTheAlarmEventMessageColorForInfoAndLowPriority(String infoColor,String lowColor) {
        alarmBannerSteps.setAlarmMessageFontColorLowInfoPriority(infoColor,lowColor);
    }


    @Given("Open Navigation Menu for {string}")
    public void openNavigationMenuFor(String page) {
    if(page.equalsIgnoreCase("MPV")){
        alarmBannerSteps.clickOnHembergerMenuMPV();
    }else{
        appSteps.openNavigationMenu();
    }

    }
}

