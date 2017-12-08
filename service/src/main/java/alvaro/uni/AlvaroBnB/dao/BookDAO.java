package alvaro.uni.AlvaroBnB.dao;


import alvaro.uni.AlvaroBnB.dao.exceptions.UserExceptions.UserNotFoundException;
import alvaro.uni.AlvaroBnB.dao.exceptions.bookExceptions.BookAlreadyExistsException;
import alvaro.uni.AlvaroBnB.dao.exceptions.bookExceptions.BookNotFoundException;
import alvaro.uni.AlvaroBnB.dao.exceptions.propertyExceptions.PropertyNotFoundException;
import alvaro.uni.AlvaroBnB.model.Book;
import alvaro.uni.AlvaroBnB.model.Property;
import alvaro.uni.AlvaroBnB.model.User;

import java.util.Collection;

public interface BookDAO {

    void createBook(Book book) throws BookAlreadyExistsException;

    void updateBook(Book book) throws BookNotFoundException;

    void deleteBook(Book book) throws BookNotFoundException;

    Collection<Book> readBooks();

    Collection<Book> readBooksByOwner(User owner) throws UserNotFoundException;


    Collection<Book> readBooksByPropertie(Property property) throws PropertyNotFoundException;

}
