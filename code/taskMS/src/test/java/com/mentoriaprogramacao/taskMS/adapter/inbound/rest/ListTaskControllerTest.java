package com.mentoriaprogramacao.taskMS.adapter.inbound.rest;

import com.mentoriaprogramacao.taskMS.domain.entity.ListTasksEntity;
import com.mentoriaprogramacao.taskMS.domain.service.listTasksService.ListTaskService;
import com.mentoriaprogramacao.taskMS.domain.service.tasksService.TaskService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ListTaskController.class)
class ListTaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ListTaskService listTaskService;

    @MockBean
    private TaskService taskService;

    @Test
    void givenAllListsExist_whenFindAllLists_thenReturnAllLists() throws Exception {
        // Given
        List<ListTasksEntity> mockLists = new ArrayList<>();
        when(listTaskService.findAllLists()).thenReturn(mockLists);

        // When-Then
        mockMvc.perform(get("/task-ms/v1/lists")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void givenListIdExists_whenDeleteList_thenNoContent() throws Exception {
        // Given
        Long listId = 1L;

        // When-Then
        mockMvc.perform(delete("/task-ms/v1/lists/{id}", listId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
