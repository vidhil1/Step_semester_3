public class BusTicketTest {

    public static void main(String[] args) {

        String[][] bookings = {
                {"Divya", "Chennai"},
                {"", "Bangalore"},
                {"Ravi123", "Pune"},
                {"Divya", "Chennai"},
                {" ", " "}
        };

        BusBookingProcessor.processBatch(bookings);

        BusTicket ticket =
                new BusTicket("Divya", "Chennai");

        ticket.markCheckedIn();
        ticket.markCheckedIn();

        System.out.println(
                ticket.getPassengerName()
                + " -> "
                + ticket.getDestination()
        );
    }
}
