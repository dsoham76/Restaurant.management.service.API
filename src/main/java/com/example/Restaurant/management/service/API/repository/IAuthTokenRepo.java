package com.example.Restaurant.management.service.API.repository;

import com.example.Restaurant.management.service.API.model.AuthenticationToken;
import com.example.Restaurant.management.service.API.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthTokenRepo extends JpaRepository<AuthenticationToken,Integer> {
    AuthenticationToken findFirstByTokenValue(String authTokenValue);

    AuthenticationToken findFirstByUser(User user);


}
