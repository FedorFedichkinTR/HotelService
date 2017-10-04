package model;

/**
 * class for user representation
 */
public class User {
    private long userID;
    private String eMail;
    private String password;
    private String firstName;
    private String lastName;
    private Roles role;

    /**
     * No-args constructor for user initialization
     */
    public User() {

    }

    /**
     *constructor with all arguments
     *
     * @param userID
     * @param eMail e-mail adres
     * @param password
     * @param firstName
     * @param lastName
     * @param role
     */
    public User(long userID, String eMail, String password, String firstName, String lastName, Roles role) {
        this.userID = userID;
        this.eMail = eMail;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}
