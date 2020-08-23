package owie.lionel.owie.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import owie.lionel.owie.Exception.WriteStoryNotFoundException;
import owie.lionel.owie.Model.ApplicationUser;
import owie.lionel.owie.Model.StoryTable;
import owie.lionel.owie.Model.WriteStory;
import owie.lionel.owie.Service.StorytableRepository;
import owie.lionel.owie.Service.WriteStoryRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class WriteStoryController {

    @Autowired
    private WriteStoryRepository writeStoryRepository;

    @Autowired
    private StorytableRepository storytableRepository;

    /**
     * {
     *     "Authorid":"Carla"
     *     "Storyid":"2"
     *     "body":"..."
     *
     * }
     * @return
     */

    @GetMapping (value = "/api/writestory")
    public List<WriteStory> getAllWritenStories() {
        List<WriteStory> writeStoryList = writeStoryRepository.findAll();
        return writeStoryRepository.findAll();
    }

    @GetMapping (value = "api/writestory/{id}")
    public WriteStory getWriteStory (@PathVariable Long id) {
        /*Optional<WriteStory> writeStory = writeStoryRepository.findById(id);*/
        return writeStoryRepository.findById(id).orElseThrow(
                () -> new WriteStoryNotFoundException(id));
    }

    @PostMapping(value = "api/writestory")
    public WriteStory saveWritestory(@RequestBody WriteStory newWriteStory) {
        return writeStoryRepository.save(newWriteStory);
    }

    @DeleteMapping(value = "api/story/{id")
    public void deleteWriteStory(@PathVariable Long id) {
        writeStoryRepository.deleteById(id);
    }

}
