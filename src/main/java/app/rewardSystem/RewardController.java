package main.java.app.rewardSystem;

import java.net.URL;
import java.util.ResourceBundle;

import main.java.app.initializable.Methods;
import main.java.app.initializable.Variables;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

/**
 * Controller class for RewardMain.fxml
 */
public class RewardController implements Initializable {
	
	@FXML
	private ListView<String> rewardItems;
	@FXML
	public Label rewardScoreKeep;
	
	private static ObservableList<String> rewardItem = FXCollections.observableArrayList("Placeholder Item 1", "Placeholder Item 2", "Placeholder Item 3");
	
	/**
	 * Gets the user selection.
	 * Creates notification with amount deducted from user account.
	 * @param e
	 */
	public void getRewardBuy(MouseEvent e) {
		int getRewardSelection = rewardItems.getSelectionModel().getSelectedIndex();
		System.out.println(getRewardSelection);
		
		switch(getRewardSelection) {
		case 0:
			if(Variables.score >= 1) {
				Methods.getBuyNotification(1);
				rewardScoreKeep.setText(String.valueOf(Variables.score));
			}else {Methods.noFunds();}
			break;
		case 1:
			if(Variables.score >= 2) {
				Methods.getBuyNotification(2);
				rewardScoreKeep.setText(String.valueOf(Variables.score));
			}else {Methods.noFunds();}
			break;
		case 2:
			if(Variables.score >= 3) {
				Methods.getBuyNotification(3);
				rewardScoreKeep.setText(String.valueOf(Variables.score));
			}else {Methods.noFunds();}
		default:
			break;
		}
	}
	
	/**
	 * Initializes the Reward List.
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rewardScoreKeep.setText(String.valueOf(Variables.score));
		rewardItems.setItems(rewardItem);
	}
}
