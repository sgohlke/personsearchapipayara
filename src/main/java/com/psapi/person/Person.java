package com.psapi.person;

/**
 * @author Stefan Gohlke
 */
public class Person {
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String[] tags;
	private String registered;
	private String about;
	private String fruit;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	public String getRegistered() {
		return registered;
	}

	public void setRegistered(String registered) {
		this.registered = registered;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getFruit() {
		return fruit;
	}

	public void setFruit(String fruit) {
		this.fruit = fruit;
	}

	public boolean fitsPersonSearch(String name) {
		return (name == null || name.isEmpty()) || (this.firstName != null && !this.firstName.isEmpty()
				&& this.lastName != null && !this.lastName.isEmpty() && name != null && !name.isEmpty()
				&& (this.firstName.toLowerCase().indexOf(name.toLowerCase()) >= 0
						|| this.lastName.toLowerCase().indexOf(name.toLowerCase()) >= 0));
	}
}
