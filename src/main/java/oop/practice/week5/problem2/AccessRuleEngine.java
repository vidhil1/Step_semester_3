public class AccessRuleEngine {

    public static String classifyAccess(String fieldModifier, String accessorContext) {

        if (fieldModifier.equals("public")) {
            return "ALLOWED";
        }

        if (fieldModifier.equals("private")) {
            if (accessorContext.equals("SAME_CLASS")) {
                return "ALLOWED";
            } else {
                return "DENIED";
            }
        }

        if (fieldModifier.equals("default")) {
            if (accessorContext.equals("SAME_CLASS") ||
                accessorContext.equals("SAME_PACKAGE")) {
                return "ALLOWED";
            } else {
                return "DENIED";
            }
        }

        if (fieldModifier.equals("protected")) {

            if (accessorContext.equals("SAME_CLASS") ||
                accessorContext.equals("SAME_PACKAGE") ||
                accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {
                return "ALLOWED";
            } else {
                return "DENIED";
            }
        }

        return "DENIED";
    }

    public static String describeContext(String accessorContext) {

        String[] words = accessorContext.split("_");

        String result = "";

        for (String word : words) {
            result = result + word.substring(0, 1).toUpperCase()
                    + word.substring(1).toLowerCase() + " ";
        }

        return result.trim();
    }
}
