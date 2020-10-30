package owie.lionel.owie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import owie.lionel.owie.domain.Story;
import owie.lionel.owie.domain.StoryPart;
import owie.lionel.owie.domain.User;
import owie.lionel.owie.repository.StoryRepository;
import owie.lionel.owie.repository.StoryPartRepository;
import owie.lionel.owie.repository.UserRepository;

import java.util.Optional;

@Service
public class StoryPartsService implements IStoryPartsService {

    @Autowired
    public StoryPartRepository storyPartRepository;
    
    @Autowired
    public UserRepository userRepository;

    @Autowired
    public StoryRepository storyRepository;


    @Override
    public StoryPart createStoryPart(long authorId, long storyId, StoryPart newStoryPart) {

        Optional<User> userFromDb =userRepository.findById(authorId);
        Optional<Story> storyFromDb = storyRepository.findById(storyId);

        if(userFromDb.isPresent() && storyFromDb.isPresent()) {
            newStoryPart.setAppUser(userFromDb.get());
            newStoryPart.setStory(storyFromDb.get());
            return storyPartRepository.save(newStoryPart);
        }
        // NickList<StoryParts> user = storyPartsRepository.findAll();
        return null;
    }

/*
    @Override
    public StoryParts updateStoryPartById(long id, StoryParts updatedPart) {
        return storyPartsRepository.findById(id).map(
                part -> {
                    part.setBody(updatedPart.getBody());
                    return storyPartsRepository.save(part);
                })
                //kan story niet vinden in database
                .orElseGet(() -> {
                    // TODO hier wordt nog geen author aan toegewezen.
                    updatedPart.setStoryPartsId(id);
                    return storyPartsRepository.save(updatedPart);
                });
    }
*/
}