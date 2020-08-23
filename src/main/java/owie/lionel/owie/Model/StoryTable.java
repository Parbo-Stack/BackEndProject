package owie.lionel.owie.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class StoryTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(
            name="native",
            strategy = "native"
    )
    private long tableid;
    private int authorid;
    private int storyid;
    private String title;
    private String body;
    private String reader;
    private String writer;
    private Timestamp timestamp;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "Writer")
    private List<WriteStory> writeStories;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "Reader")
    private List<ReadStory> Readstories;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "Finish")
    private List<FinishStory> finishStories;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "Listener")
    private List<AudioStory> audioStories;

    public long getId() {
        return tableid;
    }

    public void setId(long id) {
        this.tableid = id;
    }

    public int getAuthor() {
        return authorid;
    }

    public void setAuthor(int author) {
        this.authorid = author;
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

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public List<WriteStory> getWriteStories() {
        return writeStories;
    }

    public void setWriteStories(List<WriteStory> writeStories) {
        this.writeStories = writeStories;
    }

    public List<ReadStory> getReadstories() {
        return Readstories;
    }

    public void setReadstories(List<ReadStory> readstories) {
        Readstories = readstories;
    }

    public List<FinishStory> getFinishStories() {
        return finishStories;
    }

    public void setFinishStories(List<FinishStory> finishStories) {
        this.finishStories = finishStories;
    }

    public List<AudioStory> getAudioStories() {
        return audioStories;
    }

    public void setAudioStories(List<AudioStory> audioStories) {
        this.audioStories = audioStories;
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
}

