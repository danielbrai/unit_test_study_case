package br.com.danielbrai.core.exceptions;

public class TrainingReachedTheEndException extends RuntimeException {

    public TrainingReachedTheEndException() {
        super();
    }

    public TrainingReachedTheEndException(String msg) {
        super(msg);
    }
}
