package menu.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Week {

    MONDAY("월요일"),
    TUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일");

    private static final String HEADER = "구분";
    private final String value;

    Week(String value) {
        this.value = value;
    }

    public static List<String> getValuesWithHeader() {
        List<String> values = new ArrayList<>();
        values.add(HEADER);
        values.addAll(Arrays.stream(values())
                .map(week -> week.value)
                .collect(Collectors.toList()));

        return values;
    }
}
