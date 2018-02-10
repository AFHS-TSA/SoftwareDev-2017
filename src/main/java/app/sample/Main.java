package main.java.app.sample;

import main.java.app.initializable.Variables;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Main class that loads the root scene.
 */
public class Main extends Application {
	
    @FXML
    private BorderPane mainPane;
    public static double width = 0;
	
    
	/**
	 * Creates sample.fxml scene
	 */
    @Override
    public void start(Stage primaryStage) throws Exception {
    	setStage(primaryStage);
    	
    	  primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
    		  double width = 0; 
    	  });
    }

    /**
     * Launches start()
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void setStage(Stage stage) {
        try {
        Parent root = FXMLLoader.load(getClass().getResource("/main/resources/app/sample/sample.fxml"));
        stage.setTitle("Hello World");
        stage.setScene(new Scene(root));
        stage.show();
        stage.setResizable(true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
}
