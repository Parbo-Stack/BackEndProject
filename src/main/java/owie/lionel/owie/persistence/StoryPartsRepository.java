package owie.lionel.owie.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import owie.lionel.owie.Model.StoryParts;

public interface StoryPartsRepository extends JpaRepository<StoryParts, Long> {
}
