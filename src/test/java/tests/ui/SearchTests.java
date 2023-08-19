package tests.ui;

import com.codeborne.selenide.Condition;
import components.MainPage;
import components.SearchComponent;
import components.SearchResultPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SearchTests extends TestBase {

    SearchComponent searchComponent = new SearchComponent();
    SearchResultPage searchResultPage = new SearchResultPage();
    MainPage mainPage = new MainPage();

    @Test
    @Epic("RingCentral")
    @Tag("Smoke")
    @Owner("Aleksey Sivaks")
    @Feature("Search")
    @DisplayName("Search something from main page")
    @Severity(SeverityLevel.CRITICAL)
    void positiveSearchTest() {
        final String textToSearch = "API";
        mainPage.openPage();
        mainPage.cookieWindowCloseIfExists();
        searchComponent.clickSearchButton();
        searchComponent.inputSearchTextAndSearch(textToSearch);
        searchResultPage.checkSearchTextAndSearch(textToSearch);
        }

    @Test
    @Epic("RingCentral")
    @Tag("Smoke")
    @Owner("Aleksey Sivaks")
    @Feature("Search")
    @DisplayName("Search something from main page that should not exist")
    @Severity(SeverityLevel.NORMAL)
    void negativeSearchTest() {
        final String textToSearch = "someweridtextshatshouldnotexist";
        mainPage.openPage();
        mainPage.cookieWindowCloseIfExists();
        searchComponent.clickSearchButton();
        searchComponent.inputSearchTextAndSearch(textToSearch);
        $(".search-coveo__content--empty h1").shouldBe(Condition.visible).shouldHave(Condition.text("No results found"));
        //$$("h1").filterBy(Condition.exactText("No results found")).shouldHave(CollectionCondition.size(1)); //this works too
    }
}
