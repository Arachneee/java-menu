package menu.domain;

import java.util.Map;

public class CoachWeekMenu {

    private final Map<Coach, Map<Week, Menu>> menuTable;

    private CoachWeekMenu(Map<Coach, Map<Week, Menu>> menuTable) {
        this.menuTable = menuTable;
    }

    public static CoachWeekMenu create(final Coaches coaches, final WeekCategory weekCategory) {
        return new CoachWeekMenu(coaches.makeWeekMenu(weekCategory));
    }
}
