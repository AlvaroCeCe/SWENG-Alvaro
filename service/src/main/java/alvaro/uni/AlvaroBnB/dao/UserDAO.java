package alvaro.uni.AlvaroBnB.dao;

import alvaro.uni.AlvaroBnB.dao.exceptions.UserExceptions.UserNotFoundException;
import alvaro.uni.AlvaroBnB.dao.exceptions.UserExceptions.UserAlreadyExistsException;
import alvaro.uni.AlvaroBnB.model.User;
import alvaro.uni.AlvaroBnB.model.helpClasses.Gender;

import java.util.Collection;

public interface UserDAO {

    void createUser(User user) throws UserAlreadyExistsException;

    void updateUser(User user) throws UserNotFoundException;

    void deleteUser(User user) throws UserNotFoundException;

    Collection<User> readUsers();

    Collection<User> readUsersByGender(Gender gender);
}
