import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SavingsTest {
    private Saving saving;

    @Before
    public void setup(){this.saving = new Saving();}

    @Test
    public void setBalanceTest(){
        Saving saving = new Saving();
        Double expectedBalance = 100.0;

        saving.setBalance(expectedBalance);
        Double actualBalance = saving.getBalance();

        Assert.assertEquals(actualBalance, expectedBalance);
    }

    @Test
    public void removeBalanceTest(){
        Saving saving = new Saving();
        Double beginBalance = 100.0;
        Double balanceToRemove = 50.0;
        Double expectedBalance = 50.0;

        saving.setBalance(beginBalance);
        saving.removeBalance(balanceToRemove);

        Double actualBalance = saving.getBalance();

        Assert.assertEquals(actualBalance, expectedBalance);


    }
}
