package components;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage {

    @Step("Result should have text in caption {0}")
    public void checkSearchTextAndSearch(String textToSearch) {
        $(".CoveoResultLink").shouldHave(Condition.text(textToSearch));
    }

    //<a class="CoveoResultLink search-coveo__item-link" title="RingCentral Wins 2018 API World Award for Communications APIs" tabindex="0" href="https://www.ringcentral.com/whyringcentral/company/pressreleases/pressreleases-2018/RingCentral_Wins_2018_API_World_Award_for_Communications_APIs.html">RingCentral Wins 2018 <span class="coveo-highlight">API</span> World Award for Communications APIs</a>

}
