package com.notefy.notefyapp;

import com.notefy.notefyapp.task.Task;
import com.notefy.notefyapp.task.TaskController;
import com.notefy.notefyapp.task.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static com.notefy.notefyapp.task.PriorityType.*;
import static com.notefy.notefyapp.task.PriorityType.HIGH;
import static java.util.Calendar.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TestTaskController {
    private static final String TASK_TEST_URL = "http://task-unittest:1234";

    private TaskService taskService;
    private TaskController taskController;

    private Task t1 = new Task(
            1L,
            "Test those notes",
            CRITICAL,
            false, LocalDate.of(2023, SEPTEMBER, 21),
            LocalDate.of(2023, SEPTEMBER, 23),
            "We need to test this note"
    );

    private Task t2 = new Task(
            2L,
            "Are you good?",
            HIGH,
            true,
            LocalDate.of(2023, OCTOBER, 21),
            LocalDate.of(2023, DECEMBER, 23),
            "Pls help these notes to get tested"
    );

    @BeforeEach
    public void before() {
        this.taskService = Mockito.mock(TaskService.class);
        this.taskController = Mockito.spy(new TaskController(this.taskService));
    }

    @Test
    //@Disabled
    public void testGetTasks() {
        doReturn(List.of(t1, t2)).when(this.taskService).getTasks();

        List<Task> result = this.taskController.getTasks();

        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getId());
        assertEquals(2L, result.get(1).getId());
    }

    @Test
    //@Disabled
    public void testGetTask() throws IOException {
        doReturn(t1).when(this.taskService).getTask(1L);
        doReturn(null).when(this.taskService).getTask(2L);

        Task result = this.taskController.getTask(1L);

        assertEquals(1L, result.getId());
    }

    @Test
    @Disabled
    public void testNewTask() {

    }

    @Test
    @Disabled
    public void testUpdateTask() {

    }

    @Test
    @Disabled
    public void testDeleteTask() {

    }
}