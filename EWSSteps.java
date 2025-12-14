package steps;

import bdd.framework.handler.DataHandler;
import bdd.framework.service.DataService;
import com.ge.hc.kyma.FilterItem;
import com.ge.hc.kyma.bdd.model.streaming.NumericData;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;
import org.springframework.web.client.RestClientException;
import pageObjects.AppPage;
import pageObjects.BasicPage;
import pageObjects.EWSPage;
import util.KymaConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EWSSteps {

    @Steps
    EWSPage ewsPage;

    @Steps
    BasicPage basicPage;

    @Steps
    AppPage appPage;

    private static String restURL = System.getProperty("base.path");

    public void deleteAllPatient() throws InterruptedException {
        DataService dataService = new DataService();
        dataService.delete(FilterItem.ResourceTypeEnum.PATIENTS, null, null);
    }

    @Step
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
            numericDetails.put("entityID", "");
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
        DataService dataService = new DataService(restURL);
        dataService.update(FilterItem.ResourceTypeEnum.NUMERICS, numericDatas, entityID, Integer.valueOf(sampleInterval), "UPDATEALL");
    }

    public void selectEWSvalue(String EWS) {
        ewsPage.selectEwsValuedropdown(EWS);
    }

    //click on HamburgerMenu
    public void clickOnHamburgeroption() {
        ewsPage.ClickOnHamburgerMenu();
    }

    //To update score name
    public void enterScoreName(String scoreName) {
        ewsPage.updatescorelabel(scoreName);
    }

    //Select level from dropdown option
    public void selectlevelonevalue() {
        ewsPage.levelClick();
    }

    //close button
    public void clickOnCloseButton() {
        ewsPage.clickclosebutton();
    }

    //To validate score label
    public void validateScoreLabel(String scorelabel) {
        Assert.assertTrue(appPage.isElementAvailable(scorelabel));
    }

    //To validate score value
    public void validateScoreValue(String scorevalue) {
        Assert.assertTrue(appPage.isElementAvailable(scorevalue));
    }

    //Tap on the tag view
    public void tapOnTheTagView() {
        ewsPage.clickonTagView();
    }

    //To Validate the pop-up is not displayed
    public void validateEventPopUp(String text) {
        Assert.assertFalse(appPage.isElementAvailable(text));
    }

    //To select icon path light
    public void clickOnIcon(String alert_icon) throws InterruptedException {
        ewsPage.clickonIcon(alert_icon);
    }

    //To click on tap for small view
    public void tapOnTheSmallView() {
        ewsPage.clickonSmallView();
    }

    //To Validate the pop-up is not displayed
    public void validateErrorMessage(String text) {
        Assert.assertTrue(appPage.isElementAvailable(text));
    }

    //Tap on the medium view
    public void tapOnTheMediumView() {
        ewsPage.clickonMediumView();
    }

    //To Validate the updated color
    public void updateLevelColor(String Bordercolor, String Scorelabelcolor, String Scorevaluecolor) {
        ewsPage.updatecolor(Bordercolor, Scorelabelcolor, Scorevaluecolor);
    }

    //Tap on the tile view
    public void clickOnTileView() {
        ewsPage.clickonTileView();
    }

    public void updateEWSToggleConfiguration(String leadConfigLabel, boolean flag) {
        ewsPage.toggleConfigView(leadConfigLabel, flag);
    }

    //To update height and width
    public void updateHeightWidth(String width, String height) {
        ewsPage.updateheightwidth(width, height);
    }

    //Level 3 is tapped
    public void updateLevelThird() {
        ewsPage.clickonThirdLevel();
    }

    //To update error text message
    public void UpdateErrorMessage(String text) {
        ewsPage.updateErrorText(text);
    }

    //Level 4 is tapped
    public void updateLevelFourth() {
        ewsPage.clickonfourthLevel();
    }

    //To update width and height for medium view
    public void updateMediumHeightwidth(String width, String height) {
        ewsPage.updatewidthheightcombined(width, height);
    }

    //To Validate the pop-up is  displayed
    public void validateTextMessage(String text) {
        Assert.assertTrue(appPage.isElementAvailable(text));
    }

    public void updatestaletimefield(String text) {
        ewsPage.updatestaletime(text);
    }

    public void scrollElementUntilVisible(String direction, int noOfTimes) {
        if (direction.equalsIgnoreCase("UP")) {
            ewsPage.scrollUpConfigurationListView(noOfTimes);
        } else if (direction.equalsIgnoreCase("DOWN")) {
            ewsPage.scrollDownConfigurationListView(noOfTimes);
        }
    }
}