package controller;

import common.Answer;
import common.Post;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import model.IoModel;
import model.PostModel;

public class MyAnswerController extends BaseController{

    @FXML
    Hyperlink title1,title2,title3,title4,title5,title6;

    @FXML
    Label content1,content2,content3,content4,content5,content6;

    private Answer[] answers;
    private int localPage=1;
    private Hyperlink[] title;
    private Label[] content;

    @FXML
    void initialize(){
        title= new Hyperlink[]{title1, title2, title3, title4, title5,title6};
        content=new Label[]{content1,content2,content3,content4,content5,content6};
        answers=IoModel.UserIo.getPersonAnswer(2);
        setContent();
    }

    void setContent(){
            for(int i=0;i<6;i++){
                if(answers!=null&&(i+(localPage-1)*6)<answers.length){

                    title[i].setText(answers[i+(localPage-1)*6].getArticleName());
                    content[i].setText(answers[i+(localPage-1)*6].getContent());
                    int finalI = i+(localPage-1)*6;
                    title[i].setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            Post post=PostModel.findPost(answers[finalI].getArticleName());
                            if(null!=post)PostDetailController.post=post ;
                            PostDetail(event);
                        }
                    });
                }
                else {
                    title[i].setText("问题");
                    content[i].setText("回答");
                    title[i].setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {

                        }
                    });

                }
            }
    }

    @FXML
    void lastPage(){
        localPage=999;
        setContent();
    }

    @FXML
    void mainPage(){
        localPage=1;
        setContent();
    }

    @FXML
    void nextPage(){
        if(localPage<999)
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
