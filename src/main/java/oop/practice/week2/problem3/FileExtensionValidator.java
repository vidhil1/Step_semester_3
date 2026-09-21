public class FileExtensionValidator {

    public static String validateFileExtension(
            String filename) {

        int dotIndex =
                filename.lastIndexOf('.');

        if (dotIndex == -1
                || dotIndex == filename.length() - 1) {

            return "Rejected — invalid file type";
        }

        String extension =
                filename.substring(dotIndex + 1);

        if (extension.equalsIgnoreCase("pdf")
                || extension.equalsIgnoreCase("docx")
                || extension.equalsIgnoreCase("zip")) {

            return "Accepted";
        }

        return "Rejected — invalid file type";
    }

    public static void main(String[] args) {

        String file1 =
                "Assignment1.PDF";

        String file2 =
                "notes.txt";

        System.out.println(
                validateFileExtension(file1)
        );

        System.out.println(
                validateFileExtension(file2)
        );
    }
}
