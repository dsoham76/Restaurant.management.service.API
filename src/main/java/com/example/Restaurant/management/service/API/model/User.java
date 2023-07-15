package com.example.Restaurant.management.service.API.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,scope= User.class,property="id")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer userId;
    @Column(unique = true)
    private String username;
    private String password;
    @Column(unique = true)
    private String userEmail;
    @OneToOne(mappedBy = "user")
    GiveOrder giveOrder;


}
