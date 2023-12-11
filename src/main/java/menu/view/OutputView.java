package menu.view;

public class OutputView {

    public void printStart() {
        System.out.println(Response.START.value);
    }



    private enum Response {
        START("점심 메뉴 추천을 시작합니다.");

        private final String value;

        Response(String value) {
            this.value = value;
        }
    }
}
