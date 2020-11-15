import java.util.HashMap;
import java.util.Scanner;

public class Console {

    UserWarehouse UW = new UserWarehouse();
    HashMap<String, Integer> userList = UW.getAccounts();
    HashMap<String, User> objList = UW.getObjectList();
    Menu menu = new Menu();
    CheckingMenu checkingMenu = new CheckingMenu();
    SavingsMenu savingsMenu = new SavingsMenu();
    InvestmentMenu investmentMenu = new InvestmentMenu();


    public Console() {

    }

    public void verifyUser() {
        boolean exit = false;
        while (exit == false) {
            menu.verifyExistingUser();
            Scanner option = new Scanner(System.in);
            if (option.hasNextInt()) {
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
            else{System.out.println("Incorrect input");}
        }
    }

    public void createUser() {
        System.out.println("Please enter full name");
        Scanner name = new Scanner(System.in);
        String fullName = name.nextLine();
        if(objList.containsKey(fullName)){
            System.out.println("User name already exists. Enter new name");
            verifyUser();
        }
        else {
            User newUser = UW.createNewUser(fullName);
            System.out.println(newUser.toString());
        }
    }

    public void verifyUserCheck() {
        System.out.println("Enter full name");
        Scanner name = new Scanner(System.in);
        String fullName = name.nextLine();
        if (userList.containsKey(fullName)) {
            System.out.println("Enter password");
            Scanner pass = new Scanner(System.in);
            if(pass.hasNextInt()) {
                Integer password = pass.nextInt();
                if (userList.get(fullName).equals(password)) {
                    accountSelectionMenu(objList.get(fullName));
                } else {
                    System.out.println("Incorrect password");
                    verifyUserCheck();
                }
            }
            else {
                System.out.println("Incorrect password");
            }
        } else {
            System.out.println("Incorrect user name");
            verifyUser();
        }
    }

    public void accountSelectionMenu(User currentUser) {
        boolean quit = false;
        while (quit == false) {
            User current = currentUser;
            menu.accountSelection();
            Scanner option = new Scanner(System.in);
            if (option.hasNextInt()) {
                int selection = option.nextInt();
                switch (selection) {
                    case 1:
                        if (current.getHasChecking()) {
                            checkingMenu.checkAcctMenu(current);
                        } else {
                            CheckingMenu.verifyAccount(current);
                            if (current.getHasChecking()) {
                                checkingMenu.checkAcctMenu(current);
                            }
                        }
                        break;
                    case 2:
                        if (current.getHasSavings()) {
                            savingsMenu.savingsAcctMenu(current);
                        } else {
                            SavingsMenu.verifyAccount(current);
                            if (current.getHasSavings()) {
                                savingsMenu.savingsAcctMenu(current);
                            }
                        }
                        break;
                    case 3:
                        if (current.getHasInvestment()) {
                            investmentMenu.investmentAcctMenu(current);
                        } else {
                            InvestmentMenu.verifyAccount(current);
                            if (current.getHasInvestment()) {
                                investmentMenu.investmentAcctMenu(current);
                            }
                        }
                        break;
                    case 4:
                        quit = true;
                        break;
                    default:
                        System.out.println("Incorrect input");
                        verifyUser();
                }
            }
           else {System.out.println("Incorrect input");}
        }
        verifyUser();
    }

}

