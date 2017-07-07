package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import business.Book;
import business.BookCopy;
import business.CheckoutRecord;
import business.CheckoutRecordEntry;
import business.LibraryMember;
import dao.FileManager;
import dao.FileManagerImpl;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class IssueContoller extends AbstractController implements Initializable {

	@FXML
	private TableView<Book> bookTable;
	@FXML
	private TableColumn<Book, String> ISBN;
	@FXML
	private TableColumn<Book, String> bookTitle;
	@FXML
	private TableColumn<Book, String> type;
	@FXML
	private TableColumn<Book, String> noOfCopy;
	@FXML
	private Button btnIssueBook;
	@FXML
	private ObservableList<Book> bookList;
	
	private String isbnNo;
	private String memberId;	
	private Book book;
	
	private FileManager<Book> bookManager = new FileManagerImpl<>("book");
	private FileManager<LibraryMember> memberManager = new FileManagerImpl<>("libraryMember");
	FileManager<CheckoutRecord> checkoutRecordManager = new FileManagerImpl<>("checkoutRecord");

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ISBN.setCellValueFactory(new PropertyValueFactory<Book, String>("ISBN"));
		bookTitle.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
		type.setCellValueFactory(new PropertyValueFactory<Book, String>("type"));
		//noOfCopy.setCellValueFactory(new PropertyValueFactory<Book, String>("count"));
		noOfCopy.setCellValueFactory(p -> new SimpleStringProperty("" + p.getValue().getAvailablityCount()));
	}
	
	public void setBookToUI(String isbnNo, String memberId) {
		this.isbnNo = isbnNo;
		this.book = bookManager.findByPrimaryKey(isbnNo);
		this.memberId = memberId;
		
		List<Book> books = new ArrayList<>();
		books.add(book);
		bookList = FXCollections.observableArrayList(books);		
		bookTable.getItems().setAll(bookList);
	}

	public void issueClicked() {
		
		try {
			Book book = bookManager.findByPrimaryKey(isbnNo);
			BookCopy bc = book.getAvailableBookCopy();
			bc.setAvailable(false);
			
			CheckoutRecordEntry entry = new CheckoutRecordEntry(bc);
			CheckoutRecord checkoutRecord = checkoutRecordManager.findByPrimaryKey(memberId);
			if (checkoutRecord == null) {
				LibraryMember member = memberManager.findByPrimaryKey(memberId);
				checkoutRecord = new CheckoutRecord(member, entry);
			} else {
				checkoutRecord.addEntry(entry);
			}
			
			book.removeCopy(bc);
			bookManager.edit(book);
			
			checkoutRecordManager.insert(checkoutRecord);
			
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/SuccessfullyIssued.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			
			SuccessfullyIssued controller = fxmlLoader.getController();
			controller.setBookInformation(book, memberId, entry);
			Stage stage = new Stage();
            stage.setTitle("Confirmation");
			stage.setScene(new Scene(root, 700, 500));
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
			showAlert(AlertType.ERROR, "Book cannot issue.");
		}

	}
}