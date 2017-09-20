package initializable;

import org.controlsfx.control.Notifications;

import javafx.geometry.Pos;

public class Methods {
	
	public static void noFunds() {
		String insufficientFunds = "Insufficient funds";
		Notifications.create().title("Error in Purchase").text(insufficientFunds).position(Pos.BOTTOM_RIGHT).show();
	}
	
	public static void getBuyNotification(String title, String text, int minus) {
		Notifications.create().title(title).text(text).position(Pos.BOTTOM_RIGHT).show();
		Variables.score = Variables.score - minus;
	}
}
