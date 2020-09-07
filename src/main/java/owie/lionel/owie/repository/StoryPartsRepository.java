package owie.lionel.owie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import owie.lionel.owie.domain.StoryParts;

public interface StoryPartsRepository extends JpaRepository<StoryParts, Long> {
}
