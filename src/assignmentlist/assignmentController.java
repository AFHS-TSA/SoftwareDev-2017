package assignmentlist;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle; 
import org.controlsfx.control.Notifications;

import initializable.Variables;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class assignmentController implements Initializable {

	// Initialize variables
	@FXML
	private ListView<String> assignmentList;
	
	private static ObservableList<String> itemList = FXCollections.observableArrayList();
	
	public static ObservableList<String> returnList() {
		return(itemList);
	}	
	
	// Button to add an assignment to the list
	@FXML
	public void handleButton(ActionEvent event) throws IOException {
		// Create the new window
		Parent modalParent = FXMLLoader.load(getClass().getResource("modal.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(modalParent));
		stage.setResizable(false);
		stage.alwaysOnTopProperty();
		stage.show();
		System.out.println(stage.getOnHiding());
	}
	
	// Button to remove an item from the list
	@FXML
	public void removeList(ActionEvent event) {
		// Get the index of assignment list array
		int selectedItem = assignmentList.getSelectionModel().getSelectedIndex();
		if(selectedItem >= 0) {
		// Push notification if you remove something from the list
		Notifications.create()
			.title("Point Added")
			.text("There was 1 point added to your account")
			.position(Pos.BOTTOM_RIGHT)
			.show();
		}
		
	    System.out.println(selectedItem);
	    itemList.remove(selectedItem);
	    // Add a point every time you remove something
		Variables.score++;
	    System.out.println(Variables.score);
	}
	
	// Sorting button, sorts alphabetically
	@FXML
	public void getSort(ActionEvent event) {
		Collections.sort(itemList);
	}
	
	// Back to home button
	@FXML
	public void getHome(ActionEvent e) {
		try {
			Parent homeParent = FXMLLoader.load(getClass().getResource("/sample/sample.fxml"));
			Scene homeScene = new Scene(homeParent);
			Stage appStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			appStage.setScene(homeScene);
			appStage.show();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Initializes the array list
		assignmentList.setItems(itemList);
	}

}
