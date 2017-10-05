package model;

import model.enums.Roles;

/**
 * class for user representation
 */
public class User {
    private Long userID;
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

    public User(Long userID, String eMail, String password, String firstName, String lastName, Roles role) {
        this.userID = userID;
        this.eMail = eMail;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
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

    @Override
    public String toString() {
        return "user ID : " + userID + ", "+ firstName + ", "+ lastName;
    }
}
