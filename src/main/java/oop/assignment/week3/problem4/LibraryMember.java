public class LibraryMember {

    private String name;
    private String memberId;
    private int booksIssued;

    private static String libraryName =
            "Central Library";

    private static int memberCount = 0;

    public LibraryMember(
            String name,
            int booksIssued) {

        this.name = name;
        this.booksIssued = booksIssued;

        memberCount++;

        this.memberId =
                "LM-"
                + (1000 + memberCount);
    }

    public void printMemberCard() {

        System.out.println(
                name
                + " | "
                + memberId
        );
    }

    public static void printTotalMembers() {

        System.out.println(
                "Total members: "
                + memberCount
        );
    }

    public static String getLibraryName() {
        return libraryName;
    }
}
