package com.myplanet.notificationservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {

    String firstName;
    String lastName;
    String username;
    String toEmail;
    String toPhone;
    String message;
    String token;
    String subject;
}
