package com.appsdeveloperblog.app.ws.model.request;

import jakarta.validation.constraints.NotNull;

public class UpdateUserDetailRequestModel {
    @NotNull(message = "Firstname Cannot be Empty")
    private String firstName;

    @NotNull(message = "Lastname cannot be Empty")
    private String lastName;

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
}
