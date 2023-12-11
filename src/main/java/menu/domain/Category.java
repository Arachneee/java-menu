package menu.domain;

import static menu.domain.Menu.*;

import java.util.Arrays;
import java.util.List;
import menu.exception.CategoryException;
import menu.exception.ErrorMessage;

public enum Category {

    JAPANESE("일식", 1, List.of(
            GYUDON,
            UDON,
            MISO_SOUP,
            SUSHI,
            KATSUDON,
            ONIGIRI,
            HIGH_RICE,
            RAMEN,
            OKONOMIYAKI)),
    KOREAN("한식", 2, List.of(
            KIMBAP,
            KIMCHI_SOUP,
            SSAMBAP,
            SOY_BEAN_PASTE_SOUP,
            BIBIMBAP,
            KALGUKSU,
            BULGOGI,
            TTEOKBOKKI,
            STIR_FRIED_PORK)),
    CHINESE("중식", 3, List.of(
            KKANPUNGGI,
            FRIED_NOODLES,
            DONGPO_PORK,
            BLACK_BEAN_NOODLES,
            JJAMPPONG,
            MAPO_TOFU,
            SWEET_AND_SOUR_PORK,
            TOMATOES_STIR_FRIED_EGGS,
            RED_PEPPER_JAPCHAE)),
    ASIAN("아시안", 4, List.of(
            PAD_THAI,
            KHAO_PAD,
            NASI_GORENG,
            PINEAPPLE_FRIED_RICE,
            RICE_NOODLES,
            TOM_YUM_GOONG,
            BANH_MI,
            VIETNAMESE_SSAM,
            BUN_CHA)),
    WESTERN("양식", 5, List.of(
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
    private final int order;
    private final List<Menu> menus;

    Category(String value, int order, List<Menu> menus) {
        this.value = value;
        this.order = order;
        this.menus = menus;
    }

    public static Category orderOf(final int order) {
        return Arrays.stream(values())
                .filter(value -> value.order == order)
                .findAny()
                .orElseThrow(() -> new CategoryException(ErrorMessage.INVALID_CATETORY_ORDER));
    }

    public String getValue() {
        return value;
    }
}
