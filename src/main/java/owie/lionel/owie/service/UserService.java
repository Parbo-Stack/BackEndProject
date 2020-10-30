package owie.lionel.owie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import owie.lionel.owie.domain.Story;
import owie.lionel.owie.domain.User;
import owie.lionel.owie.exception.UserNotFoundException;
import owie.lionel.owie.repository.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {


    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public User addUser(User newUser) {
        String userName = newUser.getUsername();

        if (!userName.contains("fuck")) {
            return userRepository.save(newUser);
        }
        throw new UserNotFoundException(Long.valueOf(1));
    }

    @Override
    public User updateUserById(Long id, User updatedUser) {
        Optional<User> userFromDb = userRepository.findById(id);

        if (userFromDb.isPresent()) {
            if (checkIsValidName(updatedUser.getUsername())) {
                User applicationUser = new User();
                applicationUser.setUsername(updatedUser.getUsername());
                applicationUser.setEmail(updatedUser.getEmail());
                return userRepository.save(updatedUser);
            }
        }
        throw new UserNotFoundException(id);
    }

    @Override
    public String deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            userRepository.deleteById(id);
            return "User with id" + user.get().getUserId() + "is verwijderd";
        }
          throw new UserNotFoundException("Sorry, i don't exist");
    }

    @Override
    public User addStoryToUser(Long id, Story newStory) {
        Optional<User> user =
                userRepository.findById(id);

        if (user.isPresent()) {
            User userFromDb = user.get();
            List<Story> currentStories = userFromDb.getStories();

            if (newStory.getAuthor() == null || newStory.getAuthor().getUserId() != id) {
                newStory.setAuthor(userFromDb);
            }
            currentStories.add(newStory);
            userFromDb.setStories(currentStories);

            return userRepository.save(userFromDb);
        }
        throw new UserNotFoundException(id);
    }

    @Override
    public User addTestUserWithStories() {
        User user = new User();
        user.setUsername("Lionel Emanuelson");
        user.setEmail("emanuelsonlionel@hotmail.com");

        Story lezen = new Story();
        lezen.setTitle("puzzelstuk");

        Story read = new Story();
        read.setTitle("boek");

        return userRepository.save(user);
    }

    private boolean checkIsValidName(String name) {
        if (name.contains("fuck") || name.equalsIgnoreCase("")) {
            return false;
        }
        return true;
    }
}