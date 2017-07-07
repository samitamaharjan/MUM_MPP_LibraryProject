package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Library Management");
		try {
			//Parent root0 = FXMLLoader.load(getClass().getResource("/application/AddMember.fxml"));
			//Parent root1 = FXMLLoader.load(getClass().getResource("/application/Login.fxml"));
			Parent root2 = FXMLLoader.load(getClass().getResource("/application/CheckoutBookAvail.fxml"));
			//Parent root3 = FXMLLoader.load(getClass().getResource("/application/Admin_Librarian.fxml"));
			//Parent root5 = FXMLLoader.load(getClass().getResource("/application/SearchEditMember.fxml"));
			//Parent root6 = FXMLLoader.load(getClass().getResource("/application/issue.fxml"));
			//Parent root7 = FXMLLoader.load(getClass().getResource("/application/Checkout.fxml"));
						
			Scene scene = new Scene(root2, 600, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
