package business;

import java.io.Serializable;
import java.util.UUID;

import interfaces.PrimaryKey;

public class Address implements Serializable, PrimaryKey {

	private static final long serialVersionUID = -1337645756589619149L;
	
	private String id;
	private String street;
	private String city;
	private String zip;
	private String state;
	
	public Address() {
		
	}
	
	public Address(String street, String city, String zip, String state) {
		this.id = UUID.randomUUID().toString();
		this.street = street;
		this.city = city;
		this.zip = zip;
		this.state = state;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getZip() {
		return zip;
	}

	public String getState() {
		return state;
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
		return "Address [id=" + id + ", street=" + street + ", city=" + city + ", zip=" + zip + ", state=" + state
				+ "]";
	}
}
