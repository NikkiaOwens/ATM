
import java.util.HashMap;

public class UserWarehouse {

    public static HashMap<String, Integer> accounts = new HashMap<String, Integer>();
   // String name = "John";
    //Integer pin = 1234;
   public static HashMap<String, Integer> getAccounts() {
       return accounts;
   }

    public static void setAccounts(HashMap<String, Integer> accounts) {
        UserWarehouse.accounts = accounts;
    }


    public User createNewUser(String name) {
        int max = 9999;
        int min = 1000;
        int range = max - min + 1;
        int pin = (int)(Math.random() * range) + min;

        User user = new User(name, pin);
        accounts.put(User.name, User.pin);

        return user;
    }
}

