package com.example.javagradledevops.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class DevOpsController {

    @GetMapping("/")
    public ResponseEntity<Map<String, String>> root() {
        Map<String, String> response = new LinkedHashMap<>();
        response.put("message", "Java Gradle DevOps Application is running");
        response.put("version", "1.0.0");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/api/hello")
    public ResponseEntity<Map<String, String>> hello() {
        Map<String, String> response = new LinkedHashMap<>();
        response.put("message", "Hello from Java Gradle Application");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/api/info")
    public ResponseEntity<Map<String, String>> info() {
        Map<String, String> response = new LinkedHashMap<>();
        response.put("application", "Java Gradle DevOps App");
        response.put("version", "1.0.0");
        response.put("java", "21");
        response.put("buildTool", "Gradle");
        return ResponseEntity.ok(response);
    }
}
