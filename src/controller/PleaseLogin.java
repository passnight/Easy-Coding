package controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class PleaseLogin extends BaseController{
    @FXML
    private ImageView okay;

    @FXML
    public void initialize() {

    }

    @Override//点击前往登录界面
    void login(MouseEvent actionEvent) {

        Stage stage = (Stage) okay.getScene().getWindow();
        stage.close();
        super.login(actionEvent);
    }
}
