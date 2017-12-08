package alvaro.uni.AlvaroBnB.model;

import alvaro.uni.AlvaroBnB.model.helpClasses.*;

import java.util.Date;

public class User {

    private final String firstName;
    private final String lastName;
    private final Date birthDate;
    private Gender gender;
    private Nationality nationality;
    private CreditCard creditCard;

    public User(String firstName, String lastName, Date birthDate, Gender gender, Nationality nationality, CreditCard creditCard) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.nationality = nationality;
        this.creditCard = creditCard;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public boolean isAdult(){
        Boolean res = false;
        if((new Date().getYear()-this.birthDate.getYear())>=18){
            res = true;
        }
        return res;
    }

    @Override
    public String toString() {
        return firstName +" " + lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof  User)){
            return false;
        }
        return firstName.equals(((User)obj).firstName) && lastName.equals(((User)obj).lastName);
    }
}
