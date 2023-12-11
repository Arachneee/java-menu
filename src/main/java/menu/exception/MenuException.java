package menu.exception;

public class MenuException extends IllegalArgumentException {

    public MenuException(final ErrorMessage errorMessage) {
        super(errorMessage.get());
    }
}
