package com.mentoriaprogramacao.taskMS.port.inbound.rest;

import com.mentoriaprogramacao.taskMS.adapter.dto.ListTaskRequest;
import com.mentoriaprogramacao.taskMS.domain.entity.ListTasksEntity;
import com.mentoriaprogramacao.taskMS.domain.entity.TaskEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RequestMapping("/")
public interface ListTasksOperations {
    @GetMapping()
    ResponseEntity<List<ListTasksEntity>> findAllLists();

    @GetMapping("/{listId}")
    ResponseEntity<ListTasksEntity> findListsBylistId(@PathVariable("listId") Long listId);

    @DeleteMapping("/{listId}")
    ResponseEntity<Void> deleteList(@PathVariable("listId") Long listId);

    @PatchMapping("/{listId}")
    ResponseEntity<ListTasksEntity> updateList(@PathVariable("listId") Long listId, @RequestBody ListTaskRequest request);

    @PostMapping()
    ResponseEntity<ListTasksEntity> saveTaskList(@RequestBody ListTaskRequest request);

    @PostMapping("/{listId}/tasks")
    ResponseEntity<ListTasksEntity> saveTask(@PathVariable("listId") Long listId, @RequestBody TaskEntity request) throws IOException, URISyntaxException;

    @GetMapping("/{listId}/tasks/{taskId}")
    ResponseEntity<TaskEntity> findTaskById(@PathVariable("listId") Long listId, @PathVariable("taskId") Long taskId);

    @PutMapping("/{listId}/tasks/{taskId}")
    ResponseEntity<TaskEntity> updateTask(@PathVariable("listId") Long listId, @PathVariable("taskId") Long taskId, @RequestBody TaskEntity request);

    @DeleteMapping("/{listId}/tasks/{taskId}")
    ResponseEntity<Void> deleteTask(@PathVariable("listId") Long listId, @PathVariable("taskId") Long taskId);
}
