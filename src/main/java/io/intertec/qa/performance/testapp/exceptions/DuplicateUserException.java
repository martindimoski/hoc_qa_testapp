package io.intertec.qa.performance.testapp.exceptions;

public class DuplicateUserException extends RuntimeException {

    public DuplicateUserException() {
        super("User with the given username already exists.");
    }
}
