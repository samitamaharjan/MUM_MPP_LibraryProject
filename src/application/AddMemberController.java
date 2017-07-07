package application;

import business.Address;
import business.LibraryMember;
import dao.FileManager;
import dao.FileManagerImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddMemberController extends AbstractController{
	
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
	private Button btnAddMember;
	@FXML
	private Button btnBack;
	@FXML
	AnchorPane closeCurrentWindow;
	
	
	public void addMemberClicked(ActionEvent event){
		
		if (memId.getText().isEmpty() || fname.getText().isEmpty() || lname.getText().isEmpty() || street.getText().isEmpty() || city.getText().isEmpty()|| state.getText().isEmpty() || zip.getText().isEmpty() || phone.getText().isEmpty()) 
		{
			showAlert(AlertType.WARNING, "Please enter the details");
		}
		else{
			String memberID = memId.getText().toString();
			String firstName = fname.getText().toString();
			String lastName = lname.getText().toString();
			String phoneno = phone.getText().toString();
			String streetname = street.getText().toString();
			String cityin = city.getText().toString();
			String stateOfCountry = state.getText().toString();
			String zipCode = zip.getText().toString();

			try {
				Address add = new Address(streetname, cityin, stateOfCountry, zipCode);
				LibraryMember mem = new LibraryMember(memberID, firstName, lastName, phoneno, add);
				FileManager<LibraryMember> filemanager = new FileManagerImpl<LibraryMember>("libraryMember");
				filemanager.insert(mem);
				if (filemanager.exists(memberID)) {
					showAlert(AlertType.ERROR,"Member ID already exits");
					return;
				}
				
				filemanager.findAll();
								
				clearField(memId,fname,lname,phone,street,city,state,zip);
				
				showAlert(AlertType.CONFIRMATION,"Member added successfully");
			} 
			catch (Exception e) 
			{
				showAlert(AlertType.ERROR,"Member not added");
			}
			
		}
	}
	public void btnBackClicked(){
		 try{
				 	Stage current = (Stage) closeCurrentWindow.getScene().getWindow();
		            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/Admin_Librarian.fxml"));
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
