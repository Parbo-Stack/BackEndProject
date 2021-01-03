package owie.lionel.owie.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import owie.lionel.owie.domain.Story;
import owie.lionel.owie.domain.StoryPart;
import owie.lionel.owie.domain.User;
import owie.lionel.owie.exception.StoryPartNotFoundException;
import owie.lionel.owie.repository.StoryPartRepository;
import owie.lionel.owie.repository.StoryRepository;
import owie.lionel.owie.repository.UserRepository;

import java.util.List;
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
    public StoryPart createStoryPart(UserDetails userDetails, Long storyId, StoryPart newStoryPart) {
        Optional<Story> story = storyRepository.findById(storyId);

        if (story.isPresent()) {
            newStoryPart.setAppUser(story.get().getUsers());
            newStoryPart.setStory(story.get());
            return storyPartRepository.save(newStoryPart);
        }

        return null;
    }


    @Override
    public List<StoryPart> getAllStoryParts() {
        return storyPartRepository.findAll();
    }

    @Override
    public StoryPart findById(Long id) {
        Optional<StoryPart> storyPart = storyPartRepository.findById(id);
        return storyPart.orElse(null);
    }

    @Override
    public String deleteById(User user, Long id) {
        Optional<StoryPart> storyPart = storyPartRepository.findById(id);

        if (storyPart.isPresent()) {
            storyPartRepository.deleteById(id);
            return "StoryPart with id " + storyPart.get().getStoryPartId() + "is verwijderd";
        }
        return "StoryPart niet gevonden";
    }

}
