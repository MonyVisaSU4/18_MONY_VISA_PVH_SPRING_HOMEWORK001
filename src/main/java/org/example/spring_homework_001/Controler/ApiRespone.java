package org.example.spring_homework_001.Controler;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ApiRespone<T> {
    private Boolean success;
    private String message;
    private HttpStatus status;
    private T payload;
    private LocalDateTime timestamp;
}
