package controller;

import common.Common;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.JumpModel;
import model.UserModel;

import java.util.Optional;


public class InformationController extends BaseController {

    private static String name,password,summary;

    @FXML
    TextField nameField,ptsdField,summaryField;

    @FXML
    Button saveButton;

    //初始化
    @FXML
    public void initialize() {
        nameField.setText(Common.user.getName());
        ptsdField.setText(Common.user.getPtsd());
        summaryField.setText(Common.user.getSummary());
        //设置更改功能
        saveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                //如果为改密码，直接变更
                if(!ptsdField.getText().equals(Common.user.getPtsd())){
                    new JumpModel().reMarkPtsd();
                    Common.overStage.close();
                }
                //若更改密码，跳往再次确认框
                else {
                    Common.user.setName(nameField.getText());
                    Common.user.setSummary(summaryField.getText());
                    UserModel.savePersonal(Common.user);
                }

            }
        });
    }

    //退出登录
    @FXML
    void outLogin(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION); // 创建一个确认对话框
        alert.setHeaderText("温馨提示"); // 设置对话框的头部文本
        // 设置对话框的内容文本
        alert.setContentText("确定退出么？");
        // 显示对话框，并等待按钮返回
        Optional<ButtonType> buttonType = alert.showAndWait();
        // 判断返回的按钮类型是确定还是取消，再据此分别进一步处理
        if (buttonType.get().getButtonData().equals(ButtonBar.ButtonData.OK_DONE)) { // 单击了确定按钮OK_DONE
            Common.user=null;
            new JumpModel().main();
        } else {
        }

    }

    //用于密码变动时新窗口获取已填信息
    public static String getName() {
        return name;
    }
    public static String getPassword() {
        return password;
    }
    public static String getSummary() {
        return summary;
    }
}
