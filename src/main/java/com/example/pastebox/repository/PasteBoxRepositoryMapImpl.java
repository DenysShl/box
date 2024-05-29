package com.example.pastebox.repository;

import com.example.pastebox.exception.NotFoundEntityException;
import com.example.pastebox.model.PasteBoxEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PasteBoxRepositoryMapImpl implements PasteBoxRepository {
    private static final Map<String, PasteBoxEntity> bdByMap = new ConcurrentHashMap<>();
    @Override
    public PasteBoxEntity getByHash(String hash) {
        PasteBoxEntity pasteBoxEntity = bdByMap.get(hash);
        if (pasteBoxEntity == null) {
           throw new NotFoundEntityException(" PasteBox not found");
        }
        return pasteBoxEntity;
    }

    @Override
    public List<PasteBoxEntity> getPublicListLifetime(int amount) {
       LocalDateTime nowLocalDateTime = LocalDateTime.now().minusMinutes(10L);

        return bdByMap.values()
                .stream()
                .filter(PasteBoxEntity::isPublic)
                .filter(pasteBoxEntity -> pasteBoxEntity.getCreatedAt().isAfter(nowLocalDateTime))
                .sorted(Comparator.comparing(PasteBoxEntity::getHash))
                .limit(amount)
                .toList();
    }

    @Override
    public PasteBoxEntity create(PasteBoxEntity entity) {
        bdByMap.put(entity.getHash(), entity);
        return entity;
    }
}
