package tests.api;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.RCConfig;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class ApiTestBase {

    static final RCConfig config = ConfigFactory.create(RCConfig.class, System.getProperties());

    @BeforeAll
    @Description("add listener, set base URLs")
    static void beforeAll() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        RestAssured.baseURI = config.apiUrl();

        //String remoteString = "https://" + credentialsConfig.remoteUser() + ":" + credentialsConfig.remotePassword() + "@" + credentialsConfig.remoteUrl();
        //System.out.println("Connecting to " + remoteString);
        //Configuration.remote = remoteString;

    }
}
