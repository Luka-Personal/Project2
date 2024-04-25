package ge.tbc.tbcacademy.configs;
import ge.tbc.tbcacademy.listeners.SelenideListener;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import java.util.HashMap;
import java.util.Map;
import static com.codeborne.selenide.Configuration.*;

@Listeners(SelenideListener.class)
public class BaseSelenideConfig {
    @BeforeMethod(alwaysRun = true)
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> passManagerSettings = new HashMap<>();
        options.addArguments("start-maximized");
        passManagerSettings.put("credentials_enable_service", false);
        passManagerSettings.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", passManagerSettings);
        browserCapabilities = options;
        browserSize = null;
        timeout=5000;
        System.out.println("CONFLICT MAKER");
        System.out.println("CONFLICT");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
