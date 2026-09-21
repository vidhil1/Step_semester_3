public class FeeAccountTest {

    public static void main(String[] args) {

        FeeAccount plain =
                new FeeAccount(
                        "RA101",
                        150000,
                        150000
                );

        HostelFeeAccount hostel =
                new HostelFeeAccount(
                        "RA102",
                        200000,
                        0
                );

        ScholarshipFeeAccount scholarship =
                new ScholarshipFeeAccount(
                        "RA103",
                        180000,
                        0,
                        20
                );

        hostel.payInTwoInstallments(60000);

        FeeAccount[] accounts = {
                plain,
                hostel,
                scholarship
        };

        for (FeeAccount account : accounts) {

            if (account instanceof HostelFeeAccount) {

                HostelFeeAccount hostelAccount =
                        (HostelFeeAccount) account;

                System.out.println(
                        "Hostel account due: Rs "
                        + hostelAccount.getDue()
                );

            } else if (
                    account instanceof ScholarshipFeeAccount) {

                ScholarshipFeeAccount scholarshipAccount =
                        (ScholarshipFeeAccount) account;

                System.out.println(
                        "Scholarship account effective due: "
                        + "Rs "
                        + scholarshipAccount.effectiveDue()
                );

            } else {

                System.out.println(
                        "Plain account due: Rs "
                        + account.getDue()
                );
            }
        }
    }
}
