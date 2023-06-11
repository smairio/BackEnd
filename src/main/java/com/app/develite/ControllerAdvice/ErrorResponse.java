package com.app.develite.ControllerAdvice;

import java.time.LocalDateTime;

public class ErrorResponse {
 
    private int status;
    private String message;
    private LocalDateTime timestamp;
 
    // getters and setters

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}