package io.intertec.qa.performance.testapp.api.note;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class NoteResponse {

    String uuid;
    String name;
    String text;
    String username;
    LocalDateTime lastModifiedDate;
    LocalDateTime createdDate;
}
