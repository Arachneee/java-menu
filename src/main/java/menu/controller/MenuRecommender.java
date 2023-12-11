package menu.controller;

import java.util.List;
import java.util.function.Supplier;
import menu.domain.Coach;
import menu.domain.CoachName;
import menu.domain.CoachWeekMenu;
import menu.domain.Coaches;
import menu.domain.Menu;
import menu.domain.RandomNumberGenerator;
import menu.domain.WeekCategory;
import menu.dto.RecommendResultDto;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuRecommender {

    private final InputView inputView;
    private final OutputView outputView;

    public MenuRecommender(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStart();

        List<CoachName> coachNames = getCoachNames();
        Coaches coaches = Coaches.from(coachNames);

        getUnableMenus(coaches);

        WeekCategory weekCategory = WeekCategory.createByRandomNumber(new RandomNumberGenerator());
        CoachWeekMenu coachWeekMenu = CoachWeekMenu.create(coaches, weekCategory);

        RecommendResultDto recommendResultDto = RecommendResultDto.of(weekCategory, coachWeekMenu);
        outputView.printResult(recommendResultDto);
    }

    private List<CoachName> getCoachNames() {
        return getByRoof(() -> {
            String coachNameSource = inputView.enterCoachNames();
            return Parser.convertToCoachNames(coachNameSource);
        });
    }

    private void getUnableMenus(final Coaches coaches) {
        List<Coach> allCoach = coaches.getCoaches();
        allCoach.forEach(this::getUnableMenu);
    }

    private void getUnableMenu(final Coach coach) {
        List<Menu> unableMenus = getByRoof(() -> {
            String unableMenuSource = inputView.enterUnableMenus(coach.getName());
            return Parser.convertToMenus(unableMenuSource);
        });

        coach.addUnableMenuList(unableMenus);
    }

    private <T> T getByRoof(final Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException exception) {
                outputView.printError(exception.getMessage());
            }
        }
    }
}
