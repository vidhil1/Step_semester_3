public class BrokenLibraryMember {

    /*
     * These fields are intentionally static to reproduce
     * the broken version from the assignment.
     *
     * Static fields are shared by every object of the class.
     * Therefore, the second member overwrites the first member.
     */
    static String name;
    static String memberId;
    static int booksIssued;

    public BrokenLibraryMember(
            String name,
            String memberId,
            int booksIssued) {

        BrokenLibraryMember.name = name;
        BrokenLibraryMember.memberId = memberId;
        BrokenLibraryMember.booksIssued = booksIssued;
    }

    public void printMemberCard() {

        System.out.println(
                name
                + " | "
                + memberId
        );
    }
}
