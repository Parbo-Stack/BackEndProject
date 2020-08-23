package owie.lionel.owie.Service;

import org.springframework.data.jpa.repository.JpaRepository;
import owie.lionel.owie.Model.AudioStory;


public interface AudioStoryRepository extends JpaRepository<AudioStory, Long> {
}
