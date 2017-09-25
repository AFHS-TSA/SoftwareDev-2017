package login;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

	@FXML
	private TextField username;
	@FXML
	private TextField password;
	
	String[] myUsername = {"Jason", "Tom", "Daniel"};
	String[] myPassword = {"Password", "aaa", "123"};
	
	@FXML
	public void onLogin(ActionEvent event) {

		if (Arrays.asList(myUsername).contains(username.getText())) {
			int index = -1;
			
			for (int i=0;i<myUsername.length;i++) {
			    if (myUsername[i].equals(username.getText())) {
			        index = i;
			        break;
			    }
			}
				if (myPassword[index].equals(password.getText())) {
					((Node)(event.getSource())).getScene().getWindow().hide();
					System.out.println("Password is correct");
					
					
					try {
						Parent modalParent = FXMLLoader.load(getClass().getResource("/sample/sample.fxml"));
						Stage stage = new Stage();
						stage.setScene(new Scene(modalParent));
						stage.setResizable(false);
						stage.alwaysOnTopProperty();
						stage.show();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}else {
					System.out.println("Password is wrong");
				}
		}else {
			System.out.println("Wrong");
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

}
