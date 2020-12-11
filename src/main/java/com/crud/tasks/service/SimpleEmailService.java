package com.crud.tasks.service;

import com.crud.tasks.domain.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class SimpleEmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMailMessage.class);

    @Autowired
    private MailCreatorService mailCreatorService;

    @Autowired
    private JavaMailSender javaMailSender;

    public SimpleEmailService() {
    }

    public void send(final Mail mail, String EMAIL_TYPE, String EMAIL_TEMPLATE) {
        LOGGER.info("Starting email preparation...");
        try {
            switch(EMAIL_TYPE) {
                case "SimpleMailMessage":
                    if(EMAIL_TEMPLATE.equals("default")) {
                        SimpleMailMessage mailMessage = createMailMessage(mail);
                        javaMailSender.send(mailMessage);
                    }
                    break;
                case "MimeMessage":
                    if(EMAIL_TEMPLATE.equals("BuildTrelloCardEmail")) {
                        javaMailSender.send(createMimeMessage(mail, "BuildTrelloCardEmail"));
                    } else {
                        javaMailSender.send(createMimeMessage(mail, "BuildScheduledTasksInformationEmail"));
                    }
                    break;
            }
                LOGGER.info("Email has been sent.");
        } catch (MailException e) {
            LOGGER.error("Failed to process email sending: ", e.getMessage(), e);
        }
    }

    private MimeMessagePreparator createMimeMessage(final Mail mail, String EMAIL_TEMPLATE) {
        return mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setTo(mail.getMailTo());
            messageHelper.setSubject(mail.getSubject());
            if (EMAIL_TEMPLATE.equals("BuildTrelloCardEmail")) {
                messageHelper.setText(mailCreatorService.buildTrelloCardEmail(mail.getMessage()), true);
            } else {
                    messageHelper.setText(mailCreatorService.buildScheduledTasksInformationEmail(mail.getMessage()), true);
            }
        };
    }

    private SimpleMailMessage createMailMessage(final Mail mail) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());
        if(mail.getToCc() != null) {
            mailMessage.setCc(mail.getToCc());
        }
        return mailMessage;
    }
}
