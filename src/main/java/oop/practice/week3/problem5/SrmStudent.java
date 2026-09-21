public class SrmStudent {

    String name;
    String regNo;
    HostelFeeAccount feeAccount;
    HostelRoom room;

    public static int totalStudents = 0;

    public SrmStudent(
            String name,
            String regNo,
            HostelFeeAccount feeAccount,
            HostelRoom room) {

        this.name = name;
        this.regNo = regNo;
        this.feeAccount = feeAccount;
        this.room = room;

        totalStudents++;
    }

    public String fullStatus() {

        String roomInfo;

        if (room == null) {
            roomInfo = "unallotted";
        } else {
            roomInfo = room.getRoomNo();
        }

        return name
                + " | Due: Rs "
                + feeAccount.getDue()
                + " | Room: "
                + roomInfo;
    }
}
