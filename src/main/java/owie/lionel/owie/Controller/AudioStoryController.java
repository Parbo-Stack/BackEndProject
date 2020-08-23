package owie.lionel.owie.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import owie.lionel.owie.Model.AudioStory;
import owie.lionel.owie.Model.FinishStory;
import owie.lionel.owie.Model.StoryTable;
import owie.lionel.owie.Service.AudioStoryRepository;
import owie.lionel.owie.Service.StorytableRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class AudioStoryController {

    @Autowired
    private AudioStoryRepository audioStoryRepository;

    @Autowired
    private StorytableRepository storytableRepository;

    @GetMapping(value = "/api/audiostory")
    public List<AudioStory> getAllAudioStories() {
        return audioStoryRepository.findAll();

    }

    @GetMapping(value = "/api/audiostory/{id}")
    public AudioStory getAudiostory(@PathVariable Long id) {
        Optional<AudioStory> audioStory = audioStoryRepository.findById(id);
        if (audioStory.isPresent()) {
            return audioStory.get();
        }
        return null;
    }

    @PostMapping(value = "/api/audiostory")
    public AudioStory saveAudiostory(@RequestBody AudioStory newAudiostory) {
        return audioStoryRepository.save(newAudiostory);
    }

    @DeleteMapping(value = "/api/audiostory/{id}")
    public void deleteAudiostory(@PathVariable Long id) {
        audioStoryRepository.deleteById(id);
    }

    @PostMapping(value = "/api/audiostory/{id}")
    public AudioStory addAudiostorytostoryId(@PathVariable Long storyId, @RequestBody AudioStory audioStory) {
        Optional<StoryTable> story = storytableRepository.findById(storyId);

        if(story.isPresent()) {
            audioStory.setListener(story.get());
            return audioStoryRepository.save(audioStory);
        }

        return null;
    }

}


