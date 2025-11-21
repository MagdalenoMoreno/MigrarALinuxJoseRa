package edu.alumno.adria.api_rest_bd_futbol.exception;

public class CustomErrorResponse extends RuntimeException{

    private final String errorCode;

    public CustomErrorResponse(String errorCodes, String message) {
        this.errorCode = errorCodes + message;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
