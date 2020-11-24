package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTest {

    @InjectMocks
    private TrelloMapper trelloMapper;

    @Test
    public void mapToBoardsTest() {
        //Given
        List<TrelloListDto> trelloListsDto = new ArrayList<>();
        trelloListsDto.add(new TrelloListDto("0", "name", false));
        List<TrelloBoardDto> trelloBoardsDto = new ArrayList<>();
        trelloBoardsDto.add(new TrelloBoardDto("0", "name", trelloListsDto));

        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(new TrelloList("0", "name", false));
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("0", "name", trelloList));

        //When
        List<TrelloBoard> mappedTrelloBoards = trelloMapper.mapToBoards(trelloBoardsDto);

        //Then
        Assert.assertEquals(trelloBoards.get(0).getId(), mappedTrelloBoards.get(0).getId());
        Assert.assertEquals(trelloBoards.get(0).getName(), mappedTrelloBoards.get(0).getName());
        Assert.assertEquals(trelloBoards.get(0).getLists().get(0).getId(), mappedTrelloBoards.get(0).getLists().get(0).getId());
        Assert.assertEquals(trelloBoards.get(0).getLists().get(0).getName(), mappedTrelloBoards.get(0).getLists().get(0).getName());
        Assert.assertEquals(trelloBoards.get(0).getLists().get(0).isClosed(), mappedTrelloBoards.get(0).getLists().get(0).isClosed());
    }

    @Test
    public void mapToBoardsDtoTest() {
        //Given
        List<TrelloListDto> trelloListsDto = new ArrayList<>();
        trelloListsDto.add(new TrelloListDto("0", "name", false));
        List<TrelloBoardDto> trelloBoardsDto = new ArrayList<>();
        trelloBoardsDto.add(new TrelloBoardDto("0", "name", trelloListsDto));

        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(new TrelloList("0", "name", false));
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("0", "name", trelloList));

        //When
        List<TrelloBoardDto> mappedTrelloBoards = trelloMapper.mapToBoardsDto(trelloBoards);

        //Then
        Assert.assertEquals(trelloBoardsDto.get(0).getId(), mappedTrelloBoards.get(0).getId());
        Assert.assertEquals(trelloBoardsDto.get(0).getName(), mappedTrelloBoards.get(0).getName());
        Assert.assertEquals(trelloBoardsDto.get(0).getLists().get(0).getId(), mappedTrelloBoards.get(0).getLists().get(0).getId());
        Assert.assertEquals(trelloBoardsDto.get(0).getLists().get(0).getName(), mappedTrelloBoards.get(0).getLists().get(0).getName());
        Assert.assertEquals(trelloBoardsDto.get(0).getLists().get(0).isClosed(), mappedTrelloBoards.get(0).getLists().get(0).isClosed());
    }

    @Test
    public void mapToListTest() {
        //Given
        List<TrelloListDto> trelloListsDto = new ArrayList<>();
        trelloListsDto.add(new TrelloListDto("0", "name", false));
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("0", "name", false));

        //When
        List<TrelloList> mappedList = trelloMapper.mapToList(trelloListsDto);

        //Then
        Assert.assertEquals(trelloLists.get(0).getId(), mappedList.get(0).getId());
        Assert.assertEquals(trelloLists.get(0).getName(), mappedList.get(0).getName());
        Assert.assertEquals(trelloLists.get(0).isClosed(), mappedList.get(0).isClosed());
    }

    @Test
    public void mapToListDtoTest() {
        //Given
        List<TrelloListDto> trelloListsDto = new ArrayList<>();
        trelloListsDto.add(new TrelloListDto("0", "name", false));
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("0", "name", false));

        //When
        List<TrelloListDto> mappedList = trelloMapper.mapToListDto(trelloLists);

        //Then
        Assert.assertEquals(trelloListsDto.get(0).getId(), mappedList.get(0).getId());
        Assert.assertEquals(trelloListsDto.get(0).getName(), mappedList.get(0).getName());
        Assert.assertEquals(trelloListsDto.get(0).isClosed(), mappedList.get(0).isClosed());
    }

    @Test
    public void mapToCardTest() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name", "description", "pos", "listId");
        TrelloCard trelloCard = new TrelloCard("name", "description", "pos", "listId");

        //When
        TrelloCard mappedCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        Assert.assertEquals(trelloCard.getName(), mappedCard.getName());
        Assert.assertEquals(trelloCard.getDescription(), mappedCard.getDescription());
        Assert.assertEquals(trelloCard.getPos(), mappedCard.getPos());
        Assert.assertEquals(trelloCard.getListId(), mappedCard.getListId());
    }

    @Test
    public void mapToCardDtoTest() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name", "description", "pos", "listId");
        TrelloCard trelloCard = new TrelloCard("name", "description", "pos", "listId");

        //When
        TrelloCardDto mappedCard = trelloMapper.mapToCardDto(trelloCard);

        //Then
        Assert.assertEquals(trelloCardDto.getName(), mappedCard.getName());
        Assert.assertEquals(trelloCardDto.getDescription(), mappedCard.getDescription());
        Assert.assertEquals(trelloCardDto.getPos(), mappedCard.getPos());
        Assert.assertEquals(trelloCardDto.getListId(), mappedCard.getListId());

    }
}