package owie.lionel.owie.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Stories {


@Id
@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
@GenericGenerator(
        name="native",
        strategy = "native"
)
    private long storyid;
    private String title;
    private String body;
    private int authorId;
    private Date DatePublished;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("stories")
    private Users user;

    public long getStoriesid() { return storyid; }

    public void setStoriesid(int storiesid) { this.storyid = storiesid; }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
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

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public Date getDatePublished() {
        return DatePublished;
    }

    public void setDatePublished(Date datePublished) {
        DatePublished = datePublished;
    }

}
