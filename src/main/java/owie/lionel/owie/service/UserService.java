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
    public String deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            userRepository.deleteById(id);
            return "User with id"  + user.get().getUserId() +  "is verwijderd";
        }
          throw new UserNotFoundException("Sorry, i don't exist");
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}