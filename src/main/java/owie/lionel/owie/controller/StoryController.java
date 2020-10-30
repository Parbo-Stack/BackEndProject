package owie.lionel.owie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import owie.lionel.owie.domain.Story;
import owie.lionel.owie.service.StoryService;
import java.util.List;


@CrossOrigin
@RestController
public class StoryController {

    @Autowired
    private StoryService storyService;

    @GetMapping(value = "api/stories")
    public List<Story> getAllStories() { return storyService.getAllStories(); }

    @GetMapping (value = "api/story/{id}")
    public Story getStoryById(@PathVariable Long id) { return storyService.findById(id); }

    @PostMapping(value = "api/story/{username}")
    public Story createStory(@PathVariable String username, @RequestBody Story newStory) { return storyService.createStory(username, newStory); }

    @PutMapping(value = "api/story/{id}")
    public Story updateStoryById(@PathVariable Long id, @RequestBody Story updatedStory) {
        return storyService.findById(id,updatedStory); }

    @DeleteMapping(value = "api/story/{id}")
    public void deleteById (@PathVariable Long id) {
        storyService.deleteById(id);
    }

    @DeleteMapping(value="api/story")
    public List<Story> deleteAll () {
        return storyService.deleteAll(); }

    @GetMapping(value = "/findbytitle")
    public List<Story> findByTitle (@RequestParam String title) { return storyService.findByTitle(title); }

}
