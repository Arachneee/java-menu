package menu.domain;


import java.util.ArrayList;
import java.util.List;
import menu.exception.ErrorMessage;
import menu.exception.MenuException;

public class Coach {

    private static final int MAX_UNABLE_MENU_COUNT = 2;
    private final CoachName coachName;
    private List<Menu> unableMenu = new ArrayList<>();

    public Coach(CoachName coachName) {
        this.coachName = coachName;
    }

    public static Coach from(final CoachName coachName) {
        return new Coach(coachName);
    }

    public void addUnableMenuList(final List<Menu> menus) {
        if (menus.size() > MAX_UNABLE_MENU_COUNT) {
            throw new MenuException(ErrorMessage.INVALID_MENU_COUNT)
        }

        unableMenu.addAll(menus);
    }

    public String getName() {
        return coachName.getName();
    }
}
