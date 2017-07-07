package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import interfaces.PrimaryKey;

public class Book implements Serializable, PrimaryKey {
	
	private static final long serialVersionUID = 5720335497921250897L;

	private String ISBN;
	private String title;
	private List<Author> authorlist;
	private BookType type;
	private List<BookCopy> listbookcopy;
	private int count;
	
	public int getCount() {
		return getAvailablityCount();
	}
	
	public Book(String ISBN, String title, Author a, BookCopy b, String bookType) {
		authorlist = new ArrayList<Author>();
		listbookcopy = new ArrayList<BookCopy>();
		this.ISBN = ISBN;
		this.title = title;
		authorlist = new ArrayList<>();
		if (BookType.REFERENCE.toString().equalsIgnoreCase(bookType)) {
			this.type = BookType.REFERENCE;
		} else { 
			this.type = BookType.REGULAR;
		}
		addAuthor(a);
		addBookCopy(b);
	}
	
	public int getAvailablityCount() {
		count = 0;
		
		for (BookCopy bc : listbookcopy) {
			if (bc.isAvailable() == true) {
				count++;
 			}
		}
		return count;
	}
	
	public BookCopy getAvailableBookCopy() {
		for (BookCopy bc : listbookcopy) {
			if (bc.isAvailable() == true) {
				return bc;
			}
		}
		return null;
	}
	
	public void removeCopy(BookCopy bc) {
		listbookcopy.remove(bc);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<BookCopy> getListbookcopy() {
		return listbookcopy;
	}

	public List<Author> getAuthorlist() {
		return authorlist;
	}

	public BookType getType() {
		return type;
	}

	public String getISBN() {
		return ISBN;
	}

	public String getTitle() {
		return title;
	}

	public List<Author> getAuthor() {
		return authorlist;
	}

	@Override
	public String getPrimaryKey() {
		return ISBN;
	}
	
	public void addAuthor(Author a){
		authorlist.add(a);
	}
	
	public void addBookCopy(BookCopy b){
		listbookcopy.add(b);
		b.setBook(this);
	}

	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", title=" + title + ", authorlist=" + authorlist
				+ ", type=" + type + ", listbookcopy=" + listbookcopy + "]";
	}
}
