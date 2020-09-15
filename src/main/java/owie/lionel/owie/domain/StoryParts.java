package owie.lionel.owie.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
public class StoryParts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")

    private long StoryPartsId;
    private int storyId;
    private String body;
    private String author;


    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("storyparts")
    private ApplicationUser user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("stories")
    private Stories story;

    public StoryParts () {
    }

    public long getStoryPartsId() { return StoryPartsId; }

    public void setStoryPartsId(long storyPartsId) { StoryPartsId = storyPartsId; }

    public int getStoryId() { return storyId; }

    public void setStoryId(int storyId) { this.storyId = storyId; }

    public String getBody() { return body; }

    public void setBody(String body) { this.body = body; }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public ApplicationUser getUser() { return user; }

    public void setUser(ApplicationUser user) { this.user = user; }

    public Stories getStory() { return story; }

    public void setStory(Stories story) { this.story = story; }
}
