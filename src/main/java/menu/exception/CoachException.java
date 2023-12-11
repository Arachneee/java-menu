package menu.exception;

public class CoachException extends IllegalArgumentException {

    public CoachException(final ErrorMessage errorMessage) {
        super(errorMessage.get());
    }
}
