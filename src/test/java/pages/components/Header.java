package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class Header {
    SelenideElement mainHeader = $("ul.bork-horizontal-menu__menu"),
    dropdownMenuList = $("ul.bork-dropdown-menu__list");

    public void checkHeaderItem(String menuItem){
        mainHeader.shouldHave(text(menuItem));
    }

    public void openCategoryFromHeaderItem(String menuItem, String category){
        mainHeader.$(byText(menuItem)).hover();
        sleep(1000);
        dropdownMenuList.$(byText(category)).click();
    }
}
