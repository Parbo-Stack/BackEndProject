package owie.lionel.owie.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import owie.lionel.owie.Exception.FinishStoryNotFoundException;
import owie.lionel.owie.Model.FinishStory;
import owie.lionel.owie.Model.StoryTable;
import owie.lionel.owie.Model.WriteStory;
import owie.lionel.owie.Service.FinishStoryRepository;
import owie.lionel.owie.Service.StorytableRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class FinishStoryController {

    @Autowired
    private FinishStoryRepository finishStoryRepository;

    @Autowired
    private StorytableRepository storytableRepository;

    @GetMapping(value = "/api/finishstory")
    public List<FinishStory> getAllFinishStories() {
        List<FinishStory> finishStoryList = finishStoryRepository.findAll();
        return finishStoryRepository.findAll();

    }

    @GetMapping(value = "/api/finishstory/{id}")
    public FinishStory getFinishStory(@PathVariable Long id) {
        return finishStoryRepository.findById(id).orElseThrow(
                () -> new FinishStoryNotFoundException(id));

    }

    @PostMapping(value = "/api/finishstory")
    public FinishStory saveFinishStory(@RequestBody FinishStory newFinishStory) {
        return finishStoryRepository.save(newFinishStory);
    }

    @DeleteMapping(value = "/api/finishstory/{id}")
    public void deleteFinishstory(@PathVariable Long id) {
        finishStoryRepository.deleteById(id);
    }

}