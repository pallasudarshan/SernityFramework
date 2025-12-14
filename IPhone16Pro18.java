package starter;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

//mvn clean verify -DRunnerClass=CucumberTestSuite.java

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {
        "src/test/resources/features/PatientBanner/PatientBanner.feature",
        "src/test/resources/features/PatientBanner/PatientBannerAdditionalFields.feature",
        "src/test/resources/features/FD_Waveform/FSWGainAndZoom.feature",
        "src/test/resources/features/FD_Waveform/Caliper.feature",
        "src/test/resources/features/EWS/EarlyWarningScore.feature",
        "src/test/resources/features/FHR/MPV-FHRSlot.feature",
        "src/test/resources/features/FHR/SPV-FHRSlot.feature",
//        "src/test/resources/features/FHR/DataBreaks.feature",
//        "src/test/resources/features/FHR/FetalHeartRate.feature",
//        "src/test/resources/features/FHR/FHRUA.feature",
        "src/test/resources/features/NumericBlock/Combined_Numeric.feature",
        "src/test/resources/features/NumericBlock/Single_Numerics.feature",
        "src/test/resources/features/NumericBlock/NIBP_Numeric.feature",
        "src/test/resources/features/AlarmBanner/AlarmBanner.feature"
},
        glue = { "stepDefinitions" },
        tags = "not @ignore",
        plugin = { "json:target/IPhone16Pro18/cucumber-reports/Cucumber.json" })

public class IPhone16Pro18 {
}