import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckingMenuTest {

    @Test
    public void setTransactionHistoryTest(){
        CheckingMenu checkingMenu = new CheckingMenu();
        String expected = "this is a test";
        checkingMenu.setTransactionHistory(expected);
        String actual = checkingMenu.getTransactionHistory();
        assertEquals(expected,actual);
    }

    @Test
    public void getTransactionHistoryTest(){
        CheckingMenu checkingMenu = new CheckingMenu();
        String expected = "this is a much different test";
        checkingMenu.setTransactionHistory(expected);
        String actual = checkingMenu.getTransactionHistory();
        assertEquals(expected,actual);
    }
}
