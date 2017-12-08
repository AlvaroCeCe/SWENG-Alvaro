package alvaro.uni.AlvaroBnB.service.impl;

import alvaro.uni.AlvaroBnB.dao.BookDAO;
import alvaro.uni.AlvaroBnB.dao.UserDAO;
import alvaro.uni.AlvaroBnB.dao.exceptions.UserExceptions.UserAlreadyExistsException;
import alvaro.uni.AlvaroBnB.dao.exceptions.bookExceptions.BookAlreadyExistsException;
import alvaro.uni.AlvaroBnB.model.Book;
import alvaro.uni.AlvaroBnB.model.Property;
import alvaro.uni.AlvaroBnB.model.User;
import alvaro.uni.AlvaroBnB.model.helpClasses.CreditCard;
import alvaro.uni.AlvaroBnB.model.helpClasses.Gender;
import alvaro.uni.AlvaroBnB.model.helpClasses.Nationality;
import alvaro.uni.AlvaroBnB.service.BookManagerService;
import alvaro.uni.AlvaroBnB.service.UserManagerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class BookManagerServiceImplTest {

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private Logger LOG = LogManager.getLogger(BookManagerServiceImpl.class);
    private BookManagerService service;

    @Before
    public void  setUp() throws ParseException,BookAlreadyExistsException {
        BookDAO bookDAO = EasyMock.createMock(BookDAO.class);
        CreditCard creditCard1 = new CreditCard(
                "123456789",
                "Alvaro Carnicero",
                "VISA",
                2020,
                404,
                12
        );
        CreditCard creditCard2 = new CreditCard(
                "987654321",
                "Jose Ortiz",
                "VISA",
                2022,
                505,
                10
        );
        CreditCard creditCard3 = new CreditCard(
                "123789456",
                "Dodo Lillo",
                "VISA",
                2024,
                606,
                11
        );
        User alvaro = new User(
                "Alvaro",
                "Carnicero",
                dateFormat.parse("1996-05-11"),
                Gender.MALE,
                Nationality.ES,
                creditCard1);
        User jose = new User(
                "Jose",
                "Ortiz",
                dateFormat.parse("1996-02-10"),
                Gender.MALE,
                Nationality.ES,
                creditCard2);
        User dodo = new User(
                "Dodo",
                "Lillo",
                dateFormat.parse("1996-05-09"),
                Gender.MALE,
                Nationality.IT,
                creditCard3);
        Double[] rates1 = {2.0, 3.0, 4.0};
        Property property1 = new Property(
                "property1",
                rates1,
                "Property number 1",
                "Miskolci Egyetem",
                alvaro
        );

        Double[] rates2 = {4.0, 3.0, 4.0};
        Property property2 = new Property(
                "property2",
                rates2,
                "Property number 2",
                "Sevilla",
                jose
        );
        Double[] rates3 = {4.0, 5.0, 5.0};
        Property property3 = new Property(
                "property3",
                rates3,
                "Property number 3",
                "Sevilla",
                alvaro
        );

        Book book1 = new Book(
                "book01",
                dateFormat.parse("2017-09-15"),
                property1,
                alvaro
        );

        EasyMock.expect(bookDAO.readBooks()).andReturn(Arrays.asList(book1));
        bookDAO.createBook(book1);
        EasyMock.replay(bookDAO);
        service = new BookManagerServiceImpl(bookDAO);
    }

    @Test
    public void TestLogging(){
        LOG.info("info");
        LOG.warn("warning");
        LOG.error("error");
        LOG.fatal("fatal");
    }

    @Test
    public void TestAllBooks() throws ParseException {
        CreditCard creditCard1 = new CreditCard(
                "123456789",
                "Alvaro Carnicero",
                "VISA",
                2020,
                404,
                12
        );
        User alvaro = new User(
                "Alvaro",
                "Carnicero",
                dateFormat.parse("1996-05-11"),
                Gender.MALE,
                Nationality.ES,
                creditCard1);
        Double[] rates1 = {2.0, 3.0, 4.0};
        Property property1 = new Property(
                "property1",
                rates1,
                "Property number 1",
                "Miskolci Egyetem",
                alvaro
        );

        Book book1 = new Book(
                "book01",
                dateFormat.parse("2017-09-15"),
                property1,
                alvaro
        );

        Collection<Book> expected = Arrays.asList(book1);
        Collection<Book> actual = service.listBooks();

        //Assert.assertEquals(actual.toArray());
    }
}

