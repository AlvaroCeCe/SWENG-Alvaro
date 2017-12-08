package alvaro.uni.AlvaroBnB.dao.exceptions.UserExceptions;


import alvaro.uni.AlvaroBnB.dao.exceptions.PersistenceException;

public class UserNotFoundException extends PersistenceException {

    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
