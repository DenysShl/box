package com.example.pastebox.service.impl;

import com.example.pastebox.api.request.PasteBoxRequest;
import com.example.pastebox.api.request.PublicStatus;
import com.example.pastebox.api.response.PasteBoxResponse;
import com.example.pastebox.api.response.PasteBoxUrlResponse;
import com.example.pastebox.mapper.PasteBoxMapper;
import com.example.pastebox.model.PasteBoxEntity;
import com.example.pastebox.repository.PasteBoxRepository;
import com.example.pastebox.service.PasteBoxService;
import com.example.pastebox.util.GeneratorRandom;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PasteBoxServiceImpl implements PasteBoxService {
    private final PasteBoxRepository pasteBoxRepository;
    private final PasteBoxMapper boxMapper;
    private final GeneratorRandom generator;

    @Value("${app-props.host}")
    private String host;
    @Value("${app-props.public_list_size}")
    private int publicListSize;

    @Override
    public PasteBoxResponse getByHash(String hash) {
        PasteBoxResponse dto = boxMapper.toDto(pasteBoxRepository.getByHash(hash));
        return dto;
    }

    @Override
    public List<PasteBoxResponse> getPublicList() {
        return pasteBoxRepository.getPublicListLifetime(publicListSize)
                .stream()
                .map(boxMapper::toDto)
                .toList();
    }

    @Override
    public PasteBoxUrlResponse create(PasteBoxRequest request) {
        PasteBoxEntity entity = new PasteBoxEntity();
        entity.setData(request.getData());
        entity.setHash(Integer.toHexString(generator.generate()));
        entity.setPublic(request.getPublicStatus() == PublicStatus.PUBLIC);
        PasteBoxEntity pasteBoxEntity = pasteBoxRepository.create(entity);

        PasteBoxUrlResponse pasteBoxUrlResponse = new PasteBoxUrlResponse();
        pasteBoxUrlResponse.setUrl(host + "/" +pasteBoxEntity.getHash());
        return pasteBoxUrlResponse;
    }
}
