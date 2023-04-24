package com.spark.amazonworkmaildependancy.aws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MailScheduler {

    @Autowired
    private MailReceiver mailReceiver;

    @Scheduled(fixedDelay = 60000)
    public void receiveMail() throws MessagingException, javax.mail.MessagingException {
        mailReceiver.fetchMessages();
    }

}
