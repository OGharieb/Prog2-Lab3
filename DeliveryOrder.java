



  public class DeliveryOrder {
  private final String orderId;
  private final String customerName;
  private String deliveryAddress;
  private final int itemCount;
  private final double subtotal;
  private final DigitalWallet wallet;
  private boolean isPaid;
  private boolean isDelivered;

  public DeliveryOrder(String orderId,String customerName,String deliveryAddress,int itemCount,double subtotal){
    this.orderId=orderId;
    this.customerName=customerName;
    this.deliveryAddress=deliveryAddress;
    if(itemCount>0)
      this.itemCount=itemCount;
    else
      this.itemCount=1;
    if(subtotal>=0)
      this.subtotal=subtotal;
    else
      this.subtotal=0;
    isPaid=false;
    isDelivered=false;
    this.wallet=null;
  }

    public DeliveryOrder(String orderId,String customerName,String deliveryAddress,int itemCount,double subtotal, DigitalWallet wallet){
    this.orderId=orderId;
    this.customerName=customerName;
    this.deliveryAddress=deliveryAddress;
    if(itemCount>0)
      this.itemCount=itemCount;
    else
      this.itemCount=1;
    if(subtotal>=0)
      this.subtotal=subtotal;
    else
      this.subtotal=0;
    this.wallet=wallet;
    isPaid=false;
    isDelivered=false;  
  }

  public String getOrderID(){
    return this.orderId;
  }
  public String getCustomerName(){
    return this.customerName;
  }
  public String getDeliveryAddress(){
    return this.deliveryAddress;
  }
  public int getItemCount(){
    return this.itemCount;
  }
  public double getSubtotal(){
    return this.subtotal;
  }
  public DigitalWallet getWallet(){
    return this.wallet;
  }
  public boolean isPaid(){
    return isPaid;
  }

  public boolean  isDelivered(){
    return isDelivered;
  }

  public void setDeliveryAddress(String deliveryAddress){
    this.deliveryAddress=deliveryAddress;
  }

  private double calculateDeliveryCost(){

    if(this.subtotal<500){
      return 50;
    }
    else if(this.subtotal>=500&&subtotal<1000){
      return 30;
    }
    else 
      return 10;
    
  }
  public double calculateTotalCost(){
    return this.subtotal+this.calculateDeliveryCost();
  }

  public void payOrder(){
    if(wallet==null){
      isPaid=true;
    }
    else{
      if(wallet.withdraw(calculateTotalCost())){
        isPaid=true;
      }
    }
  }

  public void deliverOrder(){
    if(isPaid&&!isDelivered){
      isDelivered=true;
    }
  }

public void displayOrderDetails() {
    System.out.println("Order ID: " + orderId);
    System.out.println("Customer: " + customerName);
    System.out.println("Address: " + deliveryAddress);
    System.out.println("Item Count: " + itemCount);
    System.out.println("Subtotal: " + subtotal);
    System.out.println("Total Cost: " + calculateTotalCost());
    System.out.println("Is Paid: " + isPaid);
    System.out.println("Is Delivered: " + isDelivered);
    if (wallet != null) {
        System.out.println("Payment Method: Digital Wallet (" + wallet.getWalletId() + ")");
    } else {
        System.out.println("Payment Method: Cash");
    }
    
}



  }
