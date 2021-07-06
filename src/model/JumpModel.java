package model;

import common.Common;
import common.Url;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
//路由跳转
public class JumpModel {

    //用于锁定弹出窗个数
    static private boolean isInLogin=false;
    static private boolean isInPlease=false;
    static private boolean isInRemark=false;
    static private boolean isInRegister=false;
    static private boolean isInFindPtsd=false;
    static private boolean isInReview=false;

    //各种路由
    public void login() {
        if ((null==Common.user) && !isInLogin) {
            isInLogin = true;
            try {
                Parent root = FXMLLoader.load(getClass().getResource(Url.login));
                Stage primaryStage = new Stage();
                Scene login = new Scene(root, root.minWidth(-1), root.minHeight(-1));

                primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {

                        isInLogin = false;
                    }
                });

                primaryStage.setOnHidden(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        isInLogin = false;
                    }
                });

                primaryStage.setScene(login);
                primaryStage.show();
            } catch (Exception e) {
                e.fillInStackTrace();
            }


        }
        else if(!isInLogin)
              information();
    }
    public void blog(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Url.blog));

            Common.overStage.setScene(new Scene(root, root.minWidth(-1), root.minHeight(-1)));
        }catch (Exception e){
            e.fillInStackTrace();
        }
    }
    public void blogDetail(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Url.blogDetail));

            Common.overStage.setScene(new Scene(root, root.minWidth(-1), root.minHeight(-1)));
        }catch (Exception e){
            e.fillInStackTrace();
        }
    }
    public void postDetail(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Url.postDetail));

            Common.overStage.setScene(new Scene(root, root.minWidth(-1), root.minHeight(-1)));
        }catch (Exception e){
            e.fillInStackTrace();
        }
    }
    public void forum(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Url.forum));

            Common.overStage.setScene(new Scene(root, root.minWidth(-1), root.minHeight(-1)));
        }catch (Exception e){
            e.fillInStackTrace();
        }
    }
    public void attention(){
        if(null!=Common.user)
        {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(Url.attention));

                Common.overStage.setScene(new Scene(root, root.minWidth(-1), root.minHeight(-1)));
            } catch (Exception e) {
                e.fillInStackTrace();
            }
        }
        else
            pleaseLogin();
    }
    public void myAnswer(){
        if(null!=Common.user)
        {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(Url.myAnswer));

                Common.overStage.setScene(new Scene(root, root.minWidth(-1), root.minHeight(-1)));
            } catch (Exception e) {
                e.fillInStackTrace();
            }
        }
        else
            pleaseLogin();
    }
    public void main(){
        try {
            Parent root = FXMLLoader.load(getClass().getResource(Url.main));

            Common.overStage.setScene(new Scene(root, root.minWidth(-1), root.minHeight(-1)));
        }catch (Exception e){
            e.fillInStackTrace();
        }
    }
    public void message(){
        if(null!=Common.user)
        {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(Url.message));

                Common.overStage.setScene(new Scene(root, root.minWidth(-1), root.minHeight(-1)));
            } catch (Exception e) {
                e.fillInStackTrace();
            }
        }
        else
            pleaseLogin();
    }
    public void information(){
        if(null!=Common.user)
        {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(Url.information));

                Common.overStage.setScene(new Scene(root, root.minWidth(-1), root.minHeight(-1)));
            } catch (Exception e) {
                e.fillInStackTrace();
            }
        }
        else
            pleaseLogin();
    }

    public void pleaseLogin(){

        if(!isInPlease)
        {
            isInPlease=true;
            try {
                Parent root = FXMLLoader.load(getClass().getResource(Url.pleaseLogin));
                Stage primaryStage = new Stage();
                Scene please = new Scene(root, root.minWidth(-1), root.minHeight(-1));

                primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        isInPlease = false;
                    }
                });

                primaryStage.setOnHidden(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        isInPlease = false;
                    }
                });

                primaryStage.setScene(please);
                primaryStage.show();



            } catch (Exception e) {
                e.fillInStackTrace();
            }
        }
        }
    public void review(){

        if(!isInReview)
        {
            isInReview=true;
            try {
                Parent root = FXMLLoader.load(getClass().getResource(Url.review));
                Stage primaryStage = new Stage();
                Scene please = new Scene(root, root.minWidth(-1), root.minHeight(-1));

                primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        isInReview = false;
                    }
                });

                primaryStage.setOnHidden(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        isInReview= false;
                    }
                });

                primaryStage.setScene(please);
                primaryStage.show();



            } catch (Exception e) {
                e.fillInStackTrace();
            }
        }
        }
    public void reMarkPtsd(){

        if(!isInRemark)
        {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(Url.reMarkPtsd));
                Stage primaryStage = new Stage();
                Scene please = new Scene(root, root.minWidth(-1), root.minHeight(-1));

                primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        isInRemark = false;
                        Common.overStage.show();
                    }
                });

                primaryStage.setScene(please);
                primaryStage.show();

            } catch (Exception e) {
                e.fillInStackTrace();
            }
        }
        }
    public void register(){

        if(!isInRegister)
        {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(Url.register));
                Stage primaryStage = new Stage();
                Scene please = new Scene(root, root.minWidth(-1), root.minHeight(-1));

                primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {

                        isInRegister = false;
                        Common.overStage.show();

                    }
                });

                primaryStage.setScene(please);
                primaryStage.show();



            } catch (Exception e) {
                e.fillInStackTrace();
            }
        }
        }
    public void findPtsd(){

        if(!isInFindPtsd)
        {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(Url.findPtsd));
                Stage primaryStage = new Stage();
                Scene please = new Scene(root, root.minWidth(-1), root.minHeight(-1));

                primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {

                        isInFindPtsd = false;
                        Common.overStage.show();

                    }
                });

                primaryStage.setScene(please);
                primaryStage.show();



            } catch (Exception e) {
                e.fillInStackTrace();
            }
        }
        }
    public void writePost(){
        if(null!=Common.user)
        {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(Url.writePost));

                Common.overStage.setScene(new Scene(root, root.minWidth(-1), root.minHeight(-1)));
            } catch (Exception e) {
                e.fillInStackTrace();
            }
        }
        else
            pleaseLogin();
    }
    public void writeBlog(){
        if(null!=Common.user)
        {
            try {
                Parent root = FXMLLoader.load(getClass().getResource(Url.writeBlog));

                Common.overStage.setScene(new Scene(root, root.minWidth(-1), root.minHeight(-1)));
            } catch (Exception e) {
                e.fillInStackTrace();
            }
        }
        else
            pleaseLogin();
    }
}
