package com.mentoriaprogramacao.taskMS.domain.service.tasksService;

import com.mentoriaprogramacao.taskMS.adapter.dto.UserDTO;
import com.mentoriaprogramacao.taskMS.domain.entity.ListTasksEntity;
import com.mentoriaprogramacao.taskMS.domain.entity.TaskEntity;
import com.mentoriaprogramacao.taskMS.domain.service.sequenceGenerator.SequenceGeneratorService;
import com.mentoriaprogramacao.taskMS.port.inbound.repository.ListTasksRepository;
import com.mentoriaprogramacao.taskMS.port.inbound.repository.TaskRepository;
import com.mentoriaprogramacao.taskMS.port.outbound.rest.RequestUser;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImp implements TaskService{
    @Autowired
    private ListTasksRepository listTasksRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    private RequestUser requestUser;

    @Override
    public ListTasksEntity saveTask(long listId, TaskEntity request) throws IOException, URISyntaxException {

        Optional<ListTasksEntity> listTasksEntity = listTasksRepository.findById(listId);

        if(listTasksEntity.isPresent()){

            if(!verificarUser(request.getUserEmail())) {
                throw new RuntimeException("Usuario nao existe");
            }

            request.setId(sequenceGeneratorService.generateSequence(TaskEntity.SEQUENCE_NAME));

            taskRepository.save(request);

            ListTasksEntity listTask = listTasksEntity.get();
            List<TaskEntity> tasks = listTask.getListTask();
            tasks.add(request);
            listTask.setListTask(tasks);
            
            listTasksRepository.save(listTask);

            return listTask;
        } else {
         throw new RuntimeException("lista nao existe");
        }
    }

    @Override
    public TaskEntity findTaskById(long listId, long taskId) {
        Optional<ListTasksEntity> listTasksEntity = listTasksRepository.findById(listId);
        
         if(listTasksEntity.isPresent()){
            ListTasksEntity listTask = listTasksEntity.get();
            List<TaskEntity> tasks = listTask.getListTask();
            
            Optional<TaskEntity> taskEntity = tasks.stream()
                                            .filter(t -> t.getId() == taskId)
                                            .findFirst();

            if(taskEntity.isPresent()) {
                return taskEntity.get();
            } else {
                throw new RuntimeException("Task nao encontrada");
            }
        } else {
         throw new RuntimeException("lista nao existe");
        }
    }

    @Override
    public TaskEntity updateTask(long listId, long taskId, TaskEntity request) {
        Optional<ListTasksEntity> listTasksEntity = listTasksRepository.findById(listId);

        if(listTasksEntity.isPresent()){

            Optional<TaskEntity> taskEntity = this.taskRepository.findById(taskId);

            if(taskEntity.isPresent()) {
                TaskEntity task = taskEntity.get();
                updateTask(task, request);
                return this.taskRepository.save(task);
            } else {
                throw new RuntimeException("task nao encontrada");
            }
        } else {
            throw new RuntimeException("Lista nao encontrada");
        }    
        
    }

    @Override
    public void deleteTask(long listId, long taskId) {
        Optional<ListTasksEntity> listTasksEntity = listTasksRepository.findById(listId);

        if(listTasksEntity.isPresent()){
            taskRepository.deleteById(taskId);
        } else {
            throw new RuntimeException("Lista nao encontrada");
        } 

    }

    private boolean verificarUser(String email){

        String BASE_URL = "http://localhost:8090";

        String PATH = "/user-ms/v1/user";

        String RESOURCE = "/email/";

        UserDTO userDTO = null;

        try {

            userDTO = requestUser.getUser(BASE_URL.concat(PATH + RESOURCE), email);
        
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        if(userDTO != null) {
            return true;
        } else {
            return false;
        }
    }

    private void updateTask(TaskEntity task, TaskEntity taskRequest) {
        task.setDescription(taskRequest.getDescription());
        task.setTitle(taskRequest.getTitle());
        task.setDue_date(taskRequest.getDue_date());
        task.setUserEmail(taskRequest.getUserEmail());
    }
}
