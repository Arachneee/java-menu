package menu.domain;


public class Coach {

    private final CoachName coachName;

    public Coach(CoachName coachName) {
        this.coachName = coachName;
    }

    public static Coach from(final CoachName coachName) {
        return new Coach(coachName);
    }
}
