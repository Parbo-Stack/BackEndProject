package owie.lionel.owie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import owie.lionel.owie.exception.StoryNotFoundException;
import owie.lionel.owie.domain.Stories;
import owie.lionel.owie.repository.StoriesRepository;

import java.util.List;

@Service
public class StoriesService implements IStoriesService {

    @Autowired
    private StoriesRepository storiesRepository;

    @Override
    public List<Stories> findAllStories() {
        return storiesRepository.findAll();
    }

    @Override
    public void deleteStoryById(Long id) {
    storiesRepository.deleteById(id);
    }

    @Override
    public Stories getStoryById(Long id) {
        return storiesRepository.findById(id).orElseThrow(
                () -> new StoryNotFoundException(id));
    }

    @Override
    public Stories addStory(Stories newStory) {
        return storiesRepository.save(newStory);
    }

}
