package data;

public enum GiftCardWithFixPrice {
    GIFT_FIX_PRICE_10("10 тыс. р.", "https://st.bork.ru/components/gift_card_presets/podarochnaya-karta-gibkiy-nominal/podarochnaya-karta-10000.png"),
    GIFT_FIX_PRICE_30("30 тыс. р.", "https://st.bork.ru/components/gift_card_presets/podarochnaya-karta-gibkiy-nominal/podarochnaya-karta-30000.png"),
    GIFT_FIX_PRICE_50("50 тыс. р.", "https://st.bork.ru/components/gift_card_presets/podarochnaya-karta-gibkiy-nominal/podarochnaya-karta-50000.png"),
    GIFT_FIX_PRICE_100("100 тыс. р.", "https://st.bork.ru/components/gift_card_presets/podarochnaya-karta-gibkiy-nominal/podarochnaya-karta-100000.png");

    private final String fixPrice,
                        giftCardImage;
    GiftCardWithFixPrice(String fixPrice, String giftCardImage){
        this.fixPrice = fixPrice;
        this.giftCardImage = giftCardImage;
    }

    public String getFixPrice() {
        return fixPrice;
    }

    public String getGiftCardImage() {
        return giftCardImage;
    }

    @Override
    public String toString() {
        return fixPrice;
    }
}
