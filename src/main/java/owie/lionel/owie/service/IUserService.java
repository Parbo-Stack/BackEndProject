package owie.lionel.owie.service;


import owie.lionel.owie.domain.User;

import java.util.List;

public interface IUserService {
    User getUserById(Long id);
    List<User> getAllUsers();
    User addUser(User newUser);
    String deleteUser(Long id);
}
