package owie.lionel.owie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import owie.lionel.owie.domain.Story;
import java.util.List;

public interface StoryRepository extends JpaRepository<Story, Long> {
   List<Story> findByTitle(String title);

}
