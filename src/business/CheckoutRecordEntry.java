package business;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import interfaces.PrimaryKey;

public class CheckoutRecordEntry implements Serializable, PrimaryKey {

	private static final long serialVersionUID = 3212119783452653024L;
	
	private String id;
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	private BookCopy bookcopy;

	public CheckoutRecordEntry(BookCopy bookcopy) {
		this.id = UUID.randomUUID().toString();
		this.checkoutDate = LocalDate.now();
		int days = bookcopy.getBook().getType().getNoOfDays();
		this.dueDate = LocalDate.now().plusDays(days);
		this.bookcopy = bookcopy;
	}

	public BookCopy getBookcopy() {
		return bookcopy;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public String getId() {
		return id;
	}

	@Override
	public String getPrimaryKey() {
		return id;
	}

	@Override
	public String toString() {
		return "CheckoutRecordEntry [id=" + id + ", checkoutDate=" + checkoutDate + ", dueDate=" + dueDate
				+ ", bookcopy=" + bookcopy + "]";
	}
}
