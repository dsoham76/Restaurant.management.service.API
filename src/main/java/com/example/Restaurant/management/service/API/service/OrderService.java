package com.example.Restaurant.management.service.API.service;

import com.example.Restaurant.management.service.API.model.GiveOrder;
import com.example.Restaurant.management.service.API.model.User;
import com.example.Restaurant.management.service.API.repository.IOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    IOrderRepo orderRepo;

    public GiveOrder getOrderForUser(User user) {
        return orderRepo.findFirstByUser(user);
    }

    public void cancelOrder(GiveOrder order) {
            orderRepo.delete(order);
    }

    public void saveOrder(GiveOrder order) {
        orderRepo.save(order);
    }
}
