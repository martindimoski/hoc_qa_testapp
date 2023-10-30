package io.intertec.qa.performance.testapp.exceptions;

public class UserNotFoundException extends NotFoundException {

    public UserNotFoundException() {
        super("User not found.");
    }
}
