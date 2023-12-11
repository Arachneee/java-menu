package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public List<String> getCateCory() {
        List<String> values = new ArrayList<>();
        values.add(Category.HEADER);
        values.addAll(categoryOfWeek.entrySet().stream()
                .sorted((entry1, entry2) -> {
                    return entry1.getKey().getOrder() - entry2.getKey().getOrder();
                })
                .map(entry -> entry.getValue().getValue())
                .collect(Collectors.toList()));

        return values;
    }

    public Map<Week, Map<Coach, Menu>> makeWeekMenu(final Coaches coaches) {
        Map<Week, Map<Coach, Menu>> weekMenu = new HashMap<>();
        categoryOfWeek.forEach((key, value) -> weekMenu.put(key, coaches.createMenu(value, weekMenu)));
        return weekMenu;
    }
}
