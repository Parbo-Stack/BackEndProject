package owie.lionel.owie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import owie.lionel.owie.domain.Story;
import owie.lionel.owie.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

}
