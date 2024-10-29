package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Search {
    private final SelenideElement searchButton = $("[class*=bork-header-navbar-icon-list__icon--view--search]"),
    searchInput = $("input.ui-search-input__content"),
    searchBodyWrapper = $(".bork-search-body__wrapper");


    public Search setSearchText(String searchText){
        searchButton.click();
        searchInput.setValue(searchText);
        return this;
    }

    public void checkSearchCategory(String category){
        searchBodyWrapper.$(byText("Категории")).parent().shouldHave(text(category));
    }
}
