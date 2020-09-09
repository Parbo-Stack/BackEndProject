package owie.lionel.owie.service;


import owie.lionel.owie.domain.ApplicationUser;

public interface IApplicationUserService {

    ApplicationUser getUserbyId(Long id);
    ApplicationUser addUser(ApplicationUser newUser);
    ApplicationUser updateUserById(long id, ApplicationUser updatedApplicationUser);
    String deleteUser(Long id);


}
