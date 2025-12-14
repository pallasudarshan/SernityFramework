package steps;

import bdd.framework.service.StreamDataService;
import com.ge.hc.kyma.FilterItem;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;
import pageObjects.AppPage;
import pageObjects.BasicPage;
import pageObjects.FHRPage;
import util.KymaConstants;

public class FHRSteps {
    @Steps
    BasicPage basicPage;

    @Steps
    AppPage appPage;

    @Steps
    FHRPage fhrPage;

    public void selectMPVFHRValue(String text) {
        basicPage.dropdownOptionSelectUsingKeyValue("", text);

    }

    //Click on time previewbar
    public void clickTimePreviewBar() {
        fhrPage.verifytimepreviewbarenabled();

    }

    //click on update config
    public void clickUpdateConfig() throws InterruptedException {
        fhrPage.clickOnUpdateConfig();
        Thread.sleep(5000);

    }

    //Click on close button
    public void clickCloseButton() {
        fhrPage.clickOnCloseButton();

    }

    //Enable time preview bar
    public void clickOnEnableTimePreview() {
        fhrPage.enableTimePreviewBar();

    }

    //Disable datelabel
    public void clickOnDisableDateLabel() {
        fhrPage.disableDateLabel();
    }

    //Update timepreview color
    public void updateTimePreviewColor(String textcolor) {
        fhrPage.updateBgColor(textcolor);
    }

    //Update timelabel textcolor
    public void updateTimelabelTextColor(String labelcolor) {
        fhrPage.updateTimeLabelColor(labelcolor);
    }

    public void clickOnFhrConfigDropDown(String text) {
        fhrPage.clickFhrConfigDropDown(text);

    }

    //Click on icon dropdown field
    public void clickOnIconPath(String text) {
        fhrPage.clickIconDropDown(text);
    }

    //Update icon color
    public void updateIconColorValue(String color) {
        fhrPage.updateIconColor(color);
    }

    public void clickOnIconSizeDropDownFiled(String size) {
        fhrPage.clickIconSizeDropDown(size);
    }

    //Update scale label text color
    public void updateScaleLabelTextColor(String textcolor) {
        fhrPage.updateScaleTextColor(textcolor);
    }

    //Update HR grid config
    public void updateHrGridConfig(String min, String max) {
        fhrPage.updateHrGrid(min, max);
    }

    //To validate score value
    public void validateScoreLabelValue(String scorevalue) {
        Assert.assertTrue(appPage.isElementAvailable(scorevalue));
    }

    //Update HR Waveform color
    public void updateWaveFormsColorConfig(String color) {
        fhrPage.waveFormHrColor(color);
    }

    //Update widthper min in pixel
    public void updateWidth(String width) {
        fhrPage.updateWidthPerMin(width);
    }

    public void openNavigationMenuBar() {
        fhrPage.openNavigationMenu();
    }

    public void selectMPVDropDown() {
        fhrPage.selectdropdown();
    }

//    public void verifyTimePreviewBar(String timePreviewBar) {
//        fhrPage.islabelDisplayed(timePreviewBar);
//
//    }

    public void verifyGlobalIcon(String label) {
        fhrPage.islabelDisplayed(label);
    }

    public void updateScaleLabelTextSize(String saclesize) {
        fhrPage.updateLabelSize(saclesize);

    }

    public void clickOnUom() {
        fhrPage.clickOnDisableUom();

    }

    public void clickOnUomEnable() {
        fhrPage.clickOnEnableUom();
    }

    public void clickOnHrViewPort() {
        fhrPage.clickOnViewPort();

    }

    public void clickOnEnableHrViewPort() {
        fhrPage.clickOnEnableViewPort();

    }

    public void clickOnSafeRangeCheckBox() {
        fhrPage.clickOnSafeRange();
    }

    public void clickSafeRange()
    {
        fhrPage.clickOnEnableSafeRange();
    }

    public void updateSafeRangeValue(String text)
    {
        fhrPage.updateSafeRange(text);

    }

//  *********  FHR UA Steps **********

    public void verifyDateLabel(String label){
        fhrPage.islabelDisplayed(label);
    }

    public void verifyUomAvailable(String uom){
        fhrPage.isUomDisplayed(uom);
    }

    public void verifyfhrConfigDropDown(String fhrConfigOption){
        fhrPage.selectfhrConfigDropdownOption(fhrConfigOption);
    }

    public void setWidthPerMinutePixelsfhrFiled(String widthPixels){
        fhrPage.setwidthPerMinuteinPixelsValue(widthPixels);
    }

    public void closeNavigationConfig()  {
        fhrPage.closeNavigation();
    }

    public void setUAMinMaxIntervals(String min,String max)  {
        fhrPage.setUAYAxiMin(min);
        fhrPage.setUAYAxiMax(max);
    }
    public void setUAUomIntervals(String interval)  {
        fhrPage.setUomInterval(interval);
    }

    public void setUAWaveformColour(String colour)  {
        fhrPage.setWaveformColour(colour);
    }

    public void setGapBetweenUAAndHR(String gapField)  {
        fhrPage.setGapPxValueBetweenUAAndHR(gapField);
    }

    public void updateConfiguration() throws InterruptedException {
        fhrPage.updateConfigOption();
    }

    public void resetConfiguration()  {
        fhrPage.resetConfigOption();
    }

    public void openNavigationMenu()  {
        fhrPage.openNavigationMenuBar();
    }

    public void verifyTimePreviewBar(String timePreviewBar)  {
        fhrPage.islabelDisplayed(timePreviewBar);
    }

    public void verifyDateDisplayed(String format,String element)  {
        String displayed = fhrPage.getDisplayedDate(element);
        boolean result = fhrPage.isDateMatchingFormat(displayed,format);
        Assert.assertTrue("Date mismatch dispplayed : " + displayed + ",Expected Format: " +format,result);

    }

    public void setScaleLabelTextSize(String scaleLabelTextSize){
        fhrPage.setScaleLableTextSize(scaleLabelTextSize);
    }

    public void setScaleLabelTextColor(String scaleLabelTextColor) throws InterruptedException {
        fhrPage.setScaleLableTextcolor(scaleLabelTextColor);
    }

    public void disableGlobalIcon(){
        fhrPage.uncheckGlobalIconConfig();
    }

    public void disableUAUomConfig(){
        fhrPage.uncheckUAUomConfig();
    }

    public void enableUAUomConfig(){
        fhrPage.enableUAUomConfig();
    }

    public void disableTimePreviewConfig(){
        fhrPage.uncheckTimePreviewBarConfig();
    }

    public void enableTimePreviewConfig(){
        fhrPage.enableTimePreviewConfig();
    }

    public void waitWaveForm(String interval){
        try {
            Thread.sleep(Long.parseLong(interval));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void deletePerinatalWaveforms() throws Throwable {
        StreamDataService streamDataService = new StreamDataService();
        String patient_uuid = KymaConstants.getPatientUuid();
        String parental_Parameter = KymaConstants.perinatalParameter();
        streamDataService.delete(FilterItem.ResourceTypeEnum.WAVEFORMS, patient_uuid, parental_Parameter, null, null);
        Thread.sleep(1000);
    }

}
