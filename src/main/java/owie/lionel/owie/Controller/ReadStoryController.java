package owie.lionel.owie.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import owie.lionel.owie.Model.ReadStory;
import owie.lionel.owie.Service.ReadStoryRepository;
import owie.lionel.owie.Service.StorytableRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class ReadStoryController {

    @Autowired
    private ReadStoryRepository readStoryRepository;

    @Autowired
    private StorytableRepository storytableRepository;

    @PostMapping(value = "api/readstory")
    public ReadStory saveReadStory (@RequestBody ReadStory newReadStory){
        return readStoryRepository.save(newReadStory);
    }

    @DeleteMapping(value = "/api/readstory/{id}")
    public void deleteReadStory(@PathVariable Long id) {readStoryRepository.deleteById(id);}

    @GetMapping (value = "api/readstory")
    public List<ReadStory> getAllReadStories() {
        return readStoryRepository.findAll();
    }

    @GetMapping(value= "api/readstory/{id}")
    public ReadStory getReadStory (@PathVariable long id) {
        Optional<ReadStory> readStory = readStoryRepository.findById(id);
        if (readStory.isPresent()){
            return readStory.get();
        }
        return null;
    }
}
