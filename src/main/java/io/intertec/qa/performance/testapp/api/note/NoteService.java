package io.intertec.qa.performance.testapp.api.note;

import io.intertec.qa.performance.testapp.api.user.UserService;
import io.intertec.qa.performance.testapp.db.entity.Note;
import io.intertec.qa.performance.testapp.db.repository.NoteRepository;
import io.intertec.qa.performance.testapp.exceptions.NoteNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class NoteService {

    NoteRepository noteRepository;
    UserService userService;

    public Note createNote(Note note) {
        note.setUser(userService.getAuthenticatedUser());
        return noteRepository.save(note);
    }

    public List<Note> getNotes() {
        return noteRepository.findAllByUserUsername(userService.getAuthenticatedUser().getUsername());
    }

    public Note getNote(final String noteUuid) {
        return noteRepository.findByUuidAndUserUsername(noteUuid, userService.getAuthenticatedUser().getUsername())
                .orElseThrow(NoteNotFoundException::new);
    }

    public Note updateNote(final String noteUuid, final Note updatedNote) {
        var note = getNote(noteUuid);
        note.setName(updatedNote.getName());
        note.setText(updatedNote.getText());
        return noteRepository.save(note);
    }

    public void deleteNote(final String noteUuid) {
        var note = getNote(noteUuid);
        noteRepository.delete(note);
    }
}
