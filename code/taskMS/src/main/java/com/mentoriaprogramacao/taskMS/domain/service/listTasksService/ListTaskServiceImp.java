package com.mentoriaprogramacao.taskMS.domain.service.listTasksService;

import com.mentoriaprogramacao.taskMS.adapter.dto.ListTaskRequest;
import com.mentoriaprogramacao.taskMS.domain.entity.ListTasksEntity;
import com.mentoriaprogramacao.taskMS.port.inbound.repository.ListTasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListTaskServiceImp implements ListTaskService{

    @Autowired
    ListTasksRepository listTasksRepository;

    @Override
    public List<ListTasksEntity> findAllLists() {
        return listTasksRepository.findAll();
    }

    @Override
    public ListTasksEntity findListsByID(Integer id) {
        Optional<ListTasksEntity> listTasks = listTasksRepository.findById(id);
        return listTasks.get();
    }

    @Override
    public void deleteList(Integer id) {
        Optional<ListTasksEntity> listTasksEntity = listTasksRepository.findById(id);

        if (listTasksEntity.isPresent()){
            ListTasksEntity listTasks = listTasksEntity.get();
            listTasks.setDeleted(true);
            listTasksRepository.save(listTasks);
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public ListTasksEntity updateList(Integer id, ListTaskRequest request) {
        Optional<ListTasksEntity> listTasksEntity = listTasksRepository.findById(id);

        if (listTasksEntity.isPresent()){
            ListTasksEntity listTasks = listTasksEntity.get();
            listTasks.setName(request.getName());
            return this.listTasksRepository.save(listTasks);
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public ListTasksEntity saveTaskList(ListTaskRequest request) {
        ListTasksEntity listTasksEntity = new ListTasksEntity();
        listTasksEntity.setName(request.getName());
        listTasksEntity.setDeleted(false);

        return listTasksRepository.save(listTasksEntity);
    }
}
