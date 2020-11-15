import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CheckingTest {
    private Checking checking;

    @Before
    public void setup(){this.checking = new Checking();}

    @Test
    public void setBalanceTest(){
        Checking checking = new Checking();
        Double expectedBalance = 100.0;

        checking.setBalance(expectedBalance);
        Double actualBalance = checking.getBalance();

        Assert.assertEquals(actualBalance, expectedBalance);
    }

    @Test
    public void removeBalanceTest(){
        Checking checking = new Checking();
        Double beginBalance = 100.0;
        Double balanceToRemove = 50.0;
        Double expectedBalance = 50.0;

        checking.setBalance(beginBalance);
        checking.removeBalance(balanceToRemove);

        Double actualBalance = checking.getBalance();

        Assert.assertEquals(actualBalance, expectedBalance);


    }
}
