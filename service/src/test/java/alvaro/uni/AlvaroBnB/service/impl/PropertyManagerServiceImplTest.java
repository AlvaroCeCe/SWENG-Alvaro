package alvaro.uni.AlvaroBnB.service.impl;

import alvaro.uni.AlvaroBnB.dao.PropertyDAO;
import alvaro.uni.AlvaroBnB.dao.exceptions.UserExceptions.UserAlreadyExistsException;
import alvaro.uni.AlvaroBnB.dao.exceptions.propertyExceptions.PropertyAlreadyExistsException;
import alvaro.uni.AlvaroBnB.model.Property;
import alvaro.uni.AlvaroBnB.model.User;
import alvaro.uni.AlvaroBnB.model.helpClasses.CreditCard;
import alvaro.uni.AlvaroBnB.model.helpClasses.Gender;
import alvaro.uni.AlvaroBnB.model.helpClasses.Nationality;
import alvaro.uni.AlvaroBnB.service.PropertyManagerService;
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

public class PropertyManagerServiceImplTest {

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private Logger LOG = LogManager.getLogger(PropertyManagerServiceImpl.class);
    private PropertyManagerService service;

    @Before
    public void  setUp() throws ParseException, PropertyAlreadyExistsException {
        PropertyDAO propertyDAO= EasyMock.createMock(PropertyDAO.class);
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
        Double[] rates1 = {2.0,3.0,4.0};
        Property property1 = new Property(
                "property1",
                rates1,
                "Property number 1",
                "Miskolci Egyetem",
                alvaro
        );

        Double[] rates2 = {4.0,3.0,4.0};
        Property property2 = new Property(
                "property2",
                rates2,
                "Property number 2",
                "Sevilla",
                jose
        );
        Double[] rates3 = {4.0,5.0,5.0};
        Property property3 = new Property(
                "property3",
                rates3,
                "Property number 3",
                "Sevilla",
                alvaro
        );

        EasyMock.expect(propertyDAO.readProperties()).andReturn(Arrays.asList(property1,property2));
        propertyDAO.createProperty(property1);
        propertyDAO.createProperty(property2);
        propertyDAO.createProperty(property3);
        EasyMock.replay(propertyDAO);
        service = new PropertyManagerServiceImpl(propertyDAO);
    }

    @Test
    public void TestLogging(){
        LOG.info("info");
        LOG.warn("warning");
        LOG.error("error");
        LOG.fatal("fatal");
    }

    @Test
    public void TestAllProperties() throws ParseException{
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
        Double[] rates1 = {2.0,3.0,4.0};
        Property property1 = new Property(
                "property1",
                rates1,
                "Property number 1",
                "Miskolci Egyetem",
                alvaro
        );

        Double[] rates2 = {4.0,3.0,4.0};
        Property property2 = new Property(
                "property2",
                rates2,
                "Property number 2",
                "Sevilla",
                jose
        );

        Collection<Property> expected = Arrays.asList(property1,property2);
        Collection<Property> actual = service.listProperties();

       // Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }


}
