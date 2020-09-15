package owie.lionel.owie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import owie.lionel.owie.domain.StoryParts;
import owie.lionel.owie.repository.StoryPartsRepository;

import java.util.List;

@Service
public class StoryPartsService implements IStoryPartsService {

    @Autowired
    public StoryPartsRepository storyPartsRepository;

    @Override
    public StoryParts addStoryPart(StoryParts newStoryPart) {
        List<StoryParts> user = storyPartsRepository.findAll();

        if (user.isEmpty()) {
            newStoryPart.setUser(addStoryPart(newStoryPart).getUser());
            return storyPartsRepository.save(newStoryPart);
        }
        return null;
    }

    @Override
    public StoryParts updateStoryPartById(long id, StoryParts updatedPart) {
        return storyPartsRepository.findById(id).map(
                part -> {
                    part.setAuthor(updatedPart.getAuthor());
                    part.setBody(updatedPart.getBody());
                    return storyPartsRepository.save(part);
                })
                //kan story niet vinden in database
                .orElseGet(() -> {
                    updatedPart.setStoryPartsId(id);
                    return storyPartsRepository.save(updatedPart);
                });
    }

}