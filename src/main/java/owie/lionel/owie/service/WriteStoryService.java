package owie.lionel.owie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticatedPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import owie.lionel.owie.domain.User;
import owie.lionel.owie.domain.WriteStory;
import owie.lionel.owie.repository.UserRepository;
import owie.lionel.owie.repository.WriteStoryRepository;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class WriteStoryService {

    @Autowired
    private WriteStoryRepository writeStoryRepository;

    @Autowired
    private UserRepository userRepository;


    public List<WriteStory> getAllStories() {
        return writeStoryRepository.findAll();
    }


    public WriteStory findById(Long id) {
        Optional<WriteStory> writeStory = writeStoryRepository.findById(id);
        return writeStory.orElse(null);
    }

    public WriteStory createWriteStory(UserDetails userDetails, WriteStory newWriteStory) {
        Optional<User> user = userRepository.findByUsername(userDetails.getUsername());

        if(user.isPresent()) {
            newWriteStory.setUser(user.get());
            return writeStoryRepository.save(newWriteStory);
        }
        return null;
    }

}
