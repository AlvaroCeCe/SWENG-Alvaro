package alvaro.uni.AlvaroBnB.service;

import alvaro.uni.AlvaroBnB.model.Property;
import alvaro.uni.AlvaroBnB.model.User;
import alvaro.uni.AlvaroBnB.model.helpClasses.CreditCard;
import alvaro.uni.AlvaroBnB.model.helpClasses.Gender;
import alvaro.uni.AlvaroBnB.model.helpClasses.Nationality;

import java.util.Collection;
import java.util.Date;

public interface PropertyManagerService {

    Collection<Property> listProperties();

    Collection<Property> listPropertiesByRate(Double rate);

    Collection<Property> listPropertiesByOwner(User owner);

    public void createProperty(String name, Double[] rates, String description, String address, User owner);
}
