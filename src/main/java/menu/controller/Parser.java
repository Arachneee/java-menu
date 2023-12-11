package menu.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.CoachName;
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

}
