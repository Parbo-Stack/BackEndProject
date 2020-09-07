package owie.lionel.owie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import owie.lionel.owie.domain.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository <ApplicationUser, Long> {
}
