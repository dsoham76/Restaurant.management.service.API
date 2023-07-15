package com.example.Restaurant.management.service.API.repository;

import com.example.Restaurant.management.service.API.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFoodItemRepo extends JpaRepository<FoodItem,Integer> {
}
