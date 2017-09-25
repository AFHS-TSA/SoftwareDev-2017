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

	public static double getStudy() {
		double exp1 = (-Variables.time1/(Variables.memStrength+Variables.factor));
		double exp2 = (-Variables.time2/(Variables.memStrength+Variables.factor));
		double y1 = Math.exp(exp1);
		double y2 = Math.exp(exp2);
		if (y1-y2 > .7) {
			System.out.println("Study");
			Variables.factor++;
			Variables.memStrength++;
			time2 = .041;
			Variables.n++;
			Variables.d+= .041;
		} else {
			System.out.println("Relax");
			Variables.d+=.041;
			time2++;
		}
		return Variables.n;
	}
}
