import com.sun.deploy.net.MessageHeader;
import sun.management.snmp.jvmmib.JVM_MANAGEMENT_MIBOidTable;

public abstract class Account {
    private double balance = 0.0;
    public Account(){
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double deposit) {
        if(deposit > 0) {
            this.balance += deposit;
        }
    }
        public double removeBalance(Double amount){
            if (this.balance > amount){
                double newAmt = this.balance - amount;
                this.balance = newAmt;
                return amount;
            }
            return -1;
        }


    }

