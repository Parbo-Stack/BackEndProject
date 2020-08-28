package owie.lionel.owie.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import owie.lionel.owie.Model.Stories;

public interface StoriesRepository extends JpaRepository<Stories, Long> {
}
