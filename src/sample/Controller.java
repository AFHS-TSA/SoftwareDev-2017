package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

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
    private void onRewardClicked() {
        //placeholder code for reward system layout
        /*Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("rewardsystemlayout.fxml"));
            Stage stage = new Stage();
            stage.setTitle("My Galaxy");
            stage.setScene(new Scene(root, width, height));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }*/

    }

    @FXML
    private void onAssignmentClicked() {
        //placeholder code for assignment list

        try {
    		Parent assignlist = FXMLLoader.load(getClass().getResource("/assignmentlist/assignmentlist.fxml"));
    		Stage stage = new Stage();
    		stage.setScene(new Scene(assignlist));
    		stage.setResizable(false);
    		stage.alwaysOnTopProperty();
    		stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void randomQuoteGen() {
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



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        randomQuoteGen();
    }
}


