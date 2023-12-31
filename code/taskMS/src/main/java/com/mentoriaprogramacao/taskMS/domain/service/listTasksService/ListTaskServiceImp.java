package com.mentoriaprogramacao.taskMS.domain.service.listTasksService;

import com.mentoriaprogramacao.taskMS.adapter.dto.ListTaskRequest;
import com.mentoriaprogramacao.taskMS.domain.entity.ListTasksEntity;
import com.mentoriaprogramacao.taskMS.domain.entity.TaskEntity;
import com.mentoriaprogramacao.taskMS.domain.service.exceptions.ListNotFoundException;
import com.mentoriaprogramacao.taskMS.domain.service.sequenceGenerator.SequenceGeneratorService;
import com.mentoriaprogramacao.taskMS.port.inbound.repository.ListTasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ListTaskServiceImp implements ListTaskService{

    @Autowired
    private ListTasksRepository listTasksRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public List<ListTasksEntity> findAllLists() {
        return listTasksRepository.findAll();
    }

    @Override
    public ListTasksEntity findListsByID(long id) {
        Optional<ListTasksEntity> listTasksEntity = listTasksRepository.findById(id);

        if (listTasksEntity.isPresent()){
            return listTasksEntity.get();
        } else {
            throw new ListNotFoundException();
        }
    }

    @Override
    public void deleteList(long id) {
        Optional<ListTasksEntity> listTasksEntity = listTasksRepository.findById(id);

        if (listTasksEntity.isPresent()){
            ListTasksEntity listTasks = listTasksEntity.get();
            listTasks.setDeleted(true);
            listTasksRepository.save(listTasks);
        } else {
            throw new ListNotFoundException();
        }
    }

    @Override
    public ListTasksEntity updateList(long id, ListTaskRequest request) {
        Optional<ListTasksEntity> listTasksEntity = listTasksRepository.findById(id);

        if (listTasksEntity.isPresent()){
            ListTasksEntity listTasks = listTasksEntity.get();
            listTasks.setName(request.getName());
            return this.listTasksRepository.save(listTasks);
        } else {
            throw new ListNotFoundException();
        }
    }

    @Override
    public ListTasksEntity saveTaskList(ListTaskRequest request) {
        ListTasksEntity listTasksEntity = new ListTasksEntity();

        List<TaskEntity> tasks = new ArrayList<>();
        listTasksEntity.setId(sequenceGeneratorService.generateSequence(ListTasksEntity.SEQUENCE_NAME));
        listTasksEntity.setName(request.getName());
        listTasksEntity.setDeleted(false);
        listTasksEntity.setListTask(tasks);

        return listTasksRepository.save(listTasksEntity);
    }
}
