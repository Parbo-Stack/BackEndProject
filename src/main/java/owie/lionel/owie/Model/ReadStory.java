package owie.lionel.owie.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class ReadStory {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long readid;
    private int authorid;
    private String body;
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("Stories")
    private StoryTable Reader;

    public long getUserId() {
        return readid;
    }

    public void setUserId(long userId) {
        this.readid = userId;
    }

    public int getAuthor() {
        return authorid;
    }

    public void setAuthor(int author) {
        this.authorid = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public StoryTable getReader() {
        return Reader;
    }

    public void setReader(StoryTable reader) {
        Reader = reader;
    }
}
