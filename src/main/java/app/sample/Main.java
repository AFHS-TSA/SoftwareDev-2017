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
	
	/**
	 * Creates sample.fxml scene
	 */
    @Override
    public void start(Stage primaryStage) throws Exception {
//        primaryStage.widthProperty().greaterThan(600).addListener((obs, oldValue, newValue) -> {
//		    if (!newValue) {
//		    	BorderPane mainPane;
//				try {
//					mainPane = FXMLLoader.load(getClass().getResource("/main/resources/app/sample/DrawerContent.fxml"));
//			    	primaryStage.setScene(new Scene(mainPane));	
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}	      
//		    } else {
//		    	BorderPane mainPane;
//				try {
//					mainPane = FXMLLoader.load(getClass().getResource("/main/resources/app/sample/sampleBig.fxml"));
//					primaryStage.setScene(new Scene(mainPane));
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		});
    	
    	primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
        	System.out.println(primaryStage.getWidth());
        	System.out.println(primaryStage.getHeight());
        	if(primaryStage.getWidth() > 600) {
				try {
					mainPane = FXMLLoader.load(getClass().getResource("/main/resources/app/sample/sample.fxml"));
			    	primaryStage.setScene(new Scene(mainPane));
			    	primaryStage.setResizable(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	} else {
        			try {
						mainPane = FXMLLoader.load(getClass().getResource("/main/resources/app/sample/sampleBig.fxml"));
	        			primaryStage.setScene(new Scene(mainPane));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        	}
    	});
    	setStage(primaryStage);

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
        Parent root = FXMLLoader.load(getClass().getResource("/main/resources/app/sample/Main.fxml"));
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
