import java.util.HashMap;
import java.util.Scanner;

public class UserVerification {
    /**
     *
     * this will tie into the hash map of user names and passwords
     */
UserWarehouse UW = new UserWarehouse();
HashMap<String,Integer> userList = UW.getAccounts();
Console console = new Console();
public UserVerification(){

}

    public void verifyUserCheck(){
        System.out.println("Enter full name");
        Scanner name = new Scanner(System.in);
        String fullName = name.nextLine();
        if(userList.containsKey(fullName)){
            System.out.println("Enter password");
            Scanner pass = new Scanner(System.in);
            String password = pass.nextLine();
            if(userList.get(fullName).equals(password)){
                console.accountSelectionMenu();
            }
            else{
                System.out.println("Incorrect password");
                verifyUserCheck();
            }
        }
        else{
            System.out.println("Incorrect user name");
            verifyUserCheck();
        }
    }

    public void createUser(){
    System.out.println("Please enter full name");
    Scanner name = new Scanner(System.in);
    String fullName = name.nextLine();
    System.out.println("Please enter desired pin password\n" +
            "password must only be numbers with no spaces");
    Scanner pass = new Scanner(System.in);
    String password = pass.nextLine();
    //check password is a number then push name and password to the hash map
        System.out.println("Name and password are set");
    }
}
