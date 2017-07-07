package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import interfaces.PrimaryKey;

public class CheckoutRecord implements Serializable, PrimaryKey {

	private static final long serialVersionUID = -3745534127313575440L;
	
	private List<CheckoutRecordEntry> entry;
	private LibraryMember member;

	public CheckoutRecord(LibraryMember member, CheckoutRecordEntry e) {
		this.member = member;
		this.entry = new ArrayList<CheckoutRecordEntry>();
		entry.add(e);
	}

	public LibraryMember getMember() {
		return member;
	}

	public List<CheckoutRecordEntry> getEntry() {
		return entry;
	}

	public void addEntry(CheckoutRecordEntry e) {
		entry.add(e);
	}

	@Override
	public String getPrimaryKey() {
		return member.getMemberId();
	}
}
