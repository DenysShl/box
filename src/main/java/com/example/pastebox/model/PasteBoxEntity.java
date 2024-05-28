package com.example.pastebox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasteBoxEntity {
    private String data;
    private String hash;
    private String url;
    private LocalDateTime createdAt = LocalDateTime.now();
    private boolean isPublic;

    public PasteBoxEntity(String data, boolean isPublic) {
        this.data = data;
        this.isPublic = isPublic;
    }
}
