package com.example.Restaurant.management.service.API.service;

import com.example.Restaurant.management.service.API.model.AuthenticationToken;
import com.example.Restaurant.management.service.API.model.GiveOrder;
import com.example.Restaurant.management.service.API.model.User;
import com.example.Restaurant.management.service.API.model.dto.SignInInput;
import com.example.Restaurant.management.service.API.model.dto.SignUpOutput;
import com.example.Restaurant.management.service.API.repository.IAuthTokenRepo;
import com.example.Restaurant.management.service.API.repository.IFoodItemRepo;
import com.example.Restaurant.management.service.API.repository.IOrderRepo;
import com.example.Restaurant.management.service.API.repository.IUserRepo;
import com.example.Restaurant.management.service.API.service.utility.EmailHandler;
import com.example.Restaurant.management.service.API.service.utility.PasswordEncrypter;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;
    @Autowired
    IAuthTokenRepo authTokenRepo;
    @Autowired
    IFoodItemRepo foodItemRepo;
    @Autowired
    OrderService orderService;

    public SignUpOutput signUpUser(User user) {

        boolean signUpStatus = true;
        String signUpStatusMessage = null;

        String newEmail = user.getUserEmail();

        if(newEmail == null)
        {
            signUpStatusMessage = "Invalid email";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }

        //check if this patient email already exists ??
        User existingUser = userRepo.findFirstByUserEmail(newEmail);

        if(existingUser != null)
        {
            signUpStatusMessage = "Email already registered!!!";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }

        //hash the password: encrypt the password
        try {

            String encryptedPassword = PasswordEncrypter.encryptPassword(user.getPassword());

            //saveAppointment the patient with the new encrypted password

            user.setPassword(encryptedPassword);
            userRepo.save(user);

            return new SignUpOutput(signUpStatus, "Patient registered successfully!!!");
        }
        catch(Exception e)
        {
            signUpStatusMessage = "Internal error occurred during sign up";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }
    }

    public String signInUser(SignInInput signInInput) {


        String signInStatusMessage = null;

        String signInEmail = signInInput.getEmail();

        if(signInEmail == null)
        {
            signInStatusMessage = "Invalid email";
            return signInStatusMessage;


        }

        //check if this patient email already exists ??
        User existingUser = userRepo.findFirstByUserEmail(signInEmail);

        if(existingUser == null)
        {
            signInStatusMessage = "Email not registered!!!";
            return signInStatusMessage;

        }

        //match passwords :

        //hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(signInInput.getPassword());
            if(existingUser.getPassword().equals(encryptedPassword))
            {
                //session should be created since password matched and user id is valid
                AuthenticationToken authToken  = new AuthenticationToken(existingUser);
                authTokenRepo.save(authToken);

                EmailHandler.sendEmail(signInEmail,"email testing",authToken.getTokenValue());
                return "Token sent to your email";
            }
            else {
                signInStatusMessage = "Invalid credentials!!!";
                return signInStatusMessage;
            }
        }
        catch(Exception e)
        {
            signInStatusMessage = "Internal error occurred during sign in";
            return signInStatusMessage;
        }

    }




    public String deleteOrder(String email){
        User user = userRepo.findFirstByUserEmail(email);

        GiveOrder order = orderService.getOrderForUser(user);

        orderService.cancelOrder(order);

        return "Order has been deleted.";

    }

    public String sigOutUser(String email) {

        User user = userRepo.findFirstByUserEmail(email);
        authTokenRepo.delete(authTokenRepo.findFirstByUser(user));
        return "User Signed out successfully";
    }


    public boolean createOrder(GiveOrder order) {

        //id of patient
        Integer userId = order.getUser().getUserId();
        boolean isUserValid = userRepo.existsById(userId);

        if(isUserValid)
        {
            orderService.saveOrder(order);
            return true;
        }
        else {
            return false;
        }
    }
}
