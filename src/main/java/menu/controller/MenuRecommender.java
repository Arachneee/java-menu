package menu.controller;

import java.util.List;
import menu.domain.CoachName;
import menu.domain.Coaches;
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
    }

    private List<CoachName> getCoachNames() {
        String coachNameSource = inputView.getCoachNames();
        return Parser.convertToCoachNames(coachNameSource);
    }
}
