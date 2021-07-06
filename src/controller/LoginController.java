package controller;

import common.Common;
import common.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.JumpModel;
import model.UserModel;

import java.io.IOException;

public class LoginController {


    @FXML
    private TextField nameField,ptsd;

    @FXML
    private Button log;

    @FXML//登录
    void login(ActionEvent event) throws IOException {
        User user=new User(nameField.getText(),ptsd.getText());
        if(UserModel.isExist(user)){
            if(UserModel.login(user)) {
                Common.user = user;
                UserModel.initialize();
                Stage stage = (Stage) log.getScene().getWindow();
                stage.close();
                new JumpModel().login();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.titleProperty().set("warning");
                alert.headerTextProperty().set("密码错误，请重新输入");
                alert.showAndWait();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.titleProperty().set("warning");
            alert.headerTextProperty().set("没有此用户，请先注册");
            alert.showAndWait();
        }

    }

    @FXML//前往注册
    void register(ActionEvent event){
        new JumpModel().register();
        Stage stage = (Stage) log.getScene().getWindow();
        stage.close();
    }

    @FXML//初始化
    void initialize(){
        if(null!= Common.user){
            nameField.setText(Common.user.getName());
        }
    }

    @FXML//找回密码
    void findPtsd(){
        new JumpModel().findPtsd();
        Stage stage = (Stage) log.getScene().getWindow();
        stage.close();
    }

}
