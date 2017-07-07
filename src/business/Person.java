package business;

import java.io.Serializable;

import interfaces.PrimaryKey;

public class Person implements Serializable, PrimaryKey {
	
	private static final long serialVersionUID = -1161938047579074731L;
	
	private String memberId;
	private String firstName;
	private String lastName;
	private String phone;
	private Address address;
	
	public Person(String memberId, String firstName, String lastName, String phone, Address address) {
		this.memberId = memberId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhone() {
		return phone;
	}

	public Address getAddress() {
		return address;
	}

	public String getMemberId() {
		return memberId;
	}

	@Override
	public String getPrimaryKey() {
		return memberId;
	}
	
	@Override
	public String toString() {
		if (address == null) {
			address = new Address();
		}
		return String.format("%-10s %-10s %-10s %-10s %s", memberId, firstName, lastName, phone, address.toString());
	}
}
