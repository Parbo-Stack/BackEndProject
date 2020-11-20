package owie.lionel.owie.service;

import owie.lionel.owie.domain.StoryPart;

public interface IStoryPartsService {

    StoryPart createStoryPart (long storyId, StoryPart newStoryPart);
    StoryPart saveStoryPart (StoryPart newStoryPart);
}
