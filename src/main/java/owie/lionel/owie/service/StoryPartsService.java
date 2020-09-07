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
    public StoryParts addStoryParts(StoryParts newStoryParts) {
        List<StoryParts> user = storyPartsRepository.findAll();

        if (user.isEmpty()) {
            newStoryParts.setUser(addStoryParts(newStoryParts).getUser());
            return storyPartsRepository.save(newStoryParts);
        }
        return null;
    }

   /* @Override
    public StoryParts updateStoryPartById(long id, StoryParts updatedStory) {
        return storyPartsRepository.findById(id).map(
                part -> {
                    part.setBody(updatedStory.getBody());
                    part.setTitle(updatedStory.getTitle());
                    return storyPartsRepository.save(part);

                })
                //kan story niet vinden in database
                .orElse(() -> {
                    updatedStory.setAuthorId(id);
                    return storyPartsRepository.save(updatedStory);
                });
*/

}

