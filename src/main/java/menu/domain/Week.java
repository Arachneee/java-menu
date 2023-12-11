package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Week {

    MONDAY("월요일", 1),
    TUESDAY("화요일", 2),
    WEDNESDAY("수요일", 3),
    THURSDAY("목요일", 4),
    FRIDAY("금요일", 5);

    private static final String HEADER = "구분";
    private final String value;
    private final int order;

    Week(String value, int order) {
        this.value = value;
        this.order = order;
    }

    public static List<String> getValuesWithHeader() {
        List<String> values = new ArrayList<>();
        values.add(HEADER);
        values.addAll(Arrays.stream(values())
                .map(week -> week.value)
                .collect(Collectors.toList()));

        return values;
    }

    public int getOrder() {
        return order;
    }
}
