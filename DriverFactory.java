package util;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.ScriptKey;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.Set;

public class DriverFactory extends RemoteWebDriver {
//----------------------------------------------------------------
//  Below part of code is for testing on BrowserStack Appium Cloud
//----------------------------------------------------------------
    private static AppiumDriver driver;
    public static AppiumDriver getDriver() {
        if (driver == null) {
            try {
                String os = System.getProperty("os.name").toLowerCase();
                String batchFilePath = null;
                if (os.contains("win")) {
                    batchFilePath = "./start_bstack_local.bat";
                } else if (os.contains("mac")) {
                    batchFilePath = "./start_bstack_local.sh";
                }
//              String batchFilePath = "./start_bstack_local.bat";
                ProcessBuilder processBuilder = new ProcessBuilder(batchFilePath);
                Process process = processBuilder.start();
                Thread.sleep(30000);

                DesiredCapabilities capabilities = new DesiredCapabilities();
                HashMap<String, Object> bstackOptions = new HashMap<String, Object>();
                bstackOptions.put("userName", System.getProperty("bstack_userName"));
                bstackOptions.put("accessKey", System.getProperty("bstack_accessKey"));
//                bstackOptions.put("acceptInsecureCerts","true");
                bstackOptions.put("local", "true");
                capabilities.setCapability("bstack:options", bstackOptions);
                capabilities.setCapability("platformName", System.getProperty("platformName"));
                capabilities.setCapability("appium:automationName", System.getProperty("automationName"));
                capabilities.setCapability("appium:deviceName", System.getProperty("deviceName"));
                capabilities.setCapability("appium:platformVersion", System.getProperty("platformVersion"));
                capabilities.setCapability("acceptInsecureCerts",true);
                capabilities.setCapability("appium:retryBackoffTime", 3000); // in ms
                capabilities.setCapability("appium:maxRetryCount", 20);

                String filepath = "";
                if (System.getProperty("platformName").trim().equals("Android")){
                    filepath = "android_output.txt";
                } else {
                    filepath = "ios_output.txt";
                }

                String content = new String(Files.readAllBytes(Paths.get(filepath)));
                String app_url = "bs:" + content.split("bs:")[1].replace("\"}","");
                System.out.println(app_url);
                capabilities.setCapability("appium:app", app_url.trim());
                if (System.getProperty("platformName").trim().equals("Android")) {
                    driver = new AndroidDriver(new URL(System.getProperty("bstack_URL")), capabilities);
                } else{
                    capabilities.setCapability("autoAcceptAlerts", true);
                    driver = new IOSDriver(new URL(System.getProperty("bstack_URL")), capabilities);
                }
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

//---------------------------------------------------------------------------------------------------------------------
//  Below part of code is for local Appium Server Set up which is normally used for testing on Emulator and Real Device
//---------------------------------------------------------------------------------------------------------------------

//    private static AppiumDriver driver;
//    public static AppiumDriver getDriver() {
//        if (driver == null) {
//            DesiredCapabilities capabilities = new DesiredCapabilities();
//            try {
//                capabilities.setCapability("noReset", "false");
//                capabilities.setCapability("platformName", System.getProperty("platformName"));
//                capabilities.setCapability("appium:automationName", System.getProperty("automationName"));
//                capabilities.setCapability("appium:deviceName", System.getProperty("deviceName"));
//                capabilities.setCapability("appium:platformVersion", System.getProperty("platformVersion"));
//
//                if (System.getProperty("platformName").trim().equals("Android")) {
//                    capabilities.setCapability("appium:app","C:\\KymaWorkspace\\QA\\platformbdd-mobile\\Apps\\debug\\app-debug.apk");
//                    driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
//                    System.out.println("AndroidDriver initialization done!!");
//                } else{
//                    capabilities.setCapability("autoAcceptAlerts", "true");
//                    capabilities.setCapability("appium:app","/Users/gitlab/Documents/kyma-project/platformbdd-mobile/Apps/debug/app-debug.ipa");
//                    driver = new IOSDriver(new URL("http://127.0.0.1:4723"), capabilities);
//                    System.out.println("IOSDriver initialization done!!");
//                }
//                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return driver;
//    }

    @Override
    public Set<ScriptKey> getPinnedScripts() {
        return super.getPinnedScripts();
    }
}
