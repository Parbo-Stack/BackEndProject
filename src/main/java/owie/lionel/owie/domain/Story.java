package owie.lionel.owie.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private long storyId;
    private String title;
    @Column(name = "body", columnDefinition = "TEXT")
    private String body;
    private String authorId;

    LocalTime localTime = LocalTime.now();


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "story",
            cascade = CascadeType.ALL, orphanRemoval = true)
            private List<StoryPart> storyParts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("stories")
    private User author;

    public long getStoryId() {
        return storyId;
    }

    public void setStoryId(long storyId) {
        this.storyId = storyId;
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

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }



    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    public List<StoryPart> getStoryParts() {
        return storyParts;
    }

    public void setStoryParts(List<StoryPart> storyParts) {
        this.storyParts = storyParts;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}