import com.sun.deploy.net.MessageHeader;
import sun.management.snmp.jvmmib.JVM_MANAGEMENT_MIBOidTable;

public class Account {
    public Integer accountNumber;
    public Integer ownerID;
    public Double balance;

    public Account(){
        this.accountNumber = 1;
        this.ownerID = 1;
        this.balance = 0.0;
    }

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

    public void deposit(Double amount) {
        this.balance += amount;
        String bal = String.format("%.2f", this.balance);
        this.balance = Double.parseDouble(bal);
    }
        public void withdraw(Double amount){
            if (this.balance > amount){
                this.balance -= amount;
            }
        }
    }

