package com.aathasri.splitly.plan;

public class PlanNotFoundException extends RuntimeException{

    public PlanNotFoundException(String message) {
        super(message);
    }

    public PlanNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
