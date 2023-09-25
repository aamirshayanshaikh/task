package com.aamir.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> response(int statusCode, Object responseObj, String message, HttpStatus status) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", statusCode);
        map.put("message", message);
        map.put("response", responseObj);
        return new ResponseEntity<>(map, status);
    }

    public static ResponseEntity<Object> response(int statusCode, String message, HttpStatus status) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", statusCode);
        map.put("message", message);
        return new ResponseEntity<>(map, status);
    }
}