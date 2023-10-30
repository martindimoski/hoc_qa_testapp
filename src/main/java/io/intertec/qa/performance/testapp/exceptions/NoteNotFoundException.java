package io.intertec.qa.performance.testapp.exceptions;

public class NoteNotFoundException extends NotFoundException {

    public NoteNotFoundException() {
        super("Note not found.");
    }
}
