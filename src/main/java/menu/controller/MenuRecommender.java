package menu.controller;

import java.util.List;
import menu.domain.Coach;
import menu.domain.CoachName;
import menu.domain.Coaches;
import menu.domain.Menu;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuRecommender {

    private final InputView inputView;
    private final OutputView outputView;

    public MenuRecommender(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        outputView.printStart();
        run();
        outputView.printEnd();
    }

    private void run() {
        List<CoachName> coachNames = getCoachNames();
        Coaches coaches = Coaches.from(coachNames);
        getUnableMenus(coaches);

    }

    private List<CoachName> getCoachNames() {
        String coachNameSource = inputView.enterCoachNames();
        return Parser.convertToCoachNames(coachNameSource);
    }

    private void getUnableMenus(final Coaches coaches) {
        List<Coach> allCoach = coaches.getCoaches();
        allCoach.forEach(this::getUnableMenu);
    }

    private void getUnableMenu(final Coach coach) {
        String unableMenuSource = inputView.enterUnableMenus(coach.getName());
        List<Menu> unableMenus = Parser.convertToMenus(unableMenuSource);

        coach.addUnableMenuList(unableMenus);
    }
}
