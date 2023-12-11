package menu.domain;

import static menu.domain.Menu.*;

import java.util.List;

public enum Category {

    JAPANESE("일식", List.of(
            GYUDON,
            UDON,
            MISO_SOUP,
            SUSHI,
            KATSUDON,
            ONIGIRI,
            HIGH_RICE,
            RAMEN,
            OKONOMIYAKI)),
    KOREAN("한식", List.of(
            KIMBAP,
            KIMCHI_SOUP,
            SSAMBAP,
            SOY_BEAN_PASTE_SOUP,
            BIBIMBAP,
            KALGUKSU,
            BULGOGI,
            TTEOKBOKKI,
            STIR_FRIED_PORK)),
    CHINESE("중식", List.of(
            KKANPUNGGI,
            FRIED_NOODLES,
            DONGPO_PORK,
            BLACK_BEAN_NOODLES,
            JJAMPPONG,
            MAPO_TOFU,
            SWEET_AND_SOUR_PORK,
            TOMATOES_STIR_FRIED_EGGS,
            RED_PEPPER_JAPCHAE)),
    ASIAN("아시안", List.of(
            PAD_THAI,
            KHAO_PAD,
            NASI_GORENG,
            PINEAPPLE_FRIED_RICE,
            RICE_NOODLES,
            TOM_YUM_GOONG,
            BANH_MI,
            VIETNAMESE_SSAM,
            BUN_CHA)),
    WESTERN("양식", List.of(
            LASAGNA,
            GRATIN,
            GNOCCHI,
            QUICHE,
            FRENCH_TOAST,
            BAGUETTE,
            SPAGHETTI,
            PIZZA,
            PANINI));

    private final String value;
    private final List<Menu> menus;

    Category(String value, List<Menu> menus) {
        this.value = value;
        this.menus = menus;
    }

    public String getValue() {
        return value;
    }
}
