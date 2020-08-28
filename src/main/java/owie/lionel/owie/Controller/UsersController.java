package owie.lionel.owie.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import owie.lionel.owie.Model.Users;
import owie.lionel.owie.Service.UsersService;
import owie.lionel.owie.persistence.UsersRepository;
import java.util.Optional;

@RestController
public class UsersController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private UsersService usersService;

    @GetMapping(value = "api/user/{id}")
    public Users getUserById(@PathVariable Long id){
        return usersService.getUserbyId(id);
    }

    @PostMapping (value = "/api/user")
    public Users addUser(@RequestBody Users newUser) {
        return usersService.addUser(newUser);
    }

    @DeleteMapping(value = "api/user/{id}")
    public String deleteUser(@PathVariable long id) {

        return usersService.deleteUser(id);

    }

    @PutMapping(value = "/api/user/{id} ")
    public Users updateUserById(@PathVariable long id, @RequestBody Users updatedUsers) {
        return usersService.updateUserById(id, updatedUsers);
    }

        @PostMapping("/api/user/fill")
        public Users addTestUsers() {
            Users user = new Users();
            user.setName("Lionel Emanuelson");
            user.setEmail("emanuelsonlionel@hotmail.com");

            usersRepository.save(user);
            return user;
        }

}
