package owie.lionel.owie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import owie.lionel.owie.domain.WriteStory;

public interface WriteStoryRepository extends JpaRepository<WriteStory, Long> {
}
