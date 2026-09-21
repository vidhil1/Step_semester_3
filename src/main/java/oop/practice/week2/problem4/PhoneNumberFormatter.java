public class PhoneNumberFormatter {

    public static String maskPhoneNumber(
            String phone) {

        if (phone == null
                || phone.length() != 10) {

            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {

            if (!Character.isDigit(phone.charAt(i))) {

                return "Invalid phone number";
            }
        }

        StringBuilder masked =
                new StringBuilder("XXXXXX");

        masked.append("-");

        masked.append(
                phone.substring(6)
        );

        return masked.toString();
    }

    public static void main(String[] args) {

        String phone1 =
                "9876543210";

        String phone2 =
                "98765";

        System.out.println(
                maskPhoneNumber(phone1)
        );

        System.out.println(
                maskPhoneNumber(phone2)
        );
    }
}
