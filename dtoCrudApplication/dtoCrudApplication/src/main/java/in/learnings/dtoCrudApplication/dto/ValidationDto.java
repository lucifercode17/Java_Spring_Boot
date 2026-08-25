package in.learnings.dtoCrudApplication.dto;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ValidationDto {
    private LocalDateTime currentTime;
    private int statusCode;
    private String error;

    private  String path;
    private Map<String, String> errorFields;

    public ValidationDto(LocalDateTime currentTime, int statusCode, String error,  String path, Map<String, String> errorFields) {
        this.currentTime = currentTime;
        this.statusCode = statusCode;
        this.error = error;

        this.path = path;
        this.errorFields = errorFields;
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



    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getErrorFields() {
        return errorFields;
    }

    public void setErrorFields(Map<String, String> errorFields) {
        this.errorFields = errorFields;
    }
}
