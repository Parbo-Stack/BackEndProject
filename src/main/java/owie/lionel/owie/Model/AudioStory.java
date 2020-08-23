package owie.lionel.owie.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;

@Entity
public class AudioStory {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long audioid;
    private int authorid;
    private int storyid;
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("Stories")
    private StoryTable Listener;

    public long getId() {
        return audioid;
    }

    public void setId(long id) {
        this.audioid = id;
    }

    public int getAuthor() { return authorid; }

    public void setAuthor(int author) {
        this.authorid = author;
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

    public StoryTable getListener() {
        return Listener;
    }

    public void setListener(StoryTable listener) {
        this.Listener = listener;
    }
}
