public class HostelRoom {

    private String roomNo;
    private int beds;
    private int occupied;

    public HostelRoom(
            String roomNo,
            int beds,
            int occupied) {

        this.roomNo = roomNo;
        this.beds = beds;
        this.occupied = occupied;
    }

    public boolean allot(String name) {

        if (occupied < beds) {
            occupied++;
            return true;
        }

        return false;
    }

    public static HostelRoom findAvailableRoom(
            HostelRoom[] rooms) {

        if (rooms == null) {
            return null;
        }

        for (HostelRoom room : rooms) {

            if (room != null
                    && room.occupied < room.beds) {

                return room;
            }
        }

        return null;
    }

    public static void safeAllot(
            HostelRoom[] rooms,
            String studentName) {

        HostelRoom room =
                findAvailableRoom(rooms);

        if (room != null) {
            room.allot(studentName);
        } else {
            System.out.println(
                    "No rooms available for "
                    + studentName
            );
        }
    }

    public String getRoomNo() {
        return roomNo;
    }
}
