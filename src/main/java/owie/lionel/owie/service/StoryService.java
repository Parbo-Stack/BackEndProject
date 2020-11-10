package owie.lionel.owie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import owie.lionel.owie.domain.Story;
import owie.lionel.owie.domain.User;
import owie.lionel.owie.repository.StoryRepository;
import owie.lionel.owie.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StoryService implements IStoryService  {

    @Autowired
    private StoryRepository storyRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Story> getAllStories() {
        return storyRepository.findAll(); }

    @Override
    public Story findById(Long id) {
        Optional<Story> story = storyRepository.findById(id);
        return story.orElse(null);
    }

    @Override
    public Story createStory( String username, Story newStory) {
        Optional<User> userFromDb = userRepository.findByUsername(username);

        if (userFromDb.isPresent()) {
            newStory.setAuthor(userFromDb.get());
            return storyRepository.save(newStory);
        }
        return null;
    }
    @Override
    public Story findById(Long id, Story updatedStory){
        return storyRepository.findById(id) .map(
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
    public void deleteById(Long id) { storyRepository.deleteById(id); }

    @Override
    public List<Story> deleteAll () {
        storyRepository.deleteAll ();
        //De return statement weer nakijken, want dit is niet geadviseerd te doen(video nick: put and delete video)
        return null;
    }

    @Override
    public List<Story> findByTitle(String title) {
          return storyRepository.findByTitle(title);
    }


/*
   @Override
    public Story addStory(long storiesId, Story newStory) {
        Optional<ApplicationUser> userFromDb = applicationUserRepository.findById(storiesId);

        if(userFromDb.isPresent()) {
            newStory.setOwner(userFromDb.get());
            return storyRepository.save(newStory);
        }
        return null;


   }
 */


}
