package io.intertec.qa.performance.testapp.api.user;

import io.intertec.qa.performance.testapp.constants.Endpoints;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Endpoints.SIGN_UP_ENDPOINT)
@RequiredArgsConstructor
public class SignUpController {

    private final UserService userService;
    private final UserMapper mapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping
    public String signup(@RequestBody @Validated SignUpRequest request) {
        var user = userService.createUser(mapper.signupRequestToUser(request, bCryptPasswordEncoder));
        return "User " + user.getUsername() + " is created.";
    }
}
