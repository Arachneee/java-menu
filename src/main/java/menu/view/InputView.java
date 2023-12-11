package menu.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static java.lang.System.lineSeparator;

public class InputView {

    public String getCoachNames() {
        System.out.println(Request.COACH_NAME.getWithEnter());
        return readLine();
    }

    private enum Request {
        COACH_NAME("코치의 이름을 입력해 주세요. (, 로 구분)");
        private final String value;

        Request(String value) {
            this.value = value;
        }

        public String getWithEnter() {
            return lineSeparator() + value;
        }
    }

}
