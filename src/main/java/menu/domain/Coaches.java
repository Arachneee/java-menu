package menu.domain;

import java.util.List;
import java.util.stream.Collectors;
import menu.exception.CoachException;
import menu.exception.ErrorMessage;

public class Coaches {

    private static final int MIN_COUNT = 2;
    private static final int MAX_COUNT = 5;

    private List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public static Coaches from(final List<CoachName> coachNames) {
        if (coachNames.size() < MIN_COUNT || coachNames.size() > MAX_COUNT) {
            throw new CoachException(ErrorMessage.INVALID_COACH_COUNT);
        }

        return createCoach(coachNames);
    }

    private static Coaches createCoach(final List<CoachName> coachNames) {
        return new Coaches(coachNames.stream()
                .map(Coach::from)
                .collect(Collectors.toList()));
    }

}
