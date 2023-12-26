package com.mentoriaprogramacao.taskMS.domain.service.tasksService;

import com.mentoriaprogramacao.taskMS.domain.entity.ListTasksEntity;
import com.mentoriaprogramacao.taskMS.domain.entity.TaskEntity;

import java.io.IOException;
import java.net.URISyntaxException;

public interface TaskService {
    ListTasksEntity saveTask(long listId, TaskEntity request) throws IOException, URISyntaxException;
    TaskEntity findTaskById(long listId, long taskId);

    TaskEntity updateTask(long listId, long taskId, TaskEntity request);

    void deleteTask(long listId, long taskId);
}
