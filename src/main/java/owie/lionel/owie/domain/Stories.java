package owie.lionel.owie.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Stories {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    private long StoriesId;
    private String title;
    private String body;
    private int authorId;
    private Date DatePublished;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "story",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StoryParts> storyPartsList;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("users")
    private ApplicationUser user;

    public Stories() {

    }

    public long getStoriesId() { return StoriesId; }

    public void setStoriesId(long storiesId) { StoriesId = storiesId; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getBody() { return body; }

    public void setBody(String body) { this.body = body; }

    public int getAuthorId() { return authorId; }

    public void setAuthorId(int authorId) { this.authorId = authorId; }

    public Date getDatePublished() { return DatePublished; }

    public void setDatePublished(Date datePublished) { DatePublished = datePublished; }

    public List<StoryParts> getStoryPartsList() { return storyPartsList; }

    public void setStoryPartsList(List<StoryParts> storyPartsList) { this.storyPartsList = storyPartsList; }

    public ApplicationUser getUser() { return user; }

    public void setUser(ApplicationUser user) { this.user = user; }
}