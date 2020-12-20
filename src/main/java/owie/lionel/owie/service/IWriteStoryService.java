package owie.lionel.owie.service;

import org.springframework.security.core.userdetails.UserDetails;
import owie.lionel.owie.domain.Story;
import owie.lionel.owie.domain.User;
import owie.lionel.owie.domain.WriteStory;

import java.util.List;

public interface IWriteStoryService {

    List<WriteStory> getAllStories();
    WriteStory findById(Long id);
    WriteStory createWriteStory(UserDetails userDetails, WriteStory newWriteStory);
}
