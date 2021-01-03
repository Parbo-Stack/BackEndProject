package owie.lionel.owie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import owie.lionel.owie.domain.StoryPart;
import owie.lionel.owie.domain.User;
import owie.lionel.owie.service.StoryPartsService;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
public class StoryPartController {

    @Autowired
    private StoryPartsService storyPartsService;

    @PostMapping(value = "/api/story/{storyId}/storypart")
    public StoryPart createStoryPart(@AuthenticationPrincipal UserDetails UserDetails, @PathVariable Long storyId, @RequestBody StoryPart newStoryPart) {
        return storyPartsService.createStoryPart(UserDetails, storyId, newStoryPart); }

    @GetMapping(value = "api/storypart")
    public List<StoryPart> getAllStoryParts() {
        return storyPartsService.getAllStoryParts();
    }

    @GetMapping(value = "api/storypart/{id}")
    public StoryPart getStoryPartById(@PathVariable Long id) {
        return storyPartsService.findById(id);
    }

    @DeleteMapping(value = "api/storypart/{id}")
    public String deleteStoryPart(@AuthenticationPrincipal User user, @PathVariable Long id) {
        return storyPartsService.deleteById(user, id);
    }


}



