import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SavingsMenuTest {


    @Test
    public void setTransactionHistoryTest(){
        SavingsMenu savingsMenu = new SavingsMenu();
        String expected = "this is a test";
        savingsMenu.setTransactionHistory(expected);
        String actual = savingsMenu.getTransactionHistory();
        assertEquals(expected,actual);
    }

    @Test
    public void getTransactionHistoryTest(){
        SavingsMenu savingsMenu = new SavingsMenu();
        String expected = "this is a much different test";
        savingsMenu.setTransactionHistory(expected);
        String actual = savingsMenu.getTransactionHistory();
        assertEquals(expected,actual);
    }

}