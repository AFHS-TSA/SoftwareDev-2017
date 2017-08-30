package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
<<<<<<< HEAD
        primaryStage.setScene(new Scene(root, 600, 400));
=======
        primaryStage.setScene(new Scene(root, 300, 275));
>>>>>>> 48c18e06f8b2ce46e781abb3e70272515c8fc6a1
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
