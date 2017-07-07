package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import business.Book;
import business.CheckoutRecordEntry;
import business.LibraryMember;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SuccessfullyIssued extends AbstractController {
	ObservableList<String> booktypeList = FXCollections.observableArrayList("Regular","Special");
	
	@FXML
	Label memId;
	@FXML
	Label bookTitle;
	@FXML
	Label bookIsbn;
	@FXML
	Label dateOfIssue;
	@FXML
	Label overdueDate;
	@FXML
	private Button btnOkConfirmation;
	@FXML
	AnchorPane closeCurrentWindow;
	
	private Book book;
	
	public void setBookInformation(Book book, String memberId, CheckoutRecordEntry entry) {
		bookTitle.setText(book.getTitle());
		bookIsbn.setText(book.getISBN());
		memId.setText(memberId);
		dateOfIssue.setText(entry.getCheckoutDate().toString());
		overdueDate.setText(entry.getDueDate().toString());
	}
	
	public void addBookClicked(){
			
			try {
				Stage current = (Stage) closeCurrentWindow.getScene().getWindow();
				
				current.hide();
			} 
			catch (Exception e) 
			{
				showAlert(AlertType.ERROR,"Some error occoured");
			}
			
		}


}
