package owie.lionel.owie.Service;


import owie.lionel.owie.Model.Users;

public interface IUsersService {

    Users getUserbyId(Long id);
    Users addUser(Users newUser);
    Users updateUserById(Long id, Users updatedUsers);
    String deleteUser(Long id);


}
