package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeekCategory {

    private static final long MAX_CATEGORY_COUNT = 2L;
    private final Map<Week, Category> categoryOfWeek;

    private WeekCategory(Map<Week, Category> categoryOfWeek) {
        this.categoryOfWeek = categoryOfWeek;
    }

    public static WeekCategory createByRandomNumber(final NumberGenerator numberGenerator) {
        EnumMap<Week, Category> weekCategory = new EnumMap<>(Week.class);
        Arrays.stream(Week.values())
                .forEach(week -> weekCategory.put(week, getCategory(numberGenerator, weekCategory)));

        return new WeekCategory(weekCategory);
    }

    private static Category getCategory(final NumberGenerator numberGenerator,
            final EnumMap<Week, Category> weekCategory) {
        while (true) {
            Category selectedCategory = Category.orderOf(numberGenerator.generate());
            if (isOverCount(weekCategory, selectedCategory)) {
                continue;
            }

            return selectedCategory;
        }
    }

    private static boolean isOverCount(final EnumMap<Week, Category> weekCategory, final Category selectedCategory) {
        return weekCategory.values().stream()
                .filter(category -> category.equals(selectedCategory))
                .count() >= MAX_CATEGORY_COUNT;
    }

    public Map<Week, Menu> createMenu(final Coach coach) {
        Map<Week, Menu> weekMenu = new HashMap<>();
        categoryOfWeek.forEach((key, value) -> weekMenu.put(key, getMenu(value, coach, weekMenu)));

        return weekMenu;
    }

    private Menu getMenu(final Category category, final Coach coach, final Map<Week, Menu> weekMenu) {
        List<String> menus = category.getMenus();

        while (true) {
            String menuName = Randoms.shuffle(menus).get(0);
            Menu menu = Menu.from(menuName);

            if (coach.canEat(menu) || isDuplicate(menu, weekMenu)) {
                continue;
            }

            return menu;
        }
    }

    private boolean isDuplicate(final Menu menu, final Map<Week, Menu> weekMenu) {
        return weekMenu.containsValue(menu);
    }
}
