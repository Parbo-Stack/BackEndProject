package owie.lionel.owie.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class WriteStory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )

    private Long writeStoryId;
    private String title;
    @Column(name = "body", columnDefinition = "TEXT")
    private String body;
    LocalDate localDate = LocalDate.now();

    public WriteStory() {
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "writeStory",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StoryPart> storyParts;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("writeStories")
    private User user;

    public Long getWriteStoryId() {
        return writeStoryId;
    }

    public void setWriteStoryId(Long writeStoryId) {
        this.writeStoryId = writeStoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public List<StoryPart> getStoryParts() {
        return storyParts;
    }

    public void setStoryParts(List<StoryPart> storyParts) {
        this.storyParts = storyParts;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
