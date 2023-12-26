package com.mentoriaprogramacao.taskMS.domain.service.listTasksService;

import com.mentoriaprogramacao.taskMS.adapter.dto.ListTaskRequest;
import com.mentoriaprogramacao.taskMS.domain.entity.ListTasksEntity;

import java.util.List;

public interface ListTaskService {
    List<ListTasksEntity> findAllLists();

    ListTasksEntity findListsByID(long id);

    void deleteList(long id);

    ListTasksEntity updateList(long id, ListTaskRequest request);

    ListTasksEntity saveTaskList(ListTaskRequest request);
}
