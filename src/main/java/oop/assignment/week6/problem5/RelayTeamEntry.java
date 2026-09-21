public class RelayTeamEntry extends RaceEntry {

    private int teamSize;

    public RelayTeamEntry(String bibNumber,
                          double entryFee,
                          int teamSize) {

        super(bibNumber, entryFee);

        if (teamSize <= 0) {
            throw new IllegalArgumentException("Invalid team size");
        }

        this.teamSize = teamSize;
    }

    public int getTeamSize() {
        return teamSize;
    }
}
