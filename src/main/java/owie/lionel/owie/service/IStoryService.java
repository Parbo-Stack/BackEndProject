package owie.lionel.owie.service;

import org.springframework.security.core.userdetails.UserDetails;
import owie.lionel.owie.domain.Story;
import owie.lionel.owie.domain.User;

import java.security.Principal;
import java.util.List;


public interface IStoryService {

    List <Story> getAllStories();
    List<Story> getAllStories(Principal principal, String username);
    Story findById(Long id);
    Story createStory(UserDetails userDetails, Story newStory);
    Story findById(Long id, Story updatedStory);
    void deleteById (Long storyId);
    List <Story> deleteAll ();
}
