package owie.lionel.owie.service;

import owie.lionel.owie.domain.StoryParts;

public interface IStoryPartsService {

    StoryParts addStoryPart(StoryParts newStory);
    StoryParts updateStoryPartById (long id, StoryParts updatedPart);
}
