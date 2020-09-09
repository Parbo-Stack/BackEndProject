package owie.lionel.owie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import owie.lionel.owie.exception.ApplicationUserNotFoundException;
import owie.lionel.owie.domain.ApplicationUser;
import owie.lionel.owie.repository.ApplicationUserRepository;

import java.util.Optional;

@Service
public class ApplicationUserService implements IApplicationUserService {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @Override
    public ApplicationUser getUserbyId(Long id) {
        Optional<ApplicationUser> user = applicationUserRepository.findById(id);
        return user.orElse(null);
    }
    @Override
    public ApplicationUser addUser(ApplicationUser newUser){
        String userName = newUser.getUsername();

        if(!userName.contains("fuck")) {
            return applicationUserRepository.save(newUser);
        }
        throw new ApplicationUserNotFoundException(Long.valueOf(1));
    }

    @Override
    public ApplicationUser updateUserById(long id, ApplicationUser updatedUser) {
        return applicationUserRepository.findById(id).map(
                user -> {
                    user.setUsername(updatedUser.getUsername());
                    user.setEmail(updatedUser.getEmail());
                    return applicationUserRepository.save(user);
                })
                .orElseGet(() -> {
                    updatedUser.setId(id);
                    return applicationUserRepository.save(updatedUser);
                });
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



