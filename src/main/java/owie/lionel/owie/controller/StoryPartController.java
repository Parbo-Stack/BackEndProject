package owie.lionel.owie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import owie.lionel.owie.domain.StoryPart;
import owie.lionel.owie.domain.User;
import owie.lionel.owie.service.StoryPartsService;
import java.security.Principal;


@CrossOrigin
@RestController
public class StoryPartController {

    @Autowired
    private StoryPartsService storyPartsService;

    @RequestMapping(value = "/api/story/{storyId}/storypart", method = RequestMethod.POST)
    public StoryPart createStoryPart (@AuthenticationPrincipal User user, @PathVariable Long storyId, @RequestBody StoryPart newStoryPart) {
        return storyPartsService.createStoryPart(user, storyId, newStoryPart);
    }

}



