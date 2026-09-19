public class WorkshopTicket extends EventTicket {

    protected String track;

    public WorkshopTicket(String attendeeId, double basePrice, String track) {
        super(attendeeId, basePrice);
        this.track = track;
    }

    @Override
    public String printTicket() {
        return "Workshop Ticket | Track: " + track
                + " | Balance Due: " + balanceDue;
    }

    public String getTrack() {
        return track;
    }
}
