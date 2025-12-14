package pageObjects;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.github.ashwith.flutter.FlutterFinder;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;


public class LoginPage extends PageObject{

    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]")
    private WebElement userName;

    @AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]")
    private WebElement password;

    @AndroidFindBy(xpath="//android.widget.Button[@content-desc=\"Login\"]")
    private WebElement login;

    private final FlutterFinder finder = new FlutterFinder((RemoteWebDriver) ((WebDriverFacade) getDriver()).getProxiedDriver());

    public void login() {
        finder.byText("Welcome to Kyma Mobile").click();
//        finder.byValueKey("usernameField").sendKeys("tester");
        finder.bySemanticsLabel("Username TextField").click();
        finder.bySemanticsLabel("Username TextField").sendKeys("admin");
//        ((RemoteWebDriver) ((WebDriverFacade) getDriver()).getProxiedDriver()).hideKeyboard();
        finder.byText("Welcome to Kyma Mobile").click();
        finder.bySemanticsLabel("Password TextField").click();
        finder.bySemanticsLabel("Password TextField").sendKeys("admin");
//        userName.click();
//        userName.sendKeys("admin");
//        password.click();
//        password.sendKeys("admin");
//        login.click();
        finder.byText("Login").click();
    }


}
