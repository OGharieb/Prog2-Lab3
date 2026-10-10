
 public class OOPLab3 {
    public static void main(String[] args) {
        
        MovieTicket validTicket = new MovieTicket("T01", "Endgame Encore", "Omar", "A1", 200.0);
        MovieTicket negativePriceTicket = new MovieTicket("T02", "Logan", "Omar", "A2", -50.0);
        MovieTicket zeroPriceTicket = new MovieTicket("T03", "Deadpool", "Omar", "A3", 0.0);

        validTicket.applyDiscount(150);
        validTicket.applyDiscount(-10);
        validTicket.applyDiscount(10);

        validTicket.bookTicket();
        validTicket.bookTicket();
        validTicket.changeSeat("B1");

        zeroPriceTicket.bookTicket();

        validTicket.cancelBooking();
        validTicket.changeSeat("B2");
        validTicket.bookTicket();

        validTicket.displayTicketDetails();
        negativePriceTicket.displayTicketDetails();
        zeroPriceTicket.displayTicketDetails();

        
        DigitalWallet wallet1 = new DigitalWallet("W01", "Omar", 3000.0);
        DigitalWallet wallet2 = new DigitalWallet("W02", "Ali", 500.0);

        wallet1.deposit(500.0);
        wallet1.deposit(-100.0);

        wallet1.withdraw(10000.0);
        wallet1.withdraw(-50.0);
        wallet1.withdraw(200.0);

        wallet1.transfer(100.0, null);
        wallet1.transfer(100.0, wallet1);
        wallet1.transfer(100.0, wallet2);
        wallet1.transfer(600.0, wallet2);
        wallet1.transfer(1500.0, wallet2);
        wallet2.transfer(5000.0, wallet1);

        wallet1.displayWalletDetails();
        wallet2.displayWalletDetails();

    
        DeliveryOrder cashOrder = new DeliveryOrder("O01", "Omar", "Alexandria", 2, 200.0);
        DeliveryOrder walletOrder = new DeliveryOrder("O02", "Omar", "Alexandria", 4, 1200.0, wallet1);

        cashOrder.deliverOrder();
        cashOrder.payOrder();
        cashOrder.deliverOrder();

        walletOrder.payOrder();
        walletOrder.deliverOrder();

        cashOrder.displayOrderDetails();
        walletOrder.displayOrderDetails();
        
        
        wallet1.displayWalletDetails();
    }
}