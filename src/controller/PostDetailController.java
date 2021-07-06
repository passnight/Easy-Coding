package controller;

import common.Answer;
import common.Common;
import common.Post;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.BlogModel;
import model.IoModel;
import model.JumpModel;
import model.PostModel;

public class PostDetailController extends BaseController{
    public static Post post;

    @FXML
    private Label author,title,reviewAuthor1,reviewAuthor2,reviewAuthor3,reviewContent1,reviewContent2,reviewContent3;

    @FXML
    private TextArea content;

    @FXML
    private ImageView concerned;

    private Answer[] answer;
    private Label[] reviewAuthor,reviewContent;
    private int localPage=1;

    @FXML
    void initialize(){
        //评论
        reviewAuthor=new Label[]{reviewAuthor1,reviewAuthor2,reviewAuthor3};
        reviewContent=new Label[]{reviewContent1,reviewContent2,reviewContent3};
        answer= IoModel.AnswerIo.getAnswers(post.getAuthor()+"##"+post.getSummary(),2);

        //主要内容
        if(null!=post){
            title.setText(post.getSummary());
            content.setText(post.getContent());
            author.setText(post.getAuthor());
            if(BlogModel.isAttentionListExist()&&!BlogModel.isAttentionListEmpty()&&PostModel.isAttentionExist(post)){
                Image image=new Image("view/icon/关注了.png");
                concerned.setImage(image);
            }
        }
        setContent();
    }

    @FXML
    void attention(){
        if(PostModel.isAttentionListExist()) {
            if(!PostModel.isAttentionExist(post)) {//关注
                PostModel.addAttention(post);
                initialize();
            }
            else{//取消关注

            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.titleProperty().set("warning");
            alert.headerTextProperty().set("请先登录");
            alert.showAndWait();
        }
    }

    @Override
    void Review(ActionEvent actionEvent) {
        if(null!= Common.user){
            ReviewController.type = 2;
            ReviewController.answer = new Answer(post.getAuthor(), post.getSummary());
            super.Review(actionEvent);
        }
        else
            new JumpModel().pleaseLogin();
    }

    void setContent(){
        if(answer!=null){
            for(int i=0;i<3;i++){
                if((i+(localPage-1)*3)<answer.length&&answer[i+(localPage-1)*3]!=null){
                    reviewAuthor[i].setText(answer[i+(localPage-1)*3].getReviewAuthor());
                    reviewContent[i].setText(answer[i+(localPage-1)*3].getContent());
                }
                else{
                    reviewAuthor[i].setText("用户名");
                    reviewContent[i].setText("内容");
                }
            }
        }
    }

    @FXML
    void nextPage(){
        localPage++;
        setContent();
    }

    @FXML
    void previousPage(){
        if(localPage>1)
            localPage--;
        setContent();
    }
}

