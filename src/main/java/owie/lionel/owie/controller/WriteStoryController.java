package owie.lionel.owie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import owie.lionel.owie.domain.Story;
import owie.lionel.owie.domain.User;
import owie.lionel.owie.domain.WriteStory;
import owie.lionel.owie.service.WriteStoryService;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
public class WriteStoryController {

    @Autowired
    private WriteStoryService writeStoryService;

    @GetMapping(value = "api/writestories")
    public List<WriteStory> getAllStories() {
        return writeStoryService.getAllStories();
    }

    @GetMapping(value = "api/writestories/{id}")
    public WriteStory getStoryById(@PathVariable Long id) {
        return writeStoryService.findById(id);
    }

    @PostMapping(value = "api/writestory")
    public WriteStory createWriteStory(@AuthenticationPrincipal UserDetails userDetails, @RequestBody WriteStory newWriteStory){
        return writeStoryService.createWriteStory(userDetails, newWriteStory);}

//        @DeleteMapping(value = "api/story/{id}")
//        public void deleteById(@PathVariable Long id) {
//            storyService.deleteById(id);}
//
//        @DeleteMapping(value="api/story")
//        public List<Story> deleteAll () {
//            return storyService.deleteAll(); }

}

