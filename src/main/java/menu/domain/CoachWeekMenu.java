package menu.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CoachWeekMenu {

    private final Map<Coach, Map<Week, Menu>> menuTable;

    private CoachWeekMenu(Map<Coach, Map<Week, Menu>> menuTable) {
        this.menuTable = menuTable;
    }

    public static CoachWeekMenu create(final Coaches coaches, final WeekCategory weekCategory) {
        return new CoachWeekMenu(coaches.makeWeekMenu(weekCategory));
    }

    public Set<Entry<Coach, Map<Week, Menu>>> getEntries() {
        return Collections.unmodifiableSet(menuTable.entrySet());
    }
}
