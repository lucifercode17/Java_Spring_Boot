package in.learnings.dtoCrudApplication.dto;

import java.time.LocalDateTime;

public class ExpectionResponseDto {

    private LocalDateTime currentTime;
    private int statusCode;
    private String error;
    private  String message;
    private  String path;

    public ExpectionResponseDto(LocalDateTime currentTime, int statusCode, String error, String message, String path) {
        this.currentTime = currentTime;
        this.statusCode = statusCode;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public LocalDateTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = currentTime;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
