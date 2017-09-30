package initializable;

import org.controlsfx.control.Notifications;

import javafx.geometry.Pos;

import static initializable.Variables.time2;

public class Methods {
	
	public static void noFunds() {
		String insufficientFunds = "Insufficient funds";
		Notifications.create().title("Error in Purchase").text(insufficientFunds).position(Pos.BOTTOM_RIGHT).show();
	}
	
	public static void getBuyNotification(int amount) {
		Notifications.create().title("Points Deducted").text("There was " +amount+ " point deducted from your account").position(Pos.BOTTOM_RIGHT).show();
		Variables.score = Variables.score - amount;
	}
}
