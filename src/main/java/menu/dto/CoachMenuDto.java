package menu.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.Week;

public class CoachMenuDto {
    private final List<String> coachMenus;

    private CoachMenuDto(List<String> coachMenus) {
        this.coachMenus = coachMenus;
    }

    public static CoachMenuDto of(final Coach coach, final Map<Week, Menu> weekMenu) {
        List<String> values = new ArrayList<>();
        values.add(coach.getName());
        values.addAll(weekMenu.values().stream()
                .map(Menu::get)
                .collect(Collectors.toList()));

        return new CoachMenuDto(values);
    }

    public List<String> getCoachMenus() {
        return coachMenus;
    }
}
