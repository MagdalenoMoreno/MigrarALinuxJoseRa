package edu.alumno.adria.api_rest_bd_futbol.exception;

public class CiudadNotFoundException extends RuntimeException {
    private final String errorCode;

    public CiudadNotFoundException(String errorcode, String message) {
        super(message);
        this.errorCode = errorcode + message;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
