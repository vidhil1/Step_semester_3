public class LibraryCheckout {

    public static void processCheckouts(LibraryItem[] items) {

        for (LibraryItem item : items) {

            System.out.println(
                item.getItemId()
                + " | Loan period: "
                + item.getLoanPeriodDays()
                + " days"
            );
        }
    }

    public static String reserveIfSupported(Object o) {

        if (o instanceof Reservable) {

            Reservable item = (Reservable) o;

            return item.reserve();
        }

        return "Reservation not supported";
    }
}
