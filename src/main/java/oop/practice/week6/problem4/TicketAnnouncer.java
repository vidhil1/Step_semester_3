public class TicketAnnouncer {

    public static String batchPrint(EventTicket[] tickets) {

        StringBuilder report = new StringBuilder();

        for (EventTicket ticket : tickets) {

            report.append(ticket.printTicket());

            if (ticket instanceof WorkshopTicket) {

                WorkshopTicket workshop =
                        (WorkshopTicket) ticket;

                report.append(" [Track via downcast: ")
                      .append(workshop.getTrack())
                      .append("]");
            }

            report.append(" | ");
        }

        return report.toString();
    }
}
