package owie.lionel.owie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import owie.lionel.owie.domain.ApplicationUser;
import owie.lionel.owie.domain.Stories;
import owie.lionel.owie.service.ApplicationUserService;
import owie.lionel.owie.repository.ApplicationUserRepository;

@RestController
public class ApplicationUserController {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Autowired
    private ApplicationUserService applicationUserService;

    @GetMapping(value = "api/user/{id}")
    public ApplicationUser getUserById(@PathVariable Long id){ return applicationUserService.getUserbyId(id); }

    @PostMapping (value = "/api/user")
    public ApplicationUser addUser(@RequestBody ApplicationUser newUser) {
        return applicationUserService.addUser(newUser);
    }

    @DeleteMapping(value = "api/user/{id}")
    public String deleteUserById(@PathVariable long id) { return applicationUserService.deleteUser(id); }

    @PutMapping(value = "/api/user/{id}")
    public ApplicationUser updateUserById(@PathVariable long id, @RequestBody ApplicationUser updatedUser) {
        return applicationUserService.updateUserById(id, updatedUser); }

    @PutMapping("api/user/{id}/story")
    public ApplicationUser addStoryToUser(@PathVariable long id, @RequestBody Stories newStory) {
        return applicationUserService.addStoryToUser(id, newStory);
    }




        @PostMapping("/api/user/fill")
        public ApplicationUser addTestUsers() {return applicationUserService.addTestUserWithStories();}

        }


