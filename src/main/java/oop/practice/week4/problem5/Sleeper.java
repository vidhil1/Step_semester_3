public class Sleeper extends BusTicketAccount {

    public Sleeper(String bookingId, double ticketFare) {
        super(bookingId, ticketFare);
    }

    public Sleeper(String bookingId) {
        super(bookingId);
    }

    @Override
    public final double calculatePenalty(int minutesLate) {

        double regularPenalty =
                super.calculatePenalty(minutesLate);

        return regularPenalty * 1.5;
    }
}
