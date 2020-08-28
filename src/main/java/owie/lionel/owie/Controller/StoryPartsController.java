package owie.lionel.owie.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;
import owie.lionel.owie.Model.StoryParts;
import owie.lionel.owie.Model.Users;
import owie.lionel.owie.Service.StoryPartsService;
import owie.lionel.owie.persistence.StoriesRepository;
import owie.lionel.owie.persistence.StoryPartsRepository;
import owie.lionel.owie.persistence.UsersRepository;

import java.util.Optional;

@RestController
public class StoryPartsController {

    @Autowired
    private StoryPartsService storyPartsService;


    @PostMapping(value = "/api/storiespart")
    private StoryParts createStoryPart (@PathVariable StoryParts newStoryPart) {
        return storyPartsService.createStoryParts(newStoryPart);
    }





    }



