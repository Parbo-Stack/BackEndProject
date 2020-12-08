package owie.lionel.owie.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
public class StoryPart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long storyPartId;
    @Column(name = "body", columnDefinition = "TEXT")
    private String body;
    LocalDate localDate = LocalDate.now();

    @JsonIgnore //toegevoegd zodat ik java.lang.IllegalStateException: Cannot call sendError() after the response has been committed voorkom
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("users")
    private User appUser;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("stories")
    private Story story;

    public StoryPart() {

    }

    public long getStoryPartId() {
        return storyPartId;
    }

    public void setStoryPartId(long storyPartId) {
        this.storyPartId = storyPartId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getAppUser() {
        return appUser;
    }

    public void setAppUser(User appUser) {
        this.appUser = appUser;
    }

    public Story getStory() {
        return story;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public void setStory(Story story) {
        this.story = story;
    }


}
