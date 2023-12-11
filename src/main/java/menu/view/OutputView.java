package menu.view;

import static java.lang.System.lineSeparator;

import java.util.List;
import java.util.stream.Collectors;
import menu.dto.CoachMenuDto;
import menu.dto.RecommendResultDto;

public class OutputView {

    public void printStart() {
        System.out.println(Response.START.value);
    }

    public void printError(final String message) {
        System.out.println(message);
    }

    public void printResult(final RecommendResultDto recommendResultDto) {
        System.out.println(Response.RESULT.value);
        printWeek(recommendResultDto.getWeeks());
        printCategory(recommendResultDto.getCategorys());
        printCoachMenus(recommendResultDto.getCoachMenuDtos());
        System.out.println(lineSeparator() + Response.END.value);
    }

    private void printWeek(List<String> weeks) {
        System.out.println(weeks.stream()
                .collect(Collectors.joining(" | ", "[ ", " ]")));
    }

    private void printCategory(List<String> categorys) {
        System.out.println(categorys.stream()
                .collect(Collectors.joining(" | ", "[ ", " ]")));
    }

    private void printCoachMenus(List<CoachMenuDto> coachMenuDtos) {
        coachMenuDtos.forEach(coachMenuDto -> printCoachMenu(coachMenuDto.getCoachMenus()));
    }

    private void printCoachMenu(List<String> coachMenuDto) {
        System.out.println(coachMenuDto.stream()
                .collect(Collectors.joining(" | ", "[ ", " ]")));
    }


    private enum Response {
        START("점심 메뉴 추천을 시작합니다."),
        END("추천을 완료했습니다."),
        RESULT(System.lineSeparator() + "메뉴 추천 결과입니다.");

        private final String value;

        Response(String value) {
            this.value = value;
        }
    }
}
