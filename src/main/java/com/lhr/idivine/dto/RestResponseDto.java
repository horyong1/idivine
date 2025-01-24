package com.lhr.idivine.dto;

import java.util.Map;

import lombok.Data;

import java.util.HashMap;

@Data
public class RestResponseDto {
    private String result;
    private String reason;
    private String message;
    private Map<String , Object> data = new HashMap<>();

    public void add(String key , Object value){
        data.put(key, value);
    }
}
