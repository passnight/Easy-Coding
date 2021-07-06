package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.JumpModel;

//找回密码（未实现）
public class FindPtsdController extends BaseController {

    @FXML
    private TextField mail;

    //取消
    @FXML
    void cancel(ActionEvent event){
        Stage stage=(Stage)mail.getScene().getWindow();
        stage.close();
        new JumpModel().login();

    }
}
