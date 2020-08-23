package owie.lionel.owie.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class FinishStory {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long finishid;
    private String storyid;
    private String authorid;
    private String title;
    private String body;
    private Timestamp timestamp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("Stories")
    private StoryTable Finish;

    public long getFinishid() { return finishid;
    }

    public void setFinishid(long finishid) { this.finishid = finishid;
    }

    public StoryTable getFinish() { return Finish;
    }

    public void setFinish(StoryTable finish) { this.Finish = finish;
    }

    public long getId() {
        return finishid;
    }

    public void setId(long id) {
        this.finishid = id;
    }

    public String getStoryid() {
        return storyid;
    }

    public void setStoryid(String storyid) {
        this.storyid = storyid;
    }

    public String getAuthorid() {
        return authorid;
    }

    public void setAuthorid(String authorid) {
        this.authorid = authorid;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }


}
