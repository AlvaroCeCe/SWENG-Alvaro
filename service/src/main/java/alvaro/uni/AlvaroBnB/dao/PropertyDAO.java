package alvaro.uni.AlvaroBnB.dao;

import alvaro.uni.AlvaroBnB.dao.exceptions.propertyExceptions.PropertyAlreadyExistsException;
import alvaro.uni.AlvaroBnB.dao.exceptions.propertyExceptions.PropertyNotFoundException;
import alvaro.uni.AlvaroBnB.model.Property;
import alvaro.uni.AlvaroBnB.model.User;

import java.util.Collection;

public interface PropertyDAO {

    void createProperty(Property property) throws PropertyAlreadyExistsException;

    void updateProperty(Property property) throws PropertyNotFoundException;

    void deleteProperty(Property property) throws PropertyNotFoundException;

    Collection<Property> readProperties();

    Collection<Property> readPropertiesByOwner(User owner);

}

