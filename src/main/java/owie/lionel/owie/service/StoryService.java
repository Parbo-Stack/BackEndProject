package owie.lionel.owie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import owie.lionel.owie.domain.Story;
import owie.lionel.owie.domain.User;
import owie.lionel.owie.repository.StoryRepository;
import owie.lionel.owie.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StoryService implements IStoryService {

    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Story> findAllStoryByAuthorIsNull() {
        return storyRepository.findAllStoryByAuthorIsNull();
    }

    @Override
    public List<Story> findAllStoryByTitleIsNull() {
        return storyRepository.findAllStoryByTitleIsNull();
    }

    @Override
    public List<Story> findAllStoryByTitleIsNotNullAndAuthorIsNotNull() {
        return storyRepository.findAllStoryByTitleIsNotNullAndAuthorIsNotNull();

    }

    @Override
    public Story findById(Long id) {
        Optional<Story> story = storyRepository.findById(id);
        return story.orElse(null);
    }


    @Override
    public Story createStory(UserDetails userDetails, Story newStory) {
        Optional<User> user = userRepository.findByUsername(userDetails.getUsername());

        if (user.isPresent()) {
            newStory.setUsers(user.get());
            return storyRepository.save(newStory);
        }
        return null;
    }

    @Override
    public Story findById(Long id, Story updatedStory) {
        return storyRepository.findById(id).map(
                story -> {
                    story.setTitle(updatedStory.getTitle());
                    story.setBody(updatedStory.getBody());
                    return storyRepository.save(story);
                })
                .orElseGet(() -> {
                    updatedStory.setStoryId(id);
                    return storyRepository.save(updatedStory);
                });
    }

    @Override
    public void deleteById(User user, Long id) {
        Optional<Story> story = storyRepository.findById(id);

        if (story.isPresent()) {
            storyRepository.deleteById(id);
        }
    }


}
