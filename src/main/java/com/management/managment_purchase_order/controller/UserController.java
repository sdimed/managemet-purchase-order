package com.management.managment_purchase_order.controller;

import com.management.managment_purchase_order.entity.User;
import com.management.managment_purchase_order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping
    public User save(User user){
        return userService.save(user);
    }
    @Secured(value = {"ADMIN"})
    @GetMapping
    public List<User> get(){
        return userService.get();
    }
}
