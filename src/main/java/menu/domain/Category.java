package menu.domain;

import static menu.domain.Menu.BAGUETTE;
import static menu.domain.Menu.BANH_MI;
import static menu.domain.Menu.BIBIMBAP;
import static menu.domain.Menu.BLACK_BEAN_NOODLES;
import static menu.domain.Menu.BULGOGI;
import static menu.domain.Menu.BUN_CHA;
import static menu.domain.Menu.DONGPO_PORK;
import static menu.domain.Menu.FRENCH_TOAST;
import static menu.domain.Menu.FRIED_NOODLES;
import static menu.domain.Menu.GNOCCHI;
import static menu.domain.Menu.GRATIN;
import static menu.domain.Menu.GYUDON;
import static menu.domain.Menu.HIGH_RICE;
import static menu.domain.Menu.JJAMPPONG;
import static menu.domain.Menu.KALGUKSU;
import static menu.domain.Menu.KATSUDON;
import static menu.domain.Menu.KHAO_PAD;
import static menu.domain.Menu.KIMBAP;
import static menu.domain.Menu.KIMCHI_SOUP;
import static menu.domain.Menu.KKANPUNGGI;
import static menu.domain.Menu.LASAGNA;
import static menu.domain.Menu.MAPO_TOFU;
import static menu.domain.Menu.MISO_SOUP;
import static menu.domain.Menu.NASI_GORENG;
import static menu.domain.Menu.OKONOMIYAKI;
import static menu.domain.Menu.ONIGIRI;
import static menu.domain.Menu.PAD_THAI;
import static menu.domain.Menu.PANINI;
import static menu.domain.Menu.PINEAPPLE_FRIED_RICE;
import static menu.domain.Menu.PIZZA;
import static menu.domain.Menu.QUICHE;
import static menu.domain.Menu.RAMEN;
import static menu.domain.Menu.RED_PEPPER_JAPCHAE;
import static menu.domain.Menu.RICE_NOODLES;
import static menu.domain.Menu.SOY_BEAN_PASTE_SOUP;
import static menu.domain.Menu.SPAGHETTI;
import static menu.domain.Menu.SSAMBAP;
import static menu.domain.Menu.STIR_FRIED_PORK;
import static menu.domain.Menu.SUSHI;
import static menu.domain.Menu.SWEET_AND_SOUR_PORK;
import static menu.domain.Menu.TOMATOES_STIR_FRIED_EGGS;
import static menu.domain.Menu.TOM_YUM_GOONG;
import static menu.domain.Menu.TTEOKBOKKI;
import static menu.domain.Menu.UDON;
import static menu.domain.Menu.VIETNAMESE_SSAM;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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

    public static final String HEADER = "카테고리";
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

    public List<String> getMenus() {
        return menus.stream()
                .map(Menu::get)
                .collect(Collectors.toList());
    }
}
