package alvaro.uni.AlvaroBnB.dao.exceptions.bookExceptions;


import alvaro.uni.AlvaroBnB.dao.exceptions.PersistenceException;

public class BookNotFoundException extends PersistenceException {

    public BookNotFoundException() {
    }

    public BookNotFoundException(String message) {
        super(message);
    }

    public BookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
