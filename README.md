# Restaurant.management.service.API

## Framework and Language

> Framework: SpringBoot Language: Java 8

## Data flow

1.  Controller

        1.1  User Controller
        1.2  Admin Controller

2.  Services

        1.1 UserService
        1.2 AdminService
        1.3 OrderService
        1.4 FoodItemService

3.  Repository

        1.1 UserRepo
        1.2 AdminRepo
        1.3 OrderRepo
        1.4 FoodItemRepo

4.  Database Design

        4.1 User Model:
                - Integer userId
                - String username
                - String password
                - String userEmail
                - Order giveOrder
        4.2 Admin Model:
                - Integer Id
                - String username
                - String password
                - String Email
        4.3 FoodItem Model:
                - String title
                - String description
                - Double price
        4.4 Order Model:
                - User user;
                - List<FoodItem> foodItems;
                - Integer quantity;
                - Status status;
## Data Structure Used in Project

     JPARepository has been used as primay datastructure

## Project Summary

    The Restaurant Management Service API  is a comprehensive software solution designed to keep track of orders . The system provides a centralized platform that enables  admin to create, read, edit, and delete user and product accounts.
