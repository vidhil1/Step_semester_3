package oop.assignment_problems;

public class LibraryMemberJavaBean {

    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;

    public LibraryMemberJavaBean() {
        this(null, null);
    }

    public LibraryMemberJavaBean(String name) {
        this(null, name);
    }

    public LibraryMemberJavaBean(String membershipId, String name) {
        this.membershipId = membershipId;
        this.name = name;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String id) {

        if (this.membershipId == null) {
            this.membershipId = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premium) {
        this.premiumMember = premium;
    }

    public void setSecurityAnswer(String answer) {

        if (answer != null) {
            this.securityAnswer =
                Integer.toHexString(answer.hashCode());
        }
    }

    public static void main(String[] args) {

        LibraryMemberJavaBean member =
            new LibraryMemberJavaBean();

        member.setMembershipId("LIB-8841");
        member.setMembershipId("FAKE-0000");

        System.out.println(
            member.getMembershipId()
        );

        LibraryMemberJavaBean member2 =
            new LibraryMemberJavaBean("Priya Nair");

        System.out.println(
            member2.getMembershipId()
        );
    }
}