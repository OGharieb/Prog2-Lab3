public class DigitalWallet {
    private final String walletId;
    private String ownerName;
    private double balance;
    private int transactionCount;
    
    public DigitalWallet(String walletId, String ownerName, double balance){
        this.walletId=walletId;
        this.ownerName=ownerName;
        
        if (balance>0) 
            this.balance=balance;  
        else
            this.balance=0;

        transactionCount=0;
    }


    public String getWalletId(){
        return walletId;
    }

    public String getOwnerName(){
        return ownerName;
    }
    public double getBalance(){
        return balance;
    }
    public int getTransactionCount(){
        return transactionCount;
    }
    public void setOwnerName(String ownerName){
        this.ownerName=ownerName;
    }

    public void deposit(double value){
        if(value>0){
            balance+=value;
            transactionCount++;
        }

    }
    public boolean  withdraw(double value){
        if(value>0 && balance>=value){
            balance-=value;
            transactionCount++;
            return true;
        }
        else
            return false;
    }
    public void transfer(double value,DigitalWallet receiverWallet){
        if(receiverWallet!=null && receiverWallet!=this && value>0 && balance>=value+calculateTransactionFee(value)){
           balance-=(value+calculateTransactionFee(value));
           receiverWallet.balance+=value;
           transactionCount++;
           receiverWallet.transactionCount++;

        }
    }

    private double calculateTransactionFee(double value){
           double fee;  
           if(value<500){
                fee=5.00;
            }
            else if(value>=500&&value<1000){
                fee=10.00;
            }
            else 
                fee=15.00;
            return fee;
    }

    public void displayWalletDetails() {
    System.out.println("Wallet ID: " + walletId);
    System.out.println("Owner Name: " + ownerName);
    System.out.println("Balance: " + balance);
    System.out.println("Transaction Count: " + transactionCount);
    }
}
