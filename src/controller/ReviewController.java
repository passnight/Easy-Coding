package controller;

import common.Answer;
import common.Common;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.IoModel;

public class ReviewController extends BaseController{

    @FXML
    TextArea content;

    @FXML//题目和大框标题
    Label title,bigTitle;

    public static Answer answer=new Answer();
    public static int type;//type==1为评论，type==2为回答

    @FXML
    void initialize(){
        if(type==1) {
            title.setText("博客：" + answer.getArticleName());
            bigTitle.setText("评论");
        }
        if(type==2){
            title.setText("问题：" + answer.getArticleName());
            bigTitle.setText("回答");
        }
    }

    @FXML//生成回答或评论
    void okay(){
        answer.setReviewAuthor(Common.user.getName());
        answer.setContent(content.getText());
            IoModel.AnswerIo.saveContent(answer,type);
            IoModel.AnswerIo.savePersonRecord(answer,type);
        ((Stage)content.getScene().getWindow()).close();
    }

    @FXML
    void cancel(){//取消
        ((Stage)title.getScene().getWindow()).close();
    }
}
