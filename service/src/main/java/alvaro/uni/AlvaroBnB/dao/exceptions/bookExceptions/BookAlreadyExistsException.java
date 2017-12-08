package alvaro.uni.AlvaroBnB.dao.exceptions.bookExceptions;


import alvaro.uni.AlvaroBnB.dao.exceptions.PersistenceException;

public class BookAlreadyExistsException extends PersistenceException {

    public BookAlreadyExistsException() {
    }

    public BookAlreadyExistsException(String message) {
        super(message);
    }

    public BookAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
