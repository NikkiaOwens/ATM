import java.util.Scanner;

public class InvestmentMenu {
    private static Menu menu;
    private static Console console;
    private static User current;
    private StringBuilder transactionHistory = new StringBuilder();
    public void investmentAcctMenu(User current) {

            boolean back = false;
            while (back == false) {
                acctMenu();
                Scanner option = new Scanner(System.in);
                int selection = option.nextInt();
                switch (selection) {
                    case 1:
                        System.out.println("Enter amount to withdraw");
                        Scanner withD = new Scanner(System.in);
                        double withdraw = withD.nextDouble();
                        System.out.println("You withdrew: ");
                        System.out.println(current.investmentWithdraw(withdraw));
                        System.out.println("current balance: ");
                        System.out.println(current.getInvestmentBalance());
                        setTransactionHistory("Withdrew: " + withdraw + " from investment. " + "Remaining Balance: " + current.getInvestmentBalance() + "\n");
                        break;
                    case 2:
                        System.out.println("Enter amount to deposit");
                        Scanner depos = new Scanner(System.in);
                        double deposit = depos.nextDouble();
                        System.out.println("You deposited: ");
                        current.investmentDeposit(deposit);
                        System.out.println("current balance: ");
                        System.out.println(current.getInvestmentBalance());
                        setTransactionHistory("Deposited: " + deposit + " into investment. " + "Remaining Balance: " + current.getInvestmentBalance() + "\n");
                        break;
                    case 3:
                        System.out.println(current.getInvestmentBalance());
                        break;
                    case 4:
                        System.out.println("Enter account to transfer to");
                        Scanner type = new Scanner(System.in);
                        String acct = type.nextLine();
                        System.out.println("Enter amount to transfer");
                        Scanner amt = new Scanner(System.in);
                        double amount = amt.nextDouble();
                        if(current.getInvestmentBalance() >= amount) {
                            if (acct.toLowerCase().equals("checking") && current.getHasChecking() == true) {
                                current.investmentWithdraw(amount);
                                current.checkingDeposit(amount);
                                System.out.println("Transfer successful \nCurrent balance: " + current.getInvestmentBalance());
                            } else if (acct.toLowerCase().equals("savings") && current.getHasSavings() == true) {
                                current.investmentWithdraw(amount);
                                current.savingsDeposit(amount);
                                System.out.println("Transfer successful \nCurrent balance: " + current.getInvestmentBalance());
                            } else {
                                System.out.println("Account not found. Please create account before transfer.");
                            }
                        }
                        else {
                            System.out.println("You do not have sufficient funds in account");
                        }
                        break;
                    case 5:
                        current.setHasInvestment(false);
                        System.out.println(current.closeInvestment());
                        console.accountSelectionMenu(current);
                        break;
                    case 6:
                        System.out.println(getTransactionHistory());
                        break;
                    case 7:
                        back = true;
                        break;
                    default:
                        System.out.println("Incorrect input");
                        break;

                }
            }
        }

    public static boolean verifyAccount(User current) {
        System.out.println("Would you like to create a investment account?\n" +
                "Enter yes or no");
        Scanner scan = new Scanner(System.in);
        String answer = scan.nextLine();
        if (answer.toLowerCase().equals("yes")) {
            current.setHasInvestment(true);
            System.out.println("Account creation successful.\nInvestment:");
            return true;
        } else {
            return false;
        }
    }
    public void acctMenu(){
        System.out.println("Please enter your menu selection\n" +
                "1:Withdraw 2:Deposit 3:Check balance 4:Transfer to my account \n" +
                "5:Close account 6:Transaction history 7:Back");
    }
    public void setTransactionHistory(String s){
        this.transactionHistory.append(s);
    }
    public String getTransactionHistory(){
        return this.transactionHistory.toString();
    }
}
