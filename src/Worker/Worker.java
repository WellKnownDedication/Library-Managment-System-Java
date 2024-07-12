package Worker;

public class Worker {
    private String UserName;
    private String ContactInfo;
    private char[] password;
    private Role role;

    public Worker(String user, String contactInfo, char[] password, Role role) {
        this.UserName = user;
        this.ContactInfo = contactInfo;
        this.password = password;
        this.role = role;
    }

    public String GetUserName() {
        return this.UserName;
    }

    public String GetContactInfo() {
        return this.ContactInfo;
    }

    public char[] GetPassword() {
        return this.password;
    }

    public Role GetRole() {
        return this.role;
    }
}
