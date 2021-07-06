package common;

public class Post {
    private String author;
    private String summary;
    private String content;
    private int likeNum;


    public Post(String author, String summary, String content) {
        this.author = author;
        this.content = content;
        this.summary = summary;
    }

    public Post() {
    }

    @Override
    public String toString() {
        return "Post{" +
                "author='" + author + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
