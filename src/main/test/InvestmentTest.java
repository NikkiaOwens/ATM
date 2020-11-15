import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvestmentTest {
    private Investment investment;

    @Before
    public void setup(){this.investment = new Investment();}

    @Test
    public void setBalanceTest(){
        Investment investment = new Investment();
        Double expectedBalance = 100.0;

        investment.setBalance(expectedBalance);
        Double actualBalance = investment.getBalance();

        Assert.assertEquals(actualBalance, expectedBalance);
    }

    @Test
    public void removeBalanceTest(){
        Investment investment = new Investment();
        Double beginBalance = 100.0;
        Double balanceToRemove = 50.0;
        Double expectedBalance = 50.0;

        investment.setBalance(beginBalance);
        investment.removeBalance(balanceToRemove);

        Double actualBalance = investment.getBalance();

        Assert.assertEquals(actualBalance, expectedBalance);


    }
}
