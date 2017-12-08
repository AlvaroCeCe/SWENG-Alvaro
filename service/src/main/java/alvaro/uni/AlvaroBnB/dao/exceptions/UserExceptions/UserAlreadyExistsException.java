package alvaro.uni.AlvaroBnB.dao.exceptions.UserExceptions;


import alvaro.uni.AlvaroBnB.dao.exceptions.PersistenceException;

public class UserAlreadyExistsException extends PersistenceException {

    public UserAlreadyExistsException() {
    }

    public UserAlreadyExistsException(String message) {
        super(message);
    }

    public UserAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
