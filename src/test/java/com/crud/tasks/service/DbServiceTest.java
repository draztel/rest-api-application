package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbServiceTest {

    @Autowired
    private DbService dbService;

    @Test
    public void shouldSaveAndDeleteTask() {
        //Given
        System.out.println(dbService.getAllTasks().size());
        Task task1 = new Task("title", "content");

        //When
        dbService.saveTask(task1);

        //Then
        Assert.assertEquals(1, dbService.getAllTasks().size());

        //CleanUp
        dbService.deleteById(task1.getId());
    }

    @Test
    public void shouldGetTask() {
        //Given
        Task task = new Task("title", "content");
        dbService.saveTask(task);

        //When
        Optional<Task> resultTask = dbService.getTask(task.getId());

        //Then
        Assert.assertEquals(task.getId(), resultTask.get().getId());
        Assert.assertEquals(task.getTitle(), resultTask.get().getTitle());
        Assert.assertEquals(task.getContent(), resultTask.get().getContent());

        //CleanUp
        dbService.deleteById(task.getId());
    }

    @Test
    public void shouldGetAllTasks() {
        //Given
        Task task1 = new Task("title", "content");
        Task task2 = new Task("title", "content");
        Task task3 = new Task("title", "content");
        dbService.saveTask(task1);
        dbService.saveTask(task2);
        dbService.saveTask(task3);

        //When
        int taskListSize = dbService.getAllTasks().size();

        //Then
        Assert.assertEquals(3, taskListSize);

        //CleanUp
        dbService.deleteById(task1.getId());
        dbService.deleteById(task2.getId());
        dbService.deleteById(task3.getId());
    }
}