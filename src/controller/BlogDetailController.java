package controller;

import common.Answer;
import common.Blog;
import common.Common;
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


public class BlogDetailController extends BaseController{

    @FXML
    private Label title,author, reviewAuthor1, reviewAuthor2,reviewContent1,reviewContent2;

    @FXML
    private TextArea contain;

    @FXML
    private ImageView concerned;

    public  static Blog blog;
    private Answer[] answer;
    private Label[] reviewAuthor,reviewContent;

    //出书画
    @FXML
    void initialize(){
        //评论
        answer= IoModel.AnswerIo.getAnswers(blog.getAuthor()+"##"+blog.getTitle(),1);
        reviewAuthor=new Label[]{reviewAuthor1,reviewAuthor2};
        reviewContent=new Label[]{reviewContent1,reviewContent2};
        if(answer!=null){
            for(int i=0;i<3;i++){
                if(i<answer.length){
                    reviewAuthor[i].setText(answer[i].getReviewAuthor());
                    reviewContent[i].setText(answer[i].getContent());
                }
            }
        }

        //主要内容
        if(null!=blog){
            title.setText(blog.getTitle());
            contain.setText(blog.getContent());
            author.setText(blog.getAuthor());
            if(BlogModel.isAttentionListExist()&&!BlogModel.isAttentionListEmpty()&&BlogModel.isAttentionExist(blog)){
                Image image=new Image("view/icon/关注了.png");
                concerned.setImage(image);
            }
        }
    }

    //前往评论
    @Override
    void Review(ActionEvent actionEvent) {
        if(null!=Common.user){
            ReviewController.type = 1;
            ReviewController.answer = new Answer(blog.getAuthor(), blog.getTitle());
            super.Review(actionEvent);
        }
        else
            new JumpModel().pleaseLogin();
    }

    //关注
    @FXML
    void attention(){
        if(BlogModel.isAttentionListExist()) {
            if(!BlogModel.isAttentionExist(blog)) {//关注
                BlogModel.addAttention(blog);
                initialize();
            }
            else{//取消关注

            }
        }
        else{//未登录
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.titleProperty().set("warning");
            alert.headerTextProperty().set("请先登录");
            alert.showAndWait();
        }
    }

}
