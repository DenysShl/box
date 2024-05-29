package com.example.pastebox.mapper;

import com.example.pastebox.api.response.PasteBoxResponse;
import com.example.pastebox.model.PasteBoxEntity;
import org.springframework.stereotype.Component;

@Component
public class PasteBoxMapper {

    public PasteBoxResponse toDto(PasteBoxEntity entity) {
        return PasteBoxResponse.builder()
                .data(entity.getData())
                .hash(entity.getHash())
                .createdAt(entity.getCreatedAt())
                .isPublic(entity.isPublic())
                .build();
    }
}
