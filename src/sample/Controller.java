package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

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
            root = FXMLLoader.load(getClass().getClassLoader().getResource("teststage.fxml"));
            Stage stage = new Stage();
            stage.setTitle("My New Stage Title");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }*/
    }

}


