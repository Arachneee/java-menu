package menu.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.System.lineSeparator;

public class InputView {

    public String enterCoachNames() {
        System.out.println(Request.COACH_NAME.getWithEnter());
        return readLine();
    }

    public String enterUnableMenus(final String name) {
        System.out.printf(Request.UNABLE_MENUS_FORMAT.getWithEnter(), name);
        return readLine();
    }

    private enum Request {
        COACH_NAME("코치의 이름을 입력해 주세요. (, 로 구분)"),
        UNABLE_MENUS_FORMAT("%s(이)가 못 먹는 메뉴를 입력해 주세요." + lineSeparator());
        private final String value;

        Request(String value) {
            this.value = value;
        }

        public String getWithEnter() {
            return lineSeparator() + value;
        }
    }

}
