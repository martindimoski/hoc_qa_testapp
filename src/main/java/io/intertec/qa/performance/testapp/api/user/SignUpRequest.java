package io.intertec.qa.performance.testapp.api.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
@AllArgsConstructor
public class SignUpRequest {

    @NonNull
    private String username;
    @NonNull
    private String password;
}
