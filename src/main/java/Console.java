import java.util.HashMap;
import java.util.Scanner;

public class Console {


    UserWarehouse UW = new UserWarehouse();
    HashMap<String, Integer> userList = UW.getAccounts();
    HashMap<String, User> objList = UW.getObjectList();
    StringBuilder transactionHistory = new StringBuilder();
    Menu menu = new Menu();


    public Console() {
    }

    public void verifyUser() {
        boolean exit = false;
        while (exit == false) {
            menu.verifyExistingUser();
            Scanner option = new Scanner(System.in);
            int selection = option.nextInt();
            switch (selection) {
                case 1:
                    verifyUserCheck();
                    break;
                case 2:
                    createUser();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Incorrect input");
                    break;
            }
        }
    }

    public void createUser() {
        System.out.println("Please enter full name");
        Scanner name = new Scanner(System.in);
        String fullName = name.nextLine();
        User newUser = UW.createNewUser(fullName);
        System.out.println(newUser.toString());
    }

    public void verifyUserCheck() {
        System.out.println("Enter full name");
        Scanner name = new Scanner(System.in);
        String fullName = name.nextLine();
        if (userList.containsKey(fullName)) {
            System.out.println("Enter password");
            Scanner pass = new Scanner(System.in);
            Integer password = pass.nextInt();
            if (userList.get(fullName).equals(password)) {
                accountSelectionMenu(objList.get(fullName));
            } else {
                System.out.println("Incorrect password");
                verifyUserCheck();
            }
        } else {
            System.out.println("Incorrect user name");
            verifyUserCheck();
        }
    }

    public void accountSelectionMenu(User currentUser) {
        boolean quit = false;
        while (quit == false) {
            User current = currentUser;
            menu.accountSelection();
            Scanner option = new Scanner(System.in);
            int selection = option.nextInt();
            switch (selection) {
                case 1:
                    System.out.println("Checking");
                    checkAcctMenu(current);
                    break;
                case 2:
                    System.out.println("Savings");
                    savingsAcctMenu(current);
                    break;
                case 3:
                    System.out.println("Investment");
                    investmentAcctMenu(current);
                    break;
                case 4:
                    System.out.println("Transaction History");
                    getTransactions();
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Incorrect input");
                    verifyUser();
            }
        }
        verifyUser();
    }

    public void getTransactions() {
        String trans = transactionHistory.toString();
        System.out.print(trans);
    }

    public void checkAcctMenu(User current) {
        boolean checking = current.getHasChecking();
        if (checking == true) {
            boolean back = false;
            while (back == false) {
                menu.acctMenu();
                Scanner option = new Scanner(System.in);
                int selection = option.nextInt();
                switch (selection) {
                    case 1:
                        System.out.println("Enter amount to withdraw");
                        Scanner withD = new Scanner(System.in);
                        double withdraw = withD.nextDouble();
                        System.out.println("You withdrew: ");
                        System.out.println(current.checkingWithdraw(withdraw));
                        System.out.println("current balance: ");
                        System.out.println(current.getCheckingBalance());
                        transactionHistory.append("Withdrew: " + withdraw + " from checking. " + "Remaining Balance: " + current.getCheckingBalance() + "\n");
                        break;
                    case 2:
                        System.out.println("Enter amount to deposit");
                        Scanner depos = new Scanner(System.in);
                        double deposit = depos.nextDouble();
                        System.out.println("You deposited: ");
                        current.checkingDeposit(deposit);
                        System.out.println("current balance: ");
                        System.out.println(current.getCheckingBalance());
                        transactionHistory.append("Deposited: " + deposit + " into checking. " + "Remaining Balance: " + current.getCheckingBalance() + "\n");
                        break;
                    case 3:
                        System.out.println(current.getCheckingBalance());
                        break;
                    case 4:
                        System.out.println("Enter account to transfer to");
                        Scanner type = new Scanner(System.in);
                        String acct = type.nextLine();
                        System.out.println("Enter amount to transfer");
                        Scanner amt = new Scanner(System.in);
                        double amount = amt.nextDouble();
                        if (acct.toLowerCase().equals("savings") && current.getHasSavings()==true) {
                            current.checkingWithdraw(amount);
                            current.savingsDeposit(amount);
                            System.out.println("Transfer successful \nCurrent balance: " + current.getCheckingBalance());
                        } else if (acct.toLowerCase().equals("investment") && current.getHasInvestment()==true) {
                            current.checkingWithdraw(amount);
                            current.investmentDeposit(amount);
                            System.out.println("Transfer successful \nCurrent balance: " + current.getCheckingBalance());
                        } else {
                            System.out.println("Account not found. Please create account before transfer.");
                        }
                        break;
                    case 5:
                        current.setHasChecking(false);
                        System.out.println(current.closeCheck());
                        accountSelectionMenu(current);
                        break;
                    case 6:
                        back = true;
                        break;
                    default:
                        System.out.println("Incorrect input");
                        break;

                }
            }
        } else {
            System.out.println("Would you like to create a checking account?\n" +
                    "Enter yes or no");
            Scanner scan = new Scanner(System.in);
            String answer = scan.nextLine();
            if (answer.toLowerCase().equals("yes")) {
                current.setHasChecking(true);
                System.out.println("Account creation successful.\nChecking:");

                checkAcctMenu(current);
            } else {
                accountSelectionMenu(current);
            }
        }
    }


    public void savingsAcctMenu(User current) {
        boolean savings = current.getHasSavings();
        if (savings == true) {
            boolean back = false;
            while (back == false) {
                menu.acctMenu();
                Scanner option = new Scanner(System.in);
                int selection = option.nextInt();
                switch (selection) {
                    case 1:
                        System.out.println("Enter amount to withdraw");
                        Scanner withD = new Scanner(System.in);
                        double withdraw = withD.nextDouble();
                        System.out.println("You withdrew: ");
                        System.out.println(current.savingsWithdraw(withdraw));
                        System.out.println("current balance: ");
                        System.out.println(current.getSavingBalance());
                        transactionHistory.append("Withdrew: " + withdraw + " from savings. " + "Remaining Balance: " + current.getSavingBalance() + "\n");
                        break;
                    case 2:
                        System.out.println("Enter amount to deposit");
                        Scanner depos = new Scanner(System.in);
                        double deposit = depos.nextDouble();
                        System.out.println("You deposited: ");
                        current.savingsDeposit(deposit);
                        System.out.println("current balance: ");
                        System.out.println(current.getSavingBalance());
                        transactionHistory.append("Deposited: " + deposit + " into savings. " + "Remaining Balance: " + current.getSavingBalance() + "\n");
                        break;
                    case 3:
                        System.out.println(current.getSavingBalance());
                        break;
                    case 4:
                        System.out.println("Enter account to transfer to");
                        Scanner type = new Scanner(System.in);
                        String acct = type.nextLine();
                        System.out.println("Enter amount to transfer");
                        Scanner amt = new Scanner(System.in);
                        double amount = amt.nextDouble();
                        if (acct.toLowerCase().equals("checking") && current.getHasChecking()==true) {
                            current.savingsWithdraw(amount);
                            current.checkingDeposit(amount);
                            System.out.println("Transfer successful \nCurrent balance: " + current.getCheckingBalance());
                        } else if (acct.toLowerCase().equals("investment") && current.getHasInvestment()==true) {
                            current.savingsWithdraw(amount);
                            current.investmentDeposit(amount);
                            System.out.println("Transfer successful \nCurrent balance: " + current.getCheckingBalance());
                        } else {
                            System.out.println("Account not found. Please create account before transfer.");
                        }
                        break;
                    case 5:
                        current.setHasSavings(false);
                        System.out.println(current.closeSaving());
                        accountSelectionMenu(current);
                        break;
                    case 6:
                        back = true;
                        break;
                    default:
                        System.out.println("Incorrect input");
                        break;

                }


            }

        } else {
            System.out.println("Would you like to create a savings account?\n" +
                    "Enter yes or no");
            Scanner scan = new Scanner(System.in);
            String answer = scan.nextLine();
            if (answer.toLowerCase().equals("yes")) {
                current.setHasSavings(true);
                System.out.println("Account creation successful.\nSavings:");
                savingsAcctMenu(current);
            } else {
                accountSelectionMenu(current);
            }
        }
    }

    public void investmentAcctMenu(User current) {
        boolean investment = current.getHasInvestment();
        if (investment == true) {
            boolean back = false;
            while (back == false) {
                menu.acctMenu();
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
                        transactionHistory.append("Withdrew: " + withdraw + " from investment. " + "Remaining Balance: " + current.getInvestmentBalance() + "\n");
                        break;
                    case 2:
                        System.out.println("Enter amount to deposit");
                        Scanner depos = new Scanner(System.in);
                        double deposit = depos.nextDouble();
                        System.out.println("You deposited: ");
                        current.investmentDeposit(deposit);
                        System.out.println("current balance: ");
                        System.out.println(current.getInvestmentBalance());
                        transactionHistory.append("Deposited: " + deposit + " into investment. " + "Remaining Balance: " + current.getInvestmentBalance() + "\n");
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
                        if(acct.toLowerCase().equals("checking") && current.getHasChecking()==true){
                            current.investmentWithdraw(amount);
                            current.checkingDeposit(amount);
                            System.out.println("Transfer successful \nCurrent balance: "+current.getCheckingBalance());
                        }
                        else if(acct.toLowerCase().equals("savings")&& current.getHasSavings()==true){
                            current.investmentWithdraw(amount);
                            current.savingsDeposit(amount);
                            System.out.println("Transfer successful \nCurrent balance: "+current.getCheckingBalance());
                        }
                        else{
                            System.out.println("Account not found. Please create account before transfer.");
                        }
                        break;
                    case 5:
                        current.setHasInvestment(false);
                        System.out.println(current.closeInvestment());
                        accountSelectionMenu(current);
                        break;
                    case 6:
                        back = true;
                        break;
                    default:
                        System.out.println("Incorrect input");
                        break;

                }
            }
        } else {
            System.out.println("Would you like to create an investment account?\n" +
                    "Enter yes or no");
            Scanner scan = new Scanner(System.in);
            String answer = scan.nextLine();
            if (answer.toLowerCase().equals("yes")) {
                current.setHasInvestment(true);
                System.out.println("Account creation successful.\nInvestment:");
                investmentAcctMenu(current);
            } else {
                accountSelectionMenu(current);
            }
        }
    }
}

