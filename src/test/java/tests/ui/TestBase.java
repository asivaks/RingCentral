package tests.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.RCConfig;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

    static final RCConfig config = ConfigFactory.create(RCConfig.class, System.getProperties());
//    static final String login = config.userLogin();
//    static final String password = config.userPassword();

    @BeforeAll
    @Description("add listener, set base URLs")
    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.baseUrl = config.webUrl();
        //Configuration.browser = browserName;
        //Configuration.browserVersion = browserVersion;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 7000;

        System.out.println("capabilities= " + capabilities.asMap());
//        System.out.println("Will login to " + Configuration.baseUrl + " with user " + login + " & password " + password);

        //CredentialsConfig credentialsConfig = ConfigFactory.create(CredentialsConfig.class);
        //String remoteString = "https://" + credentialsConfig.remoteUser() + ":" + credentialsConfig.remotePassword() + "@" + credentialsConfig.remoteUrl();
        //System.out.println("Connecting to " + remoteString);
        //Configuration.remote = remoteString;

    }
}
