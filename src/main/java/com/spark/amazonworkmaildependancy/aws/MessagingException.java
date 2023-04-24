package com.spark.amazonworkmaildependancy.aws;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class MessagingException extends Exception {

    public ResponseEntity<String> handleMessagingException(MessagingException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while sending the email: " + ex.getMessage());
    }

}
