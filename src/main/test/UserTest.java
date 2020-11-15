import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

    private User user;

    @Before
    public void setup(){this.user = new User();}
//has checking account test
    @Test
    public void setHasCheckingTest(){
        User user = new User();
        boolean expectedChecking = true;

        user.setHasChecking(expectedChecking);

        boolean actualChecking = user.getHasChecking();

        Assert.assertEquals(actualChecking,expectedChecking);

    }
//has savings account test
    @Test
    public void setHasSavingsTest(){
        User user = new User();
        boolean expectedSavings = true;

        user.setHasSavings(expectedSavings);

        boolean actualSavings = user.getHasSavings();

        Assert.assertEquals(actualSavings,expectedSavings);

    }
//has investment account test
    @Test
    public void setHasInvestmentTest(){
        User user = new User();
        boolean expectedInvestment = true;

        user.setHasInvestment(expectedInvestment);

        boolean actualInvestment = user.getHasInvestment();

        Assert.assertEquals(actualInvestment,expectedInvestment);

    }
// checking deposit/withdraw tests
    @Test
    public void checkingDepositTest(){
        User user = new User();
        Double expectedBalance = 200.0;
        Double expectedDeposit = 200.0;
        //double expectedWithdraw = 50.0;

        user.checkingDeposit(expectedDeposit);
        //user.checkingWithdraw(expectedWithdraw);

        Double actualBalance = user.getCheckingBalance();

        Assert.assertEquals(actualBalance,expectedBalance);

    }

    @Test
    public void checkingWithdrawTest(){
        User user = new User();
        Double expectedBalance = 120.0;
        Double expectedDeposit = 200.0;
        Double expectedWithdraw = 50.0;

        user.checkingDeposit(expectedDeposit);
        user.checkingWithdraw(expectedWithdraw);

        Double actualBalance = user.getCheckingBalance();

        Assert.assertNotEquals(actualBalance,expectedBalance);

    }
// savings deposit/withdraw tests
    @Test
    public void savingsDepositTest(){
        User user = new User();
        Double expectedBalance = 200.0;
        Double expectedDeposit = 200.0;


        user.savingsDeposit(expectedDeposit);


        Double actualBalance = user.getSavingBalance();

        Assert.assertEquals(actualBalance,expectedBalance);

    }

    @Test
    public void savingsWithdrawTest(){
        User user = new User();
        Double expectedBalance = 150.0;
        Double expectedDeposit = 200.0;
        Double expectedWithdraw = 50.0;

        user.savingsDeposit(expectedDeposit);
        user.savingsWithdraw(expectedWithdraw);

        Double actualBalance = user.getSavingBalance();

        Assert.assertEquals(actualBalance,expectedBalance);

    }
// investment deposit/withdraw tests
    @Test
    public void investmentDepositTest(){
        User user = new User();
        Double expectedBalance = 200.0;
        Double expectedDeposit = 200.0;


        user.investmentDeposit(expectedDeposit);


        Double actualBalance = user.getInvestmentBalance();

        Assert.assertEquals(actualBalance,expectedBalance);

    }

    @Test
    public void investmentWithdrawTest(){
        User user = new User();
        Double expectedBalance = 150.0;
        Double expectedDeposit = 200.0;
        Double expectedWithdraw = 50.0;

        user.investmentDeposit(expectedDeposit);
        user.investmentWithdraw(expectedWithdraw);

        Double actualBalance = user.getInvestmentBalance();

        Assert.assertEquals(actualBalance,expectedBalance);

    }
// close accounts test
    @Test
    public void closeCheckingTest(){
        User user = new User();
        String expected = "Account successfully closed";

        String actual = user.closeCheck();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void closeSavingsTest(){
        User user = new User();
        String expected = "Account successfully closed";

        String actual = user.closeSaving();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void closeInvestmentTest(){
        User user = new User();
        String expected = "Account successfully closed";

        String actual = user.closeInvestment();

        Assert.assertEquals(actual, expected);
    }


}
