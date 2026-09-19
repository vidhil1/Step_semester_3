public class WorkshopTicket extends EventTicket {

    private String track;

    public WorkshopTicket(double basePrice, String track) {
        super(basePrice);
        this.track = track;
    }

    public String getTrack() {
        return track;
    }

    @Override
    public String printTicket() {
        return "Workshop | Track: " + track
                + " | Balance: " + balanceDue;
    }
}
