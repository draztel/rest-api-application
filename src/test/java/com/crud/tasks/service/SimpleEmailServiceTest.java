package com.crud.tasks.service;

import com.crud.tasks.domain.Mail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class SimpleEmailServiceTest {

    @InjectMocks
    private SimpleEmailService simpleEmailService;

    @Mock
    private JavaMailSender javaMailSender;

    @Test
    public void shouldSendEmail() {
        //Given
        Mail mail1 = new Mail("test@test.com", "Test", "Test Message", "test@test.pl");
        Mail mail2 = new Mail("test@test.com", "Test", "Test Message");

        SimpleMailMessage mailMessage1 = new SimpleMailMessage();
        mailMessage1.setTo(mail1.getMailTo());
        mailMessage1.setSubject(mail1.getSubject());
        mailMessage1.setText(mail1.getMessage());
        mailMessage1.setCc(mail1.getToCc());

        SimpleMailMessage mailMessage2 = new SimpleMailMessage();
        mailMessage2.setTo(mail2.getMailTo());
        mailMessage2.setSubject(mail2.getSubject());
        mailMessage2.setText(mail2.getMessage());

        //When
        simpleEmailService.send(mail1);
        simpleEmailService.send(mail2);

        //Then
        verify(javaMailSender, times(1)).send(mailMessage1);
        verify(javaMailSender, times(1)).send(mailMessage2);
    }
}