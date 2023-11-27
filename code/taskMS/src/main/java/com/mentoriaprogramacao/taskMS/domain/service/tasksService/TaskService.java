package com.mentoriaprogramacao.taskMS.domain.service.tasksService;

import com.mentoriaprogramacao.taskMS.domain.entity.ListTasksEntity;
import com.mentoriaprogramacao.taskMS.domain.entity.TaskEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface TaskService {
    ListTasksEntity saveTask(Integer listId, TaskEntity request);
    TaskEntity findTaskById(Integer listId, Integer taskId);

    ListTasksEntity updateTask(Integer listId, Integer taskId, TaskEntity request);

    void deleteTask(Integer listId, Integer taskId);
}
