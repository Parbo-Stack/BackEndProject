package owie.lionel.owie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import owie.lionel.owie.domain.ApplicationUser;

import java.util.Optional;

public interface UserRepository extends JpaRepository<ApplicationUser, Long> {

    Optional<ApplicationUser> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
