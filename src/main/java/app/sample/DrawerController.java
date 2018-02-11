package main.java.app.sample;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXListView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class DrawerController implements Initializable{

	@FXML
	private JFXListView<Label> drawerList;
	
	@FXML
	public void test(ActionEvent e) {
		for(int i = 0 ; i < 4 ; i++) drawerList.getItems().add(new Label("Item " + i));
	}
	
	@FXML
	public void tglCollapse(ActionEvent e) {
		if(!drawerList.isExpanded()) {
			drawerList.setExpanded(true);
			drawerList.depthProperty().set(1);
		} else {
			drawerList.setExpanded(false);
			drawerList.depthProperty().set(0);
		}
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
}
