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
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;

public class UserManagerServiceImplTest {

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private Logger LOG = LogManager.getLogger(UserManagerServiceImpl.class);
    private UserManagerService service;

    @Before
    public void  setUp() throws ParseException, UserAlreadyExistsException {
        UserDAO userDAO = EasyMock.createMock(UserDAO.class);
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

        EasyMock.expect(userDAO.readUsers()).andReturn(Arrays.asList(alvaro,jose));
        userDAO.createUser(alvaro);
        EasyMock.expectLastCall().andThrow(new UserAlreadyExistsException("Alvaro Carnicero already exists!"));
        userDAO.createUser(dodo);
        EasyMock.replay(userDAO);
        service = new UserManagerServiceImpl(userDAO);
    }

    @Test
    public void TestLogging(){
        LOG.info("info");
        LOG.warn("warning");
        LOG.error("error");
        LOG.fatal("fatal");
    }

    @Test
    public void TestAllUsers() throws ParseException {
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

        Collection<User> expected = Arrays.asList(alvaro,jose);
        Collection<User> actual = service.listUsers();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }



    @Test
    public void CreateUserWhichExists() throws ParseException {

        CreditCard creditCard1 = new CreditCard(
                "123456789",
                "Alvaro Carnicero",
                "VISA",
                2020,
                404,
                12
        );

        service.createUser(
                "Alvaro",
                "Carnicero",
                dateFormat.parse("1996-05-11"),
                Gender.MALE,
                Nationality.ES,
                creditCard1);
    }

}
