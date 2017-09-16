package assignmentlist;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class assignmentController implements Initializable {

	@FXML
	private ListView<String> assignmentList;
	public static int score = 0;
	
	private static ObservableList<String> list = FXCollections.observableArrayList();
	
	public static ObservableList<String> returnList() {
		return(list);
	}	
	
	@FXML
	public void handleButton(ActionEvent event) throws IOException {
		Parent modalParent = FXMLLoader.load(getClass().getResource("modal.fxml"));
		Stage stage = new Stage();
		stage.setScene(new Scene(modalParent));
		stage.setResizable(false);
		stage.alwaysOnTopProperty();
		stage.show();
		System.out.println(stage.getOnHiding());
	}
	
	@FXML
	public void removeList(ActionEvent event) {
	    int selectedItem = assignmentList.getSelectionModel().getSelectedIndex();
	    System.out.println(selectedItem);
	    list.remove(selectedItem);
		score++;
	    System.out.println(score);
	}
	
	@FXML
	public void getSort(ActionEvent event) {
		Collections.sort(list);
	}
	
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
		assignmentList.setItems(list);
	}

}
