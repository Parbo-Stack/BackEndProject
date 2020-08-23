package owie.lionel.owie.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import owie.lionel.owie.Model.ReadStory;

public interface ReadStoryRepository extends JpaRepository<ReadStory, Long> {
}
