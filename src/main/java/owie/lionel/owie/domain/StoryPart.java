package owie.lionel.owie.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@Entity
public class StoryPart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long storypartId;
    private String storyId;
    private String body;
    LocalTime localTime = LocalTime.now();


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("users")
    private User appUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("stories")
    private Story story;

    public StoryPart() {

    }

    public long getStorypartId() {
        return storypartId;
    }

    public void setStorypartId(long storypartId) { this.storypartId = storypartId; }

    public String getStoryId() { return storyId; }

    public void setStoryId(String storyId) { this.storyId = storyId; }

    public String getBody() { return body; }

    public void setBody(String body) { this.body = body; }

    public LocalTime getLocalTime() { return localTime; }

    public void setLocalTime(LocalTime localTime) { this.localTime = localTime; }

    public User getAppUser() {
        return appUser;
    }

    public void setAppUser(User appUser) {
        this.appUser = appUser;
    }

    public Story getStory() {
        return story;
    }

    public void setStory(Story story) {
        this.story = story;

    }
}
