package common;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

// 경고장, 알림창 클래스
public class AlertClass {
	public static void alertInfo(String msg) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(msg);
		alert.show();
	}

	public static void alertErr(String msg) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setContentText(msg);
		alert.show();
	}
}
