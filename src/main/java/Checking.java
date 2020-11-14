public class Checking extends Account {
    public Checking(){
        this.accountNumber = 1;
        this.ownerID = 1;
        this.balance = 0.0;
    }


    public Checking(Double balance,Integer ownerID, Integer accountNumber){
        super(balance,ownerID,accountNumber);
    }

}
