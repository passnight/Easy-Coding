package controller;

import common.Common;
import common.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.JumpModel;
import model.UserModel;

import java.io.IOException;

public class RegisterController {

    @FXML
    private TextField nameField,ptsd,ptsdAgain;

    @FXML//注册
    void register(ActionEvent event) throws IOException {
        if(nameField.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.titleProperty().set("warning");
            alert.headerTextProperty().set("请输入用户名");
            alert.showAndWait();
        }

        else if(ptsd.getText().equals(ptsdAgain.getText())) {
            User user = new User(nameField.getText(), ptsd.getText());
            if(UserModel.isExist(user)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.titleProperty().set("warning");
                alert.headerTextProperty().set("此用户名已存在");
                alert.showAndWait();
            }
            else{
                UserModel.register(user);
                Common.user=user;
                UserModel.initialize();
                Stage stage=(Stage)ptsd.getScene().getWindow();
                stage.close();
                new JumpModel().login();
            }
        }

    }

    @FXML//取消
    void cancel(ActionEvent event){
        Stage stage=(Stage)ptsd.getScene().getWindow();
        stage.close();
        new JumpModel().login();

    }
}
