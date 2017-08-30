package sample;

import javafx.fxml.FXML;
<<<<<<< HEAD
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
=======
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
>>>>>>> 48c18e06f8b2ce46e781abb3e70272515c8fc6a1

    @FXML
    public Label dashText;
    @FXML
    public Label quote;
    @FXML
    public Button rewardButton;

<<<<<<< HEAD


=======
>>>>>>> 48c18e06f8b2ce46e781abb3e70272515c8fc6a1
    @FXML
    private void onRewardClicked() {
        //placeholder code for reward system layout
        /*Parent root;
        try {
<<<<<<< HEAD
            root = FXMLLoader.load(getClass().getClassLoader().getResource("rewardsystemlayout.fxml"));
            Stage stage = new Stage();
            stage.setTitle("My Galaxy");
            stage.setScene(new Scene(root, width, height));
=======
            root = FXMLLoader.load(getClass().getClassLoader().getResource("teststage.fxml"));
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(root, 450, 450));
>>>>>>> 48c18e06f8b2ce46e781abb3e70272515c8fc6a1
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }*/
<<<<<<< HEAD

    }

    @FXML
    private void onAssignmentClicked() {
        //placeholder code for assignment list
        /*Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("assignmentlist.fxml"));
            Stage stage = new Stage();
            stage.setTitle("My Assignments");
            stage.setScene(new Scene(root, width, height));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }*/
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
=======
    }

>>>>>>> 48c18e06f8b2ce46e781abb3e70272515c8fc6a1
}


