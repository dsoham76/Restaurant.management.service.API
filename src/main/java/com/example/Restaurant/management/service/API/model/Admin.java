package com.example.Restaurant.management.service.API.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer adminId;
    @Column(unique = true)
    private String username;
    private String password;
    @Column(unique = true)
    @Pattern(regexp = "^.+@admin\\.com$")
    private String email;
}
