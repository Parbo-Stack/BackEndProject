package owie.lionel.owie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import owie.lionel.owie.domain.Story;
import owie.lionel.owie.domain.User;
import owie.lionel.owie.service.StoryService;

import javax.websocket.server.PathParam;
import java.security.Principal;
import java.util.List;


@CrossOrigin
@RestController
public class StoryController {

    @Autowired
    private StoryService storyService;

    @GetMapping(value = "api/stories")
    public List<Story> getAllStories() { return storyService.getAllStories(); }

    @GetMapping(value = "api/stories/username")
    public List<Story> getAllStories(@AuthenticationPrincipal Principal principal, @RequestParam(value=" username") String  username)
    { return storyService.getAllStories(principal, username); }

    @GetMapping (value = "api/stories/{id}")
    public Story getStoryById(@PathVariable Long id) { return storyService.findById(id); }

    @PostMapping(value = "api/story")
    public Story createStory(@AuthenticationPrincipal UserDetails userDetails, @RequestBody Story newStory)
    { return storyService.createStory(userDetails, newStory); }

    @PutMapping(value = "api/story/{id}")
    public Story updateStoryById(@PathVariable Long id, @RequestBody Story updatedStory) {
        return storyService.findById(id,updatedStory); }

    @DeleteMapping(value = "api/story/{id}")
    public void deleteById(@PathVariable Long id) {
        storyService.deleteById(id);}

    @DeleteMapping(value="api/story")
    public List<Story> deleteAll () {
        return storyService.deleteAll(); }

}
