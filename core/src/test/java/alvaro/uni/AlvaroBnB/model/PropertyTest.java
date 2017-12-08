package alvaro.uni.AlvaroBnB.model;

import alvaro.uni.AlvaroBnB.model.helpClasses.CreditCard;
import alvaro.uni.AlvaroBnB.model.helpClasses.Gender;
import alvaro.uni.AlvaroBnB.model.helpClasses.Nationality;
import org.junit.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PropertyTest {

    Property property;

    @BeforeClass
    public static void beforeClass(){
    }

    @AfterClass
    public static  void afterClass(){
    }

    @Before
    public void setUp() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CreditCard creditCard = new CreditCard(
                "123456789",
                "Álvaro Carnicero",
                "VISA",
                2020,
                101,
                06
        );
        Date date1 = dateFormat.parse("1996-05-11");
        User owner= new User(
                "Alvaro",
                "Carnicero",
                date1,
                Gender.MALE,
                Nationality.ES,
                creditCard);
        Double[] rates = {5.0,2.5,3.0,4.5,5.0};
        this.property = new Property(
                "property1",
                rates,
                "Property number 1",
                "Miskolci Egyetem",
                owner
        );
    }

    @After
    public void tearDown(){
    }

     @Test
    public void testPropertyName(){
         Assert.assertEquals(property.getName(), "property1");
     }

    @Test
    public void testPropertyRateGreaterThan3(){
        Assert.assertTrue(property.getRate()>3.0);
    }

    @Test
    public void testPropertyOwnerIsAdult(){
        Assert.assertTrue(property.getOwner().isAdult());
    }

}
