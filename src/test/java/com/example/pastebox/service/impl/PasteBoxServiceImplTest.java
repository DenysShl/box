package com.example.pastebox.service.impl;

import com.example.pastebox.api.response.PasteBoxResponse;
import com.example.pastebox.exception.NotFoundEntityException;
import com.example.pastebox.mapper.PasteBoxMapper;
import com.example.pastebox.model.PasteBoxEntity;
import com.example.pastebox.repository.PasteBoxRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
class PasteBoxServiceImplTest {
    @Autowired
    private PasteBoxServiceImpl pasteBoxService;
    @Autowired
    private PasteBoxMapper mapper;

    @MockBean
    private PasteBoxRepository repository;


    @Test
    public void notExistHash_Ok() {
       when(repository.getByHash(anyString())).thenThrow(NotFoundEntityException.class);
       assertThrows(NotFoundEntityException.class, () -> pasteBoxService.getByHash("1fghh23"));
    }

    @Test
    public void existHash_Ok() {
        LocalDateTime now = LocalDateTime.now();
        when(repository.getByHash("123")).thenReturn(new PasteBoxEntity("123", "123"," true", now, true));
        PasteBoxResponse expected = mapper.toDto(new PasteBoxEntity("123", "123"," true", now, true));
        PasteBoxResponse actual = pasteBoxService.getByHash("123");
        assertNotNull(actual);
        assertEquals(expected, actual);
    }
}