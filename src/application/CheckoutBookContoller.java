package application;

import business.Book;
import business.BookCopy;
import business.CheckoutRecord;
import business.CheckoutRecordEntry;
import business.LibraryMember;
import dao.FileManager;
import dao.FileManagerImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CheckoutBookContoller extends AbstractController{
	@FXML
	private TextField checkoutMemIdText;
	@FXML
	private TextField checkoutMemIsbnText;
	@FXML
	private Button btnSubmit;
	
	FileManager<LibraryMember> memberManager = new FileManagerImpl<>("libraryMember");
	FileManager<Book> bookManager = new FileManagerImpl<>("book");
	FileManager<CheckoutRecord> checkoutRecordManager = new FileManagerImpl<>("checkoutRecord");
	
	public void checkAvailibilityClicked(ActionEvent event){
		
		if (checkoutMemIdText.getText().isEmpty() || checkoutMemIsbnText.getText().isEmpty()) 
		{
			showAlert(AlertType.WARNING, "Please enter the details");
		}
		else{
			String memberID = checkoutMemIdText.getText();
			String isbnNo = checkoutMemIsbnText.getText();
			
			if (!memberManager.exists(memberID)) {
				showAlert(AlertType.ERROR,"Invalid member id");
				return;
			}
			
			if (!bookManager.exists(isbnNo)) {
				showAlert(AlertType.ERROR,"Invalid ISBN");
				return;
			}
			
			try {
				Book book = bookManager.findByPrimaryKey(isbnNo);
				
				BookCopy bc = book.getAvailableBookCopy();
				if (bc == null) {
					showAlert(AlertType.CONFIRMATION,"Book copies are not available at this time.");
				}
				CheckoutRecordEntry entry = new CheckoutRecordEntry(bc);
				CheckoutRecord checkoutRecord = checkoutRecordManager.findByPrimaryKey(memberID);
				checkoutRecord.addEntry(entry);
				bc.setAvailable(false);
				
				clearField(checkoutMemIdText,checkoutMemIsbnText);
				
				showAlert(AlertType.CONFIRMATION,"Book checkout successfully");
			} 
			catch (Exception e) 
			{
				showAlert(AlertType.ERROR,"Book cannot checkout");
			}
			
		}
}
}
