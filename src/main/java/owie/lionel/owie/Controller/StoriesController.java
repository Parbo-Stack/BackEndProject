package owie.lionel.owie.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import owie.lionel.owie.Model.Stories;
import owie.lionel.owie.Service.StoriesService;
import owie.lionel.owie.persistence.StoriesRepository;

import java.util.List;

@RestController
public class StoriesController {

    @Autowired
    private StoriesService storiesService;

    @GetMapping(value = "/api/story")
    public List<Stories> getStories() {
        return storiesService.findAllStories();
    }

    @GetMapping (value = "/api/story/{id}")
    public Stories getStoriesById(@PathVariable Long id) {
        return storiesService.getStoryById(id);
    }

    @DeleteMapping(value= "/api/story/{id}")
    public void deleteStory(@PathVariable Long id) {
        storiesService.deleteStoryById(id);
    }


    @PostMapping(value = "/api/story/")
    public Stories addStory(@RequestBody Stories newStory) {
        return storiesService.addStory(newStory);
    }

}
