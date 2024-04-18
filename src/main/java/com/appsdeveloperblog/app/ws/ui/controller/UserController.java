package com.appsdeveloperblog.app.ws.ui.controller;

import com.appsdeveloperblog.app.ws.model.request.UpdateUserDetailRequestModel;
import com.appsdeveloperblog.app.ws.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;
import com.appsdeveloperblog.app.ws.userservice.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertFalse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("users")
public class UserController {

    Map<String, UserRest> users;

    @Autowired
    UserService user_service;

    @GetMapping(path = {"/{userID}"}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> getUsers(@PathVariable String userID) {
        if (users.containsKey(userID)) {
            return new ResponseEntity<>(users.get(userID), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping
    public String getUser(@RequestParam(value = "page", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "4545") int limit, @RequestParam(value = "sort", required = false) String sort) {
        if (sort != null) {
            return "Get Users Called" + String.valueOf(page) + String.valueOf(limit) + sort;
        } else {
            return "Get Users Called" + String.valueOf(page) + String.valueOf(limit);
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
        UserRest user = user_service.createUser(userDetails);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{userID}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> updateUser(@PathVariable String userID, @Valid @RequestBody UpdateUserDetailRequestModel userDetails) {
        UserRest storedUser = users.get(userID);
        storedUser.setFirstName(userDetails.getFirstName());
        storedUser.setLastName(userDetails.getLastName());

        return new ResponseEntity<>(storedUser, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        users.remove(userId);
        return ResponseEntity.noContent().build();
    }

}
