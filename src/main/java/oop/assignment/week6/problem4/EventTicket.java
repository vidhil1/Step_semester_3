public class EventTicket {

    protected double balanceDue;

    public EventTicket(double basePrice) {
        balanceDue = basePrice;
    }

    public void pay(double amount) {
        balanceDue = balanceDue - amount;
    }

    public double getBalanceDue() {
        return balanceDue;
    }

    public String printTicket() {
        return "Standard | Balance: " + balanceDue;
    }
}
