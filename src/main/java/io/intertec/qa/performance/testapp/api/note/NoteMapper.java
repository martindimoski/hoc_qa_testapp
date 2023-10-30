package io.intertec.qa.performance.testapp.api.note;

import io.intertec.qa.performance.testapp.db.entity.Note;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface NoteMapper {

    Note createNoteRequestToNote(CreateNoteRequest request);

    @Mapping(target = "username", source = "note.user.username")
    NoteResponse noteToNoteResponse(Note note);

    List<NoteResponse> listNotesToListNotesResponse(List<Note> notes);

    Note updateNoteRequestToNote(UpdateNoteRequest request);
}
