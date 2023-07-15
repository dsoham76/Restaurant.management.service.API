package com.example.Restaurant.management.service.API.repository;

import com.example.Restaurant.management.service.API.model.GiveOrder;
import com.example.Restaurant.management.service.API.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepo extends JpaRepository<GiveOrder,Integer> {

    GiveOrder findFirstByUser(User user);
}
