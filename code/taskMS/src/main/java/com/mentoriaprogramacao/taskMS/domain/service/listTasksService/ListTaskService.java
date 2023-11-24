package com.mentoriaprogramacao.taskMS.domain.service.listTasksService;

import com.mentoriaprogramacao.taskMS.adapter.dto.ListTaskRequest;
import com.mentoriaprogramacao.taskMS.domain.entity.ListTasksEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ListTaskService {
    List<ListTasksEntity> findAllLists();

    ListTasksEntity findListsByID(Integer id);

    void deleteList(Integer id);

    ListTasksEntity updateList(Integer id, ListTaskRequest request);

    ListTasksEntity saveTaskList(ListTaskRequest request);
}
