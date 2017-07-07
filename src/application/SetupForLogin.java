package application;

import java.io.IOException;

import business.Address;
import business.LibraryMember;
import dao.FileManager;
import dao.FileManagerImpl;

public class SetupForLogin {

	public static void main(String[] args) throws IOException {
		FileManager<LibraryMember> loginManager = new FileManagerImpl<>("libraryMember");
		loginManager.clean();
		Address addr1 = new Address("1000 N 4th St", "Fairfield", "52555", "IA");
		Address addr2 = new Address("1260 N 4th St", "Seattle", "52555", "WA");
		Address addr3 = new Address("2500 N 4th St", "Redmond", "52555", "PA");
		LibraryMember maria = new LibraryMember("10", "Maria", "Jackson", "256981", addr1);
		LibraryMember john = new LibraryMember("20", "John", "Smith", "2589642", addr2);
		LibraryMember samita = new LibraryMember("30", "Samita", "Maharjan", "2058651", addr3);
		LibraryMember madhuri = new LibraryMember("40", "Madhuri", "Agrawal", "2058651", addr3);
		
		loginManager.insert(john);
		loginManager.insert(samita);
		loginManager.insert(maria);
		loginManager.insert(madhuri);
		loginManager.print();
		
		System.out.println("=========================");
		
		/*samita.setFirstName("James");
		samita.setLastName("Singh");
		loginManager.edit(samita);
		loginManager.print();*/
	}
}
