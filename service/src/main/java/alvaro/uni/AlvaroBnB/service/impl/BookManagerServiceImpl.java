package alvaro.uni.AlvaroBnB.service.impl;

import alvaro.uni.AlvaroBnB.dao.exceptions.bookExceptions.BookNotFoundException;
import alvaro.uni.AlvaroBnB.dao.BookDAO;
import alvaro.uni.AlvaroBnB.dao.exceptions.bookExceptions.BookAlreadyExistsException;
import alvaro.uni.AlvaroBnB.model.Book;
import alvaro.uni.AlvaroBnB.model.Property;
import alvaro.uni.AlvaroBnB.model.User;
import alvaro.uni.AlvaroBnB.service.BookManagerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;


public class BookManagerServiceImpl implements BookManagerService
{


    private static Logger LOG = LogManager.getLogger(BookManagerServiceImpl.class);
    private BookDAO bookDAO;

    public BookManagerServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public void addBook(String bookID, Date bookDate, Property property, User user){
        Book book= new Book(bookID,bookDate,property,user);
        try {
            bookDAO.createBook(book);
        } catch (BookAlreadyExistsException e) {
            LOG.warn(e.getMessage());
        }

    }

    public void updateBook(String bookID, Date bookDate, Property property , User user){
        Book book = new Book(bookID,bookDate,property,user);
        try {
            bookDAO.updateBook(book);
        } catch (BookNotFoundException e) {
            LOG.warn(e.getMessage());
        }

    }


    public void deleteBook(Book book) {
        try {
            bookDAO.deleteBook(book);
        } catch (BookNotFoundException e) {
            LOG.warn(e.getMessage());
        }

    }


    public Collection<Book> listBooks() {
        return bookDAO.readBooks();
    }

    public Collection<Book> listBooksByUser(User user){
        Collection<Book> res = new HashSet<Book>();
            for (Book b:bookDAO.readBooks()){
                if(b.getUser().equals(user)){
                    res.add(b);
                }
            }
        return res;
    }


}
