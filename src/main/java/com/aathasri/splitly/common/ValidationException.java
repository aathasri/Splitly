package com.aathasri.splitly.common;

import java.util.ArrayList;
import java.util.List;

public class ValidationException extends RuntimeException{
    private final List<String> errors;

    public ValidationException(String message) {
        super(message);
        this.errors = new ArrayList<String>();
    }

    public ValidationException() {
        super("Validation failed with errors:");
        this.errors = new ArrayList<String>();
    }

    public List<String> getErrors() {
        return errors;
    }

    public void addErrors(String message) {
        errors.add(message);
    }

    public Boolean hasErrors() {
        return !errors.isEmpty();
    }

    @Override
    public String getMessage() {
        if (!hasErrors()) {
            return super.getMessage();
        }
        StringBuilder formattedErrors = new StringBuilder(super.getMessage() + "\n");
        for (String error : errors) {
            formattedErrors.append("\t").append(error).append("\n");
        }
        return formattedErrors.toString().trim();
    }
}
