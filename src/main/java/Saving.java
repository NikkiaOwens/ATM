import com.sun.deploy.net.MessageHeader;

public class Saving extends Account {
    public Double interestR;

    public Saving(){
        this.accountNumber = 1;
        this.ownerID = 1;
        this.balance = 0.0;
    }

    public Saving(Double balance,Integer ownerID, Integer accountNumber, Double interestR){
        super(balance,ownerID,accountNumber);
        this.interestR = interestR;
    }
    public Double getInterestR(){
        return this.interestR;
    }
}
