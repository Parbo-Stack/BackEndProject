package owie.lionel.owie.service;


import org.springframework.security.core.userdetails.UserDetails;
import owie.lionel.owie.domain.User;

import java.util.List;

public interface IUserService {
    User getUserById(Long id);
    List<User> getAllUsers();
    String deleteById(Long id);
}
