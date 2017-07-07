package application;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AdministratorController {
	
	@FXML
	private Button btnAddMember;
	
	@FXML
	private Button btnEditMember;
	
	@FXML
	private Button btnAddBook;
	
	@FXML
	private Button btnAddBookCopy;
	
	@FXML
	AnchorPane closeCurrentWindow;
	
	public void addMemberClicked(){
	
		 try{
			 	Stage current = (Stage) closeCurrentWindow.getScene().getWindow();
	            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/AddMember.fxml"));
	            Parent root = (Parent) fxmlLoader.load();
	            Stage stage = new Stage();
	            stage.setTitle("Administartor");
	            stage.setScene(new Scene(root));
	            current.hide();
	            stage.show();
	          } catch(Exception e) {
	        	  e.printStackTrace();
	          }

	}
	
	public void editMemberClicked(){
		try{
			Stage current = (Stage) closeCurrentWindow.getScene().getWindow();
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/application/EditMember.fxml"));
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
	
	public void addBookClicked(){
		try{
			Stage current = (Stage) closeCurrentWindow.getScene().getWindow();
            FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("/application/AddBook.fxml"));
            Parent root2 = (Parent) fxmlLoader2.load();
            Stage stage2 = new Stage();
            stage2.setTitle("Add Book");
            stage2.setScene(new Scene(root2)); 
            current.hide();
            stage2.show();
          } catch(Exception e) {
        	  e.printStackTrace();
          }
	}
	public void addBookCopyClicked(){
		try{
			Stage current = (Stage) closeCurrentWindow.getScene().getWindow();
            FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("/application/SearchByISBN.fxml"));
            Parent root2 = (Parent) fxmlLoader2.load();
            Stage stage2 = new Stage();
            stage2.setTitle("Add Book");
            stage2.setScene(new Scene(root2));
            current.hide();
            stage2.show();
          } catch(Exception e) {
        	  e.printStackTrace();
          }
	}

	
}
