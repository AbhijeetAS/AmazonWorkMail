package com.spark.amazonworkmaildependancy.aws;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
//        This code creates a JavaMailSenderImpl bean that is configured with
//        the host, port, username, and password properties from the application.properties file.
//        The setProtocol method is used to specify the IMAP protocol, which is used for receiving email messages.
public class MailConfig {

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.port}")
    private int port;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    // which is a class provided by Spring Boot that implements the JavaMailSender interface.
    // The JavaMailSenderImpl object is used to send emails through a configured mail server.
    //The method creates a JavaMailSenderImpl object, sets its host, port, username, password, and protocol
    //properties based on the configuration properties defined in the application.properties file.
    // In this case, the protocol is set to "imaps" which stands for "Internet Message Access Protocol with SSL/TLS encryption",
    // which is used for retrieving email messages from a mail server over a secure connection.
    @Bean
    public JavaMailSenderImpl javaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(host);
        javaMailSender.setPort(port);
        javaMailSender.setUsername(username);
        javaMailSender.setPassword(password);
        javaMailSender.setProtocol("imaps");
        javaMailSender.setJavaMailProperties(new Properties());
        return javaMailSender;
    }

}

