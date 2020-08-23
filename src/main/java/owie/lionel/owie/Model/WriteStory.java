package owie.lionel.owie.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class WriteStory{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(
            name="native",
            strategy = "native"
    )
    private long writeid;
    private int authorid;
    private int storyid;
    private String title;
    private String body;
    private String submit;
    private Timestamp timestamp;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("stories")
    private StoryTable Writer;

    public long getWriteid() {
        return writeid;
    }

    public void setWriteid(long writeid) {
        this.writeid = writeid;
    }

    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int authorid) {
        this.authorid = authorid;
    }

    public int getStoryid() {
        return storyid;
    }

    public void setStoryid(int storyid) {
        this.storyid = storyid;
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

    public String getSubmit() {
        return submit;
    }

    public void setSubmit(String submit) {
        this.submit = submit;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public StoryTable getWriter() {
        return Writer;
    }

    public void setWriter(StoryTable writer) {
        Writer = writer;
    }
}