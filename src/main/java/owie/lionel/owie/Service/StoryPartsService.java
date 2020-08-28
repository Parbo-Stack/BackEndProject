package owie.lionel.owie.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import owie.lionel.owie.Model.StoryParts;
import owie.lionel.owie.persistence.StoryPartsRepository;

@Service
public class StoryPartsService implements IStoryPartsService {

    @Autowired
    public StoryPartsRepository storyPartsRepository;

    @Override
    public StoryParts createStoryParts (StoryParts newStoryPart){
        return storyPartsRepository.save(newStoryPart);
    }
}
