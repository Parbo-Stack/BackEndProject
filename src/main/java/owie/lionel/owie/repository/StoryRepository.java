package owie.lionel.owie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import owie.lionel.owie.domain.Story;
import java.util.List;
import java.util.Optional;

public interface StoryRepository extends JpaRepository<Story, Long> {
   List<Story> findByTitle(String title);// dit weer nagaan TODO

   Optional<Story> findByAuthor(String authorId);//findbyauthor heb ik er zelf aan toegevoegd

}
