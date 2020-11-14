import java.util.HashMap;

public class UserWarehouse {
    HashMap<String, Integer> accounts = new HashMap<String, Integer>();
    String name = "John";
    Integer pin = 1234;


    public void addUser(String name, Integer pin) {
        accounts.put(name, pin);
    }
}

