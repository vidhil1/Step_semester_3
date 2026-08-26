package oop.assigment_problems;

public class LibraryMember {

    // Broken version:
    // name, memberId and booksIssued should NOT be static.
    // If they are static, all LibraryMember objects share the same data.
    // Therefore, creating Rohan after Aditi overwrites Aditi's data.

    // Fixed version:
    private String name;
    private String memberId;
    private int booksIssued;

    private static String libraryName = "SRM Library";
    private static int memberCount = 0;

    public LibraryMember(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;

        memberCount++;
        this.memberId = "LM-" + (1000 + memberCount);
    }

    public void printMemberCard() {
        System.out.println(name + " | " + memberId);
    }

    public static void printTotalMembers() {
        System.out.println("Total members: " + memberCount);
    }

    public static void main(String[] args) {

        // Demonstrating the broken static behaviour
        System.out.println("Broken version:");

        BrokenLibraryMember member1 =
                new BrokenLibraryMember("Aditi", "LM-1001", 2);

        BrokenLibraryMember member2 =
                new BrokenLibraryMember("Rohan", "LM-1002", 3);

        member1.printName();
        member2.printName();

        // Corrected version
        System.out.println("Fixed version:");

        LibraryMember m1 =
                new LibraryMember("Aditi", 2);

        LibraryMember m2 =
                new LibraryMember("Rohan", 3);

        m1.printMemberCard();
        m2.printMemberCard();

        LibraryMember.printTotalMembers();
    }

    // Separate class used only to demonstrate the broken design.
    static class BrokenLibraryMember {

        static String name;
        static String memberId;
        static int booksIssued;

        BrokenLibraryMember(String name, String memberId, int booksIssued) {
            BrokenLibraryMember.name = name;
            BrokenLibraryMember.memberId = memberId;
            BrokenLibraryMember.booksIssued = booksIssued;
        }

        void printName() {
            System.out.println(name);
        }
    }
}