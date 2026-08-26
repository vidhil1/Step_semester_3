package oop.assigment_problems;

public class BookIssue {

    String title;
    String borrowerName;
    int daysOverdue;

    public BookIssue(String title, String borrowerName, int daysOverdue) {
        this.title = title;
        this.borrowerName = borrowerName;
        this.daysOverdue = daysOverdue;
    }
    public double fineAmount() {
    if (daysOverdue > 0) {
        return daysOverdue * 5;
    }
    return 0;
}
public boolean isSeverelyOverdue() {
    return daysOverdue > 14;
}
// totalFineCollected is static because it calculates the total fine for multiple BookIssue objects,
// while fineAmount is an instance method because it calculates the fine for one particular book.
public static double totalFineCollected(BookIssue[] issues) {
    double total = 0;

    for (BookIssue issue : issues) {
        total = total + issue.fineAmount();
    }

    return total;
}
public static void main(String[] args) {
    BookIssue[] issues = {
    new BookIssue("Clean Code", "Aditi", 18),
    new BookIssue("Effective Java", "Rohan", 5),
    new BookIssue("Refactoring", "Karan", 0),
    new BookIssue("DSA Handbook", "Meera", 21),
    new BookIssue("Design Patterns", "Arjun", 9)
};
for (BookIssue issue : issues) {
    System.out.print(issue.title + " - " + issue.daysOverdue + " days - ");

    if (issue.isSeverelyOverdue()) {
        System.out.println("Severely overdue");
    } else {
        System.out.println("OK");
    }
}
System.out.println("Total fine collected: Rs " + BookIssue.totalFineCollected(issues));

}

}