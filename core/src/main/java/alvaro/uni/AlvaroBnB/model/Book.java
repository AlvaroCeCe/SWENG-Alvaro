package alvaro.uni.AlvaroBnB.model;

import java.util.Date;

public class Book{

    private String BookID;
    private Date BookDate;
    private Property property;
    private User user;

    public Book(String bookID, Date bookDate, Property property, User user) {
        BookID = bookID;
        BookDate = bookDate;
        this.property = property;
        this.user = user;
    }

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String bookID) {
        BookID = bookID;
    }

    public Date getBookDate() {
        return BookDate;
    }

    public void setBookDate(Date bookDate) {
        BookDate = bookDate;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}