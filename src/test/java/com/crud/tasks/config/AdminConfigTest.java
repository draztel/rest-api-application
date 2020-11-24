package com.crud.tasks.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = { "admin.mail=test@gmail.com" })
public class AdminConfigTest {

    @Autowired
    private AdminConfig adminConfig;

    @Test
    public void shouldReturnAdminMail() {
        String value = adminConfig.getAdminMail();

        Assert.assertEquals("test@gmail.com", value);
    }

}