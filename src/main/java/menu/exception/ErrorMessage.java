package menu.exception;

public enum ErrorMessage {

    BLANK_COACH_NAME("코치 이름이 비어있을 수 없습니다."),
    INVALID_COACH_NAME_LENGTH("코치 이름 길이가 적절하지 않습니다."),
    INVALID_COACH_COUNT("코치 수가 적절하지 않습니다.");

    private static final String PREFIX = "[ERROR]";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return PREFIX + message;
    }
}
