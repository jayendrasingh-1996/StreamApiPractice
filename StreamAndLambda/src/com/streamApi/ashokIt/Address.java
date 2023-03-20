package com.streamApi.ashokIt;

public class Address {
	private String doorNo;
	private String street;
	private String cityName;

	public Address(String doorNo, String street, String cityName) {
		super();
		this.doorNo = doorNo;
		this.street = street;
		this.cityName = cityName;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", street=" + street + ", cityName=" + cityName + "]";
	}

}
