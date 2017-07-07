package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class AbstractController {
	
	protected void showAlert(AlertType t, String msg) {
		Alert alert = new Alert(t);
		alert.setHeaderText("Message");
		alert.setContentText(msg);

		alert.showAndWait();
	}
	protected void clearField(TextField... txt) {
		for (TextField t : txt) {
			t.clear();
		}
	}

}
