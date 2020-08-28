package owie.lionel.owie.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import owie.lionel.owie.Exception.UsersNotFoundException;
import owie.lionel.owie.Model.Stories;
import owie.lionel.owie.Model.Users;
import owie.lionel.owie.persistence.UsersRepository;

import java.util.Optional;

@Service
public class UsersService implements IUsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users getUserbyId(Long id) {
        Optional<Users> user = usersRepository.findById(id);
        return user.orElse(null);
    }
    @Override
    public Users addUser(Users newUser){
        String userName = newUser.getName();

        if(!userName.contains("fuck")) {
            return usersRepository.save(newUser);
        }
        throw new UsersNotFoundException(Long.valueOf(1));
    }

    @Override
    public Users updateUserById(Long id, Users updatedUser) {

        Optional<Users>userFromDb = usersRepository.findById(id);

                if(userFromDb.isPresent()) {
                    String name = updatedUser.getName();
                    if (checkIsValidName(name)) {
                        Users users = new Users();
                        users.setName(updatedUser.getName());
                        users.setEmail(updatedUser.getEmail());
                        return usersRepository.save(users);
                    }
                }
                    throw new UsersNotFoundException(id);
        }

    @Override
    public String deleteUser(Long id) {
        return null;
    }

    private boolean checkIsValidName (String name){
            if (name.contains("fuck") || name.equalsIgnoreCase("")) {
                return false;
            }
            return true;
        }
    }



