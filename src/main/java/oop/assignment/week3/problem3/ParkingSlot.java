public class ParkingSlot {

    private String slotNo;
    private int capacity;
    private int occupiedCount;

    public ParkingSlot(
            String slotNo,
            int capacity,
            int occupiedCount) {

        this.slotNo = slotNo;
        this.capacity = capacity;
        this.occupiedCount = occupiedCount;
    }

    public boolean allot(String vehicleNo) {

        if (occupiedCount < capacity) {

            occupiedCount++;

            System.out.println(
                    vehicleNo
                    + " allotted to slot "
                    + slotNo
            );

            return true;
        }

        return false;
    }

    public static ParkingSlot findAvailableSlot(
            ParkingSlot[] slots) {

        if (slots == null) {
            return null;
        }

        for (ParkingSlot slot : slots) {

            if (slot != null
                    && slot.occupiedCount < slot.capacity) {

                return slot;
            }
        }

        return null;
    }

    public static void safeAllot(
            ParkingSlot[] slots,
            String vehicleNo) {

        ParkingSlot available =
                findAvailableSlot(slots);

        if (available != null) {

            available.allot(vehicleNo);

        } else {

            System.out.println(
                    "No slots available for "
                    + vehicleNo
            );
        }
    }

    public String getSlotNo() {
        return slotNo;
    }

    public int getOccupiedCount() {
        return occupiedCount;
    }

    public int getCapacity() {
        return capacity;
    }

    /*
     * Passing a ParkingSlot[] does not create copies of the
     * ParkingSlot objects. The array contains references to the
     * original objects, so changes made through a reference
     * affect the same ParkingSlot object.
     */

    public static void main(String[] args) {

        ParkingSlot[] availableSlots = {
                new ParkingSlot("A1", 4, 3),
                new ParkingSlot("A2", 5, 5)
        };

        safeAllot(
                availableSlots,
                "TN09AB1234"
        );

        ParkingSlot[] fullSlots = {
                new ParkingSlot("A1", 4, 4),
                new ParkingSlot("A2", 5, 5)
        };

        safeAllot(
                fullSlots,
                "TN09AB1234"
        );
    }
}
