package owie.lionel.owie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import owie.lionel.owie.domain.Story;
import owie.lionel.owie.domain.User;
import owie.lionel.owie.service.UserService;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "api/user/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);}

    @GetMapping(value = "api/users")
    public List<User> getAllUsers() { return userService.getAllUsers(); }

    @DeleteMapping(value = "api/user/{id}")
    public String deleteById( @PathVariable Long id) {
        return userService.deleteById(id); }
}


