package owie.lionel.owie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import owie.lionel.owie.domain.StoryPart;

public interface StoryPartRepository extends JpaRepository<StoryPart, Long> {

}
