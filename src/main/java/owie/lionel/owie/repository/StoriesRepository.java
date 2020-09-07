package owie.lionel.owie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import owie.lionel.owie.domain.Stories;

public interface StoriesRepository extends JpaRepository<Stories, Long> {
}
