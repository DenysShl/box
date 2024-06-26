package com.example.pastebox.controller;

import com.example.pastebox.api.request.PasteBoxRequest;
import com.example.pastebox.api.response.PasteBoxResponse;
import com.example.pastebox.api.response.PasteBoxUrlResponse;
import com.example.pastebox.service.PasteBoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/boxes")
public class PasteBoxController {
    private final PasteBoxService pasteBoxService;

    @GetMapping("/{hash}")
    public PasteBoxResponse getByHash(@PathVariable String hash) {
        return pasteBoxService.getByHash(hash);
    }

    @GetMapping
    public List<PasteBoxResponse> getPublicList() {
        return pasteBoxService.getPublicList();
    }

    @PostMapping
    public PasteBoxUrlResponse create(@RequestBody PasteBoxRequest request) {
        return pasteBoxService.create(request);
    }
}
