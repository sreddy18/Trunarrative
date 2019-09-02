package context;

public class TestContext {
    private String registrationNo; // private = restricted access

    // Getter
    public String getRegistrationNo() {
        return registrationNo;
    }

    // Setter
    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
        System.out.println("registrationNo"+registrationNo);
    }
}