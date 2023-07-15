package com.example.Restaurant.management.service.API.repository;

import com.example.Restaurant.management.service.API.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User,Integer> {
    User findFirstByUserEmail(String newEmail);
}
