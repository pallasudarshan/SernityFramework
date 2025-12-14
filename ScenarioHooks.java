package stepDefinitions;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.core.pages.PageObject;
import pageObjects.BasicPage;
import steps.PatientSteps;
import util.DriverFactory;


public class ScenarioHooks extends PageObject {

    private static AppiumDriver driver; // Made static to resolve static context issues
    public PatientSteps patientSteps;


    /**
     * This method is called before each scenario to activate the application and switch context.
     * It ensures that the application is ready for interaction before any test steps are executed.
     */
    @Before
    public void activateTheApplication() {
        driver = DriverFactory.getDriver();
//        BasicPage.switchContext(driver, "NATIVE_APP");
        try {
            if (driver instanceof AndroidDriver) {
                ((AndroidDriver) driver).activateApp("org.gehealthcare.kyma_mobile_reference_app");
            } else {
                ((IOSDriver) driver).activateApp("org.gehealthcare.kymaMobileReferenceApp");
            }
        } catch (Exception e) {
            System.err.println("Error during application launching: " + e.getMessage());
        }
        BasicPage.switchContext(driver, "FLUTTER");
    }

    /**
     * This method is called after each scenario to terminate the application and perform cleanup.
     * It also discharges all patients to ensure a clean state for the next scenario.
     *
     * @param scenario The current scenario being executed.
     */

    @After
    public void terminateTheApplication(Scenario scenario) {
        driver = DriverFactory.getDriver();
        BasicPage.switchContext(driver, "NATIVE_APP");
        try {
            if (driver instanceof AndroidDriver) {
                ((AndroidDriver) driver).terminateApp("org.gehealthcare.kyma_mobile_reference_app");
            } else {
                ((IOSDriver) driver).terminateApp("org.gehealthcare.kymaMobileReferenceApp");
            }
        } catch (Exception e) {
            System.err.println("Error during application closing: " + e.getMessage());
        }

        try {
            patientSteps = new PatientSteps();
            patientSteps.deletePatientByUUID();
//            patientSteps.dischargeAllPatients();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        BasicPage.switchContext(driver, "FLUTTER");
    }
}

