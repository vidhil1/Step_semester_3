package oop.assignment_problems;

public class BookCopyCirculationGuard {

    static class BookInventory {

        private int copiesTotal;
        private int copiesAvailable;

        BookInventory(int copiesTotal) {

            if (copiesTotal <= 0 || copiesTotal > 500) {
                throw new IllegalArgumentException("Invalid copiesTotal");
            }

            this.copiesTotal = copiesTotal;
            this.copiesAvailable = copiesTotal;
        }

        void checkOut() {

            if (copiesAvailable > 0) {
                copiesAvailable--;
            }
        }

        void checkIn() {

            if (copiesAvailable < copiesTotal) {
                copiesAvailable++;
            }
        }

        int getCopiesAvailable() {
            return copiesAvailable;
        }
    }

    public static void main(String[] args) {

        try {
            new BookInventory(0);
        } catch (IllegalArgumentException e) {
            System.out.println("construction rejected");
        }

        BookInventory b = new BookInventory(3);

        b.checkOut();
        b.checkOut();
        b.checkOut();
        b.checkOut();

        System.out.println(
            "Available after checkout: "
            + b.getCopiesAvailable()
        );

        b.checkIn();
        b.checkIn();
        b.checkIn();
        b.checkIn();

        System.out.println(
            "Available after check-in: "
            + b.getCopiesAvailable()
        );
    }
}