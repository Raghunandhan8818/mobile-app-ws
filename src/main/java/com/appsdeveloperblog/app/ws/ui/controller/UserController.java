package com.appsdeveloperblog.app.ws.ui.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping(path = {"/{userID}"})
    public String getUsers(@PathVariable String userID) {
        return "Get Users Called" + userID;
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
