package edu.alumno.adria.dwes_primer_rest.exception;

public class AlumnoNotFoundExcepcion extends RuntimeException {

    private final String errorCode;

    public AlumnoNotFoundExcepcion(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}