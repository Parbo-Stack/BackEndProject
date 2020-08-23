package owie.lionel.owie.Service;

import owie.lionel.owie.Model.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {

}
