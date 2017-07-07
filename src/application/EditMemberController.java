package application;

import business.Address;
import business.LibraryMember;
import dao.FileManager;
import dao.FileManagerImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;

public class EditMemberController extends AbstractController{
	
	@FXML
	TextField memId;
	
	@FXML
	TextField fname;
	
	@FXML
	TextField lname;
	
	@FXML
	TextField street;
	
	@FXML
	TextField city;
	
	@FXML
	TextField state;
	
	@FXML
	TextField zip;
	
	@FXML
	TextField phone;
	@FXML
	private Button btnBack;
	@FXML
	AnchorPane closeCurrentWindow;
	
	@FXML
	private Button btnEditMember;
	private FileManager<LibraryMember> fileManager = new FileManagerImpl<>("libraryMember");
	
	public void editMemberClicked(ActionEvent event){
		if (memId.getText().isEmpty() || fname.getText().isEmpty() || lname.getText().isEmpty() || street.getText().isEmpty() || city.getText().isEmpty()|| state.getText().isEmpty() || zip.getText().isEmpty() || phone.getText().isEmpty()) 
		{
			showAlert(AlertType.WARNING, "Please enter all the details");
		}
		else{
			String memberID = memId.getText();
			String firstName = fname.getText();
			String lastName = lname.getText();
			String phoneno = phone.getText();
			String streetname = street.getText();
			String cityin = city.getText();
			String stateOfCountry = state.getText();
			String zipCode = zip.getText();

			try {
				Address add = new Address(streetname, cityin, stateOfCountry, zipCode);
				LibraryMember mem = new LibraryMember(memberID, firstName, lastName, phoneno, add);
				fileManager.edit(mem);	
				
				clearField(memId,fname,lname,phone,street,city,state,zip);
				showAlert(AlertType.CONFIRMATION,"Member details changed");
			} 
			catch (Exception e) 
			{
				showAlert(AlertType.ERROR,"Member details not changed");
			}
			
		}
	}
	public void btnBackClicked(){
		 try{
				 	Stage current = (Stage) closeCurrentWindow.getScene().getWindow();
		            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/SearchEditMember.fxml"));
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

}