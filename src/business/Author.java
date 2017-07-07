package business;

import java.io.Serializable;
import java.util.UUID;

public class Author extends Person implements Serializable {

	private static final long serialVersionUID = 9201781304188471757L;

	private String credential;
	private String bio;

	public Author(String firstName, String lastName, String phone, Address address, String credential, String bio) {
		super(UUID.randomUUID().toString(), firstName, lastName, phone, address);
		this.credential = credential;
		this.bio = bio;
	}

	public String getCredential() {
		return credential;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getBio() {
		return bio;
	}

	@Override
	public String toString() {
		return super.toString() + " Author [credential=" + credential + ", bio=" + bio + "]";
	}	
}
