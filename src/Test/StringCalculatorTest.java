package Test;
import com.StringCalculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class StringCalculatorTest {
    StringCalculator stringCalculator;
    @Before
    public void setUp(){
         stringCalculator = new StringCalculator();
    }
    @Test public void blankStringTest(){
        //check for blank string
        assertEquals(0,stringCalculator.add(""));
    }
    @Test public void oneOrTwoNumberTest(){
        assertEquals(1,stringCalculator.add("1"));
        assertEquals(3,stringCalculator.add("1,2"));
        assertEquals(80,stringCalculator.add("30,50"));
    }
    @Test public void unknownAmountOfNumberTest(){
        assertEquals(7,stringCalculator.add("5,2"));
        assertEquals(6,stringCalculator.add("1,2,3"));
        assertEquals(55,stringCalculator.add("1,2,3,4,5,6,7,8,9,10"));
    }
    @Test public void numberAndAlphabetTest(){
        assertEquals(4,stringCalculator.add("1,a,b"));
        assertEquals(7,stringCalculator.add("1,2,a,c"));
        assertEquals(44,stringCalculator.add("1,a,3,5,6,b,z"));
        assertEquals(50,stringCalculator.add("a,3,5,b,z,3,j"));
    }


    @Test public void ThrowNegativeNotAllowedExceptionTest(){
        assertThrows("Negatives Not allowed",IllegalArgumentException.class,()->stringCalculator.add("1,-2"));
    }


    @Test public void showNegativesTest(){
        assertThrows(IllegalArgumentException.class,()->stringCalculator.add("-2,-3,4,-5,6"));
    }

    @Test public void numberLargerThan1000ShouldIgnoreTest(){
        assertEquals(2,stringCalculator.add("2,1001"));
        assertEquals(64,stringCalculator.add("10,4,50,6000,4444"));
    }

}
