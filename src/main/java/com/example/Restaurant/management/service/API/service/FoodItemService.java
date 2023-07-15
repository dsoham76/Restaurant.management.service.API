package com.example.Restaurant.management.service.API.service;

import com.example.Restaurant.management.service.API.model.FoodItem;
import com.example.Restaurant.management.service.API.repository.IFoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FoodItemService {
    @Autowired
    IFoodItemRepo foodItemRepo;


    public String addFoodItems(FoodItem foodItem){
        foodItemRepo.save(foodItem);
        return "Food Item has been added.";
    }

    public String removeFoodItem(FoodItem foodItem){
        foodItemRepo.delete(foodItem);
        return "Food Item has been removed";

    }
}
