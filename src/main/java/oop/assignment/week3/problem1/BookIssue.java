public class BookIssue {

    private String title;
    private String borrowerName;
    private int daysOverdue;

    public BookIssue(String title, String borrowerName, int daysOverdue) {
        this.title = title;
        this.borrowerName = borrowerName;
        this.daysOverdue = daysOverdue;
    }

    public double fineAmount() {
        if (daysOverdue > 0) {
            return daysOverdue * 5.0;
        }

        return 0.0;
    }

    public boolean isSeverelyOverdue() {
        return daysOverdue > 14;
    }

    /*
     * fineAmount() is an instance method because the fine depends
     * on one particular book issue and its daysOverdue.
     *
     * totalFineCollected() is static because it works on an
     * entire array of BookIssue objects, not on one particular book.
     */
    public static double totalFineCollected(BookIssue[] issues) {

        double total = 0.0;

        if (issues == null) {
            return total;
        }

        for (BookIssue issue : issues) {

            if (issue != null) {
                total += issue.fineAmount();
            }
        }

        return total;
    }

    public String getTitle() {
        return title;
    }

    public int getDaysOverdue() {
        return daysOverdue;
    }

    public static void main(String[] args) {

        BookIssue[] issues = {
                new BookIssue("Clean Code", "Aditi", 18),
                new BookIssue("Effective Java", "Rohan", 5),
                new BookIssue("Refactoring", "Karan", 0),
                new BookIssue("DSA Handbook", "Meera", 21),
                new BookIssue("Design Patterns", "Divya", 9)
        };

        for (BookIssue issue : issues) {

            String status;

            if (issue.isSeverelyOverdue()) {
                status = "Severely overdue";
            } else {
                status = "OK";
            }

            System.out.println(
                    issue.getTitle()
                    + " - "
                    + issue.getDaysOverdue()
                    + " days - "
                    + status
            );
        }

        System.out.println(
                "Total fine collected: Rs "
                + BookIssue.totalFineCollected(issues)
        );
    }
}
