package com.crud.tasks.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
"trello.username=testusername",
"trello.api.endpoint.prod=testendpoint",
"trello.app.key=testkey",
"trello.app.token=testtoken" })
public class TrelloConfigTest {

    @Autowired
    private TrelloConfig trelloConfig;

    @Test
    public void shouldReturnTrelloUsername() {
        //Given & When
        String value = trelloConfig.getTrelloUsername();

        //Then
        Assert.assertEquals("testusername", value);
    }

    @Test
    public void shouldReturnTrelloAppKey() {
        //Given & When
        String value = trelloConfig.getTrelloAppKey();

        //Then
        Assert.assertEquals("testkey", value);
    }

    @Test
    public void shouldReturnTrelloApiEndpoint() {
        //Given & When
        String value = trelloConfig.getTrelloApiEndpoint();

        //Then
        Assert.assertEquals("testendpoint", value);
    }

    @Test
    public void shouldReturnTrelloToken() {
        //Given & When
        String value = trelloConfig.getTrelloToken();

        //Then
        Assert.assertEquals("testtoken", value);
    }

}
