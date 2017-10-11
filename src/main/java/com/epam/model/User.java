package com.epam.model;


public class User {
    private Long userID;
    private String eMail;
    private String password;
    private String firstName;
    private String lastName;
    private Role role;

    public User() {
    }
    
    public User(Long userID, String eMail, String password, String firstName, String lastName, Role role) {
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

    public String getEmail() {
        return eMail;
    }

    public void setEmail(String eMail) {
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!userID.equals(user.userID)) return false;
        if (!eMail.equals(user.eMail)) return false;
        if (!password.equals(user.password)) return false;
        if (!firstName.equals(user.firstName)) return false;
        if (!lastName.equals(user.lastName)) return false;
        return role == user.role;
    }

    @Override
    public int hashCode() {
        int result = userID.hashCode();
        result = 31 * result + eMail.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "user ID : " + userID + ", "+ firstName + ", "+ lastName;
    }
}
