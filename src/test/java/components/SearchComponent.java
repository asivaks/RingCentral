package components;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class SearchComponent {
    @Step("Click search button")
    public void clickSearchButton() {
        $("div.search").click();
    }
    @Step("Input search text & search")
    public void inputSearchTextAndSearch(String textToSearch) {
        $(".select__input").setValue(textToSearch);
        sleep(3000); //should wait a bit for suggestion to appear
        $(".select__input").pressEnter();
    }
}
