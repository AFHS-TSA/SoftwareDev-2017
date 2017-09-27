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
	

	Preferences pref = Preferences.userNodeForPackage(LoginController.class);
	private void output() {
		
        pref.put("Username", myUsername[1]);
        pref.put("Password", myPassword[1]);
        
 
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
		
		
		/*if (Arrays.asList(myUsername).contains(username.getText())) {
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
		}*/
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

}
