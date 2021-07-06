package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import model.JumpModel;

//用于公共功能（主要使设置公共控件跳转功能）
public class BaseController {

    @FXML
    void login(MouseEvent actionEvent){
        new JumpModel().login();
    }

    @FXML
    void forum(ActionEvent actionEvent) {
        new JumpModel().forum();
    }

    @FXML
    void blog(ActionEvent actionEvent){
        new JumpModel().blog();
    }

    @FXML
    void writeBlog(ActionEvent actionEvent){
        new JumpModel().writeBlog();
    }

    @FXML
    void writeBlogByView(MouseEvent actionEvent){
        new JumpModel().writeBlog();
    }

    @FXML
    void writePost(ActionEvent actionEvent){
        new JumpModel().writePost();
    }

    @FXML
    void writePostByView(MouseEvent actionEvent){
        new JumpModel().writePost();
    }


    @FXML
    void myAnswer(ActionEvent actionEvent){
        new JumpModel().myAnswer();
    }

    @FXML
    void myAnswerByView(MouseEvent actionEvent){
        new JumpModel().myAnswer();
    }

    @FXML
    void main(ActionEvent actionEvent){
        new JumpModel().main();
    }

    @FXML
    void information(ActionEvent actionEvent){
        new JumpModel().information();
    }

    @FXML
    void messageByView(MouseEvent actionEvent){ new JumpModel().message();}

    @FXML
    void messageByButton(ActionEvent actionEvent){ new JumpModel().message(); }

    @FXML
    void attentionByView(MouseEvent actionEvent){new JumpModel().attention(); }

    @FXML
    void attentionByButton(ActionEvent actionEvent){new JumpModel().attention(); }

    @FXML
    void blogDetail(ActionEvent actionEvent){
        new JumpModel().blogDetail();
    }

    @FXML
    void PostDetail(ActionEvent actionEvent){
        new JumpModel().postDetail();
    }

    @FXML
    void Review(ActionEvent actionEvent){
        new JumpModel().review();
    }
}
