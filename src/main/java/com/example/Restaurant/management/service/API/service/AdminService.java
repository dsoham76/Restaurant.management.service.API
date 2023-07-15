package com.example.Restaurant.management.service.API.service;



import com.example.Restaurant.management.service.API.model.FoodItem;
import com.example.Restaurant.management.service.API.model.User;
import com.example.Restaurant.management.service.API.repository.IAdminRepo;

import com.example.Restaurant.management.service.API.repository.IFoodItemRepo;
import com.example.Restaurant.management.service.API.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    IAdminRepo adminRepo;

    @Autowired
    IFoodItemRepo foodItemRepo;

    @Autowired
    IUserRepo userRepo;


    public String addFoodItems(FoodItem foodItem){
        foodItemRepo.save(foodItem);
        return "Food Item has been added.";
    }

    public String removeFoodItem(Integer foodId){
        Optional<FoodItem> foodItems=foodItemRepo.findById(foodId);
        FoodItem foodItem=foodItems.get();
        if(foodItems!=null){
            foodItemRepo.delete(foodItem);
            return "Food Item has been removed";
        }else{
            return "No such foodItem exists";
        }

    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }




}
