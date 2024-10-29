import data.GiftCardWithFixPrice;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.GiftCardPage;
import pages.MainPage;
@Tag("simple")
public class BorkTests extends TestBase {
    MainPage mainPage = new MainPage();
    GiftCardPage giftCardPage = new GiftCardPage();


    @ValueSource(strings = {
            "Новинки", "Идеи подарков", "Кухня", "Дом", "Красота и здоровье",
            "Outdoor", "Bork home", "Voyage", "Interior"
    })
    @ParameterizedTest(name = "Хедер содержит пункт {0}")
    public void headerShouldHaveAllItemsTest(String menuItem) {
        mainPage.openMainPage()
                .checkHeaderItem(menuItem);
    }

    @EnumSource(GiftCardWithFixPrice.class)
    @ParameterizedTest(name = "У подарочной карты с фиксированной ценой {0} отображается соответствующая картинка")
    public void giftCardWithFixPriceShouldHaveOwnPicture(GiftCardWithFixPrice giftCard) {
        mainPage.openMainPage()
                .openCategoryFromHeaderItem("Идеи подарков", "Подарочные карты");
        giftCardPage.setFixPriceGiftCard(giftCard.getFixPrice())
                .checkImageGiftCard(giftCard.getGiftCardImage());
    }


    @ValueSource(strings = {
            "3000", "500000"
    })
    @ParameterizedTest(name = "Кнопка покупки кликабельна при вводе допустимого граничного значения {0} в поле суммы подарочной карты")
    public void positiveBoundaryValuesOfGiftPriceTest(String price){
        mainPage.openMainPage()
                .openCategoryFromHeaderItem("Идеи подарков", "Подарочные карты");
        giftCardPage.setPriceGiftCard(price)
                .checkBuyButtonIsEnabled();
    }

    @CsvSource(value = {
            "2999,Сумма должна быть больше 3 000",
            "500001,Сумма должна быть меньше 500 000"
    })
    @ParameterizedTest(name = "Появляется ошибка \"{1}\" при вводе недопустимного значения {0} в поле суммы подарочной карты")
    public void negativeBoundaryValuesOfGiftPriceTest(String price, String textError) {
        mainPage.openMainPage()
                .openCategoryFromHeaderItem("Идеи подарков", "Подарочные карты");
        giftCardPage.setPriceGiftCard(price)
                .checkErrorMessagePrice(textError)
                .checkBuyButtonIsDisabled();
    }

    @CsvSource(value = {
            "Чайники,Чайники",
            "Посуда,Посуда и сервировка"
    })
    @ParameterizedTest(name = "Появляется категория \"{1}\" при вводе в поиск слова {0}")
    public void searchCategoryUsingKeyWord(String searchText, String category){
        mainPage.openMainPage()
                .setSearchText(searchText)
                .checkSearchCategory(category);
    }
}
