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

        ParkingSlot slot =
                findAvailableSlot(slots);

        if (slot != null) {
            slot.allot(vehicleNo);
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
}
