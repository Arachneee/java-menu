package menu.domain;


import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final CoachName coachName;
    private List<Menu> unableMenu = new ArrayList<>();

    public Coach(CoachName coachName) {
        this.coachName = coachName;
    }

    public static Coach from(final CoachName coachName) {
        return new Coach(coachName);
    }

    public void addUnableMenuList(final List<Menu> menus) {
        unableMenu.addAll(menus);
    }

    public String getName() {
        return coachName.getName();
    }
}
