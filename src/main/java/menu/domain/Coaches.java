package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.exception.CoachException;
import menu.exception.ErrorMessage;

public class Coaches {

    private static final int MIN_COUNT = 2;
    private static final int MAX_COUNT = 5;

    private List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        this.coaches = coaches;
    }

    public static Coaches from(final List<CoachName> coachNames) {
        if (coachNames.size() < MIN_COUNT || coachNames.size() > MAX_COUNT) {
            throw new CoachException(ErrorMessage.INVALID_COACH_COUNT);
        }

        return createCoach(coachNames);
    }

    private static Coaches createCoach(final List<CoachName> coachNames) {
        return new Coaches(coachNames.stream()
                .map(Coach::from)
                .collect(Collectors.toList()));
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public Map<Coach, Menu> createMenu(final Category category, final Map<Week, Map<Coach, Menu>> weekMenu) {
        return coaches.stream()
                .collect(Collectors.toMap(coach -> coach,
                        coach -> getMenu(category, weekMenu, coach)));
    }

    private Menu getMenu(final Category category, final Map<Week, Map<Coach, Menu>> weekMenu, final Coach coach) {
        List<String> menus = category.getMenus();

        while (true) {
            String menuName = Randoms.shuffle(menus).get(0);
            Menu menu = Menu.from(menuName);

            if (coach.canNotEat(menu) || isDuplicate(menu, coach, weekMenu)) {
                continue;
            }

            return menu;
        }
    }

    private boolean isDuplicate(final Menu menu, final Coach coach, final Map<Week, Map<Coach, Menu>> weekMenu) {
        return weekMenu.values().stream()
                .map(menus -> menus.get(coach))
                .collect(Collectors.toList())
                .contains(menu);
    }
}
