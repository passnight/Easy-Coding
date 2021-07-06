package controller;

import common.Blog;
import common.Post;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.text.Text;
import model.BlogModel;
import model.PostModel;

public class MainController extends BaseController{


    @FXML
    private Hyperlink hotBlogTitle,hotPostTitle,attentionTitle1,attentionTitle2;

    @FXML
    Text hotBlogContain,hotPostContain;

    private Hyperlink[] attentionTitle;


    @FXML//初始化
    public void initialize() {
        attentionTitle=new Hyperlink[]{attentionTitle1,attentionTitle2};
        setContain();
    }
    //页面相关
    void setContain(){
        if(BlogModel.isNormalExist()&&!BlogModel.isNormalEmpty()){//热门文章
            Blog blog=BlogModel.getAllBlog()[0];
            hotBlogTitle.setText(blog.getTitle());
            hotBlogTitle.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    BlogDetailController.blog=blog;
                    blogDetail(event);
                }
            });
            hotBlogContain.setText(blog.getContent());
        }
        if(PostModel.isNormalExist()&&!PostModel.isNormalEmpty()){//热门话题
            Post post=PostModel.getAllPost()[0];
            hotPostTitle.setText(post.getSummary());
            hotPostTitle.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    PostDetailController.post=post;
                    PostDetail(event);
                }
            });
            hotPostContain.setText(post.getContent());
        }
        if (BlogModel.isAttentionListExist()&&!BlogModel.isAttentionListEmpty()) {
            Blog blogs[] = BlogModel.getAllAttentionBlog();
            for(int i=0;i<2;i++){
                if (i<blogs.length&&blogs[i]!=null) {
                    attentionTitle[i].setText(blogs[i].getTitle());
                    int finalI = i;
                    attentionTitle[i].setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            BlogDetailController.blog = blogs[finalI];
                            blogDetail(event);
                        }
                    });
                }
            }


        }
    }
}