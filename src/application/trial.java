package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import business.Book;
import business.LibraryMember;
import business.Login;

public class trial {
	public static void main(String args[]){
		
		List<Login> list2 = new ArrayList<>();
		Login log = new Login("admin", "admin");
		Login log2 = new Login("library", "library");
		Login log3 = new Login("both", "both");
		/*list2.add(log);
		list2.add(log2);
		list2.add(log3);*/
		
		try (ObjectOutputStream oos =
				new ObjectOutputStream(new FileOutputStream("adminlogin"))) {
			oos.writeObject(log);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		//*********
		try (ObjectOutputStream oos =
				new ObjectOutputStream(new FileOutputStream("librarianlogin"))) {
			oos.writeObject(log2);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		try (ObjectOutputStream oos =
				new ObjectOutputStream(new FileOutputStream("bothlogin"))) {
			oos.writeObject(log3);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		//
		
		List<Book> list = new ArrayList<>();
		try (ObjectInputStream ois
				= new ObjectInputStream(new FileInputStream("book"))) {
				list = (List<Book>) ois.readObject();
			} catch (Exception ex) {
				// ex.printStackTrace();
			}
		for(Book lm : list){
			System.out.println(lm.getTitle()); //, lm.getLastName(), lm.getAddress());
		}
	}

}
