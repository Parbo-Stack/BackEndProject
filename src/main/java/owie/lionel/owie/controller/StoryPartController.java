package owie.lionel.owie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import owie.lionel.owie.domain.StoryPart;
import owie.lionel.owie.service.StoryPartsService;


@CrossOrigin
@RestController
public class StoryPartController {

    @Autowired
    private StoryPartsService storyPartsService;

    @PostMapping(value = "/api/storypart/{authorId}/{storyId}")
    public StoryPart createStoryPart(@PathVariable long authorId, @PathVariable long storyId,
                                     @RequestBody StoryPart newStoryPart) {
        return storyPartsService.createStoryPart(authorId, storyId, newStoryPart);
    }
    /*
    @PutMapping(value = "/api/storypart/{id}")
    public StoryParts updateStoryPartById (@PathVariable long id, @RequestBody StoryParts updatedPart) {
        return storyPartsService.updateStoryPartById(id, updatedPart); }
    */

}



