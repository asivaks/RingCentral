package components;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    @Step("Open main page")
    public void openPage() {
        open("");
    }

    @Step("Close cookies acceptance window if exists")
    public void cookieWindowCloseIfExists() {
        if ($("#onetrust-accept-btn-handler").exists())
        {
            $("#onetrust-accept-btn-handler").shouldBe(visible).click();
        }
    }
}
