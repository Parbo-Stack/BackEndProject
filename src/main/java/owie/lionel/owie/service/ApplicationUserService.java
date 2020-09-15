package owie.lionel.owie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import owie.lionel.owie.domain.ApplicationUser;
import owie.lionel.owie.domain.Stories;
import owie.lionel.owie.exception.ApplicationUserNotFoundException;
import owie.lionel.owie.repository.ApplicationUserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationUserService implements IApplicationUserService {

    @Autowired
    private final ApplicationUserRepository applicationUserRepository;

    @Autowired
    public ApplicationUserService(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public ApplicationUser getUserbyId(Long id) {
        return applicationUserRepository.findById(id)
                .orElseThrow(() -> new ApplicationUserNotFoundException(id));
    }

    @Override
    public ApplicationUser addUser(ApplicationUser newUser) {
        String userName = newUser.getUsername();

        if (!userName.contains("fuck")) {
            return applicationUserRepository.save(newUser);
        }
        throw new ApplicationUserNotFoundException(Long.valueOf(1));
    }

    @Override
    public ApplicationUser updateUserById(Long id, ApplicationUser updatedUser) {
        Optional<ApplicationUser> userFromDb = applicationUserRepository.findById(id);

        if (userFromDb.isPresent()) {
            if (checkIsValidName(updatedUser.getUsername())) {
                ApplicationUser applicationUser = new ApplicationUser();
                applicationUser.setUsername(updatedUser.getUsername());
                applicationUser.setEmail(updatedUser.getEmail());
                return applicationUserRepository.save(applicationUser);
            }
        }
        throw new ApplicationUserNotFoundException(id);
    }

    @Override
    public String deleteUser(Long id) {
        return null;
    }

    private boolean checkIsValidName(String name) {
        if (name.contains("fuck") || name.equalsIgnoreCase("")) {
            return false;
        }
        return true;
    }


    @Override
    public ApplicationUser addStoryToUser(Long id, Stories newStory) {
        Optional<ApplicationUser> user =
                applicationUserRepository.findById(id);

        if (user.isPresent()) {
            ApplicationUser userFromDb = user.get();
            List<Stories> currentStories = userFromDb.getStories();

            if (newStory.getUser() == null || newStory.getUser().getApplicationUserid() != id) {
                newStory.setUser(userFromDb);
            }
            currentStories.add(newStory);
            userFromDb.setStories(currentStories);

            return applicationUserRepository.save(userFromDb);
        }
        throw new ApplicationUserNotFoundException(id);
    }

    @Override
    public ApplicationUser addTestUserWithStories() {
        ApplicationUser user = new ApplicationUser();
        user.setUsername("Lionel Emanuelson");
        user.setEmail("emanuelsonlionel@hotmail.com");

        Stories lezen = new Stories();
        lezen.setTitle("puzzelstuk");
        lezen.setBody("storytime");

        Stories read = new Stories();
        read.setTitle("boek");
        read.setBody("");

        return applicationUserRepository.save(user);
    }

}