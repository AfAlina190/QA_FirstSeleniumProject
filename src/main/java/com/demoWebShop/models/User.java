package com.demoWebShop.models;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;

    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
