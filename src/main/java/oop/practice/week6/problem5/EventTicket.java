public class EventTicket {

    private static int ticketsIssued = 0;

    public final String ticketId;

    protected double balanceDue;

    public EventTicket(double basePrice) {

        ticketsIssued++;

        ticketId = "TCK-" + (1000 + ticketsIssued);

        balanceDue = basePrice;
    }

    public void pay(double amount) {
        balanceDue = balanceDue - amount;
    }

    public void pay(double amount, String mode) {

        System.out.println("Payment mode: " + mode);

        pay(amount);
    }

    public double getBalanceDue() {
        return balanceDue;
    }

    public static boolean isValidPromoCode(String code) {

        if (code == null || code.length() != 5) {
            return false;
        }

        if (code.charAt(0) != 'F') {
            return false;
        }

        if (!Character.isDigit(code.charAt(1))) {
            return false;
        }

        if (!Character.isDigit(code.charAt(2))) {
            return false;
        }

        if (!Character.isDigit(code.charAt(3))) {
            return false;
        }

        if (!Character.isUpperCase(code.charAt(4))) {
            return false;
        }

        return true;
    }

    public static int getTicketsIssued() {
        return ticketsIssued;
    }
}
