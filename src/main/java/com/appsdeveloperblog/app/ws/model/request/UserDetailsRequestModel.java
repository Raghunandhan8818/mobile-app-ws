package com.appsdeveloperblog.app.ws.model.request;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDetailsRequestModel {

    @NotNull(message = "Firstname Cannot be Empty")
    private String firstName;

    @NotNull(message = "Lastname cannot be Empty")
    private String lastName;

    @NotNull(message = "Email Cannot be Empty")
    @Email
    private String email;

    @NotNull(message = "Password cannot be Empty")
    @Size(min = 8, max = 16, message = "Password should > 8 &  < 16")
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
