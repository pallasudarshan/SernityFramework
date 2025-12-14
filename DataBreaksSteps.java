package steps;

import bdd.framework.service.StreamDataService;
import com.ge.hc.kyma.FilterItem;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;
import pageObjects.AppPage;
import pageObjects.BasicPage;
import pageObjects.DatabreaksPage;
import util.BDDCommonUtil;
import util.KymaConstants;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DataBreaksSteps {
    @Steps
    BasicPage basicPage;

    @Steps
    AppPage appPage;

    @Steps
    DatabreaksPage databreaksPage;

    private String startDateAndTime;
    private String endDateAndTime;

    public void clickUpdateConfig() throws InterruptedException {
        databreaksPage.clickOnUpdateConfig();
        Thread.sleep(2000);
    }


    public void enterTheDataInTheDataBreaksConfigurationTextFields(String textFieldName, String textValue) {
        databreaksPage.dataBreaksConfigurationTextFields(textFieldName, textValue);
    }

    public void selectTheDropdownOption(String dropdownField, String dropdownOption) {
        databreaksPage.dataBreaksConfigurationDropdownFields(dropdownField, dropdownOption);
    }

    public void dataBreaksConfigurationsCheckBox(String checkboxField) {
        databreaksPage.dataBreaksConfigurationCheckBox(checkboxField);

    }

    public void verifyIsElementAvailable(String value, String flag) {
        if (flag.equalsIgnoreCase("true")) {
            Assert.assertTrue(appPage.isElementAvailable(value));
        } else {
            Assert.assertFalse(appPage.isElementAvailable(value));
        }
    }

    public void verifyIsElementAvailableByValueKey(String value, String flag) {
        if (flag.equalsIgnoreCase("true")) {
            Assert.assertTrue(appPage.isElementAvailableByValueKey(value));
        } else {
            Assert.assertFalse(appPage.isElementAvailableByValueKey(value));
        }
    }

    public void clickOnChevron() {
        databreaksPage.clickOnChevron();
    }

    public void clickOnTheConfigurationButton(String value) {
        databreaksPage.clickOnTheConfigurationButtons(value);
    }

    public void setTheStartBreakDateAndTime(String breakField, String type, int num) {
        startDateAndTime = BDDCommonUtil.getUTCDateTime(type, num);
        databreaksPage.dataBreaksConfigurationTextFields(breakField, startDateAndTime);
    }

    public void setTheEndBreakDateAndTime(String breakField, String type, int num) {
        endDateAndTime = BDDCommonUtil.getUTCDateTime(type, num);
        databreaksPage.dataBreaksConfigurationTextFields(breakField, endDateAndTime);
    }

    public void verifyBreakStartDateTimeText(String flag) {
        String startTime = BDDCommonUtil.formatForBreaksContainerDateAndTextLabels(startDateAndTime);
        System.out.println("Break End Date And Time:-" + startTime);
        verifyIsElementAvailableByValueKey("End" + startTime, flag);
    }

    public void verifyBreakEndDateTimeText(String flag) {
        String endTime = BDDCommonUtil.formatForBreaksContainerDateAndTextLabels(endDateAndTime);
        System.out.println("Break Start Date And Time:-" + endTime);
        verifyIsElementAvailableByValueKey("Start" + endTime, flag);
    }
    public void verifyIsElementAvailableOrNot(String value, String flag) {
        String valueSemantic = databreaksPage.availabilityOfElement(value);
        if (flag.equalsIgnoreCase("true")) {
            Assert.assertTrue(appPage.isElementAvailableByValueKey(valueSemantic));
        } else {
            Assert.assertFalse(appPage.isElementAvailableByValueKey(valueSemantic));
        }
    }

    public void scrollFHRSlotConfigurationListView(String direction, int noOfTimes) {
        int count = 0;
        while (count < noOfTimes) {
            if (direction.equalsIgnoreCase("UP")) {
                basicPage.scrollToViewTheMenuSPV("UP");
            } else if (direction.equalsIgnoreCase("DOWN")) {
                basicPage.scrollToViewTheMenuSPV("DOWN");
            }
            count++;
        }
    }


}
