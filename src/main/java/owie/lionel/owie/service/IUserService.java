package owie.lionel.owie.service;

import owie.lionel.owie.domain.Story;
import owie.lionel.owie.domain.User;

public interface IUserService {
    User getUserById(Long id);
    User addUser(User newUser);
    User updateUserById(Long id, User updatedApplicationUser);
    String deleteUser(Long id);
    User addStoryToUser(Long id, Story newStory);
    User addTestUserWithStories();
}
