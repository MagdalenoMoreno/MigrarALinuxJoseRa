package edu.alumno.exception;

public class ResourceNotFoundException extends RuntimeException {
    
    private final String errorCode;

    public ResourceNotFoundException(String message) {
        super(message);
        this.errorCode = message;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
