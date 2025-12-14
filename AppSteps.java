package steps;

import net.serenitybdd.annotations.Steps;
import org.junit.Assert;
import pageObjects.AppPage;
import pageObjects.BasicPage;
import pageObjects.MPVPage;
import pageObjects.SPVPage;

import java.io.IOException;

public class AppSteps {

    @Steps
    AppPage appPage;
    BasicPage basicPage;
    MPVPage mpvPage;
    SPVPage spvPage;

    public void openSPV(String patientId){
        mpvPage.openSPV(patientId);
    }

    public void openSPVOfTheAdmittedPatient() throws InterruptedException {
        mpvPage.openSPVPage();
    }

    public void navigateToMPVPage() throws InterruptedException {
        spvPage.goToMPV();
    }

    public void openComponentPage(String pageName) {
        spvPage.openTheComponentPage(pageName);
    }

    public void openNavigationMenu() {
        appPage.openNavigationMenu();
    }

    public void closeNavigationMenu() throws InterruptedException {
        appPage.closeNavigationMenu();
    }

    public void resetNavigationMenu() throws InterruptedException {
        appPage.resetConfiguration();
    }

    public void scrollTheElementUntilVisible(String direction, int noOfTimes) {
        if(direction.equalsIgnoreCase("UP")) {
            appPage.scrollUpWaveformConfigurationListView(noOfTimes);
        } else if (direction.equalsIgnoreCase("DOWN")){
            appPage.scrollDownWaveformConfigurationListView(noOfTimes);
        }
    }

    public void scrollToViewTheElement(String direction, String text, int noOfTimes) {
        if(direction.equalsIgnoreCase("UP")) {
            appPage.scrollUpToViewPatientBannerExpandedWrappedView(noOfTimes, text);
        } else if (direction.equalsIgnoreCase("DOWN")){
            appPage.scrollDownToViewPatientBannerExpandedWrappedView(noOfTimes, text);
        }
    }

    public void clickTab(String tabName) {
        spvPage.openTheComponentPage(tabName);
    }

    public void verifyTheDisplayedApplicationLayout(String images, String threshold) {
        String[] imageArr = images.split(";");
        for (int i = 0; i <= imageArr.length - 1; i++) {
            String imagePath = imageArr[i]+"_"+System.getProperty("deviceName").replaceAll("\\s", "")+".png";
            System.out.println("imagePath "+imagePath);
            Assert.assertTrue(" There is a mismatch or other issue with - "+imagePath,basicPage.isImagePatternMatch(imagePath, Double.parseDouble(threshold)));
        }
    }

    public void verifyTheApplicationComponentIsNotDisplayed(String images, String threshold,long duration){
        String[] imageArr = images.split(";");
        for (int i = 0; i <= imageArr.length - 1; i++) {
            String imagePath = imageArr[i]+"_"+System.getProperty("deviceName").replaceAll("\\s", "")+".png";
            System.out.println("imagePath "+imagePath);
            Assert.assertTrue(" There is a mismatch or other issue with - "+imagePath,basicPage.isImagePatternMatch(imagePath, Double.parseDouble(threshold),duration));
        }
    }

    public void updateTheme(String theme) throws IOException {
        switch (theme){
            case "Dark":
                spvPage.switchToDarkThemeInSPVPage();
                break;
            case "Light":
                spvPage.switchToLightThemeInSPVPage();
                break;
            default:
                throw new IOException("Invalid Theme name !!");
        }

    }



}
