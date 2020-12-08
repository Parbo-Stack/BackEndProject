package owie.lionel.owie.service;

import org.springframework.security.core.Authentication;
import owie.lionel.owie.domain.StoryPart;
import owie.lionel.owie.domain.User;

import java.security.Principal;

public interface IStoryPartsService {
        StoryPart createStoryPart(User user, Long storyId, StoryPart newStoryPart);
}
