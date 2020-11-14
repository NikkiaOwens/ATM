import java.util.HashMap;

public class User {
    public static Integer pin;
    public static String name;
    public static Double savingsBalance = 0.0;
    public static Double investmentBalance = 0.0;
    public static Double checkingBalance = 0.0;
    // private String name;
    // private Integer pin;

    public User(String name, Integer pin) {
        this.name = name;
        this.pin = pin;
    }
    public User(){}

    public Double getBalance(){
        return investmentBalance;
    }
    public Double getCheckingBalance(){
        return checkingBalance;
    }

    public Double getSavingsBalance(){
        return savingsBalance;
    }
}
//}
//public void name(String name) {
   // this.name = name;
//}
//public String getName() {
  //  return name;
//}
 //public void setPin(Integer pin) {
  //  this.pin = pin;
 //}
 //public Integer getPin() {
  //  return pin;
 //}

//}
