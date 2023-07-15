package com.example.Restaurant.management.service.API.controller;

import com.example.Restaurant.management.service.API.model.GiveOrder;
import com.example.Restaurant.management.service.API.model.User;
import com.example.Restaurant.management.service.API.model.dto.SignInInput;
import com.example.Restaurant.management.service.API.model.dto.SignUpOutput;
import com.example.Restaurant.management.service.API.service.AuthTokenService;
import com.example.Restaurant.management.service.API.service.UserService;
import jakarta.persistence.criteria.Order;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthTokenService authenticationService;

    @PostMapping("user/signup")
    public SignUpOutput signUpUser(@RequestBody User user)
    {

        return userService.signUpUser(user);
    }

    @PostMapping("user/signIn")
    public String sigInUser(@RequestBody @Valid SignInInput signInInput)
    {
        return userService.signInUser(signInInput);
    }

    @DeleteMapping("user/signOut")
    public String sigOutUser(String email, String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.sigOutUser(email);
        }
        else {
            return "Sign out not allowed for non authenticated user.";
        }

    }

    @PostMapping("order")
    public String  scheduleAppointment(@RequestBody GiveOrder order, String email, String token)
    {

        if(authenticationService.authenticate(email,token)) {
            boolean status = userService.createOrder(order);
            return status ? "Order Placed":"error occurred placing order";
        }
        else
        {
            return "Invalid authentication";
        }
    }

    @DeleteMapping("order/cancel")
    public String  cancelOrder(String email, String token)
    {

        if(authenticationService.authenticate(email,token)) {
            userService.deleteOrder(email);
            return "canceled order successfully";
        }
        else
        {
            return "Cancellation failed because invalid authentication";
        }
    }



}
