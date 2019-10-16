package com.izdebski.sendingemail.controller;

import com.izdebski.sendingemail.domain.User;
import com.izdebski.sendingemail.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    private Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private NotificationService notificationService;

    @RequestMapping("/signup-success")
    public String signupSuccess(){

        // create user
        User user = new User();
        user.setFirstName("Ivan");
        user.setLastName("Izdepskyi");
        user.setEmailAddress("claudedebussy@gmail.com");

        // send a notification
        try {
            notificationService.sendNotificaitoin(user);
        }catch( Exception e ){
            // catch error
            logger.info("Error Sending Email: " + e.getMessage());
        }

        return "Thank you for registering with us.";
    }
}