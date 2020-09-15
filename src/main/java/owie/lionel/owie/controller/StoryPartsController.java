package owie.lionel.owie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import owie.lionel.owie.domain.StoryParts;
import owie.lionel.owie.service.StoryPartsService;

@RestController
public class StoryPartsController {

    @Autowired
    private StoryPartsService storyPartsService;

    @PutMapping(value = "/api/storypart")
    public StoryParts addStoryPart(@RequestBody StoryParts newStoryPart) {
        return storyPartsService.addStoryPart(newStoryPart);
    }


    @PutMapping(value = "/api/storypart/{id}")
    public StoryParts updateStoryPartById (@PathVariable long id, @RequestBody StoryParts updatedPart) {
        return storyPartsService.updateStoryPartById(id, updatedPart); }


}



