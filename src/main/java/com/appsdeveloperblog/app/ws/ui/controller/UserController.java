package com.appsdeveloperblog.app.ws.ui.controller;

import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping(path = {"/{userID}"}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> getUsers(@PathVariable String userID) {
        UserRest user = new UserRest();
        user.setUserID(userID);
        user.setEmail("email@email.com");
        user.setFirstName("firstName");
        user.setLastName("lastName");
        return new ResponseEntity<UserRest>(user, HttpStatus.OK);
    }

    @GetMapping
    public String getUser(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "4545") int limit, @RequestParam(value = "sort", required = false) String sort) {
        if(sort != null) {
            return "Get Users Called" + String.valueOf(page) + String.valueOf(limit) + sort;
        }else{
            return "Get Users Called" + String.valueOf(page) + String.valueOf(limit) ;
        }
    }

    @PostMapping
    public String createUser() {
        return "Create User Called";
    }

    @PutMapping
    public String updateUser() {
        return "Update User Called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "Delete User Called";
    }

}
