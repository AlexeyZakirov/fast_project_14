package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class GiftCardPage {
    SelenideElement fixPriceGiftContainer = $("div.bork-gift-card-page-presets__container"),
    imageGiftCard = $("img[data-test='gift-card-page-card-selector-desktop-selected-card-img']"),
    priceGiftInput = $(".bork-gift-card-page-price-selector__inner input"),
    buttonBuyGiftCard = $("button[data-test=gift-card-page-inner-buy-button]"),
    errorMessagePriceGiftCard = $(".bork-gift-card-page-price-selector__inner .ui-input__error");

    @Step("Выбрать фиксированную сумму подарочной карты")
    public GiftCardPage setFixPriceGiftCard(String fixPrice){
        fixPriceGiftContainer.$(byText(fixPrice)).click();
        return this;
    }

    @Step("Ввести сумму подарочной карты")
    public GiftCardPage setPriceGiftCard(String price){
        priceGiftInput.setValue(price);
        return this;
    }

    @Step("Проверить соответствующую картинку")
    public void checkImageGiftCard(String image){
        imageGiftCard.shouldHave(attribute("src", image));
    }

    @Step("Проверить, что кнопка \"Купить\" кликабельна")
    public void checkBuyButtonIsEnabled(){
        buttonBuyGiftCard.shouldNotHave(attribute("disabled"));
    }

    @Step("Проверить, что кнопка \"Купить\" не кликабельна")
    public void checkBuyButtonIsDisabled(){
        buttonBuyGiftCard.shouldHave(attribute("disabled"));
    }

    @Step("Проверить, что текст ошибки - {0}")
    public GiftCardPage checkErrorMessagePrice(String message){
        errorMessagePriceGiftCard.shouldHave(text(message));
        return this;
    }

}
