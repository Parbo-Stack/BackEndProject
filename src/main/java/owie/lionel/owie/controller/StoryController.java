package owie.lionel.owie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import owie.lionel.owie.domain.Story;
import owie.lionel.owie.domain.StoryPart;
import owie.lionel.owie.domain.User;
import owie.lionel.owie.service.StoryService;

import javax.websocket.server.PathParam;
import java.security.Principal;
import java.time.LocalDate;
import java.util.List;


@CrossOrigin
@RestController
public class StoryController {

    @Autowired
    private StoryService storyService;

    @GetMapping (value = "api/stories/{id}")
    public Story getStoryById(@PathVariable Long id) { return storyService.findById(id); }

    @GetMapping(value = "api/stories/author")
    public List<Story> findAllStoryByAuthorIsNull() {return storyService.findAllStoryByAuthorIsNull();}

    @GetMapping(value = "api/stories/titleIsNull")
    public List<Story> findAllStoryByTitleIsNull() {
        return storyService.findAllStoryByTitleIsNull();}

    @GetMapping(value = "api/stories")
    public List<Story> findAllStoryByTitleIsNotNullAndAuthorIsNotNull() {
        return storyService.findAllStoryByTitleIsNotNullAndAuthorIsNotNull();}

    @PostMapping(value = "api/story")
    public Story createStory(@AuthenticationPrincipal UserDetails userDetails, @RequestBody Story newStory)
    { return storyService.createStory(userDetails, newStory); }

    @PutMapping(value = "api/story/{id}")
    public Story updateStoryById(@PathVariable Long id, @RequestBody Story updatedStory) {
        return storyService.findById(id,updatedStory); }

    @DeleteMapping(value = "api/story/{id}")
    public void deleteById(@AuthenticationPrincipal User user, @PathVariable Long id) {
        storyService.deleteById(user, id);}

    @DeleteMapping(value="api/stories")
    public List<Story> deleteAll () {
        return storyService.deleteAll(); }

}
