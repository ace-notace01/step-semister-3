package Week5.AssignmentProblems;

public class MembershipFieldReachChecker {

    enum AccessContext {
        SAME_CLASS,
        SAME_PACKAGE,
        DIFFERENT_PACKAGE,
        SUBCLASS_SAME_PACKAGE,
        SUBCLASS_DIFFERENT_PACKAGE
    }

    // Checks whether a field with the given modifier is accessible
    // from the specified context.
    static String classifyAccess(String fieldModifier,
                                 String accessContext) {

        fieldModifier = fieldModifier.toLowerCase();

        switch (fieldModifier) {

            case "private":
                if (accessContext.equals("SAME_CLASS")) {
                    return "ALLOWED";
                }
                return "DENIED";

            case "default":
                if (accessContext.equals("SAME_PACKAGE") ||
                    accessContext.equals("SUBCLASS_SAME_PACKAGE")) {
                    return "ALLOWED";
                }
                return "DENIED";

            case "protected":
                if (accessContext.equals("SAME_CLASS") ||
                    accessContext.equals("SAME_PACKAGE") ||
                    accessContext.equals("SUBCLASS_SAME_PACKAGE") ||
                    accessContext.equals("SUBCLASS_DIFFERENT_PACKAGE")) {
                    return "ALLOWED";
                }
                return "DENIED";

            case "public":
                return "ALLOWED";

            default:
                return "DENIED";
        }
    }

    static String summarizeByModifier(String[][] attempts) {

        int privateAllowed = 0;
        int privateDenied = 0;

        int defaultAllowed = 0;
        int defaultDenied = 0;

        int protectedAllowed = 0;
        int protectedDenied = 0;

        int publicAllowed = 0;
        int publicDenied = 0;

        // Group by modifier, NOT by order of attempts
        for (String[] attempt : attempts) {

            String modifier = attempt[0];
            String context = attempt[1];

            String result = classifyAccess(modifier, context);

            if (modifier.equals("private")) {
                if (result.equals("ALLOWED"))
                    privateAllowed++;
                else
                    privateDenied++;
            }

            else if (modifier.equals("default")) {
                if (result.equals("ALLOWED"))
                    defaultAllowed++;
                else
                    defaultDenied++;
            }

            else if (modifier.equals("protected")) {
                if (result.equals("ALLOWED"))
                    protectedAllowed++;
                else
                    protectedDenied++;
            }

            else if (modifier.equals("public")) {
                if (result.equals("ALLOWED"))
                    publicAllowed++;
                else
                    publicDenied++;
            }
        }

        return "private: " + privateAllowed + " allowed / "
                + privateDenied + " denied | "
                + "default: " + defaultAllowed + " allowed / "
                + defaultDenied + " denied | "
                + "protected: " + protectedAllowed + " allowed / "
                + protectedDenied + " denied | "
                + "public: " + publicAllowed + " allowed / "
                + publicDenied + " denied";
    }

    public static void main(String[] args) {

        System.out.println(
            classifyAccess("private", "SAME_CLASS")
        );

        System.out.println(
            classifyAccess("protected", "DIFFERENT_PACKAGE")
        );

        String[][] attempts = {
            {"private", "SAME_CLASS"},
            {"private", "SAME_PACKAGE"},

            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},

            {"protected", "SAME_PACKAGE"},
            {"protected", "DIFFERENT_PACKAGE"},

            {"public", "SAME_CLASS"},
            {"public", "DIFFERENT_PACKAGE"}
        };

        System.out.println(
            summarizeByModifier(attempts)
        );
    }
}