package assignmentlist;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

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
import login.LoginController;

public class assignmentController implements Initializable {

	// Initialize variables
	@FXML
	private ListView<String> assignmentList;
	
	static Preferences pref = Preferences.userNodeForPackage(LoginController.class);
	private static ObservableList<String> itemList = FXCollections.observableArrayList();
	int place = 1;
	
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
	//	place -= 1;
		pref.remove("Assignment2");
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
	    
	   // pref.remove("Assignment" + place);
	}
	
	// Sorting button, sorts alphabetically
	@FXML
	public void getSort(ActionEvent event) {
		output();

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
	

	private void output() {
		int arySize = itemList.size();
		//System.out.println(arySize);
		
		for (int i = 0; i < arySize ; i++) {
			System.out.println(i);
			
			// pref.put("Assignment" + i, itemList.get(i));
			pref.remove("Assignment15");
			pref.remove("Assignment");
			
			//place += 1;
		}

        try {
            pref.exportNode(new FileOutputStream("Jason"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BackingStoreException e) {
            e.printStackTrace();
        }
	}
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Initializes the array list
		assignmentList.setItems(itemList);

		for (int i = 0; i < 15; i++) {
			String get = pref.get("Assignment" + i, "root");
			itemList.add(get);
		}
	}

}
