package steps;

import bdd.framework.service.DataService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ge.hc.kyma.FilterItem;
import com.ge.hc.kyma.bdd.model.streaming.WaveformData;
import net.serenitybdd.annotations.Steps;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import pageObjects.AppPage;
import pageObjects.BasicPage;
import pageObjects.WaveformPage;
import util.KymaConstants;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WaveformSteps {

    @Steps
    WaveformPage waveformPage;

    @Steps
    AppPage appPage;

    @Steps
    BasicPage basicPage;

//    public void openNavigationMenu() throws InterruptedException {
//        waveformPage.openNavigationMenu();
//    }

    public void isECGIAvailable() {
        waveformPage.iSEcgIAvailable();
    }

    public void refreshFSWApplication() throws InterruptedException {
        waveformPage.reloadFSWApplication();
    }

    public void refreshFSWApplicationFromErrorPage() throws InterruptedException {
        waveformPage.reloadFSWApplicationForError();
    }

    public void isTitleDisplayed(String title){
        Assert.assertTrue("Page header is not displaying !!", waveformPage.isLabelDisplayed(title));
    }

    public void verifyErrorMessage(String expectedErrorMessage){
        String actualErrorMessage = waveformPage.getErrorMessage();
        Assert.assertTrue("Error message is not matching !! Actual is - "+actualErrorMessage+" AND expected is - "+expectedErrorMessage, expectedErrorMessage.equals(actualErrorMessage));
    }


    public void zoomIn(int noOfTime, String position) throws InterruptedException {
        int count=0;
        while (count < noOfTime) {
            waveformPage.pinchOut(position);
            count++;
        }
    }

    public void zoomOut(int noOfTime, String position) throws InterruptedException {
        int count=0;
        while (count < noOfTime) {
            waveformPage.pinchIn(position);
            count++;
        }
    }

    public void doubleTapOnComponent(String component){
        switch (component.toLowerCase()) {
            case "caliper":
                waveformPage.doubleTapOnCaliper();
                break;
            case "waveform layout":
                waveformPage.doubleTapOnWaveformLayout();
                break;
            default:
                throw new IllegalArgumentException("Invalid component: " + component);
        }
    }

    public void setWaveformWidth(String waveformWidth){
        waveformPage.setWaveformWidth(waveformWidth);
    }

    public void setLeadLabelWidth(String leadLabelWidth){
        waveformPage.setLeadLabelWidth(leadLabelWidth);
    }

    public void setDividerHeight(String dividerHeight){
        waveformPage.setDeviderHeight(dividerHeight);
    }

    public void setDoubleTapZoomMaxValue(String maxZoomLevel){
        waveformPage.setDoubleTapZoomValue(maxZoomLevel);
    }

    public void setWaveformStrokeColor(String waveformStrokeColor, String waveform){
        waveformPage.setWaveformforStrokeAndLabelColor(waveform);
        waveformPage.setWaveformColor(waveformStrokeColor);
    }

    public void setLeadLabelColor(String leadLabelColor, String waveform){
        waveformPage.setWaveformforStrokeAndLabelColor(waveform);
        waveformPage.setLeadLabelColor(leadLabelColor);
    }

    public void setGridColor(String outerGridColor, String innerGridColor){
        waveformPage.setGraphOuterGridColor(outerGridColor);
        waveformPage.setGraphInnerGridColor(innerGridColor);
    }

    public void setGain(String gain){
        waveformPage.setGainValue(gain);
    }

    public void setLeadGain(String leadGainType, String gainValue){
        waveformPage.setLeadGainValue(leadGainType, gainValue);
    }

    public void updateWaveformToggleConfiguration(String leadConfigLabel, String flag) throws InterruptedException {
        waveformPage.enableToggleConfigView(leadConfigLabel, flag);
    }

    public void resetConfiguration() {
        int attempt = 0;
        while (attempt < 5) {
            waveformPage.ScrollUpWaveformConfigurationListView();
            if (appPage.isElementAvailableBySemanticsLabel("data reset button")) {
                break;
            }
            attempt++;
        }
        waveformPage.resetConfiguration();
    }


    public void setCaliperLaunchLead(String waveform) {
        waveformPage.setCaliperLaunchLeadValue(waveform);
    }

    public void setRhythmLead(String waveform) {
        waveformPage.setRhythmLeadValue(waveform);
    }

    public void getCaliperVitals(String key, String value) {
        if (key != null && !key.isEmpty()) {
            switch (key.toLowerCase()){
                case "lead name":
                    System.out.println("Lead name is - "+waveformPage.getLaunchedCaliperLeadName());
                    Assert.assertEquals(value, waveformPage.getLaunchedCaliperLeadName());
                    break;
                case "interval":
                    System.out.println("Interval is - "+waveformPage.getCaliperInterval());
                    Assert.assertEquals(value, waveformPage.getCaliperInterval());
                    break;
                case "heart rate":
                    System.out.println("HR is - "+waveformPage.getCaliperHeartRate());
                    Assert.assertEquals(value, waveformPage.getCaliperHeartRate());
                    break;
                case "amplitude":
                    System.out.println("Amplitude is - "+waveformPage.getCaliperAmplitude());
                    Assert.assertEquals(value, waveformPage.getCaliperAmplitude());
                    break;
                default:
                    throw new IllegalArgumentException("Invalid caliper vitals: " + key + " : " + value);
            }
        }
    }

    public void setMinDurationOfCaliper(String minDurationOfCaliper){
        waveformPage.setWaveformWidth(minDurationOfCaliper);
    }

    public void setMinHeightOfCaliper(String minHeightOfCaliper){
        waveformPage.setWaveformWidth(minHeightOfCaliper);
    }

    public void setDefaultDurationOfCaliper(String defaultDurationOfCaliper){
        waveformPage.setDefaultDurationOfCaliperValue(defaultDurationOfCaliper);
    }

    public void isCaliperLaunched(){
        Assert.assertTrue("Caliper is not launched !!", waveformPage.isCaliperDisplayed());
    }

    public void areCaliperDotsDisplayed(boolean dotsDisplayed) throws Exception {
        if(dotsDisplayed) {
            Assert.assertTrue("Caliper arm dots are not displayed !!", waveformPage.areCaliperArmsAreDisplayed());
        } else if(!dotsDisplayed){
            Assert.assertFalse("Caliper arm dots should not displayed !!", waveformPage.areCaliperArmsAreDisplayed());
        } else{
            throw new IOException("Invalid Exception !!");
        }
    }

    public void areCaliperMarchoutLinesDisplayed(boolean marchoutLinesDisplayed) throws Exception {
        if(marchoutLinesDisplayed) {
            Assert.assertTrue("Caliper Marchout lines are not displayed !!", waveformPage.areCaliperMarchoutLinesDisplayed());
        } else if(!marchoutLinesDisplayed){
            Assert.assertFalse("Caliper Marchout lines should not displayed !!", waveformPage.areCaliperMarchoutLinesDisplayed());
        } else{
            throw new IOException("Invalid Exception !!");
        }
    }

    public void clickOnWaveformLayout() {
        waveformPage.clickOnTheWaveformArea();
    }

    public void dragAndDropTheCaliper(int noOfTime, String direction) throws InterruptedException {
        int count=0;
        while (count < noOfTime) {
            waveformPage.dragAndDropTheCaliper(direction);
            count++;
        }
    }

    public void dragAndDropTheCaliperArm(String arm, int noOfTime, String direction) throws InterruptedException {
        int count=0;
        while (count < noOfTime) {
            Thread.sleep(1000);
            waveformPage.dragTheCaliperArms(arm, direction);
            count++;
        }
    }

    public void swipeWaveformLayout(int noOfTime, String direction) throws InterruptedException {
        int count=0;
        while (count < noOfTime) {
            Thread.sleep(3000);
            waveformPage.swipeWaveformLayout(direction);
            count++;
        }
    }

    public void rotateTheScreen(String displayMode) {
        waveformPage.rotateScreen(displayMode);
    }

    public void isECGWaveformsAvailable(String waveform) {
        Assert.assertTrue(waveform+" is not available !!", waveformPage.isTheWaveformAvailable(waveform));
    }

    public void isECGWaveformsAvailable() {
        waveformPage.iSEcgIAvailable();
        waveformPage.iSecgIIAvailable();
        waveformPage.iSecgIIIAvailable();
        waveformPage.iSecgAVFAvailable();
        waveformPage.iSecgAVRAvailable();
        waveformPage.iSecgAVLAvailable();
        waveformPage.iSecgV1Available();
        waveformPage.iSecgV2Available();
        waveformPage.iSecgV3Available();
        waveformPage.iSecgV4Available();
        waveformPage.iSecgV5Available();
        waveformPage.iSecgV6Available();
    }

    public void updateWaveform(String waveformPayloadPath, String waveformType) throws IOException, InterruptedException, ParseException {
        InputStream inStream = getClass().getResourceAsStream(waveformPayloadPath);
        List<WaveformData> waveformDatas = parseWaveformDatafromJson(inStream);
        String patient_uuid = KymaConstants.getPatientUuid();
        DataService dataService = new DataService();

        dataService.create(patient_uuid, FilterItem.ResourceTypeEnum.WAVEFORMS, waveformDatas,"GE", waveformType);

    }

    private List<WaveformData> parseWaveformDatafromJson(InputStream inStream)
            throws IOException, JsonParseException, JsonMappingException, ParseException {
        InputStreamReader reader = new InputStreamReader(inStream);

        JSONParser parser = new JSONParser();

        JSONObject jsonObject = (JSONObject) parser.parse(reader);
        JSONArray waveformData = (JSONArray) jsonObject.get("waveformData");

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        List<WaveformData> waveformDatas = new ArrayList<WaveformData>();

        for (Object singleWaveformData : waveformData) {
            System.out.println(singleWaveformData.toString());
            waveformDatas.add((WaveformData) mapper.readValue(singleWaveformData.toString(), WaveformData.class));
        }
        return waveformDatas;
    }
}
