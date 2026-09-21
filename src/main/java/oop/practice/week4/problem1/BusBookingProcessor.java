public class BusBookingProcessor {

    public static void processBatch(String[][] rawBookings) {

        int valid = 0;
        int rejected = 0;
        int duplicates = 0;

        String[][] accepted = new String[rawBookings.length][2];

        for (String[] booking : rawBookings) {

            if (booking == null || booking.length < 2) {
                rejected++;
                continue;
            }

            String passengerName = booking[0];
            String destination = booking[1];

            try {

                BusTicket ticket =
                        new BusTicket(passengerName, destination);

                boolean duplicate = false;

                for (int i = 0; i < valid; i++) {

                    if (accepted[i][0].equals(passengerName)
                            && accepted[i][1].equals(destination)) {

                        duplicate = true;
                        break;
                    }
                }

                if (duplicate) {
                    duplicates++;
                } else {

                    accepted[valid][0] = passengerName;
                    accepted[valid][1] = destination;

                    valid++;
                }

            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        System.out.println(
                "Valid: " + valid
                + " | Rejected: " + rejected
                + " | Duplicates skipped: " + duplicates
        );
    }
}
