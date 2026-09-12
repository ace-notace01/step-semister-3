package Week5.AssignmentProblems;
public class LoanReceipt {

    private final String memberId;
    private final String[] bookIds;

    // Class-level initialization
    static {
        // One-time initialization
    }

    // Constructor
    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;

        // Defensive copy
        if (bookIds == null) {
            this.bookIds = new String[0];
        } else {
            this.bookIds = bookIds.clone();
        }
    }

    public String getMemberId() {
        return memberId;
    }

    // Defensive copy
    public String[] getBookIds() {
        return bookIds.clone();
    }

    // Creates a NEW LoanReceipt
    public LoanReceipt withCorrectedBookId(int index, String newId) {

        // Invalid index → return original object
        if (index < 0 || index >= bookIds.length) {
            return this;
        }

        String[] newBookIds = bookIds.clone();

        newBookIds[index] = newId;

        return new LoanReceipt(memberId, newBookIds);
    }

    // Constructor used by ReferenceOnlyLoanReceipt
    protected LoanReceipt(String memberId,
                          String[] bookIds,
                          boolean referenceOnly) {

        this.memberId = memberId;

        if (bookIds == null) {
            this.bookIds = new String[0];
        } else {
            this.bookIds = bookIds.clone();
        }
    }

    // Nightly circulation processor
    public static String processNightlyCirculation(
            LoanReceipt[] receipts) {

        int processed = 0;
        int nullSkipped = 0;
        int referenceOnly = 0;
        int regular = 0;

        if (receipts == null) {
            return "0 processed | 0 null skipped | "
                    + "0 reference-only | 0 regular";
        }

        for (LoanReceipt receipt : receipts) {

            if (receipt == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (receipt instanceof ReferenceOnlyLoanReceipt) {
                referenceOnly++;
            } else {
                regular++;
            }
        }

        return processed + " processed | "
                + nullSkipped + " null skipped | "
                + referenceOnly + " reference-only | "
                + regular + " regular";
    }
}