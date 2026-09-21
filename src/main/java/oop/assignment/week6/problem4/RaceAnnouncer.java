public class RaceAnnouncer {

    static String announceAll(RaceEntry[] entries) {

        StringBuilder report = new StringBuilder();

        for (RaceEntry entry : entries) {

            entry.announce();

            if (entry instanceof RelayTeamEntry) {

                RelayTeamEntry relay = (RelayTeamEntry) entry;

                report.append(
                    "Relay Team | Bib: " + relay.bibNumber +
                    " | Team Size: " + relay.getTeamSize() +
                    " | Balance: " + relay.getBalanceDue()
                );

                report.append(
                    " [Team size via downcast: " +
                    relay.getTeamSize() + "] | "
                );

            } else if (entry instanceof RunnerEntry) {

                RunnerEntry runner = (RunnerEntry) entry;

                report.append(
                    "Runner Entry | Bib: " + runner.bibNumber +
                    " | Balance: " + runner.getBalanceDue() +
                    " | "
                );

            } else {

                report.append(
                    "Race Entry | Bib: " + entry.bibNumber +
                    " | Balance: " + entry.getBalanceDue() +
                    " | "
                );
            }
        }

        return report.toString();
    }

    public static void main(String[] args) {

        RunnerEntry runnerEntry =
            new RunnerEntry("BIB2001", 80, "Open 10K");

        RelayTeamEntry relayEntry =
            new RelayTeamEntry("BIB4001", 300, 4);

        RaceEntry[] fleet = {
            runnerEntry,
            relayEntry
        };

        System.out.println(announceAll(fleet));
    }
}
