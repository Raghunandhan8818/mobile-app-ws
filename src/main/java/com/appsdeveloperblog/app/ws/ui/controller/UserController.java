package com.appsdeveloperblog.app.ws.ui.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public String getUsers() {
        return "Get Users Called";
    }

    @PostMapping
    public String createUser(){
        return "Create User Called";
    }

    @PutMapping
    public String updateUser(){
        return "Update User Called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "Delete User Called";
    }

}
