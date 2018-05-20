package sk.ness.interview.domain;

import sk.ness.interview.utils.Constants;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = Constants.TABLE_COMMENTS)
@SequenceGenerator(name = Constants.COMMENTS_SEQUENCE_GENERATOR_NAME, sequenceName = Constants.COMMENTS_SEQUENCE_NAME, allocationSize = 1)
public class Comment {

    @Id
    @Column(name = Constants.COLUMN_NAME_ID, unique = true, nullable = false, precision = Constants.COLUMN_PRECISION_10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Constants.COMMENTS_SEQUENCE_GENERATOR_NAME)
    private Integer id;

    @Column(name = Constants.COLUMN_NAME_AUTHOR, length = Constants.COLUMN_LENGTH_50)
    private String author;

    @Column(name = Constants.COLUMN_NAME_TEXT, length = Constants.COLUMN_LENGTH_2000)
    private String text;

    @Column(name = Constants.COLUMN_NAME_CREATE_TIMESTAMP)
    private Date createTimestamp;

    public Comment() {
        this.createTimestamp = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(Date createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}
