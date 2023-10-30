package io.intertec.qa.performance.testapp.api.user;

import io.intertec.qa.performance.testapp.db.entity.User;
import org.mapstruct.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Mapper(injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    User signupRequestToUser(SignUpRequest request, @Context BCryptPasswordEncoder bCryptPasswordEncoder);

    @AfterMapping
    default void afterSignupRequestToUser(SignUpRequest request,
                                          @MappingTarget User user,
                                          @Context BCryptPasswordEncoder bCryptPasswordEncoder) {
        user.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
    }
}
