package com.company.service.impl;

import com.company.model.Mail;
import com.company.service.MailService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailServiceImpl implements MailService {
    private final JavaMailSender mailSender;
    @SneakyThrows
    @Override
    public void send(Mail mail) {
        log.info("ActionLog.MailServiceImpl.send.start");
        var simpleMail=new SimpleMailMessage();
        simpleMail.setFrom(mail.getFrom());
        simpleMail.setTo(mail.getTo());
        simpleMail.setText(mail.getBody());
        simpleMail.setFrom(mail.getFrom());
        simpleMail.setSubject(mail.getSubject());
        mailSender.send(simpleMail);
        log.info("ActionLog.MailServiceImpl.send.end");
    }
}
