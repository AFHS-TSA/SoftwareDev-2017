package rewardSystem;

import java.net.URL;
import java.util.ResourceBundle;

import org.controlsfx.control.Notifications;

import assignmentlist.assignmentController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class RewardController implements Initializable {
	
	@FXML
	private ListView<String> rewardItems;
	@FXML
	private Label rewardScoreKeep;
	
	private static ObservableList<String> rewardItem = FXCollections.observableArrayList("Placeholder Item 1", "Placeholder Item 2", "Placeholder Item 3");
	
	public void getRewardBuy(MouseEvent e) {
		int getRewardSelection = rewardItems.getSelectionModel().getSelectedIndex();
		String insufficientFunds = "Insufficient funds";
		System.out.println(getRewardSelection);
		
		switch(getRewardSelection) {
		case 0:
			if(assignmentController.score >= 1) {
			Notifications.create().title("Point Added").text("There was 1 point deducted from your account").position(Pos.BOTTOM_RIGHT).show();
			assignmentController.score = assignmentController.score - 1;
			rewardScoreKeep.setText(String.valueOf(assignmentController.score));
			}else {Notifications.create().title("Error in Purchase").text(insufficientFunds).position(Pos.BOTTOM_RIGHT).show();}
			break;
		case 1:
			if(assignmentController.score >= 2) {
			Notifications.create().title("Point Added").text("There was 2 point deducted from your account").position(Pos.BOTTOM_RIGHT).show();
			assignmentController.score = assignmentController.score - 2;
			rewardScoreKeep.setText(String.valueOf(assignmentController.score));
			}else {Notifications.create().title("Error in Purchase").text(insufficientFunds).position(Pos.BOTTOM_RIGHT).show();}
			break;
		case 2:
			if(assignmentController.score >= 3) {
			Notifications.create().title("Point Added").text("There was 2 point deducted from your account").position(Pos.BOTTOM_RIGHT).show();
			assignmentController.score = assignmentController.score - 3;
			rewardScoreKeep.setText(String.valueOf(assignmentController.score));
			}else {Notifications.create().title("Error in Purchase").text(insufficientFunds).position(Pos.BOTTOM_RIGHT).show();}
		default:
			break;
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rewardScoreKeep.setText(String.valueOf(assignmentController.score));
		rewardItems.setItems(rewardItem);
	}
}
