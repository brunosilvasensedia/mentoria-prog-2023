package com.mentoriaprogramacao.taskMS.domain.service.tasksService;

import com.mentoriaprogramacao.taskMS.domain.entity.ListTasksEntity;
import com.mentoriaprogramacao.taskMS.domain.entity.TaskEntity;
import com.mentoriaprogramacao.taskMS.port.inbound.repository.ListTasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImp implements TaskService{
    @Autowired
    ListTasksRepository listTasksRepository;

    @Override
    public ListTasksEntity saveTask(Integer listId, TaskEntity request) {
        Optional<ListTasksEntity> listTasksEntity = listTasksRepository.findById(listId);

        if(listTasksEntity.isPresent()){
            ListTasksEntity listTask = listTasksEntity.get();
            List<TaskEntity> tasks = listTask.getListTask();
            tasks.add(request);
            listTask.setListTask(tasks);

            return listTask;
        } else {
         throw new RuntimeException();
        }
    }

    @Override
    public TaskEntity findTaskById(Integer listId, Integer taskId) {
        return null;
    }

    @Override
    public ListTasksEntity updateTask(Integer listId, Integer taskId, TaskEntity request) {
        return null;
    }

    @Override
    public void deleteTask(Integer listId, Integer taskId) {

    }
}
