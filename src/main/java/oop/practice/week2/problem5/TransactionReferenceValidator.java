public class TransactionReferenceValidator {

    public static String normalizeReference(
            String raw) {

        if (raw == null) {
            return null;
        }

        String reference =
                raw.trim();

        if (reference.length() < 3) {
            return reference;
        }

        String bankCode =
                reference
                        .substring(0, 3)
                        .toUpperCase();

        String remaining =
                reference.substring(3);

        return bankCode + remaining;
    }

    public static String validateAndFormat(
            String reference) {

        if (reference == null) {

            return "Invalid: wrong length";
        }

        if (reference.length() != 14) {

            return "Invalid: wrong length";
        }

        /*
         * Check the first three characters.
         */
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(
                    reference.charAt(i))) {

                return "Invalid: bank code must be 3 letters";
            }
        }

        /*
         * Check the remaining eleven characters.
         */
        for (int i = 3; i < 14; i++) {

            if (!Character.isDigit(
                    reference.charAt(i))) {

                return "Invalid: body must contain only digits";
            }
        }

        String bankCode =
                reference.substring(0, 3);

        String date =
                reference.substring(3, 9);

        String sequence =
                reference.substring(9, 14);

        String day =
                date.substring(0, 2);

        String month =
                date.substring(2, 4);

        String year =
                date.substring(4, 6);

        StringBuilder result =
                new StringBuilder();

        result.append("[");
        result.append(bankCode);
        result.append("] DATE: ");
        result.append(day);
        result.append("/");
        result.append(month);
        result.append("/");
        result.append(year);
        result.append(" | SEQ: ");
        result.append(sequence);

        return result.toString();
    }

    public static void main(String[] args) {

        String rawReference =
                " hdf03022600042 ";

        String normalized =
                normalizeReference(rawReference);

        System.out.println(
                validateAndFormat(normalized)
        );

        String invalidReference =
                "12F03022600042";

        String normalizedInvalid =
                normalizeReference(
                        invalidReference
                );

        System.out.println(
                validateAndFormat(
                        normalizedInvalid
                )
        );
    }
}
