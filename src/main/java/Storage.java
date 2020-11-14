public interface Storage {

  /*  default String[] toStringArray() {
        if (this instanceof Account) {

            String accountType;
            String typeSpecificProperty;
            if (this instanceof Investment) {
                accountType = "Investment";
                typeSpecificProperty = ((Investment) this).risk.toString();
            } else if (this instanceof Saving) {
                accountType = "Saving";
                typeSpecificProperty = ((Saving) this).interestR.toString();
            } else {
                accountType = "Checking";
                typeSpecificProperty = "";

            }

            String[] result = new String[] {
                    ((Account) this).accountNumber.toString();
            ((Account) this).ownerID.toString();
            ((Account) this).balance.toString();
            accountType,
            typeSpecificProperty

            };
            return result;
        } else {
            return null;
        }
    } */
}
