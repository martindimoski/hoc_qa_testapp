package io.intertec.qa.performance.testapp.db.repository;

import io.intertec.qa.performance.testapp.db.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, String> {

    List<Note> findAllByUserUsername(String username);

    Optional<Note> findByUuidAndUserUsername(String noteUuid, String username);
}
