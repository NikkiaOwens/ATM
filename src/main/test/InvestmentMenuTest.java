import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InvestmentMenuTest {


    @Test
    public void setTransactionHistoryTest(){
        InvestmentMenu investmentMenu = new InvestmentMenu();
        String expected = "this is a test";
        investmentMenu.setTransactionHistory(expected);
        String actual = investmentMenu.getTransactionHistory();
        assertEquals(expected,actual);
    }

    @Test
    public void getTransactionHistoryTest(){
        InvestmentMenu investmentMenu = new InvestmentMenu();
        String expected = "this is a much different test";
        investmentMenu.setTransactionHistory(expected);
        String actual = investmentMenu.getTransactionHistory();
        assertEquals(expected,actual);
    }

}