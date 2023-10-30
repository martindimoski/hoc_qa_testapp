package io.intertec.qa.performance.testapp.api.user;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public String getUser() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
