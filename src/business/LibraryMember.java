package business;

import java.io.Serializable;

public class LibraryMember extends Person implements Serializable {

	private static final long serialVersionUID = -3088103115147220469L;

	private CheckoutRecord checkoutRecord;
	
	public LibraryMember(String memberId, String firstName, String lastName, String phone, Address address) {
		super(memberId, firstName, lastName, phone, address);
	}

	public CheckoutRecord getCheckoutRecord() {
		return checkoutRecord;
	}
	
	
}
