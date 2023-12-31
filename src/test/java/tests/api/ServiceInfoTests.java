package tests.api;

import config.RCConfig;
import io.qameta.allure.*;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ServiceInfoTests extends ApiTestBase {
    @Test
    @Epic("RingCentral")
    @Tag("Smoke")
    @Owner("Aleksey Sivaks")
    @Feature("Service Info")
    @DisplayName("Try to get service info with invalid access token and receive 401")
    @Severity(SeverityLevel.CRITICAL)
    void serviceInfoTest() {

        given()
                .log().all()
                .header("Authorization", "Bearer UExxxxxxxxMnzpdvtYYNWMSJ7CL8h0zM6q6a9ntw")
                .when()
                .get("restapi/v1.0/account/~/service-info")
                .then()
                .log().all()
                .statusCode(401)
                .body("errorCode", is("TokenInvalid"))
                .body("message", is("Invalid token"))
                .body("errors[0].errorCode", is("OAU-149"))
                .body("errors[0].message", is("Invalid token"))
        ;

    }
}
