package owie.lionel.owie.service;

import owie.lionel.owie.domain.StoryParts;

public interface IStoryPartsService {

    StoryParts addStoryParts(StoryParts newStory);

    //nog niet zeker als er updates komen
    //StoryParts updateStoryPartById (long id, StoryParts updatedStory);
}
