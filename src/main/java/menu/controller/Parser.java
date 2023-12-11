package menu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.CoachName;
import menu.domain.Menu;
import menu.exception.CoachException;
import menu.exception.ErrorMessage;

public final class Parser {

    private static final String SEPARATOR = ",";
    private Parser() {
    }

    public static List<CoachName> convertToCoachNames(final String source) {
        if (source.isBlank()) {
            throw new CoachException(ErrorMessage.BLANK_COACH_NAME);
        }

        return createCoachNames(source);
    }

    private static List<CoachName> createCoachNames(final String source) {
        return Arrays.stream(source.split(SEPARATOR))
                .map(CoachName::from)
                .collect(Collectors.toList());
    }

    public static List<Menu> convertToMenus(final String source) {
        if (source.isBlank()) {
            return new ArrayList<>();
        }

        return createMenus(source);
    }

    private static List<Menu> createMenus(final String source) {
        return Arrays.stream(source.split(SEPARATOR))
                .map(Menu::from)
                .collect(Collectors.toList());
    }
}
