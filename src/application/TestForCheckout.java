package application;

import java.util.List;

import business.CheckoutRecord;
import business.CheckoutRecordEntry;
import dao.FileManager;
import dao.FileManagerImpl;

public class TestForCheckout {
	public static void main(String[] args) {
		FileManager<CheckoutRecord> entryManager = new FileManagerImpl<>("checkoutRecord");
		List<CheckoutRecord> list = entryManager.findAll();
		
		for (CheckoutRecord record : list) {
			System.out.println(record.getMember());
			List<CheckoutRecordEntry> entries = record.getEntry();
			
			for (CheckoutRecordEntry entry : entries) {
				System.out.println(entry);
			}
		}
	}
}
