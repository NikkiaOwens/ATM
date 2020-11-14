import com.sun.deploy.net.MessageHeader;
import java.util.Random;

public class Investment extends Account implements Storage {
    Double risk;
    public Investment(){
        this.accountNumber = 1;
        this.ownerID = 1;
        this.balance = 0.0;
    }



    public Investment(Double balance, Integer ownerID, Integer accountNumber, Double risk){
        super(balance,ownerID,accountNumber);
        this.risk = risk;
    }

    public Double getRisk() {
        return risk;
    }

    public void setRisk(Double risk) {
        this.risk = risk;
    }

}