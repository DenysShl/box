package com.example.pastebox.api.request;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PasteBoxRequest {
    private String hash;
    private String content;
    private String data;
    @JsonProperty("expiration_time_seconds")
    private Long expirationTimeSeconds;
    private PublicStatus publicStatus;

}
