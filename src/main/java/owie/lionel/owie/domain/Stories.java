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
    private long storyid;
    private String title;
    private String body;
    private String author;
    private Date DatePublished;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "story",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StoryParts> storyPartsList;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("users")
    private ApplicationUser user;

    public Stories() {

    }

    public long getStoryid() { return storyid; }

    public void setStoryid(long storyid) { this.storyid = storyid; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getBody() { return body; }

    public void setBody(String body) { this.body = body;}

    public String getAuthor() { return author; }

    public void setAuthor(int authorId) { this.author = author; }

    public Date getDatePublished() { return DatePublished; }

    public void setDatePublished(Date datePublished) {DatePublished = datePublished; }

    public List<StoryParts> getStoryPartsList() { return storyPartsList; }

    public void setStoryPartsList(List<StoryParts> storyPartsList) { this.storyPartsList = storyPartsList; }

    public ApplicationUser getUser() { return user; }

    public void setUser(ApplicationUser user) { this.user = user; }
}