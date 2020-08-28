package owie.lionel.owie.Service;

import owie.lionel.owie.Model.Stories;

import java.util.List;

public interface IStoriesService {

    List<Stories> findAllStories();
    Stories getStoryById(Long id);
    Stories addStory(Stories newStory);
    void deleteStoryById (Long id);
}
