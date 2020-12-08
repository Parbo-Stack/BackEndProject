package owie.lionel.owie.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )

    private Long storyId;
    private String title;
    @Column(name = "body", columnDefinition = "TEXT")
    private String body;
    LocalDate localDate = LocalDate.now();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "story",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StoryPart> storyParts;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("stories")
    private User author;

    public Story (){
    }

    public Long getStoryId() {
        return storyId;
    }

    public void setStoryId(Long storyId) {
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

    public LocalDate getLocalDate() { return localDate; }

    public void setLocalDateTime(LocalDate localDate) { this.localDate = localDate; }

    public List<StoryPart> getStoryParts() {
        return storyParts;
    }

    public void setStoryParts(List<StoryPart> storyParts) {
        this.storyParts = storyParts;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) { this.author = author; }

}