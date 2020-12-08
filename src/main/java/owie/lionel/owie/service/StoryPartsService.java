package owie.lionel.owie.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import owie.lionel.owie.domain.Story;
import owie.lionel.owie.domain.StoryPart;
import owie.lionel.owie.domain.User;
import owie.lionel.owie.repository.StoryPartRepository;
import owie.lionel.owie.repository.StoryRepository;
import owie.lionel.owie.repository.UserRepository;

import java.security.Principal;
import java.util.Optional;

@Service
public class StoryPartsService implements IStoryPartsService {

    @Autowired
    public StoryPartRepository storyPartRepository;

    @Autowired
    public StoryRepository storyRepository;

    @Autowired
    public UserRepository userRepository;


    @Override
    public StoryPart createStoryPart(User user, Long storyId, StoryPart newStoryPart) {
            Optional<Story> story = storyRepository.findById(storyId);

        if (story.isPresent()) {
            newStoryPart.setAppUser(user.getUserId());
            newStoryPart.setStory(story.get()); //TODO:nog nagaan waarom ik een comment kan posten als admin
            return storyPartRepository.save(newStoryPart);
        }
        return null;
    }

}
