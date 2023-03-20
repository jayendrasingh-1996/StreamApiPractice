package com.streamApi.ashokIt;

import java.util.List;

public class Customer {
	private int id;
	private String name;
	private String location;
	private String email;
	private String contact;

	private List<Address> address;

	public Customer(int id, String name, String location, String email, String contact, List<Address> address) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.email = email;
		this.contact = contact;
		this.address = address;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", location=" + location + ", email=" + email + ", contact="
				+ contact + ", address=" + address + "]";
	}


}
