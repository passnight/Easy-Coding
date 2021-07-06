package controller;

import common.Answer;
import common.Post;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.IoModel;

public class ReviewDetailController extends BaseController{

    @FXML
    Label postAuthor,postContent,reviewAuthor1,reviewAuthor2,reviewAuthor3,reviewContent1,reviewContent2,reviewContent3;

    private Label[] reviewAuthor,reviewContent;
    private int localPage=1;
    private Answer[] answer;
    public static Post post;

    @FXML
    void initialize(){
        postAuthor.setText(post.getAuthor());
        postContent.setText(post.getSummary());
        reviewAuthor=new Label[]{reviewAuthor1,reviewAuthor2,reviewAuthor3};
        reviewContent=new Label[]{reviewContent1,reviewContent2,reviewContent3};
        answer= IoModel.AnswerIo.getAnswers(post.getAuthor()+"##"+post.getSummary(),2);
        setContent();
    }

    void setContent(){

        if(answer!=null){
            for(int i=0;i<3;i++){
                if((i+(localPage-1)*3)<answer.length){
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
}
