package alvaro.uni.AlvaroBnB.dao.exceptions.propertyExceptions;


import alvaro.uni.AlvaroBnB.dao.exceptions.PersistenceException;

public class PropertyNotFoundException extends PersistenceException {

    public PropertyNotFoundException() {
    }

    public PropertyNotFoundException(String message) {
        super(message);
    }

    public PropertyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
