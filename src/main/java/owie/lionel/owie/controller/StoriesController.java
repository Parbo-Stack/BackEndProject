package owie.lionel.owie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import owie.lionel.owie.domain.Stories;
import owie.lionel.owie.service.StoriesService;

import java.util.List;

@RestController
public class StoriesController {

    @Autowired
    private StoriesService storiesService;

    @GetMapping(value = "/api/stories")
    public List<Stories> getStories() {
        return storiesService.findAllStories();
    }

    @GetMapping (value = "/api/story/{id}")
    public Stories getStoriesById(@PathVariable Long id) {
        return storiesService.getStoryById(id);
    }

    @DeleteMapping(value = "/api/story/{id}")
    public void deleteStoryById(@PathVariable Long id) {
        storiesService.deleteStoryById(id);
    }

    @PostMapping(value = "/api/story/")
    public Stories addStory(@RequestBody Stories newStory) {
        return storiesService.addStory(newStory);
    }

}
