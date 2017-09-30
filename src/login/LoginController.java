package login;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import assignmentlist.assignmentController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	
	
	String[] myUsername = {"Jason", "Tom", "Daniel"};
	String[] myPassword = {"Password", "aaa", "123"};
	

	static Preferences pref = Preferences.userNodeForPackage(LoginController.class);
	public static String getUser = pref.get("Username", "root");
	
	private void output() {
		
        pref.put("Username", myUsername[0]);
        pref.put("Password", myPassword[0]);
        
 
        try {
            pref.exportNode(new FileOutputStream("Jason"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BackingStoreException e) {
            e.printStackTrace();
        }
	}


	
	@FXML
	public void onLogin(ActionEvent event) throws IOException {

		output();
		
		String getUser = pref.get("Username", "root");
		String getPass = pref.get("Password", "root");
		
		if (getUser.equals(username.getText())){
			System.out.println("Username Correct");
			if (getPass.equals(password.getText())) {
				System.out.println("Password Correct");
				
				Parent modalParent = FXMLLoader.load(getClass().getResource("/sample/sample.fxml"));
				Stage stage = new Stage();
				stage.setScene(new Scene(modalParent));
				stage.setResizable(false);
				stage.alwaysOnTopProperty();
				stage.show();
				
				((Node)(event.getSource())).getScene().getWindow().hide();
			}
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

}
