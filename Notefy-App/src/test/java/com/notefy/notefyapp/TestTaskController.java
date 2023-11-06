package com.notefy.notefyapp;

import com.notefy.notefyapp.task.Task;
import com.notefy.notefyapp.task.TaskController;
import com.notefy.notefyapp.task.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static com.notefy.notefyapp.task.PriorityType.*;
import static com.notefy.notefyapp.task.PriorityType.HIGH;
import static java.util.Calendar.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        classes = NotefyAppApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ActiveProfiles("test")
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
    public void testGetTasks() {
        doReturn(List.of(t1, t2)).when(this.taskService).getTasks();

        List<Task> result = this.taskController.getTasks();

        verify(this.taskService).getTasks();
        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getId());
        assertEquals(2L, result.get(1).getId());
    }

    @Test
    public void testGetTask() {
        doReturn(t1).when(this.taskService).getTask(1L);
        doReturn(null).when(this.taskService).getTask(2L);

        Task result = this.taskController.getTask(1L);

        verify(this.taskService).getTask(1L);
        assertEquals(1L, result.getId());
    }

    @Test
    public void testGetTaskNotFound() {
        doReturn(null).when(this.taskService).getTask(3L);

        try {
            this.taskController.getTask(3L);
        } catch (ResponseStatusException e) {
            assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
        }

        verify(this.taskService).getTask(3L);
    }


    @Test
    public void testNewTask() {
        this.taskController.newTask(t1);
        verify(this.taskService).newTask(t1);

        verifyNoMoreInteractions(this.taskService);
    }

    @Test
    public void testUpdateTask() {
        doReturn(t1).when(this.taskService).getTask(1L);
        this.taskController.updateTask(1L, t2);

        verify(this.taskService, times(1)).getTask(1L);
        verify(this.taskService, times(1)).updateTask(argThat(new ArgumentMatcher<Task>() {
            @Override
            public boolean matches(Task task) {
                return t2.getTitle().equals(task.getTitle());
            }
        }));
        verifyNoMoreInteractions(this.taskService);
    }

    @Test
    public void testUpdateTaskNotFound() {
        doReturn(null).when(this.taskService).getTask(3L);

        try {
            this.taskController.updateTask(3L, t2);
        } catch (ResponseStatusException e) {
            assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
        }

        verify(this.taskService).getTask(3L);
    }

    @Test
    public void testDeleteTask() {
        doReturn(t1).when(this.taskService).getTask(1L);
        this.taskController.deleteTask(1L);
        verify(this.taskService).deleteTask(1L);
    }

    @Test
    public void testDeleteTaskNotFound() {
        doReturn(null).when(this.taskService).getTask(3L);

        try {
            this.taskController.deleteTask(3L);
        } catch (ResponseStatusException e) {
            assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode());
        }

        verify(this.taskService).getTask(3L);
    }
}