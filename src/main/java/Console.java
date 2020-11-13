import java.util.Scanner;

public class Console {

    Menu menu = new Menu();
    UserVerification v = new UserVerification();
    public Console() {
    }

    public void verifyUser() {
        menu.verifyExistingUser();
        Scanner option = new Scanner(System.in);
        int selection = option.nextInt();
        switch (selection) {
            case 1:
                v.verifyUserCheck();
                verifyUser();
                break;
            case 2:
                v.createUser();
                verifyUser();
                break;
            default:
                System.out.println("Incorrect input");
                verifyUser();
        }
    }


    public void accountSelectionMenu() {
        menu.accountSelection();
        Scanner option = new Scanner(System.in);
        int selection = option.nextInt();
        boolean quit = false;
        while (quit == false) {
            switch (selection) {
                case 1:
                    System.out.println("Checking");
                    acctMenu();
                    break;
                case 2:
                    System.out.println("Savings");
                    acctMenu();
                    break;
                case 3:
                    System.out.println("Investment");
                    acctMenu();
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
    public void acctMenu(){
        menu.acctMenu();
        Scanner option = new Scanner(System.in);
        int selection = option.nextInt();
        boolean back = false;
        while (back == false){
            switch(selection){
                case 1:
                    //withdraw
                    break;
                case 2:
                    //deposit
                    break;
                case 3:
                    //check balance
                    break;
                case 4:
                    //transfer to my acct
                    break;
                case 5:
                    //close account
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
        accountSelectionMenu();
    }
}