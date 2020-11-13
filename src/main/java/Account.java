import com.sun.deploy.net.MessageHeader;

public class Account {
    public Integer accountNumber;
    public Integer ownerID;
    public Double balance;

    public Account(Double balance, Integer ownerID, Integer accountNumber){
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.ownerID = ownerID;
    }
    public Integer getAccountNumber() {
        return accountNumber;
    }

    public Integer getOwnerID() {
        return ownerID;
    }

    public Double getBalance() {
        return balance;
    }
}
