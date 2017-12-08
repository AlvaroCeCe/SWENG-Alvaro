package alvaro.uni.AlvaroBnB.dao.exceptions.propertyExceptions;


import alvaro.uni.AlvaroBnB.dao.exceptions.PersistenceException;

public class PropertyAlreadyExistsException extends PersistenceException {

    public PropertyAlreadyExistsException() {
    }

    public PropertyAlreadyExistsException(String message) {
        super(message);
    }

    public PropertyAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
