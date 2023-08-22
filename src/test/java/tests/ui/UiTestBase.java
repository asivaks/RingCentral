package tests.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.RCConfig;
import helpers.Attach;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class UiTestBase {

    static final RCConfig config = ConfigFactory.create(RCConfig.class, System.getProperties());

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
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 14000;

        System.out.println("capabilities= " + capabilities.asMap());

        //String remoteString = "http://" + credentialsConfig.remoteUser
        // () + ":" + credentialsConfig.remotePassword() + "@" + credentialsConfig.remoteUrl();
        //String selenoidUrl = "http://<remote-server-ip>:4444/wd/hub";

        //String remoteUrl = "89.223.123.173:4444/wd/hub";
        //String remoteString = "http://" + remoteUrl;
        String remoteString = System.getProperty("remoteString");
        System.out.println("Connecting to " + remoteString);
        Configuration.remote = remoteString;
    }

    @AfterEach
    void addAttachments() {
        try {
            Attach.screenshotAs("Last screen");
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Attach.pageSource();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Attach.browserConsoleLogs();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Attach.addVideo();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
