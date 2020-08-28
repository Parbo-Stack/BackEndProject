package owie.lionel.owie.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(
            name="native",
            strategy ="native"
    )
    private long usersid;
    private String name;
    private String email;
    private String password;
    private String username;
    private String isAdmin;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user",
    cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Stories> storiesList;

    public List<Stories> getStoriesList() { return storiesList; }

    public void setStoriesList(List<Stories> storiesList) { this.storiesList = storiesList; }

    public long getUsersid() { return usersid; }

    public void setUsersid(int usersid) { this.usersid = usersid; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setUsersid(long usersid) { this.usersid = usersid; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }
}
