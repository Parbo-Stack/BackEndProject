package owie.lionel.owie.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class UserLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(
            name ="native",
            strategy = "native"
    )
    private long userid;
    private String username;
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("login")
    private ApplicationUser applicationUsers;

    public ApplicationUser getLogin() {
        return applicationUsers;
    }

    public void setLogin(ApplicationUser login) {
        applicationUsers = applicationUsers;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
