package alvaro.uni.AlvaroBnB.service;


import alvaro.uni.AlvaroBnB.model.*;
import java.util.Collection;
import java.util.Date;

public interface BookManagerService {


    public Collection<Book> listBooks();
    public Collection<Book> listBooksByUser(User user);

    void addBook(String bookID, Date bookDate, Property property, User user);

}
