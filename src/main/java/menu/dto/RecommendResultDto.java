package menu.dto;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.CoachWeekMenu;
import menu.domain.Menu;
import menu.domain.Week;

public class RecommendResultDto {

    private final List<String> weeks;
    private final List<String> categorys;
    private final List<CoachMenuDto> coachMenuDtos;

    private RecommendResultDto(List<String> weeks, List<String> categorys, List<CoachMenuDto> coachMenuDtos) {
        this.weeks = weeks;
        this.categorys = categorys;
        this.coachMenuDtos = coachMenuDtos;
    }

    public static RecommendResultDto from(final CoachWeekMenu coachWeekMenu) {
        return new RecommendResultDto(Week.getValuesWithHeader(), Category.getValues(), createCoachMenuDto(coachWeekMenu));
    }

    private static List<CoachMenuDto> createCoachMenuDto(final CoachWeekMenu coachWeekMenu) {
        Set<Entry<Coach, Map<Week, Menu>>> coachMenus = coachWeekMenu.getEntries();

        return coachMenus.stream()
                .map(entry -> CoachMenuDto.of(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    public List<String> getWeeks() {
        return weeks;
    }

    public List<String> getCategorys() {
        return categorys;
    }

    public List<CoachMenuDto> getCoachMenuDtos() {
        return coachMenuDtos;
    }
}
