package main.java.app.sample;

import main.java.app.initializable.Variables;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class that loads the root scene.
 */
public class Main extends Application {
	
	/**
	 * Creates sample.fxml scene
	 */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/main/resources/app/sample/sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, Variables.width, Variables.height));
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    /**
     * Launches start()
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
