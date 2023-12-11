package menu.controller;

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
        Coaches coaches = getCoach();
    }

    private Coaches getCoach() {
        String coachNames = inputView.getCoachNames();

    }
}
