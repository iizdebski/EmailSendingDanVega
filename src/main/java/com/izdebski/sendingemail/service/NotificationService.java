package com.izdebski.sendingemail.service;

import com.izdebski.sendingemail.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    @Async
    public void sendNotificaitoin(User user) throws MailException, InterruptedException {

        System.out.println("Sleeping now...");
        Thread.sleep(10000);

        System.out.println("Sending email...");

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmailAddress());
        mail.setFrom("johnystartup@gmail.com");
        mail.setSubject("Spring Boot is awesome!");
        mail.setText("Why aren't you using Spring Boot?");
        javaMailSender.send(mail);

        System.out.println("Email Sent!");
    }

}