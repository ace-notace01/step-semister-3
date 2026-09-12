package Week5.AssignmentProblems;

public class ReferenceDeskSubclassReach {

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
                    accessContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {

                    return "ALLOWED";
                }

                if (accessContext.equals("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE")) {
                    return "DENIED";
                }

                return "DENIED";

            case "public":
                return "ALLOWED";

            default:
                return "DENIED";
        }
    }


    static String firstDeniedAttempt(String[][] attempts) {

        for (int i = 0; i < attempts.length; i++) {

            String modifier = attempts[i][0];
            String context = attempts[i][1];

            String result = classifyAccess(modifier, context);

            if (result.equals("DENIED")) {
                return modifier + " via " + context
                        + " (attempt #" + (i + 1) + ")";
            }
        }

        return "None Denied";
    }


    public static void main(String[] args) {

        String[][] attempts = {
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };

        System.out.println(
            firstDeniedAttempt(attempts)
        );


        String[][] attempts2 = {
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };

        System.out.println(
            firstDeniedAttempt(attempts2)
        );
    }
}