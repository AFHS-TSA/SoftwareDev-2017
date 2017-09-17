package assignmentlist;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class modalController implements Initializable {	

	@FXML
	private TextField addItem;
	@FXML
	private Button btnBack;
	@FXML
	private Button cancelBtn;
	ObservableList<String> list = assignmentController.returnList();
	
	@FXML
	public void addItem(ActionEvent event) throws IOException{
		list.add(addItem.getText());
		System.out.println("Assignment Added");
		((Node)(event.getSource())).getScene().getWindow().hide();
	}
	
	@FXML
	public void cancelAdd(ActionEvent event) {
		((Node)(event.getSource())).getScene().getWindow().hide();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
}
}