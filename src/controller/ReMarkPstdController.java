package controller;

import common.Common;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.JumpModel;
import model.UserModel;


public class ReMarkPstdController {

    @FXML
    Button okay,cancel;

    @FXML
    TextField ptsdField;

    @FXML
    public void initialize(){
        //确认更改密码
        okay.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Common.user.setPtsd(ptsdField.getText());
                Common.user.setSummary(InformationController.getSummary());
                Common.user.setName(InformationController.getName());
                UserModel.savePersonal(Common.user);
                Stage stage = (Stage) okay.getScene().getWindow();
                stage.close();
                new JumpModel().information();
                Common.overStage.show();
            }
        });

        //取消
        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) okay.getScene().getWindow();
                stage.close();
                Common.overStage.show();
            }
        });
    }
}
