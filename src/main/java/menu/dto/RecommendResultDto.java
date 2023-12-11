package menu.dto;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.domain.CoachWeekMenu;
import menu.domain.Menu;
import menu.domain.Week;
import menu.domain.WeekCategory;

public class RecommendResultDto {

    private final List<String> weeks;
    private final List<String> categorys;
    private final List<CoachMenuDto> coachMenuDtos;

    private RecommendResultDto(List<String> weeks, List<String> categorys, List<CoachMenuDto> coachMenuDtos) {
        this.weeks = weeks;
        this.categorys = categorys;
        this.coachMenuDtos = coachMenuDtos;
    }

    public static RecommendResultDto of(final WeekCategory weekCategory, final CoachWeekMenu coachWeekMenu) {
        return new RecommendResultDto(Week.getValuesWithHeader(), weekCategory.getCateCory(), createCoachMenuDto(coachWeekMenu));
    }

    private static List<CoachMenuDto> createCoachMenuDto(final CoachWeekMenu coachWeekMenu) {
        Set<Coach> coaches = coachWeekMenu.getCoaches();

        Set<Entry<Week, Map<Coach, Menu>>> coachMenus = coachWeekMenu.getEntries();

        List<Map<Coach, Menu>> collect = coachMenus.stream()
                .sorted((entry1, entry2) -> entry1.getKey().getOrder() - entry2.getKey().getOrder())
                .map(Entry::getValue)
                .collect(Collectors.toList());

        return coaches.stream()
                .map(coach -> CoachMenuDto.of(coach, collect.stream()
                        .map(menus -> menus.get(coach))
                        .collect(Collectors.toList())))
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
