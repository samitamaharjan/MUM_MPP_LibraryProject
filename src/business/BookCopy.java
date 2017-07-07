package business;

import java.io.Serializable;

import interfaces.PrimaryKey;

public class BookCopy implements Serializable, PrimaryKey {

	private static final long serialVersionUID = 5654380069068491357L;
	
	private String copybookid;
	private boolean available;
	private Book book;
		
	public BookCopy(String copybookid){
		this.copybookid = copybookid;
		this.available = true;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void setCopybookid(String copybookid) {
		this.copybookid = copybookid;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCopybookid() {
		return copybookid;
	}

	public boolean isAvailable() {
		return available;
	}

	public String getCopyBookId() {
		return copybookid;
	}
	
	@Override
	public String getPrimaryKey() {
		return copybookid;
	}
	
	@Override
	public String toString() {
		return "BookCopy [copybookid=" + copybookid + "]";
	}
}
