package com.example.pastebox.api.request;

import lombok.Data;

@Data
public class PasteBoxRequest {
    private String hash;
    private String content;
    private String data;
    private Long expirationTimeSeconds;
    private PublicStatus publicStatus;

}
