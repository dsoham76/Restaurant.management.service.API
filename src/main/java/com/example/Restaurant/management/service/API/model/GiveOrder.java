package com.example.Restaurant.management.service.API.model;

import com.example.Restaurant.management.service.API.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class GiveOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="fk_user_id")
    private User user;
    @OneToMany(cascade =CascadeType.ALL)
    @JoinColumn(name="fk_food_id")
    private List<FoodItem> foodItems;
    private Integer quantity;
    private Status status;
}
