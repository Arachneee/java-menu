package menu.domain;

import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.Map;
import menu.exception.ErrorMessage;
import menu.exception.MenuException;

public enum Menu {
    GYUDON("규동"),
    UDON("우동"),
    MISO_SOUP("미소시루"),
    SUSHI("스시"),
    KATSUDON("가츠동"),
    ONIGIRI("오니기리"),
    HIGH_RICE("하이라이스"),
    RAMEN("라멘"),
    OKONOMIYAKI("오코노미야끼"),
    KIMBAP("김밥"),
    KIMCHI_SOUP("김치찌개"),
    SSAMBAP("쌈밥"),
    SOY_BEAN_PASTE_SOUP("된장찌개"),
    BIBIMBAP("비빔밥"),
    KALGUKSU("칼국수"),
    BULGOGI("불고기"),
    TTEOKBOKKI("떡볶이"),
    STIR_FRIED_PORK("제육볶음"),
    KKANPUNGGI("깐풍기"),
    FRIED_NOODLES("볶음면"),
    DONGPO_PORK("동파육"),
    BLACK_BEAN_NOODLES("짜장면"),
    JJAMPPONG("짬뽕"),
    MAPO_TOFU("마파두부"),
    SWEET_AND_SOUR_PORK("탕수육"),
    TOMATOES_STIR_FRIED_EGGS("토마토 달걀볶음"),
    RED_PEPPER_JAPCHAE("고추잡채"),
    PAD_THAI("팟타이"),
    KHAO_PAD("카오 팟"),
    NASI_GORENG("나시고렝"),
    PINEAPPLE_FRIED_RICE("파인애플 볶음밥"),
    RICE_NOODLES("쌀국수"),
    TOM_YUM_GOONG("똠얌꿍"),
    BANH_MI("반미"),
    VIETNAMESE_SSAM("월남쌈"),
    BUN_CHA("분짜"),
    LASAGNA("라자냐"),
    GRATIN("그라탱"),
    GNOCCHI("뇨끼"),
    QUICHE("끼슈"),
    FRENCH_TOAST("프렌치 토스트"),
    BAGUETTE("바게트"),
    SPAGHETTI("스파게티"),
    PIZZA("피자"),
    PANINI("파니니");

    private static final Map<String, Menu> menus= Arrays.stream(values())
            .collect(toMap(menu -> menu.name, menu -> menu));
    private final String name;

    Menu(String name) {
        this.name = name;
    }

    public static Menu from(String name) {
        return menus.computeIfAbsent(name, key -> {
            throw new MenuException(ErrorMessage.INVALID_MENU_NAME);
        });
    }

    public String get() {
        return name;
    }
}
