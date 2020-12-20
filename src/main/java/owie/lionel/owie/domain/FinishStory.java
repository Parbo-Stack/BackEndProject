package owie.lionel.owie.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class FinishStory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )

    private Long FinishStoryId;
    private String body;
    LocalDate localDate = LocalDate.now();

    public FinishStory() {
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "finishStory",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StoryPart> storyParts;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnoreProperties("finishedStories")
    private User user;

    public Long getFinishStoryId() {
        return FinishStoryId;
    }

    public void setFinishStoryId(Long finishStoryId) {
        FinishStoryId = finishStoryId;
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
