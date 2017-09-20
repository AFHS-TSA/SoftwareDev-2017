package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import org.controlsfx.control.Notifications;

import assignmentlist.assignmentController;
import initializable.Variables;

public class Controller implements Initializable{


    private int randomInt;

    String[] quotes = {"Test 0",
                       "Test 1",
                       "Test 2",
                       "Test 3",
                       "Test 4"};

    @FXML
    public Label dashText;
    @FXML
    public Label quote;
    @FXML
    public Button rewardButton;
    @FXML
    private Label getScore;

    @FXML
    private void onRewardClicked(ActionEvent e) {
        //placeholder code for reward system layout
        try {
    		Parent rewardParent = FXMLLoader.load(getClass().getResource("/rewardSystem/RewardMain.fxml"));
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

        try {
        	/*
    		Parent assignlist = FXMLLoader.load(getClass().getResource("/assignmentlist/assignmentlist.fxml"));
    		Stage stage = new Stage();
    		stage.setScene(new Scene(assignlist));
    		stage.setResizable(false);
    		stage.alwaysOnTopProperty();
    		stage.show();*/
    		

    		Parent assignmentParent = FXMLLoader.load(getClass().getResource("/assignmentlist/assignmentlist.fxml"));
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

    /*private void randomQuoteGen() {
        Preferences preferences = Preferences.userNodeForPackage(Controller.class);
        Random random = new Random();
        do {
            randomInt = random.nextInt((4-0) + 1) + 0;
        } while (randomInt == Integer.parseInt(preferences.get("RandomNumber", "root")));
        quote.setText(""+quotes[randomInt]);

        preferences.putInt("RandomNumber", randomInt);
        try {
            preferences.exportNode(new FileOutputStream("Preferences"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BackingStoreException e) {
            e.printStackTrace();
        }

    }
*/


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        getScore.setText(String.valueOf(Variables.score));
    }
}


