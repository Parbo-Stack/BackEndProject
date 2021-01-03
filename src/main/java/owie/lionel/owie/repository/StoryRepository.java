package owie.lionel.owie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import owie.lionel.owie.domain.Story;
import owie.lionel.owie.domain.StoryPart;
import owie.lionel.owie.domain.User;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface StoryRepository extends JpaRepository<Story, Long> {
    //dit is de Derived queries methode
    List<Story> findAllStoryByAuthorIsNull();
    List<Story> findAllStoryByTitleIsNull();
    List<Story> findAllStoryByTitleIsNotNullAndAuthorIsNotNull();
}
