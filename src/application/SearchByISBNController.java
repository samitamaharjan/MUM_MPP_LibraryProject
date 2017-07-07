package application;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import business.Book;
import business.BookCopy;
import business.Login;
import dao.FileManager;
import dao.FileManagerImpl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class SearchByISBNController extends AbstractController{
	
	@FXML
	TextField txtISBN;
	
	@FXML
	TextField txtcopybookid;
	
	@FXML
	private Button btnadd;
	@FXML
	private Button btnBack;
	@FXML
	AnchorPane closeCurrentWindow;
	
	public void btnsubmitClicked(){
		
		String ISBN = txtISBN.getText();
		
		try (ObjectInputStream ois
				= new ObjectInputStream(new FileInputStream("book"))) {
			
			List<Book> books = (ArrayList<Book>)ois.readObject();
					
			Book b = null;
			boolean isFound = false;
			for(Book book: books) {
					if(ISBN.equals(book.getISBN())){
						//System.out.println("succes");
						b = book;
						isFound = true;
					}
			}
			
			if(isFound == false) {
				showAlert(AlertType.ERROR,"ISBN not found");
				return;
			}
			
			
			//check copy number unique
			for(BookCopy bookCopy : b.getListbookcopy()) {
				
				if(bookCopy.getCopyBookId().equals( txtcopybookid.getText())) {
					showAlert(AlertType.ERROR,"book copy duplicate");
					return;
					
				}
				
			}
			
			b.getListbookcopy().add(new BookCopy(txtcopybookid.getText()));
			showAlert(AlertType.CONFIRMATION,"successfully added");	
			FileManager<Book> filemanager = new FileManagerImpl<Book>("book");
			filemanager.edit(b);
			
			} catch (Exception ex) {
				ex.printStackTrace();
			}
	}
	public void btnBackClicked(){
		 try{
				 	Stage current = (Stage) closeCurrentWindow.getScene().getWindow();
		            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/Admin_Librarian.fxml"));
		            Parent root = (Parent) fxmlLoader.load();
		            Stage stage = new Stage();
		            stage.setScene(new Scene(root,600,500)); 
		            stage.show();
		            current.hide();
		          } catch(Exception e) {
		        	  e.printStackTrace();
		          }
		}

}
