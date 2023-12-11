package menu.domain;

import menu.exception.CoachException;
import menu.exception.ErrorMessage;

public class CoachName {

    private static final int MIN_LENGTH = 2;
    private static final int MAX_LENGTH = 4;
    private final String name;

    private CoachName(String name) {
        this.name = name;
    }

    public static CoachName from(final String name) {
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new CoachException(ErrorMessage.INVALID_COACH_NAME_LENGTH);
        }

        return new CoachName(name);
    }

    public String getName() {
        return name;
    }
}
