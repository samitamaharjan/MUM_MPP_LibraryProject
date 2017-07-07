package application;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import business.Login;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;


public class LoginController extends AbstractController{
	
		
	@FXML
	private TextField txtusername;
	
	@FXML
	private TextField txtpassword;
	
	@FXML
	private Label lblmessage;
	
	@FXML
	private Button btnsubmit;
	@FXML
	AnchorPane closeCurrentWindow;
	
	public void clicked(){
		
		String name=txtusername.getText();
		String password=String.valueOf(txtpassword.getText());
		
		if(name.isEmpty() || password.isEmpty()){
			
			showAlert(AlertType.ERROR,"Please enter details");
			return;
		}
		
		try (ObjectInputStream ois
				= new ObjectInputStream(new FileInputStream("bothlogin"))) {
				Login login = (Login)ois.readObject();
				
					if(name.equals(login.getUsername())&& password.equals(login.getPassword())){
						//System.out.println("succes");
						 try{
							 	Stage current = (Stage) closeCurrentWindow.getScene().getWindow();
					            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/Admin_Librarian.fxml"));
					            Parent root = (Parent) fxmlLoader.load();
					            Stage stage = new Stage();
					            stage.setTitle("Admin and Librarian");
					            root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					            stage.setScene(new Scene(root)); 
					            current.hide();
					            stage.show();
					           
					          } catch(Exception e) {
					        	  e.printStackTrace();
					          }
						 return;
					}
					
				
			} catch (Exception ex) {
				// ex.printStackTrace();
			}
		
		try (ObjectInputStream ois
				= new ObjectInputStream(new FileInputStream("adminlogin"))) {
				Login login = (Login)ois.readObject();
				
					if(name.equals(login.getUsername())&& password.equals(login.getPassword())){
						//System.out.println("succes");
						 try{
							 Stage current = (Stage) closeCurrentWindow.getScene().getWindow();
					            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/Administrator.fxml"));
					            Parent root = (Parent) fxmlLoader.load();
					            Stage stage = new Stage();
					            stage.setTitle("Administrator");
					            root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					            stage.setScene(new Scene(root)); 
					            current.hide();
					            stage.show();
					          } catch(Exception e) {
					        	  e.printStackTrace();
					          }
						 return;
					}
					
				
			} catch (Exception ex) {
				// ex.printStackTrace();
			}
		
		
		try (ObjectInputStream ois
				= new ObjectInputStream(new FileInputStream("librarianlogin"))) {
				Login login = (Login)ois.readObject();
				
					if(name.equals(login.getUsername())&& password.equals(login.getPassword())){
						//System.out.println("succes");
						 try{
							 Stage current = (Stage) closeCurrentWindow.getScene().getWindow();
					            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/CheckoutBookAvail.fxml"));
					            Parent root = (Parent) fxmlLoader.load();
					            Stage stage = new Stage();
					            stage.setTitle("Checkout Book");
					            root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					            stage.setScene(new Scene(root)); 
					            current.hide();
					            stage.show();
					            return;
					          } catch(Exception e) {
					        	  e.printStackTrace();
					          }
					}else {
						showAlert(AlertType.ERROR, "Invalid Username / Password");
						//	System.out.println("error");
							txtusername.setText("");
							txtpassword.setText("");
					}
				
			} catch (Exception ex) {
				 ex.printStackTrace();
			}
		
		
		
		
					
	}

}

