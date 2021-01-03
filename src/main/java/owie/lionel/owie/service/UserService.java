package owie.lionel.owie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import owie.lionel.owie.domain.Story;
import owie.lionel.owie.domain.User;
import owie.lionel.owie.exception.UserNotFoundException;
import owie.lionel.owie.repository.StoryRepository;
import owie.lionel.owie.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository, StoryRepository storyRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public String deleteById(Long id) {
        Optional<User> userFromDb = userRepository.findById(id);

        if(userFromDb.isPresent()) {
            userRepository.deleteById(id);
            return "user met id " + userFromDb.get().getUserId() + "is verwijderd";
        }
        return "User niet gevonden";
    }

}