package owie.lionel.owie.service.security;

import org.springframework.stereotype.Service;
import org.springframework.security.access.prepost.PreAuthorize;

@Service
public class TestService {

    public String generatePublicContent() {
        return "Public Content.";
    }

    @PreAuthorize("hasRole('USER')")
    public String generateUserContent() {
        return "User Content.";
    }

    @PreAuthorize("hasRole('ADMIN')")
    public String generateAdminContent() {
        return "Admin Board.";
    }

}
