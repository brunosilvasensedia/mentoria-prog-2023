package com.mentoriaprogramacao.taskMS.port.inbound.rest;

import com.mentoriaprogramacao.taskMS.adapter.dto.ListTaskRequest;
import com.mentoriaprogramacao.taskMS.domain.entity.ListTasksEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/default")
public interface ListTasksOperations {
    @GetMapping()
    ResponseEntity<List<ListTasksEntity>> findAllLists();

    @GetMapping("/{id}")
    ResponseEntity<ListTasksEntity> findListsByID(@PathVariable("id") Integer id);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteList(@PathVariable("id") Integer id);

    @PatchMapping("/{id}")
    ResponseEntity<ListTasksEntity> updateList(@PathVariable("id") Integer id, @RequestBody ListTaskRequest request);

    @PostMapping()
    ResponseEntity<ListTasksEntity> saveTaskList(@RequestBody ListTaskRequest request);
}
