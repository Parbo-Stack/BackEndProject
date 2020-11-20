package owie.lionel.owie.service.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import owie.lionel.owie.payload.request.SignupRequest;
import owie.lionel.owie.service.security.AuthorizationService;

import java.util.HashSet;
import java.util.Set;

@Component
class DBFiller implements CommandLineRunner {
    private final AuthorizationService authorizationService;

    @Autowired
    public DBFiller(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @Override
    public void run(String... args) {

        Set<String> roles = new HashSet<>();
        roles.add("admin");

        SignupRequest admin = new SignupRequest();
        admin.setUsername("admin");
        admin.setEmail("admin@admin.com");
        admin.setPassword("BlauweBeker$12");
        admin.setRole(roles);
        authorizationService.registerUser(admin);
        
    }
}

