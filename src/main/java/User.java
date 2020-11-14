import java.util.HashMap;

public class User {
    public static Integer pin;
    public static String name;
    public static Checking checking = new Checking();
    public static Saving savings = new Saving();
    public static Investment investment = new Investment();
    // private String name;
    // private Integer pin;

    public User(String name, Integer pin) {
        this.name = name;
        this.pin = pin;
    }
    public User(){}

    public Double getCheckingBalance(){
        return checking.getBalance();
    }
    public Double getSavingBalance(){
        return savings.getBalance();
    }
    public Double getInvestmentBalance(){
        return investment.getBalance();
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
