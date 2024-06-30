package br.com.danielbrai.exceptions;

public class TrainingReachedTheEndException extends RuntimeException {

    public TrainingReachedTheEndException() {
        super();
    }

    public TrainingReachedTheEndException(String msg) {
        super(msg);
    }
}
