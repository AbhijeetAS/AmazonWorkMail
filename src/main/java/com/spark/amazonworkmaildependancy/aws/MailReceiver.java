package com.spark.amazonworkmaildependancy.aws;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class MailReceiver {

    @Autowired
    private JavaMailSenderImpl mailSender;

    public void fetchMessages() throws MessagingException, javax.mail.MessagingException {
        Folder folder = null;
        Store store = null;
        try {
            //create the session where all mails are stored in the amazon mailbox server
            //The fetchMessages() method fetches the email messages by creating a
            // Store object from the JavaMailSenderImpl session and connecting to the email server.
            // It then opens the inbox folder and retrieves all the messages in the folder.
            // The email messages can then be processed as needed, such as printing their subjects in this example.
            store = mailSender.getSession().getStore();
            //connect that session to server
            store.connect();
            //get the folder from the email server
            folder = store.getFolder("INBOX");
            //open that folder and give the permission of read only
            folder.open(Folder.READ_ONLY);

            //collect the all mails in the message array
            Message[] messages = folder.getMessages();

            //print all the messages line by line
            for (Message message : messages) {
                // Do something with the message, such as printing its subject
                System.out.println(message.getSubject());
            }
        } catch (NoSuchProviderException e) {
            throw new RuntimeException(e);
        } catch (javax.mail.MessagingException e) {
            throw new RuntimeException(e);
        } finally {
            if (folder != null) {
                folder.close(false);
            }
            if (store != null) {
                store.close();
            }
        }
    }

}

