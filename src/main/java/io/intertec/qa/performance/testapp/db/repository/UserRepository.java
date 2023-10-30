package io.intertec.qa.performance.testapp.db.repository;

import io.intertec.qa.performance.testapp.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);
}
