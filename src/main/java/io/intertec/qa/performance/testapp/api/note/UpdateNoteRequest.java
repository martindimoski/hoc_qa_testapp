package io.intertec.qa.performance.testapp.api.note;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateNoteRequest {

    @NonNull
    private String name;
    @NonNull
    private String text;
}
