package owie.lionel.owie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import owie.lionel.owie.domain.StoryParts;
import owie.lionel.owie.service.StoryPartsService;

@RestController
public class StoryPartsController {

    @Autowired
    private StoryPartsService storyPartsService;

    //problemen met postman: The Postmapping en de Putmapping geven error 415
    @PostMapping(value = "/api/storyparts")
    public StoryParts addStoryParts(@RequestBody StoryParts newStoryParts) {
        return storyPartsService.addStoryParts(newStoryParts);
    }

    //nog niet  zeker als ik updates wil
    /*@PutMapping(value = "/api/storypart/{id}")
    public StoryParts updateStoryById (@PathVariable long id, @RequestBody StoryParts updatedPart) {
        return storyPartsService.updateStoryPartById(id, updatedPart); }

     */

}



