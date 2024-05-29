package com.example.pastebox.repository;

import com.example.pastebox.model.PasteBoxEntity;

import java.util.List;

public interface PasteBoxRepository {
    PasteBoxEntity getByHash(String hash);
    List<PasteBoxEntity> getPublicListLifetime(int amount);
    PasteBoxEntity create(PasteBoxEntity entity);
}
