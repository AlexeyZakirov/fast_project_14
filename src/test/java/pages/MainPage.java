package pages;

import io.qameta.allure.Step;
import pages.components.Header;
import pages.components.Search;

import static com.codeborne.selenide.Selenide.open;


public class MainPage {
    Header header = new Header();
    Search search = new Search();

    @Step("Открыть главную страницу")
    public MainPage openMainPage(){
        open("/");
        return this;
    }
    @Step("Проверить, что хэдер содержит пункт {0}")
    public void checkHeaderItem(String menuItem){
        header.checkHeaderItem(menuItem);
    }

    @Step("Открыть категорию {1} из пункта {0} в хэдере")
    public void openCategoryFromHeaderItem(String menuItem, String category){
        header.openCategoryFromHeaderItem(menuItem, category);
    }

    @Step("Ввести в поиск текст {0}")
    public MainPage setSearchText(String searchText){
        search.setSearchText(searchText);
        return this;
    }
    @Step("Проверить наличие категории {0}")
    public void checkSearchCategory(String category){
        search.checkSearchCategory(category);
    }

}
