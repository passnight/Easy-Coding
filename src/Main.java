import common.Common;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.BlogModel;
import model.IoModel;
import model.PostModel;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        IoModel.initialize();
        BlogModel.initialize();
        PostModel.initialize();
        int useless;
        Common.overStage=primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("view/UI/main.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, root.minWidth(-1), root.minHeight(-1)));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
