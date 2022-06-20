package com.gestionlabo.gestionlabo.service;

import com.gestionlabo.gestionlabo.model.User;
import com.gestionlabo.gestionlabo.model.email.EmailConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {
    @Autowired
    private EmailConfiguration emailConfiguration;

    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
        mailSenderImpl.setHost(emailConfiguration.getHost());
        mailSenderImpl.setPort(emailConfiguration.getPort());
        mailSenderImpl.setUsername(emailConfiguration.getUsername());
        mailSenderImpl.setPassword(emailConfiguration.getPassword());
        return mailSenderImpl;
    }

    public void sendSimpleMessage(String to, String from, String subject, User user) {
        MimeMessage mimeMessage = getJavaMailSender().createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg = "</br><h3>Bonjour Mr./Mme. "+user.getNom()+" "+user.getPrenom()+" .</h3>  </br> Bienvenue dans notre plateforme ! </br> Votre mot de passe de connexion est : <b>"+user.getPassword()+"</b></br> Cordialement.";
        try {
        helper.setText(htmlMsg, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setFrom(from);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        getJavaMailSender().send(mimeMessage);
    }

}
