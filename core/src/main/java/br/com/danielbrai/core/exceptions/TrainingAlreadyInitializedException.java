package br.com.danielbrai.core.exceptions;

public class TrainingAlreadyInitializedException extends RuntimeException {

    public TrainingAlreadyInitializedException() {
        super();
    }

    public TrainingAlreadyInitializedException(String msg) {
        super(msg);
    }
}
