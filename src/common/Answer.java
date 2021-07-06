package common;

public class Answer {

    private String articleName;//评论的文章名
    private String author;//评论的作者名
    private String content;//内容
    private String reviewAuthor;//评论/回答者用户名

    public Answer() {
    }

    public Answer( String author,String articleName) {
        this.articleName = articleName;
        this.author = author;
    }

    public Answer(String articleName, String author, String content, String reviewAuthor) {
        this.articleName = articleName;
        this.author = author;
        this.content = content;
        this.reviewAuthor = reviewAuthor;
    }

    public String getReviewAuthor() {
        return reviewAuthor;
    }

    public void setReviewAuthor(String reviewAuthor) {
        this.reviewAuthor = reviewAuthor;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
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

    @Override
    public String toString() {
        return "Answer{" +
                "articleName='" + articleName + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", reviewAuthor='" + reviewAuthor + '\'' +
                '}';
    }
}
