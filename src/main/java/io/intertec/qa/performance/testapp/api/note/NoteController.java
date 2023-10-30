package io.intertec.qa.performance.testapp.api.note;

import io.intertec.qa.performance.testapp.api.user.UserService;
import io.intertec.qa.performance.testapp.constants.Endpoints;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Endpoints.NOTES_ENDPOINT)
@AllArgsConstructor
@PreAuthorize("hasRole('USER')")
public class NoteController {

    NoteService noteService;
    NoteMapper noteMapper;
    UserService userService;

    @PostMapping
    public NoteResponse createNote(@RequestBody @Validated CreateNoteRequest request) {
        var note = noteService.createNote(noteMapper.createNoteRequestToNote(request));
        return noteMapper.noteToNoteResponse(note);
    }

    @GetMapping
    public List<NoteResponse> getNotes() {
        return noteMapper.listNotesToListNotesResponse(noteService.getNotes());
    }

    @GetMapping("/{noteUuid}")
    public NoteResponse getNote(@PathVariable String noteUuid) {
        return noteMapper.noteToNoteResponse(noteService.getNote(noteUuid));
    }

    @PutMapping("/{noteUuid}")
    public NoteResponse updateNote(@PathVariable String noteUuid,
                                   @RequestBody @Validated UpdateNoteRequest request) {
        var updatedNote = noteService.updateNote(noteUuid, noteMapper.updateNoteRequestToNote(request));
        return noteMapper.noteToNoteResponse(updatedNote);
    }

    @DeleteMapping("/{noteUuid}")
    public String deleteNote(@PathVariable String noteUuid) {
        noteService.deleteNote(noteUuid);
        return "The note was deleted.";
    }
}
