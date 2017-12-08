package alvaro.uni.AlvaroBnB.service.impl;

import alvaro.uni.AlvaroBnB.dao.PropertyDAO;
import alvaro.uni.AlvaroBnB.dao.exceptions.propertyExceptions.PropertyAlreadyExistsException;
import alvaro.uni.AlvaroBnB.model.Property;
import alvaro.uni.AlvaroBnB.model.User;
import alvaro.uni.AlvaroBnB.service.PropertyManagerService;

import java.util.Collection;
import java.util.HashSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PropertyManagerServiceImpl implements PropertyManagerService {

    private static Logger LOG = LogManager.getLogger(PropertyManagerServiceImpl.class);
    private PropertyDAO propertyDAO;

    public PropertyManagerServiceImpl(PropertyDAO propertyDAO) {
        this.propertyDAO = propertyDAO;
    }

    public Collection<Property> listProperties() {
        return propertyDAO.readProperties();
    }

    public Collection<Property> listPropertiesByRate(Double rate) {
      Collection<Property> res = new HashSet<Property>();
        for(Property p:propertyDAO.readProperties()){
            if(p.getRate()>=rate){
                res.add(p);
            }
        }
        return res;
    }

    public Collection<Property> listPropertiesByOwner(User owner) {
        return propertyDAO.readPropertiesByOwner(owner);
    }

    public void createProperty(String name, Double[] rates, String description, String address, User owner) {
        Property property = new Property(name,rates,description,address,owner);
        try {
            propertyDAO.createProperty(property);
        } catch (PropertyAlreadyExistsException e) {
            LOG.warn(e.getMessage());
        }
    }


}
