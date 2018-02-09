package main.java.app.sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXMasonryPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.java.app.initializable.Variables;

public class ControllerBig implements Initializable{

    private int randomInt;

    String[] quotes = {"Test 0",
                       "Test 1",
                       "Test 2",
                       "Test 3",
                       "Test 4"};

    @FXML
    private AnchorPane topBar;
    @FXML
    public Label dashText;
    @FXML
    public Label quote;
    @FXML
    public Button rewardButton;
    @FXML
    private Label getScore;
    @FXML
    private JFXDrawer navDrawer;
    @FXML
    private JFXMasonryPane Masonry;
    @FXML
    private Label test;
	
	 @FXML
	    private void onRewardClicked(ActionEvent e) {
	        //placeholder code for reward system layout
	        try {
	    		Parent rewardParent = FXMLLoader.load(getClass().getResource("/main/resources/app/rewardSystem/RewardMain.fxml"));
	    		Scene rewardScene = (new Scene(rewardParent, Variables.width, Variables.height));
	    		Stage appStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
	    		appStage.setResizable(false);
	    		appStage.setScene(rewardScene);
	    		appStage.show();
	        }
	        catch (IOException ec) {
	            ec.printStackTrace();
	        }

	    }

	    @FXML
	    private void onAssignmentClicked(ActionEvent e) {

	        //placeholder code for assignment list
	        System.out.println("TESTING");
	        try {
	        	/*
	    		Parent assignlist = FXMLLoader.load(getClass().getResource("/assignmentlist/assignmentlist.fxml"));
	    		Stage stage = new Stage();
	    		stage.setScene(new Scene(assignlist));
	    		stage.setResizable(false);
	    		stage.alwaysOnTopProperty();
	    		stage.show();*/
	    		

	    		Parent assignmentParent = FXMLLoader.load(getClass().getResource("/main/resources/app/assignmentlist/assignmentlist.fxml"));
	    		Scene assignmentScene = (new Scene(assignmentParent, Variables.width, Variables.height));
	    		Stage appStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
	    		appStage.setResizable(false);
	    		appStage.setScene(assignmentScene);
	    		appStage.show();
	        }
	        catch (IOException ec) {
	            ec.printStackTrace();
	        }
	    }

	    @FXML
	    private void onDelete(ActionEvent e) {
	    	Masonry.getChildren().remove(test);
	    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

}
