package alvaro.uni.AlvaroBnB.model;

import alvaro.uni.AlvaroBnB.model.helpClasses.CreditCard;
import alvaro.uni.AlvaroBnB.model.helpClasses.Gender;
import alvaro.uni.AlvaroBnB.model.helpClasses.Nationality;
import org.junit.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookTest {

    private Book book1;

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
        Date date2 = dateFormat.parse("1996-02-10");
        User user= new User(
                "Jose",
                "Ortiz",
                date1,
                Gender.MALE,
                Nationality.ES,
                creditCard);
        Double[] rates = {5.0,2.5,3.0,4.5,5.0};
        Property property = new Property(
                "property1",
                rates,
                "Property number 1",
                "Miskolci Egyetem",
                owner
        );
        Date dateBook = dateFormat.parse("2017-09-15");
        this.book1 = new Book(
                "book01",
                dateBook,
                property,
                user
        );

    }

    @After
    public void tearDown(){
    }

    @Test
    public void testBookID(){
        Assert.assertEquals(book1.getBookID(), "book01");
    }

    @Test
    public void testBookPropertyName(){
        Assert.assertEquals(book1.getProperty().getName(),"property1" );
    }

    @Test
    public void testBookUserGender(){
        Assert.assertEquals(book1.getUser().getGender(), Gender.MALE);
    }

    @Test
    public void testBookPropertyOwnerName(){
        Assert.assertEquals(book1.getProperty().getOwner().getFirstName(), "Alvaro");
    }


}
