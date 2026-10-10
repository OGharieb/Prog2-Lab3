public class MovieTicket {
    private final String ticketId;
    private final String movieName;
    private final String customerName;
    private String seatNum;
    private final double price;
    private boolean isBooked;
    private int discount;

    public MovieTicket(String ticketId, String movieName, String customerName,String seatNumber, double price)
    {
        this.ticketId=ticketId;
        this.movieName=movieName;
        this.customerName=customerName;
        this.seatNum=seatNumber;
         if(price<0)
            this.price=0;
         else
            this.price=price;
        isBooked=false;
        discount=0;
}

public String getTicketId(){
    return ticketId;
}

public String getMovieName(){
    return movieName;
}

public String getCustomerName(){
    return customerName;
}

public String getSeatNum(){
    return seatNum;
}
public double getPrice(){
    return price;
}
public boolean isBooked(){
    return isBooked;
}
public int getDiscount(){
    return discount;
}

public void bookTicket(){
    if(!isBooked&&price>0){
        isBooked=true;
    }
}

public void cancelBooking(){
    if(isBooked){
        isBooked=false;
    }
}
public void changeSeat(String seatNum){
    if(!isBooked){
        this.seatNum=seatNum;
    }
}

public void applyDiscount(int discount){
    if(discount>=0&&discount<=100){
        this.discount=discount;
    }
}
public double getFinalPrice(){
    double discountedAmount = price *(getDiscount()/100.0);
    double discountedPrice= price-discountedAmount;
    if(isBooked){
        double finalPrice=discountedPrice*1.1;
        return finalPrice;
    
    }
    return discountedPrice;
}

public void displayTicketDetails() {
    System.out.println("Ticket ID: " + ticketId);
    System.out.println("Movie: " + movieName);
    System.out.println("Customer: " + customerName);
    System.out.println("Seat: " + seatNum);
    System.out.println("Base Price: " + price);
    System.out.println("Discount: " + discount + "%");
    System.out.println("Is Booked: " + isBooked);
    System.out.println("Final Price: " + getFinalPrice());
    
}




}
