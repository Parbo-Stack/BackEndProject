package owie.lionel.owie.service;

import owie.lionel.owie.domain.Story;

import java.util.List;


public interface IStoryService {

    List <Story> getAllStories();
    Story findById(Long id);
    Story createStory(String username, Story newStory);
    Story findById(Long id, Story updatedStory);
    void deleteById (Long id);
    List <Story> deleteAll ();
    List<Story> findByTitle(String title);
}
