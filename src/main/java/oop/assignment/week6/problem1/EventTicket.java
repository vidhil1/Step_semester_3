public class EventTicket {

    protected String attendeeId;
    protected double basePrice;
    protected double balanceDue;

    public EventTicket(String attendeeId, double basePrice) {

        if (attendeeId == null || attendeeId.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid attendee ID");
        }

        this.attendeeId = attendeeId.trim();
        this.basePrice = basePrice;
        this.balanceDue = basePrice;
    }

    public void pay(double amount) {
        balanceDue = balanceDue - amount;
    }

    public double getBalanceDue() {
        return balanceDue;
    }

    public static String registerBatch(String[] attendeeIds, double basePrice) {

        int registered = 0;
        int rejected = 0;

        for (String id : attendeeIds) {
            try {
                new EventTicket(id, basePrice);
                registered++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Registered: " + registered + " | Rejected: " + rejected;
    }

    public String printTicket() {
        return "Standard Event Ticket | Balance Due: " + balanceDue;
    }
}
