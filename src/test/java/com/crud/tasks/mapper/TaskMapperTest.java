package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TaskMapperTest {

    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    public void mapToTaskTest() {
        //Given
        TaskDto taskDto = new TaskDto(1l, "title", "content");
        Long testId = 1l;

        //When
        Task mappedTask = taskMapper.mapToTask(taskDto);

        //Then
        Assert.assertEquals(testId, mappedTask.getId());
        Assert.assertEquals("title", mappedTask.getTitle());
        Assert.assertEquals("content", mappedTask.getContent());
    }

    @Test
    public void mapToTaskDtoTest() {
        //Given
        Task task = new Task(1l, "title", "content");
        Long testId = 1l;
        //When
        TaskDto mappedTask = taskMapper.mapToTaskDto(task);

        //Then
        Assert.assertEquals(testId, mappedTask.getId());
        Assert.assertEquals("title", mappedTask.getTitle());
        Assert.assertEquals("content", mappedTask.getContent());
    }

    @Test
    public void mapToTaskDtoList() {
        //Given
        List<Task> taskList = new ArrayList<>();
        taskList.add(new Task(1l, "title", "content"));
        Long testId = 1l;

        //When
        List<TaskDto> mappedTaskList = taskMapper.mapToTaskDtoList(taskList);

        //Then
        Assert.assertEquals(testId, mappedTaskList.get(0).getId());
        Assert.assertEquals("title", mappedTaskList.get(0).getTitle());
        Assert.assertEquals("content", mappedTaskList.get(0).getContent());
    }
}