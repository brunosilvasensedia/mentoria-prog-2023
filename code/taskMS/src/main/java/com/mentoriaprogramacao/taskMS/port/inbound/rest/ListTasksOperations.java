package com.mentoriaprogramacao.taskMS.port.inbound.rest;

import com.mentoriaprogramacao.taskMS.adapter.dto.ListTaskRequest;
import com.mentoriaprogramacao.taskMS.domain.entity.ListTasksEntity;
import com.mentoriaprogramacao.taskMS.domain.entity.TaskEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/default")
public interface ListTasksOperations {
    @GetMapping()
    ResponseEntity<List<ListTasksEntity>> findAllLists();

    @GetMapping("/{listId}")
    ResponseEntity<ListTasksEntity> findListsBylistId(@PathVariable("listId") Integer listId);

    @DeleteMapping("/{listId}")
    ResponseEntity<Void> deleteList(@PathVariable("listId") Integer listId);

    @PatchMapping("/{listId}")
    ResponseEntity<ListTasksEntity> updateList(@PathVariable("listId") Integer listId, @RequestBody ListTaskRequest request);

    @PostMapping()
    ResponseEntity<ListTasksEntity> saveTaskList(@RequestBody ListTaskRequest request);

    @PostMapping("/{listId}/tasks")
    ResponseEntity<ListTasksEntity> saveTask(@PathVariable("listId") Integer listId, @RequestBody TaskEntity request);

    @GetMapping("/{listId}/tasks/{taskId}")
    ResponseEntity<TaskEntity> findTaskById(@PathVariable("listId") Integer listId, @PathVariable("taskId") Integer taskId);

    @PutMapping("/{listId}/tasks/{taskId}")
    ResponseEntity<ListTasksEntity> updateTask(@PathVariable("listId") Integer listId, @PathVariable("taskId") Integer taskId, @RequestBody TaskEntity request);

    @DeleteMapping("/{listId}/tasks/{taskId}")
    ResponseEntity<Void> deleteTask(@PathVariable("listId") Integer listId, @PathVariable("taskId") Integer taskId);
}
