package Week5.AssignmentProblems;

public class LibraryMember {

    private String membershipId;
    private String name;
    private boolean premiumMember;

    private String securityAnswer;


    // Public no-argument constructor
    public LibraryMember() {
    }


    // JavaBean getter and setter for membershipId

    public String getMembershipId() {
        return membershipId;
    }


    public void setMembershipId(String membershipId) {

        // Write once
        if (this.membershipId == null) {
            this.membershipId = membershipId;
        }
    }


    // JavaBean getter and setter for name

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    // Boolean JavaBean property

    public boolean isPremiumMember() {
        return premiumMember;
    }


    public void setPremiumMember(boolean premiumMember) {
        this.premiumMember = premiumMember;
    }


    // Write-only security answer

    public void setSecurityAnswer(String answer) {

        // One-way deterministic transformation
        // Simple transformation is enough; no cryptographic library required.
        this.securityAnswer = transform(answer);
    }


    private String transform(String answer) {

        if (answer == null) {
            return null;
        }

        return new StringBuilder(answer)
                .reverse()
                .toString();
    }


    public static void main(String[] args) {

        LibraryMember m = new LibraryMember();

        m.setMembershipId("LIB-8841");
        m.setName("Priya Nair");
        m.setPremiumMember(true);

        System.out.println(m.getMembershipId());

        // Write-once test
        m.setMembershipId("FAKE-0000");

        System.out.println(m.getMembershipId());

        // Boolean getter
        System.out.println(m.isPremiumMember());

        // Write-only property
        m.setSecurityAnswer("BlueMountain");
    }
}