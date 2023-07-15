package com.example.Restaurant.management.service.API.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FoodItem {
    private String title;
    private String description;
    private Double price;
}
