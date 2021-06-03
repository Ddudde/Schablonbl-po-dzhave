package com.demo;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;

@NoArgsConstructor
public class EmailService {
    @Autowired
    public JavaMailSender emailSender;

    @Async
    public void SendEmail(String tema, String mes){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("nat.muradov@yandex.ru");
        message.setSubject(tema);
        message.setText(mes);
        emailSender.send(message);
        System.out.println("Email send");
    }

}
