package controller;

import common.Blog;
import common.Post;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import model.BlogModel;
import model.PostModel;

public class AttentionController extends BaseController{

    @FXML
    Hyperlink postTitle1,postTitle2,blogTitle1,blogTitle2;

    @FXML
    Label postContent1,postContent2,blogContent1,blogContent2;

    private Hyperlink[] postTitle,blogTitle;
    private Label[] postContent,blogContent;
    private int localPostPage=1,localBlogPage=1;

    @FXML//初始化
    void initialize(){
        postContent=new Label[]{postContent1,postContent2};
        blogContent=new Label[]{blogContent1,blogContent2};
        postTitle=new Hyperlink[]{postTitle1,postTitle2};
        blogTitle=new Hyperlink[]{blogTitle1,blogTitle2};
        setContain();

    }

    //刷新页面
    void setContain(){
        if (BlogModel.isAttentionListExist()&&!BlogModel.isAttentionListEmpty()) {
            Blog[] blogs = BlogModel.getAllAttentionBlog();
            int length = blogs.length;
            for(int i=0;i<2;i++){
                if ((i + (localBlogPage - 1) * 2) < length&&blogs[i+(localBlogPage-1)*2]!=null) {
                    blogTitle[i].setText(blogs[i].getTitle());
                    blogContent[i].setText(blogs[i].getContent());
                    int finalI = i;
                    blogTitle[i].setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            BlogDetailController.blog = blogs[finalI];
                            blogDetail(event);
                        }
                    });
                }
                else {
                    blogTitle[i].setText("标题");
                    blogContent[i].setText("内容");
                    blogTitle[i].setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {

                        }
                    });
                }
            }


        }
        else{
            blogTitle[0].setText("标题");
            blogContent[0].setText("内容");
            blogTitle[1].setText("标题");
            blogContent[1].setText("内容");
        }

        if (PostModel.isAttentionListExist()&&!PostModel.isAttentionListEmpty()) {
            Post[] posts = PostModel.getAllAttentionPost();
            int length = posts.length;

            for(int i=0;i<2;i++){
                if ((i + (localPostPage - 1) * 2) < length&&posts[i+(localPostPage-1)*2]!=null) {
                    postTitle[i].setText(posts[i].getSummary());
                    postContent[i].setText(posts[i].getContent());
                    int finalI = i;
                    postTitle[i].setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            PostDetailController.post = posts[finalI];
                            PostDetail(event);
                        }
                    });
                }
                else {
                    postTitle[i].setText("标题");
                    postContent[i].setText("内容");
                    blogTitle[i].setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {

                        }
                    });
                }
            }


        }
        else{
            postTitle[0].setText("标题");
            postContent[0].setText("内容");
            blogTitle[0].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                }
            });
            postTitle[1].setText("标题");
            postContent[1].setText("内容");
            blogTitle[1].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                }
            });
        }
    }

    //关注博客的下一页
    @FXML
    void nextBlogPage(){
        localBlogPage++;
        setContain();
    }

    //关注博客的上一页
    @FXML
    void previousBlogPage(){
        if(localBlogPage>1)
            localBlogPage--;
        setContain();
    }

    //关注帖子的下一页
    @FXML
    void nextPostPage(){
        localPostPage++;
        setContain();
    }

    //关注帖子的上一页
    @FXML
    void previousPostPage(){
        if(localPostPage>1)
            localPostPage--;
        setContain();
    }
}
