package main.java.app.sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXMasonryPane;
import com.jfoenix.effects.JFXDepthManager;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import com.jfoenix.transitions.hamburger.HamburgerSlideCloseTransition;

import main.java.app.assignmentlist.assignmentController;
import main.java.app.initializable.Variables;

/**
 * Controller class for sample.fxml
 */
public class Controller implements Initializable{


    private int randomInt;

    String[] quotes = {"Test 0",
                       "Test 1",
                       "Test 2",
                       "Test 3",
                       "Test 4"};

    @FXML
    private AnchorPane topBar;
    @FXML
    private AnchorPane rightDrawer;
    @FXML
    private BorderPane mainPane;
    @FXML
    public Label dashText;
    @FXML
    public Label quote;
    @FXML
    public Button rewardButton;
    @FXML
    private Label getScore;
    @FXML
    private JFXHamburger homeBurger;
    @FXML
    private JFXDrawer navDrawer;
    @FXML
    private JFXMasonryPane Masonry;
    @FXML
    private Label test;
    
    @FXML
    private void onRewardClicked(ActionEvent e) {
        //placeholder code for reward system layout
        try {
    		Parent rewardParent = FXMLLoader.load(getClass().getResource("/main/resources/app/rewardSystem/RewardMain.fxml"));
    		Scene rewardScene = (new Scene(rewardParent, Variables.width, Variables.height));
    		Stage appStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
    		appStage.setResizable(false);
    		appStage.setScene(rewardScene);
    		appStage.show();
        }
        catch (IOException ec) {
            ec.printStackTrace();
        }

    }

    @FXML
    private void onAssignmentClicked(ActionEvent e) {

        //placeholder code for assignment list
        System.out.println("TESTING");
        try {
        	/*
    		Parent assignlist = FXMLLoader.load(getClass().getResource("/assignmentlist/assignmentlist.fxml"));
    		Stage stage = new Stage();
    		stage.setScene(new Scene(assignlist));
    		stage.setResizable(false);
    		stage.alwaysOnTopProperty();
    		stage.show();*/
    		

    		Parent assignmentParent = FXMLLoader.load(getClass().getResource("/main/resources/app/assignmentlist/assignmentlist.fxml"));
    		Scene assignmentScene = (new Scene(assignmentParent, Variables.width, Variables.height));
    		Stage appStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
    		appStage.setResizable(false);
    		appStage.setScene(assignmentScene);
    		appStage.show();
        }
        catch (IOException ec) {
            ec.printStackTrace();
        }
    }

    @FXML
    private void onDelete(ActionEvent e) {
    	//Masonry.getChildren().remove(test);
    	System.out.println(mainPane.getWidth());
    }
    
    private void Drawer() {
        try {    	
    		AnchorPane drawerContent = FXMLLoader.load(getClass().getResource("/main/resources/app/sample/DrawerContent.fxml"));
    		navDrawer.setSidePane(drawerContent);
        	HamburgerBackArrowBasicTransition burgerTask = new HamburgerBackArrowBasicTransition(homeBurger);
        	burgerTask.setRate(-1);
        	homeBurger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e)->{
        	    burgerTask.setRate(burgerTask.getRate()*-1);
        	    burgerTask.play();
        	    
        	    if(navDrawer.isShown()) {
        	    	navDrawer.close();
        	    } else {
        	    	navDrawer.open();
        	    }
        	 });
        	
        } catch (IOException e1) {
    		e1.printStackTrace();
        }
    }
    
    @SuppressWarnings("static-access")
	private void Shadow() {
    	JFXDepthManager shadow = null;
    	shadow.setDepth(topBar, Variables.shadow);
    }
/*    private void randomQuoteGen() {
>>>>>>> develop
        Preferences preferences = Preferences.userNodeForPackage(Controller.class);
        Random random = new Random();
        do {
            randomInt = random.nextInt((4-0) + 1) + 0;
        } while (randomInt == Integer.parseInt(preferences.get("RandomNumber", "root")));
        quote.setText(""+quotes[randomInt]);
        preferences.putInt("RandomNumber", randomInt);
        try {
            preferences.exportNode(new FileOutputStream("Preferences"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BackingStoreException e) {
            e.printStackTrace();
        }
    }*/



    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	Drawer();
    	Shadow();
        getScore.setText(String.valueOf(Variables.score));
        //randomQuoteGen();
        
        mainPane.widthProperty().addListener((obs, oldVal, newVal) -> {
			
        	
        	System.out.println(mainPane.getWidth());
        	if(mainPane.getWidth() < 875) {
        		homeBurger.setVisible(true);
        		rightDrawer.setVisible(false);
        	} else {
        		homeBurger.setVisible(false);
        		rightDrawer.setVisible(true);
        		
        		try {
    				AnchorPane pane = FXMLLoader.load(getClass().getResource("/main/resources/app/sample/DrawerContent.fxml"));
    				rightDrawer.getChildren().setAll(pane);
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
        	}
        });
    }
}


