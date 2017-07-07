package application;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdminLibrarianController {
	@FXML
	private Button addLibMem;
	@FXML
	private Button editLibMem;
	@FXML
	private Button addBook;
	@FXML
	private Button checkoutBook;
	@FXML
	private Button addBookCopyBook;
	@FXML
	AnchorPane closeCurrentWindow;
	
	public void addLibMemClick(){
		 try{
			 	Stage current = (Stage) closeCurrentWindow.getScene().getWindow();
	            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/AddMember.fxml"));
	            Parent root = (Parent) fxmlLoader.load();
	            Stage stage = new Stage();
	            
	            stage.setTitle("Add Library Member");
	            stage.setScene(new Scene(root,600,500)); 
	            stage.show();
	            current.hide();
	          } catch(Exception e) {
	        	  e.printStackTrace();
	          }
		 
	}
	public void editLibMemClick(){
		try{
			Stage current = (Stage) closeCurrentWindow.getScene().getWindow();
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/application/SearchEditMember.fxml"));
            Parent root1 = (Parent) fxmlLoader1.load();
            Stage stage1 = new Stage();
            stage1.setTitle("Edit Library Member");
            stage1.setScene(new Scene(root1)); 
            current.hide();
            stage1.show();
          } catch(Exception e) {
        	  e.printStackTrace();
          }
	}
	public void addBookClick(){
		try{
			Stage current = (Stage) closeCurrentWindow.getScene().getWindow();
            FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("/application/AddBook.fxml"));
            Parent root2 = (Parent) fxmlLoader2.load();
            Stage stage2 = new Stage();
            stage2.setTitle("Add Book");
            stage2.setScene(new Scene(root2,700,600)); 
            current.hide();
            stage2.show();
          } catch(Exception e) {
        	  e.printStackTrace();
          }
	}
	public void checkoutBookClick(){
		try{
			Stage current = (Stage) closeCurrentWindow.getScene().getWindow();
            FXMLLoader fxmlLoader4 = new FXMLLoader(getClass().getResource("/application/CheckoutBookAvail.fxml"));
            Parent root4 = (Parent) fxmlLoader4.load();
            Stage stage4 = new Stage();
            stage4.setTitle("Checkout Book");
            stage4.setScene(new Scene(root4)); 
            current.hide();
            stage4.show();
          } catch(Exception e) {
        	  e.printStackTrace();
          }
	}
	public void addBookCopyClick(){
		try{
			Stage current = (Stage) closeCurrentWindow.getScene().getWindow();
            FXMLLoader fxmlLoader5 = new FXMLLoader(getClass().getResource("/application/SearchByISBN.fxml"));
            Parent root5 = (Parent) fxmlLoader5.load();
            Stage stage5 = new Stage();
            stage5.setTitle("Checkout Book");
            stage5.setScene(new Scene(root5)); 
            current.hide();
            stage5.show();
          } catch(Exception e) {
        	  e.printStackTrace();
          }
	}
}
