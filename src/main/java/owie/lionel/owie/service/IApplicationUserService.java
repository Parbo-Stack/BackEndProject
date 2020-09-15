package owie.lionel.owie.service;


import owie.lionel.owie.domain.ApplicationUser;
import owie.lionel.owie.domain.Stories;

public interface IApplicationUserService {

    ApplicationUser getUserbyId(Long id);
    ApplicationUser addUser(ApplicationUser newUser);
    ApplicationUser updateUserById(Long id, ApplicationUser updatedApplicationUser);
    String deleteUser(Long id);
    ApplicationUser addStoryToUser(Long id, Stories newStory);
    ApplicationUser addTestUserWithStories();
}
