package owie.lionel.owie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import owie.lionel.owie.domain.Story;
import owie.lionel.owie.domain.StoryPart;
import owie.lionel.owie.repository.StoryPartRepository;
import owie.lionel.owie.repository.StoryRepository;
import java.util.Optional;

@Service
public class StoryPartsService implements IStoryPartsService {

    @Autowired
    public StoryPartRepository storyPartRepository;

    @Autowired
    public StoryRepository storyRepository;

    @Override
    public StoryPart createStoryPart(long storyId, StoryPart newStoryPart) {
        Optional<Story> storyFromDb = storyRepository.findById(storyId);

        if(storyFromDb.isPresent()) {
            newStoryPart.setStory(storyFromDb.get());
            return storyPartRepository.save(newStoryPart);
        }
        // NickList<StoryParts> user = storyPartsRepository.findAll();
        return null;
    }

    @Override
    public StoryPart saveStoryPart(StoryPart newStoryPart) {
      return  storyPartRepository.save(newStoryPart);
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