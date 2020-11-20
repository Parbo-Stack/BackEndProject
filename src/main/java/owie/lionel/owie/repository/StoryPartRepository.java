package owie.lionel.owie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import owie.lionel.owie.domain.StoryPart;

import java.util.Optional;

public interface StoryPartRepository extends JpaRepository<StoryPart, Long> {
    Optional<StoryPart> findByStory(String storyPart);
}
