package owie.lionel.owie.service;

import org.springframework.security.core.userdetails.UserDetails;
import owie.lionel.owie.domain.StoryPart;
import owie.lionel.owie.domain.User;

import java.util.List;

public interface IStoryPartsService {
        StoryPart createStoryPart(UserDetails userDetails, Long storyId, StoryPart newStoryPart);
        List<StoryPart> getAllStoryParts();
        StoryPart findById(Long id);
        String deleteById(User user, Long id);
}
