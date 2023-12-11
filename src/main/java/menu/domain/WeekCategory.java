package menu.domain;

import java.util.Arrays;
import java.util.EnumMap;
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
            long count = weekCategory.values().stream()
                    .filter(category -> category.equals(selectedCategory))
                    .count();

            if (count >= MAX_CATEGORY_COUNT) {
                continue;
            }
            return selectedCategory;
        }

    }
}
