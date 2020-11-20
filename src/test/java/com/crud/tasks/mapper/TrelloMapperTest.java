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
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        List<TrelloBoardDto> trelloBoardsDto = new ArrayList<>();
        trelloBoardsDto.add(new TrelloBoardDto("0", "name", trelloListDto));

        List<TrelloList> trelloList = new ArrayList<>();
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("0", "name", trelloList));

        //When
        List<TrelloBoard> mappedTrelloBoards = trelloMapper.mapToBoards(trelloBoardsDto);

        //Then
        Assert.assertEquals(trelloBoards.toString(), mappedTrelloBoards.toString());
    }

    @Test
    public void mapToBoardsDtoTest() {
        //Given
        List<TrelloList> trelloList = new ArrayList<>();
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("0", "name", trelloList));

        List<TrelloListDto> trelloListDto = new ArrayList<>();
        List<TrelloBoardDto> trelloBoardsDto = new ArrayList<>();
        trelloBoardsDto.add(new TrelloBoardDto("0", "name", trelloListDto));

        //When
        List<TrelloBoardDto> mappedTrelloBoards = trelloMapper.mapToBoardsDto(trelloBoards);

        //Then
        Assert.assertEquals(trelloBoardsDto.toString(), mappedTrelloBoards.toString());
    }

    @Test
    public void mapToListTest() {
        //Given
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        List<TrelloList> trelloList = new ArrayList<>();

        //When
        List<TrelloList> mappedList = trelloMapper.mapToList(trelloListDto);

        //Then
        Assert.assertEquals(trelloList.toString(), mappedList.toString());
    }

    @Test
    public void mapToListDtoTest() {
        //Given
        List<TrelloList> trelloList = new ArrayList<>();
        List<TrelloListDto> trelloListDto = new ArrayList<>();

        //When
        List<TrelloListDto> mappedList = trelloMapper.mapToListDto(trelloList);

        //Then
        Assert.assertEquals(trelloListDto.toString(), mappedList.toString());
    }

    @Test
    public void mapToCardTest() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto();
        TrelloCard trelloCard = new TrelloCard();

        //When
        TrelloCard mappedCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        Assert.assertEquals(trelloCard.toString(), mappedCard.toString());
    }

    @Test
    public void mapToCardDtoTest() {
        //Given
        TrelloCard trelloCard = new TrelloCard();
        TrelloCardDto trelloCardDto = new TrelloCardDto();

        //When
        TrelloCardDto mappedCard = trelloMapper.mapToCardDto(trelloCard);

        //Then
        Assert.assertEquals(trelloCardDto.toString(), mappedCard.toString());

    }
}