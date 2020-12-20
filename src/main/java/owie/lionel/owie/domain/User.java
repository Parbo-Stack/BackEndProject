package owie.lionel.owie.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "app_user")
public class  User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(columnDefinition = "serial")

    private Long userId;
    private String username;
    private String email;
    @JsonIgnore
    private String password;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<FinishStory> finishedStories;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<WriteStory> writeStories;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
    private List<Story> stories;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "appUser")
    private List<StoryPart> storyParts;


    public User() {}

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<FinishStory> getFinishedStories() {
        return finishedStories;
    }

    public void setFinishedStories(List<FinishStory> finishedStories) {
        this.finishedStories = finishedStories;
    }

    public List<WriteStory> getWriteStories() {
        return writeStories;
    }

    public void setWriteStories(List<WriteStory> writeStories) {
        this.writeStories = writeStories;
    }

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public List<StoryPart> getStoryParts() {
        return storyParts;
    }

    public void setStoryParts(List<StoryPart> storyParts) {
        this.storyParts = storyParts;
    }

}