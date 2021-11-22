package com.capgemini.ebugtracker.user.controller;
import com.capgemini.ebugtracker.exception.BugNotFoundException;
import com.capgemini.ebugtracker.user.entity.Customer;
import com.capgemini.ebugtracker.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/user")

public class UserController {

    private UserService userService;
    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/getAllUsers")
    public List<Customer> getAllUsers(){
        return userService.getAllUser();
    }

    @GetMapping("/getUser/{userId}")
    public Customer getUser(@PathVariable("userId") String userId){
        Customer user = userService.getUser(Long.parseLong(userId));
        if(Objects.isNull(user)){
            throw new BugNotFoundException();
        }
        return user;
    }

    @PostMapping("/saveUser")
    public Customer saveUser(@RequestBody Customer users){
        return userService.registerCustomer(users);
    }



}
