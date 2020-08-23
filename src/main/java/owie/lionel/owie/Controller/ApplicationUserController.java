package owie.lionel.owie.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import owie.lionel.owie.Model.ApplicationUser;
import owie.lionel.owie.Model.StoryTable;
import owie.lionel.owie.Model.WriteStory;
import org.springframework.web.bind.annotation.*;
import owie.lionel.owie.Service.ApplicationUserRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class ApplicationUserController {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @GetMapping(value = "/api/user/{id}")
    public ApplicationUser getUserById(@PathVariable Long id) {
        Optional<ApplicationUser> user = applicationUserRepository.findById(id);
        return user.orElse(null);
    }

    @PostMapping(value = "/api/user/")
    public ApplicationUser addUser(@RequestBody ApplicationUser newUser) {
    return applicationUserRepository.save(newUser);
    }

    @DeleteMapping(value = "/api/user/{id}")
    public String deleteUser(@PathVariable long id) {
        Optional<ApplicationUser> user = applicationUserRepository.findById(id);

        if(user.isPresent()) {
            applicationUserRepository.deleteById(id);
            return "User met id" + user.get().getId() + "Is verwijderd";
        }
        return "User niet gevonden";
    }
    @PutMapping(value = "/api/user/{id}")
    public ApplicationUser updateUserById(@PathVariable long id, @RequestBody ApplicationUser updateUser) {
        return applicationUserRepository.findById(id).map(
                user-> {
                    user.setName(updateUser.getName());
                    user.setEmail(updateUser.getEmail());
                    return applicationUserRepository.save(updateUser);
                })
                //kan de user niet vinden in database
                .orElseGet(() -> {
                    updateUser.setId(id);
                    return applicationUserRepository.save(updateUser);
                });
    }
        @PostMapping("/api/user/fill")
        public ApplicationUser addTestUsers() {
            ApplicationUser user = new ApplicationUser();
            user.setName("Lionel Emanuelson");
            user.setEmail("emanuelsonlionel@hotmail.com");

            applicationUserRepository.save(user);
            return user;

        }
    }
