package menu.controller;

import static java.util.regex.Pattern.compile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import menu.domain.CoachName;
import menu.domain.Menu;
import menu.exception.CoachException;
import menu.exception.ErrorMessage;

public final class Parser {

    private static final String SEPARATOR = ",";
    private static final Pattern PATTERN = compile("^[가-힣\\w\\s]+(?:,[가-힣\\w\\s]+)*$");
    private Parser() {
    }

    public static List<CoachName> convertToCoachNames(final String source) {
        if (source.isBlank()) {
            throw new CoachException(ErrorMessage.BLANK_COACH_NAME);
        }

        validateMenuFormat(source);

        return createCoachNames(source);
    }

    private static void validateMenuFormat(final String input) {
        final Matcher matcher = PATTERN.matcher(input);

        if (matcher.matches()) {
            return;
        }

        throw new CoachException(ErrorMessage.INVALID_FORMAT);
    }

    private static List<CoachName> createCoachNames(final String source) {
        return Arrays.stream(source.split(SEPARATOR))
                .map(name -> CoachName.from(name.trim()))
                .collect(Collectors.toList());
    }

    public static List<Menu> convertToMenus(final String source) {
        if (source.isBlank()) {
            return new ArrayList<>();
        }

        validateMenuFormat(source);

        return createMenus(source);
    }

    private static List<Menu> createMenus(final String source) {
        return Arrays.stream(source.split(SEPARATOR))
                .map(menu -> Menu.from(menu.trim()))
                .collect(Collectors.toList());
    }
}
