package owie.lionel.owie.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
public class StoryPart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )

    private long StoryPartId;
    @Column(name = "body", columnDefinition = "TEXT")
    private String body;
    LocalDate localDate = LocalDate.now();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("stories")
    private Story story;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("finishStory")
    private FinishStory finishStory;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("writeStory")
    private WriteStory writeStory;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("users")
    private User appUser; //deze appUser wordt gegeven/gevraagd in de StorypartService klasse

   public StoryPart () {}

    public WriteStory getWriteStory() { return writeStory; }

    public void setWriteStory(WriteStory writeStory) { this.writeStory = writeStory; }

    public FinishStory getFinishStory() {return finishStory; }

    public void setFinishStory(FinishStory finishStory) { this.finishStory = finishStory; }

    public long getStoryPartId() {
        return StoryPartId;
    }

    public void setStoryPartId(long storyPartId) {
        StoryPartId = storyPartId;
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

    public Story getStory() { return story; }

    public void setStory(Story story) { this.story = story; }

    public User getAppUser() { return appUser; }

    public void setAppUser(User appUser) { this.appUser = appUser; }
}