public class FirstNonRepeatingCharacter {

    public static char findFirstNonRepeatingChar(
            String text) {

        for (int i = 0;
             i < text.length();
             i++) {

            char current =
                    text.charAt(i);

            int count = 0;

            for (int j = 0;
                 j < text.length();
                 j++) {

                if (text.charAt(j)
                        == current) {

                    count++;
                }
            }

            if (count == 1) {
                return current;
            }
        }

        return '\0';
    }

    public static void main(String[] args) {

        String text1 = "swiss";
        String text2 = "aabbcc";

        char result1 =
                findFirstNonRepeatingChar(text1);

        char result2 =
                findFirstNonRepeatingChar(text2);

        if (result1 != '\0') {

            System.out.println(
                    "First Non-Repeating Character: '"
                    + result1
                    + "'"
            );

        } else {

            System.out.println(
                    "No Non-Repeating Character Found"
            );
        }

        if (result2 != '\0') {

            System.out.println(
                    "First Non-Repeating Character: '"
                    + result2
                    + "'"
            );

        } else {

            System.out.println(
                    "No Non-Repeating Character Found"
            );
        }
    }
}
