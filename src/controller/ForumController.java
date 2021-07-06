package controller;

import common.Common;
import common.Post;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import model.JumpModel;
import model.PostModel;

//基本同BlogController
public class ForumController extends  BaseController{

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

    @FXML
    public void initialize() {

        titles=new Hyperlink[]{title1,title2,title3,title4,title5};
        contains=new Label[]{contain1,contain2,contain3,contain4,contain5};
        setContain();

    }

    @FXML
    public void nextPage(){
        localPage++;
        setContain();
    }

    @FXML
    public void previousPage(){
        localPage--;
        setContain();
    }

    @FXML
    public void mainPage(){
        localPage=1;
        setContain();
    }

    @FXML
    public void lastPage(){
        localPage= PostModel.getAllAttentionPost().length/5+1;
        setContain();
    }

    @FXML
    public void like(){

    }

    @FXML
    public void attention(){
        if(null== Common.user){
            new JumpModel().attention();
        }
        else
        {
            type = 2;
            localPage=1;
            initialize();
        }
    }

    @FXML
    public void hot(){
        if(null!=Common.user)
        {
            type = 1;
            localPage=1;
            initialize();
        }
    }

    void setContain(){
        if(type==1) {
            if (PostModel.isNormalExist()&&!PostModel.isNormalEmpty()) {
                Post post[] = PostModel.getAllPost();
                int length = post.length;
                for (int i = 0; i < 5; i++) {
                    if ((i + (localPage - 1) * 5) < length&&post[i + (localPage - 1) * 5]!=null) {
                        titles[i].setText(post[i + (localPage - 1) * 5].getSummary());
                        contains[i].setText(post[i + (localPage - 1) * 5].getContent());
                        int finalI = i;

                        titles[i].setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                PostDetailController.post=post[finalI];
                                PostDetail(event);
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
            if (PostModel.isAttentionListExist()&&!PostModel.isAttentionListEmpty()) {
                Post Posts[] = PostModel.getAllAttentionPost();
                int length = Posts.length;
                for (int i = 0; i < 5; i++) {
                    if ((i + (localPage - 1) * 5) < length&&Posts[i + (localPage - 1) * 5]!=null) {
                        titles[i].setText(Posts[i + (localPage - 1) * 5].getSummary());
                        contains[i].setText(Posts[i + (localPage - 1) * 5].getContent());
                        int finalI=i;
                        titles[i].setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                PostDetailController.post=Posts[finalI];
                                PostDetail(event);
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
