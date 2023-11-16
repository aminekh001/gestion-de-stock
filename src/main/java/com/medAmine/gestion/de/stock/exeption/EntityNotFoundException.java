package com.medAmine.gestion.de.stock.exeption;

public class EntityNotFoundException extends RuntimeException{
    private ErrorCode errorCode;

    public EntityNotFoundException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public EntityNotFoundException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFoundException(String message, Throwable cause, ErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
