package owie.lionel.owie.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import owie.lionel.owie.Model.Users;

public interface UsersRepository extends JpaRepository <Users, Long> {
}
