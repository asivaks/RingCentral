package tests;

import components.MainPage;
import components.SearchComponent;
import components.SearchResultPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase{

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
        final String textToSearh = "API";
//        step("Open main page", () ->
//                open(""));
        mainPage.openPage();
        mainPage.cookieWindowCloseIfExists();
        searchComponent.clickSearchButton();
        searchComponent.inputSearchTextAndSearch(textToSearh);
        searchResultPage.checkSearchTextAndSearch(textToSearh);
        }
}
