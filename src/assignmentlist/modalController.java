package assignmentlist;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class modalController implements Initializable {	

	// Initialize variables
	@FXML
	private TextField addItem;
	@FXML
	private Button btnBack;
	@FXML
	private Button cancelBtn;
	ObservableList<String> list = assignmentController.returnList();

	
	@FXML
	public void addItem(ActionEvent event) throws IOException {
		// Add an item to assignment list
		list.add(addItem.getText());
		System.out.println("Assignment Added");
		((Node)(event.getSource())).getScene().getWindow().hide();
	}
	
	
	@FXML
	public void cancelAdd(ActionEvent event) {
		// Closes window
		((Node)(event.getSource())).getScene().getWindow().hide();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) { }
}
