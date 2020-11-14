import com.sun.deploy.net.MessageHeader;

public class Saving extends Account {
    public Double interestR;

    public Saving(Double balance,Integer ownerID, Integer accountNumber, Double interestR){
        super(balance,ownerID,accountNumber);
        this.interestR = interestR;
    }
    public Double getInterestR(){
        return this.interestR;
    }
}
