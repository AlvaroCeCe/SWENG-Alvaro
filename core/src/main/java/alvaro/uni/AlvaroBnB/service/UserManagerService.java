package alvaro.uni.AlvaroBnB.service;


import alvaro.uni.AlvaroBnB.model.User;
import alvaro.uni.AlvaroBnB.model.helpClasses.CreditCard;
import alvaro.uni.AlvaroBnB.model.helpClasses.Gender;
import alvaro.uni.AlvaroBnB.model.helpClasses.Nationality;

import java.util.Collection;
import java.util.Date;


public interface UserManagerService {


    public Collection<User> listUsers();

    public Collection<User> listUsersByGender(Gender gender);

    public Collection<User> listUsersByNationality(Nationality nationality);


    public void createUser(String firstName, String lastName, Date birthDate, Gender gender, Nationality nationality, CreditCard creditCard);

}
