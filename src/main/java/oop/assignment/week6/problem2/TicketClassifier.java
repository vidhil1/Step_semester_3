public class TicketClassifier {

    public static String classifyGeneration(EventTicket ticket) {

        if (ticket instanceof PremiumWorkshopTicket) {
            return "Multilevel descendant (3 generations deep)";
        }

        if (ticket instanceof HackathonTicket) {
            return "Hierarchical sibling (independent branch)";
        }

        if (ticket instanceof WorkshopTicket) {
            return "Single inheritance";
        }

        return "Base class";
    }

    public static double getTotalBalanceDue(EventTicket[] tickets) {

        double total = 0;

        for (EventTicket ticket : tickets) {
            total = total + ticket.getBalanceDue();
        }

        return total;
    }
}
