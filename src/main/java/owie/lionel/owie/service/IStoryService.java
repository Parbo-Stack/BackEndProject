package owie.lionel.owie.service;

import org.springframework.security.core.userdetails.UserDetails;
import owie.lionel.owie.domain.Story;
import owie.lionel.owie.domain.User;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;


public interface IStoryService {


    List<Story> findAllStoryByTitleIsNull();
    List<Story> findAllStoryByAuthorIsNull();
    List<Story> findAllStoryByTitleIsNotNullAndAuthorIsNotNull();
    Story findById(Long id);
    Story createStory(UserDetails userDetails, Story newStory);
    Story findById(Long id, Story updatedStory);
    void deleteById (User user, Long id);
}
