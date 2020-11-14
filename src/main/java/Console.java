import java.util.HashMap;
import java.util.Scanner;

public class Console {



    UserWarehouse UW = new UserWarehouse();
    HashMap<String, Integer> userList = UW.getAccounts();
    HashMap<String, User> objList = UW.getObjectList();
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
                    //verifyUser();
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
                    //acctMenu();
                    break;
                case 4:
                    //print transaction history
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

    public void checkAcctMenu(User current) {
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

                    break;
                case 2:
                    System.out.println("Enter amount to deposit");
                    Scanner depos = new Scanner(System.in);
                    double deposit = depos.nextDouble();
                    System.out.println("You deposited: ");
                    current.checkingDeposit(deposit);
                    System.out.println("current balance: ");
                    System.out.println(current.getCheckingBalance());
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
                    if(acct.toLowerCase().equals("savings")){
                        current.checkingWithdraw(amount);
                        current.savingsDeposit(amount);
                        System.out.println("Transfer successful \nCurrent balance: "+current.getCheckingBalance());
                }
                    else if(acct.toLowerCase().equals("investment")){
                        current.checkingWithdraw(amount);
                        current.investmentDeposit(amount);
                        System.out.println("Transfer successful \nCurrent balance: "+current.getCheckingBalance());
                    }
                    else{
                        System.out.println("Incorrect input");
                    }
                    break;
                case 5:
                    System.out.println(current.closeCheck());
                    break;
                case 6:
                    //transfer to outside acct
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


        public void savingsAcctMenu(User current) {
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
                        break;
                    case 2:
                        System.out.println("Enter amount to deposit");
                        Scanner depos = new Scanner(System.in);
                        double deposit = depos.nextDouble();
                        System.out.println("You deposited: ");
                        current.savingsDeposit(deposit);
                        System.out.println("current balance: ");
                        System.out.println(current.getSavingBalance());
                        break;
                    case 3:
                        System.out.println(current.getSavingBalance());
                        break;
                    case 4:
                        //transfer to my acct
                        break;
                    case 5:
                        System.out.println(current.closeSaving());
                        break;
                    case 6:
                        //transfer to outside acct
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


    public void investmentAcctMenu(User current) {
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
                    break;
                case 2:
                    System.out.println("Enter amount to deposit");
                    Scanner depos = new Scanner(System.in);
                    double deposit = depos.nextDouble();
                    System.out.println("You deposited: ");
                    current.investmentDeposit(deposit);
                    System.out.println("current balance: ");
                    System.out.println(current.getInvestmentBalance());
                    break;
                case 3:
                    System.out.println(current.getInvestmentBalance());
                    break;
                case 4:
                    //transfer to my acct
                    break;
                case 5:
                    System.out.println(current.closeInvestment());
                    break;
                case 6:
                    //transfer to outside acct
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
}

