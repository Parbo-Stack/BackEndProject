package owie.lionel.owie.service;

import owie.lionel.owie.domain.Stories;

import java.util.List;

public interface IStoriesService {

    List<Stories> findAllStories();
    Stories getStoryById(Long id);
    Stories addStory(Stories newStory);
    void deleteStoryById (Long id);
}
