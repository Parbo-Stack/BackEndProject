package owie.lionel.owie.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import owie.lionel.owie.domain.Story;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest
class StoryServiceTest {

    @Test
    void AllStoriesByAuthorShouldBeNull() {
        //ARRAGE
        StoryService storyService = new StoryService();

        //ACT
        List<Story> list = storyService.findAllStoryByAuthorIsNull();

        //ASSERT
       assertNull(list);
    }

}