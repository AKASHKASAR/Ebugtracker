package com.capgemini.ebugtracker.user.controller;
import com.capgemini.ebugtracker.exception.BugNotFoundException;
import com.capgemini.ebugtracker.exception.UserNotFoundException;
import com.capgemini.ebugtracker.staff.entity.StatusLogin;
import com.capgemini.ebugtracker.user.entity.Customer;
import com.capgemini.ebugtracker.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/user")

public class UserController {

	
	@Autowired
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
            throw new UserNotFoundException();
        }
        return user;
    }

    @PostMapping("/saveUser")
    public Customer saveUser(@RequestBody Customer users){
        return userService.registerCustomer(users);
    }
    @PostMapping("/login")
    public StatusLogin loginUser(@Validated @RequestBody Customer customer) {
    	return userService.Login(customer);
   	
     
    }



}
