
import java.util.ArrayList;
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
   HashMap<String, User> objectList = new HashMap<String, User>();

    public User createNewUser(String name) {
        int max = 9999;
        int min = 1000;
        int range = max - min + 1;
        int pin = (int)(Math.random() * range) + min;

        User user = new User(name, pin);
        objectList.put(name,user);
        accounts.put(User.name, User.pin);

        return user;
    }
    public HashMap<String,User> getObjectList(){
        return this.objectList;
    }
}

