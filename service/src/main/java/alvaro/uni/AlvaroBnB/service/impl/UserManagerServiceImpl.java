package alvaro.uni.AlvaroBnB.service.impl;

import alvaro.uni.AlvaroBnB.dao.UserDAO;
import alvaro.uni.AlvaroBnB.dao.exceptions.UserExceptions.UserAlreadyExistsException;
import alvaro.uni.AlvaroBnB.model.User;
import alvaro.uni.AlvaroBnB.model.helpClasses.CreditCard;
import alvaro.uni.AlvaroBnB.model.helpClasses.Gender;
import alvaro.uni.AlvaroBnB.model.helpClasses.Nationality;
import alvaro.uni.AlvaroBnB.service.UserManagerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

public class UserManagerServiceImpl implements UserManagerService {

    private static Logger LOG = LogManager.getLogger(UserManagerServiceImpl.class);
    private UserDAO userDAO;

    public UserManagerServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Collection<User> listUsers() {
        return userDAO.readUsers();
    }

    public Collection<User> listUsersByGender(Gender gender) {
        return userDAO.readUsersByGender(gender);
    }

    public Collection<User> listUsersByNationality(Nationality nationality) {
        Collection<User> result = new HashSet<User>();
        for(User user : userDAO.readUsers()){
            if(user.getNationality().equals(nationality)){
                result.add(user);
            }
        }
        return result;
    }

    public void createUser(String firstName, String lastName, Date birthDate, Gender gender, Nationality nationality, CreditCard creditCard) {
        User user = new User(firstName,lastName,birthDate,gender,nationality,creditCard);
        try {
            userDAO.createUser(user);
        } catch (UserAlreadyExistsException e) {
            LOG.warn(e.getMessage());
        }
    }
}
