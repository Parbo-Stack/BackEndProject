package owie.lionel.owie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import owie.lionel.owie.domain.Story;
import owie.lionel.owie.domain.User;
import owie.lionel.owie.service.UserService;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "api/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping(value = "/api/user")
    public User addUser(@RequestBody User newUser) {
        return userService.addUser(newUser);
    }

    @DeleteMapping(value = "api/user/{id}")
    public String deleteUserById(@PathVariable long id) {
        return userService.deleteUser(id);
    }

    @PutMapping(value = "/api/user/{id}")
    public User updateUserById(@PathVariable long id, @RequestBody User updatedUser) {
        return userService.updateUserById(id, updatedUser);
    }

    @PutMapping("api/user/{id}/story")
    public User addStoryToUser(@PathVariable long id, @RequestBody Story newStory) {
        return userService.addStoryToUser(id, newStory);
    }

    @PostMapping("/api/user/fill")
    public User addTestUsers() {
        return userService.addTestUserWithStories();
    }

}


