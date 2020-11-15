import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {



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
    public void savingsDepositTest1(){
        User user5 = new User();
        Double expectedBalance = 200.0;
        Double expectedDeposit = 200.0;


        user5.savingsDeposit(expectedDeposit);


        Double actualBalance = user5.getSavingBalance();

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
    public void investmentWithdrawTest2(){
        User user4 = new User();
        Double expectedBalance = 150.0;
        Double expectedDeposit = 200.0;
        Double expectedWithdraw = 50.0;

        user4.investmentDeposit(expectedDeposit);
        user4.investmentWithdraw(expectedWithdraw);

        Double actualBalance = user4.getInvestmentBalance();

        Assert.assertEquals(expectedBalance,actualBalance);

    }
// close accounts test
    @Test
    public void closeCheckingTest3(){
        User user1 = new User();
        String expected = "Account successfully closed";

        String actual = user1.closeCheck();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void closeSavingsTest4(){
        User user2 = new User();
        String expected = "Account successfully closed";

        String actual = user2.closeSaving();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void closeInvestmentTest5(){
        User user3 = new User();
        String expected = "Account successfully closed";

        String actual = user3.closeInvestment();

        Assert.assertEquals(actual, expected);
    }


}
