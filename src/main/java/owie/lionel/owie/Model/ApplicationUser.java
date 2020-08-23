package owie.lionel.owie.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native"
    )
    private Long id;
    private String name;
    private String email;
    private Date dateofbirth;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "applicationUsers",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserLogin> Login;

    public Date getDataofbirth() { return dateofbirth; }

    public void setDataofbirth(Date dataofbirth) { this.dateofbirth = dataofbirth; }

    public Date getDateofbirth() { return dateofbirth; }

    public void setDateofbirth(Date dateofbirth) { this.dateofbirth = dateofbirth; }

    public List<UserLogin> getLogin() { return Login; }

    public void setLogin(List<UserLogin> login) { Login = login; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}