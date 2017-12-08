package alvaro.uni.AlvaroBnB.model;


import alvaro.uni.AlvaroBnB.model.helpClasses.*;
import org.junit.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserTest {

    private User alvaro;

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
        Date date = dateFormat.parse("1996-05-11");
        this.alvaro = new User(
                "Alvaro",
                "Carnicero",
                date,
                Gender.MALE,
                Nationality.ES,
                creditCard);

    }

    @After
    public void tearDown(){
    }


    @Test
    public void testFirstName(){
       Assert.assertEquals(alvaro.getFirstName(), "Alvaro");
    }

    @Test
    public void testLastName(){
        Assert.assertEquals(alvaro.getFirstName(), "Alvaro");
    }

    @Test
    public void testIsAdult(){

        Assert.assertTrue(alvaro.isAdult());
    }

    @Test
    public void testGender(){
        Assert.assertEquals(alvaro.getGender(), Gender.MALE);
    }


}
