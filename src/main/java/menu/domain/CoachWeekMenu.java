package menu.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CoachWeekMenu {

    private final Map<Week, Map<Coach, Menu>> menuTable;

    private CoachWeekMenu(Map<Week, Map<Coach, Menu>> menuTable) {
        this.menuTable = menuTable;
    }

    public static CoachWeekMenu create(final Coaches coaches, final WeekCategory weekCategory) {
        CoachWeekMenu coachWeekMenu = new CoachWeekMenu(weekCategory.makeWeekMenu(coaches));
        return coachWeekMenu;
    }

    public Set<Entry<Week, Map<Coach, Menu>>> getEntries() {
        return Collections.unmodifiableSet(menuTable.entrySet());
    }

    public Set<Coach> getCoaches() {
        Map<Coach, Menu> coachMenuMap = menuTable.get(Week.MONDAY);
        return coachMenuMap.keySet();
    }
}
