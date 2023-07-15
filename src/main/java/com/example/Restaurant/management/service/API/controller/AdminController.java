package com.example.Restaurant.management.service.API.controller;

import com.example.Restaurant.management.service.API.model.FoodItem;
import com.example.Restaurant.management.service.API.model.User;
import com.example.Restaurant.management.service.API.service.AdminService;
import com.example.Restaurant.management.service.API.service.FoodItemService;
import com.example.Restaurant.management.service.API.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    FoodItemService foodItemService;

    @Autowired
    UserService userService;

    @PostMapping("foodItem")
    public String addFoodItem(@RequestBody FoodItem foodItem){
        return foodItemService.addFoodItems(foodItem);
    }

    @DeleteMapping("foodItem")
    public String removeFoodItem(@RequestBody FoodItem foodItem){
        return foodItemService.removeFoodItem(foodItem);
    }

    @GetMapping("users")
    public List<User> listOfUsers(){
        return adminService.getAllUsers();
    }




}
