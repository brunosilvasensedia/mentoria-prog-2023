package com.mentoriaprogramacao.taskMS.domain.service.listTasksService;

import static org.junit.jupiter.api.Assertions.*;

import com.mentoriaprogramacao.taskMS.domain.entity.ListTasksEntity;
import com.mentoriaprogramacao.taskMS.domain.service.exceptions.ListNotFoundException;
import com.mentoriaprogramacao.taskMS.domain.service.sequenceGenerator.SequenceGeneratorService;
import com.mentoriaprogramacao.taskMS.port.inbound.repository.ListTasksRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class ListTaskServiceImpTest {

    @Mock
    private ListTasksRepository listTasksRepository;

    @Mock
    private SequenceGeneratorService sequenceGeneratorService;

    @InjectMocks
    private ListTaskServiceImp listTaskService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAllLists_WhenListsExist_ThenReturnLists() {
        // Given
        List<ListTasksEntity> mockLists = new ArrayList<>();
        when(listTasksRepository.findAll()).thenReturn(mockLists);

        // When
        List<ListTasksEntity> result = listTaskService.findAllLists();

        // Then
        assertSame(mockLists, result);
    }

    @Test
    public void findListsByID_WhenListExists_ThenReturnList() {
        // Given
        long id = 1L;
        ListTasksEntity mockList = new ListTasksEntity();
        when(listTasksRepository.findById(id)).thenReturn(Optional.of(mockList));

        // When
        ListTasksEntity result = listTaskService.findListsByID(id);

        // Then
        assertSame(mockList, result);
    }

    @Test
    public void findListsByID_WhenListDoesNotExist_ThenThrowListNotFoundException() {
        // Given
        long id = 2L;
        when(listTasksRepository.findById(id)).thenReturn(Optional.empty());

        // When, Then
        assertThrows(ListNotFoundException.class, () -> {
            listTaskService.findListsByID(id);
        });
    }

    // Add similar tests for other methods like deleteList, updateList, and saveTaskList
}
