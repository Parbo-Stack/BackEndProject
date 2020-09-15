package owie.lionel.owie.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "app_user")
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native", strategy = "native")

    @Column(columnDefinition = "serial")
    private long ApplicationUserid;
    private String username;
    private String email;
    private String password;
    private String isAdmin;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Stories> stories;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StoryParts> storyParts;

    @ManyToMany
    @JoinTable (name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public ApplicationUser (){

    }
    public ApplicationUser (String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public long getApplicationUserid() { return ApplicationUserid; }

    public void setApplicationUserid(long applicationUserid) { ApplicationUserid = applicationUserid; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getIsAdmin() { return isAdmin; }

    public void setIsAdmin(String isAdmin) { this.isAdmin = isAdmin; }

    public List<Stories> getStories() { return stories; }

    public void setStories(List<Stories> stories) { this.stories = stories; }

    public List<StoryParts> getStoryParts() { return storyParts; }

    public void setStoryParts(List<StoryParts> storyParts) { this.storyParts = storyParts; }

    public Set<Role> getRoles() { return roles; }

    public void setRoles(Set<Role> roles) { this.roles = roles; }

}


