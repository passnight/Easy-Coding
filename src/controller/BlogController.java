package controller;

import common.Blog;
import common.Common;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.BlogModel;
import model.JumpModel;


public class BlogController extends BaseController{

    @FXML
    Hyperlink title1,title2,title3,title4,title5;

    @FXML
    Label contain1,contain2,contain3,contain4,contain5;

    @FXML
    ImageView like1;


    private Hyperlink titles[];
    private Label contains[];
    private int localPage=1;
    private static int type=1;

    @FXML//初始化
    public void initialize() {

        titles=new Hyperlink[]{title1,title2,title3,title4,title5};
        contains=new Label[]{contain1,contain2,contain3,contain4,contain5};
        setContain();
        like1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Image image=new Image("view/icon/赞.png");
                like1.setImage(image);
            }
        });
    }

    @FXML//下一页
    public void nextPage(){
        localPage++;
        setContain();
    }

    @FXML//上一页
    public void previousPage(){
        if(localPage>=1)
           localPage--;
        setContain();
    }

    @FXML//首页
    public void mainPage(){
        localPage=1;
        setContain();
    }

    @FXML//尾页
    public void lastPage(){
        localPage=BlogModel.getAllAttentionBlog().length/5+1;
        setContain();
    }

    //点赞（未实现）
    @FXML
    public void like(){

    }

    //切换至关注博客
    @FXML
    public void attention(){
        if(null==Common.user){
            new JumpModel().pleaseLogin();
        }
        else
        {
            type = 2;
            localPage=1;
            initialize();
        }
    }

    //切换至热门博客
    @FXML
    public void hot(){
        type = 1;
        localPage=1;
        initialize();
    }

    //刷新页面
    void setContain(){
        if(type==1) {
            if (BlogModel.isNormalExist()&&!BlogModel.isNormalEmpty()) {
                Blog blogs[] = BlogModel.getAllBlog();
                int length = blogs.length;
                for (int i = 0; i < 5; i++) {
                    if ((i + (localPage - 1) * 5) < length&&blogs[i + (localPage - 1) * 5]!=null) {
                        titles[i].setText(blogs[i + (localPage - 1) * 5].getTitle());
                        contains[i].setText(blogs[i + (localPage - 1) * 5].getContent());
                        int finalI = i;
                        titles[i].setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                BlogDetailController.blog=blogs[finalI];
                                blogDetail(event);
                            }
                        });
                    } else {
                        titles[i].setText("标题");
                        contains[i].setText("内容");
                        titles[i].setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {

                            }
                        });
                    }
                }
            }
            else{
                for (int i = 0; i < 5; i++) {
                    titles[i].setText("标题");
                    contains[i].setText("内容");
                    titles[i].setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {

                        }
                    });
                }
            }
        }
        else if(type==2){
            if (BlogModel.isAttentionListExist()&&!BlogModel.isAttentionListEmpty()) {
                Blog blogs[] = BlogModel.getAllAttentionBlog();
                    int length = blogs.length;
                for (int i = 0; i < 5; i++) {
                        if ((i + (localPage - 1) * 5) < length&&blogs[i + (localPage - 1) * 5]!=null) {
                            titles[i].setText(blogs[i + (localPage - 1) * 5].getTitle());
                            contains[i].setText(blogs[i + (localPage - 1) * 5].getContent());
                            int finalI = i;
                            titles[i].setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    BlogDetailController.blog=blogs[finalI];
                                    blogDetail(event);
                                }
                            });
                        } else {
                            titles[i].setText("标题");
                            contains[i].setText("内容");
                            titles[i].setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {

                                }
                            });
                        }
                    }

            }
            else{
                for (int i = 0; i < 5; i++) {
                    titles[i].setText("标题");
                    contains[i].setText("内容");
                    titles[i].setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {

                        }
                    });
                }
            }
        }
    }

}
