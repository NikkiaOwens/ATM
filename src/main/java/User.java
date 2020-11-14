import java.util.HashMap;

public class User {
    private String name;
    private Integer pin;

public User(String name, Integer pin) {
    this.name = name;
    this.pin = pin;
}
public void setName(String name) {
    this.name = name;
}
public String getName() {
    return name;
}
 public void setPin(Integer pin) {
    this.pin = pin;
 }
 public Integer getPin() {
    return pin;
 }

}
