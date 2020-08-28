package owie.lionel.owie.Model;


import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.List;

@Entity
public class StoryParts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")

    private long storypartsid;
    private int storyId;
    private String body;
    private int authorId;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Stories> storiesList;

    public List<Stories> getStoriesList() { return storiesList; }

    public void setStoriesList(List<Stories> storiesList) { this.storiesList = storiesList; }

    public long getStorypartsid() { return storypartsid; }

    public void setStorypartsid(long storypartsid) { this.storypartsid = storypartsid; }

    public int getStoryId() {
        return storyId;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
