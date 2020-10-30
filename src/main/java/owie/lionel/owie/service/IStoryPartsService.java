package owie.lionel.owie.service;


import owie.lionel.owie.domain.StoryPart;

public interface IStoryPartsService {

    StoryPart createStoryPart(long authorId, long storyId, StoryPart newStory);

}
