package br.com.danielbrai.exceptions;

public class TrainingAlreadyInitializedException extends RuntimeException {

    public TrainingAlreadyInitializedException() {
        super();
    }

    public TrainingAlreadyInitializedException(String msg) {
        super(msg);
    }
}
