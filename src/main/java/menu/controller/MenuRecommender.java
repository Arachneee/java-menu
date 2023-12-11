package menu.controller;

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
    }
}
