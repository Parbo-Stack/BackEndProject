package owie.lionel.owie.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;

public class StoryTest {

    @Test
    void newStoryPartShouldNotInitializeStoryPartlist() {
        //ARRANGE
        Story story = new Story();


        //ACT
List<StoryPart> storyParts = story.getStoryParts();

        //ASSERT
      assertNull(storyParts);
    }
}
