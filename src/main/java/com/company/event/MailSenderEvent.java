package com.company.event;

import com.company.model.Mail;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class MailSenderEvent {
    private final Mail mail;
}
