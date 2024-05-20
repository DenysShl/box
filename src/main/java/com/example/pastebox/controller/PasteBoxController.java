package com.example.pastebox.controller;

import com.example.pastebox.api.request.PasteBoxRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1/boxes")
public class PasteBoxController {

    @GetMapping("/{hash}")
    public String getByHash(@PathVariable String hash) {
        return hash;
    }

    @GetMapping
    public Collection<String> getPublicList() {
        return new ArrayList<>();
    }

    @PostMapping
    public String create(@RequestBody PasteBoxRequest request) {
        return request.getData();
    }
}
