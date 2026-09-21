public class LibraryMemberTest {

    public static void main(String[] args) {

        System.out.println("Broken version:");

        BrokenLibraryMember first =
                new BrokenLibraryMember(
                        "Aditi",
                        "LM-1001",
                        2
                );

        BrokenLibraryMember second =
                new BrokenLibraryMember(
                        "Rohan",
                        "LM-1002",
                        3
                );

        first.printMemberCard();
        second.printMemberCard();

        System.out.println(
                "(Aditi's data was overwritten because "
                + "the fields were static)"
        );

        System.out.println();

        System.out.println("Fixed version:");

        LibraryMember member1 =
                new LibraryMember(
                        "Aditi",
                        2
                );

        LibraryMember member2 =
                new LibraryMember(
                        "Rohan",
                        3
                );

        member1.printMemberCard();
        member2.printMemberCard();

        LibraryMember.printTotalMembers();
    }
}
