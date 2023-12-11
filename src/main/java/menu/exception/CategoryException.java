package menu.exception;

public class CategoryException extends IllegalArgumentException{

    public CategoryException(final ErrorMessage errorMessage) {
        super(errorMessage.get());
    }
}
