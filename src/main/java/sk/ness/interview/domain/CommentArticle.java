package sk.ness.interview.domain;

public class CommentArticle {

    private String author;
    private String text;
    private String createdDate;

    public CommentArticle(String author, String text, String createdDate) {
        this.author = author;
        this.text = text;
        this.createdDate = createdDate;
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

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
