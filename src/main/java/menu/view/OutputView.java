package menu.view;

import static java.lang.System.lineSeparator;

public class OutputView {

    public void printStart() {
        System.out.println(Response.START.value);
    }

    public void printEnd() {
        System.out.println(lineSeparator() + Response.END.value);
    }

    public void printError(final String message) {
        System.out.println(message);
    }


    private enum Response {
        START("점심 메뉴 추천을 시작합니다."),
        END("추천을 완료했습니다.");

        private final String value;

        Response(String value) {
            this.value = value;
        }
    }
}
