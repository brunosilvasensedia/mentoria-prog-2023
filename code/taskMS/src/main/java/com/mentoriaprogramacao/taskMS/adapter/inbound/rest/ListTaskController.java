package com.mentoriaprogramacao.taskMS.adapter.inbound.rest;

import com.mentoriaprogramacao.taskMS.adapter.dto.ListTaskRequest;
import com.mentoriaprogramacao.taskMS.domain.entity.ListTasksEntity;
import com.mentoriaprogramacao.taskMS.domain.entity.TaskEntity;
import com.mentoriaprogramacao.taskMS.domain.service.listTasksService.ListTaskService;
import com.mentoriaprogramacao.taskMS.port.inbound.rest.ListTasksOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "task-ms/v1/lists", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ListTaskController implements ListTasksOperations {

    @Autowired
    private ListTaskService listTaskService;

    @Override
    public ResponseEntity<List<ListTasksEntity>> findAllLists() {
        return ResponseEntity.status(HttpStatus.OK).body(listTaskService.findAllLists());
    }

    @Override
    public ResponseEntity<ListTasksEntity> findListsBylistId(Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(listTaskService.findListsByID(id));
    }

    @Override
    public ResponseEntity<Void> deleteList(Integer id) {
        listTaskService.deleteList(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<ListTasksEntity> updateList(Integer id, ListTaskRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(listTaskService.updateList(id, request));
    }

    @Override
    public ResponseEntity<ListTasksEntity> saveTaskList(ListTaskRequest request) {
        ListTasksEntity listTasksEntity = listTaskService.saveTaskList(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(listTasksEntity.getId()).toUri();
        return ResponseEntity.created(uri).body(listTasksEntity);
    }

    @Override
    public ResponseEntity<ListTasksEntity> saveTask(Integer listId, TaskEntity request) {
        return null;
    }

    @Override
    public ResponseEntity<TaskEntity> findTaskById(Integer listId, Integer taskId) {
        return null;
    }

    @Override
    public ResponseEntity<ListTasksEntity> updateTask(Integer listId, Integer taskId, TaskEntity request) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteTask(Integer listId, Integer taskId) {
        return null;
    }
}
