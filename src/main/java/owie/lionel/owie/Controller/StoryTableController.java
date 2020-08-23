package owie.lionel.owie.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import owie.lionel.owie.Model.*;
import owie.lionel.owie.Service.FinishStoryRepository;
import owie.lionel.owie.Service.ReadStoryRepository;
import owie.lionel.owie.Service.StorytableRepository;
import owie.lionel.owie.Service.WriteStoryRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class StoryTableController {

    @Autowired
    private StorytableRepository storytableRepository;

    @GetMapping(value = "api/storytable")
    public List<StoryTable> getAllStories() {
        return storytableRepository.findAll();
    }

    @GetMapping(value = "api/storytable/{id}")
    public StoryTable getStoryTable(@PathVariable long id) {
        Optional<StoryTable> storyTable = storytableRepository.findById(id);
        if (storyTable.isPresent()) {
            return storyTable.get();
        }
        return null;
    }

    @PostMapping(value = "api/storytable")
    public StoryTable saveStorytable(@RequestBody StoryTable newStoryTable) {
        return storytableRepository.save(newStoryTable);
    }

    @DeleteMapping(value = "api/storytable/{id}")
    public void deleteStoryTable(@PathVariable long id) {
        storytableRepository.deleteById(id);
    }

    @PutMapping(value = "api/storytable/{id}")
    public StoryTable updateById(@PathVariable long id, @RequestBody StoryTable updateStory) {
      return storytableRepository.findById(id).map(
              story -> {
                  story.setTitle(updateStory.getTitle());
                  story.setAuthor(updateStory.getAuthor());
                  return storytableRepository.save(story); })
              .orElseGet(() -> {
                  updateStory.setId(id);
                  return storytableRepository.save(updateStory);
                  });
    }


}







