package components;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    @Step("Open main page")
    public void openPage() {
        open("");
    }

    @Step("Accept in cookies acceptance window if exists")
    public void cookieAcceptanceWindowCloseIfExists() {
        //if ($("#onetrust-accept-btn-handler").exists()) //will not wait for the element to appear
        // TODO: 22.08.2023 move this to a separate method, pass locator and wait duration
        int sleepTimer = 5;
        while (sleepTimer > 0) {
            if ($("#onetrust-close-btn-container").exists()) {
                System.out.println("Clicking on Accept in cookies acceptance window");
                $("#onetrust-accept-btn-handler").shouldBe(visible).click();
                break;
            } else {
                System.out.println("Waiting for \"#onetrust-accept-btn-handler to appear ");
                sleep(1000);
                sleepTimer--;
            }
        }
    }

    @Step("Close cookies preferences window if exists")
    public void cookiePreferencesWindowCloseIfExists() {
        int sleepTimer = 5;
        while (sleepTimer > 0) {
            if ($("#onetrust-close-btn-container").exists()) {
                System.out.println("Clicking on Close in cookies preferences window");
                $("#onetrust-close-btn-container").shouldBe(visible).click();
                break;
            } else {
                System.out.println("Waiting for \"onetrust-close-btn-container to appear ");
                sleep(1000);
                sleepTimer--;
            }
        }
    }
}
