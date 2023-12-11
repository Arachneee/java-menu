package menu.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.domain.Menu;

public class CoachMenuDto {

    private final List<String> coachMenus;

    private CoachMenuDto(List<String> coachMenus) {
        this.coachMenus = coachMenus;
    }

    public static CoachMenuDto of(final Coach coach, final List<Menu> collect) {
        List<String> coachMenus = new ArrayList<>();
        coachMenus.add(coach.getName());
        coachMenus.addAll(collect.stream()
                .map(Menu::get)
                .collect(Collectors.toList()));

        return new CoachMenuDto(coachMenus);
    }

    public List<String> getCoachMenus() {
        return coachMenus;
    }
}
